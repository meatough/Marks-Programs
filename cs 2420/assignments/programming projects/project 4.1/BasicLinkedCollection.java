 /*********************************************************** 
 * Programming Assignment 4
 * Basic Linked Collection program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created February 13, 2013
 * Modified February 20, 2013
 * Modified by Mark Eatough
 ***********************************************************/
 
import java.util.Collection;	
import java.util.Iterator;
import java.util.AbstractCollection;

public class BasicLinkedCollection<E> extends java.util.AbstractCollection<E> 
{
	SinglyLinkedList<E> list = new SinglyLinkedList<E>();
	private int size;
	protected transient int modCount;
	
	//default constructor
	public BasicLinkedCollection()
	{
		size = 0;
		modCount = 0;
	}
		
	//parameterized constructor
	public BasicLinkedCollection( Collection<? extends E> c) 
	{
 		if ( c == null ) 
	 	{
      	throw new java.lang.IllegalArgumentException();
    	}
      int size = list.getLength();
    	modCount = 0;
	}


	//overiding methods
	public boolean add( E el ) 
	{
		//SinglyLinkedList<E> newList = new SinglyLinkedList<E>();
  		if ( el == null ) 
	 	{
      	throw new java.lang.IllegalArgumentException();
    	}
        
    	list.addFront(el);
    	size++;
    	modCount++;
    	return true;
	}

	public boolean remove( Object element )
	{
    	/*if ( element == null ) 
	 	{
      	throw new IllegalArgumentException();
    	}*/
    			
		list.removeElement(element);
	 
    // Comment out the next line to illustrate
    //  the behavior of JUnit when a test fails.
    	size--;
    	modCount++;
    	return true;
	}
	
	public boolean addAll(Collection<? extends E> c)
	{
		SinglyLinkedList<E> newList = new SinglyLinkedList<E>();
		boolean modified = false;
		E el;
		int cursor = size;		
		
		while(cursor > 0)
		{
			el = list.getElementAt(cursor);
			newList.addFront(el);
			modified = true;
			cursor--;
		}
		
		return modified;
	}
	
	public boolean removeAll(Collection<?> c)
	{
		while (size > 0)
		{
			list.removeIndex(1);
			size--;
		}
		return true;
	}
  
  	public int size()
  	{
   	return this.size;
  	}
	
   public Iterator<E> iterator() 
	{
   	return new BasicIterator();
   }
	
	private class BasicIterator implements Iterator<E> 
	{	//this class is inside basic collection class
    
	 /**
     * cursor is used to access the next element in the
     * sequence. In its implementation, cursor is always
     * the index of the next element to return. So cursor
     * should be incremented _after_ retrieving the next
     * element in the sequence.
     */
		private int cursor;

    /**
     * Provides fail-fast operation of the iterator. For each
     * call to an iterator method, expectedModcount should be
     * equal to the collection's modCount, otherwise an
     * intervening change (concurrent modification) to the
     * collection has been made and we cannot guarantee that
     * the iterator will behave correctly.
     */
    	private int expectedModcount;

    /**
     * the contract of remove() says that each call to
     * remove() must have been preceded by a call to next()
     * (they are paired). So if there has been NO call to
     * next() prior to a remove() or if there were two remove()
     * calls without an intervening next() call, it is NOT ok
     * to try to remove an item.
     */
    	private boolean okToRemove;

    	public BasicIterator() 
		{
      	cursor = 1;
      	expectedModcount = modCount;
      	okToRemove = false;
    	}

    /**
     * Determine if there are more elements in the iteration
     * sequence.
     * @returns boolean <code>true</code> if there are more
     *                  elements in the iteration sequence.
     */
    	public boolean hasNext() 
		{
      	return cursor <= size;
    	}

    /**
     * Returns the next element in the iteration sequence.
     *
     * @returns Object next element in the iteration sequence
     * @throws ConcurrentModificationException if this
     *         collection has been modified by a method outside
     *         of this iterator.
     * @throws NoSuchElementException if hasNext() is false
     */
	public E next() 	
	{
      // check for concurrent modification
   	if ( expectedModcount != modCount ) 
		{
      	throw new java.util.ConcurrentModificationException();
      }

      // check that there are more elements in the iterator
      // sequence
      if ( !hasNext() ) 
		{
      	throw new java.util.NoSuchElementException();
      }

      // indicate that we have met the contract
      // requirements for remove()
      okToRemove = true;

      // there are more elements to retrieve, so
      // 1. get the element in cursor's position
      // 2. advance the cursor to the next element
      E element = list.getElementAt(cursor);
      cursor++;
      return element;
 	}

    /**
     * remove the element returned by the last call to
     * <code>next()</code>.
     * @throws ConcurrentModificationException if this
     *         collection has been modified by a method
     *         outside of this iterator.
     * @throws IllegalStateException if there has been no
     *         call to next() for this iteration or if two
     *         calls to remove() have been made with no
     *         intervening call to next().
     */
    public void remove() 
	 {
      // check for concurrent modification
      if ( expectedModcount != modCount ) 
		{
        throw new java.util.ConcurrentModificationException();
      }

      // check that there has been a next() message to
      // provide an element to remove
      if ( !okToRemove ) 
		{
        throw new IllegalStateException();
      }

      okToRemove = false;

      // Use BasicCollection's remove() method to do the
      // actual removal. Need to predecrement cursor to
      // get to the LAST element returned by next(). After
      // the removal, this will be the value cursor should
      // have for the next call to next().
      --cursor;
      BasicLinkedCollection.this.list.removeIndex(cursor);

      // increment expectedModcount since the remove()
      // message above to the collection object will
      // have incremented modCount
      expectedModcount++;
    }//end remove method
  }//end iterator class	
}//end basiclinkedcollection class