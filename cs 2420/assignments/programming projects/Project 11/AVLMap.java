/*********************************************************** 
 * Programming Assignment 10
 * Map ADT program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 17, 2013
 * Modified  April 24, 2013
 * Modified by Mark Eatough
 ***********************************************************/ 
 
 import java.util.AbstractCollection;
 import java.util.Collection;
 import java.util.Iterator;
 import java.util.ConcurrentModificationException;
 
 
 public class AVLMap <K extends Comparable<? super K>, V extends Comparable <? super V>>
 	implements Map<K,V>
{	
	private static final int KEY_ITERATOR = 0;
  	private static final int VALUE_ITERATOR = 1;
  	private static final int ENTRY_ITERATOR = 2;

	private AVLTree<Entry<K,V>> map;
	
	private int size;
	
	private AbstractCollection<V> collectionView = null;

	protected transient int modCount;

	public AVLMap()
	{
		map = new AVLTree<Entry<K, V>>();
	}
	
	//override put method
	public V put( K key, V value ) 
  	{
    	if ( ( key == null ) || ( value == null ) ) 
	 	{
      	throw new IllegalArgumentException( "null argument" );
    	}

    	this.modCount++;
		
    	Entry entry = new Entry<K, V> ( key, value);

    	if ( containsKey(key) == false ) 
	 	{
      	map.add(entry);
      	this.size++;
      	return null;
    	}
    	else 
	 	{ 
			map.remove(entry);
     		V tempValue = (V)entry.value();
      	entry.setValue( value );
			map.add(entry);
      	return tempValue;	
    	}
  	}

  /**
   * Gets the value associated with <code>key</code> from this map,
   *  if it exists.
   * @param key the key to use to search the map; cannot be
   *  <code>null</code>.
   * @return <code>null</code> if <code>key</code> was not found in the
   *  map, the value associated with <code>key</code> otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   *    is <code>null</code>.
   */
  	public V get( K key ) 
  	{
    	if ( key == null ) 
	 	{
      	throw new IllegalArgumentException( "null argument" );
    	}
		
		for(Entry e : map)
	 	{
	 		if(key.equals(e.key()))
			{
				V value = (V)e.value();
				return value;
			}
	 	}
		return null;
  	}

  /**
   * Remove the element from this the map associated with
   * <code>key</code>. If a <code>value</code> with this <code>key</code>
   * exists in the map, it is returned, otherwise <code>null</code>
   * is returned.
   * @param key remove the entry identified by <code>key</code>;
   *    cannot be <code>null</code>.
   * @return <code>null</code> if <code>key</code> was not found in the
   * map, the <code>value</code> associated with <code>key</code>
   * otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   * is <code>null</code> or cannot be compared to other keys in
   * the map.
   */
  	public V remove( K key ) 
  	{
    	if ( key == null ) 
	 	{
      	throw new IllegalArgumentException( "null argument" );
    	}

    	this.modCount++;
		
		for(Entry e : map)
	 	{
	 		if(key.equals(e.key()))
			{
				map.remove(e);
				V value = (V)e.value();
				return value;
			}
	 	}
		return null;
  	}

  /**
   * Determines if the map contains an entry containing
   * <code>value</code>.
   * @param value the value to search for in the map.
   * @return true if <code>value</code> was not found in the map,
   * false otherwise.
   * @throws <code>IllegalArgumentException</code> if
   *   <code>value</code> is <code>null</code>.
   */
  	public boolean containsValue( V target ) 
  	{
    	java.util.Iterator iter =
        	new AVLMapIterator( VALUE_ITERATOR );
    	while ( iter.hasNext() ) 
		{
      	V value = ( V ) iter.next();
      	if ( value.equals( target ) ) 
			{
        		return true;
      	}
    	}
    	return false;
  	}

  /**
   * Determines if the map contains an entry containing
   * <code>key</code>.
   * @param key the key to search for in the map.
   * @return true if <code>key</code> was not found in the map,
   * false otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   *    is <code>null</code>.
   */
  	public boolean containsKey( K key ) 
  	{
		return ( this.get( key ) != null );
  	}
		
	public Collection<V> values() 
  	{
    // if there is already a Collection object for this map,
    // return it
    	if ( collectionView == null ) 
	 	{
      // otherwise, create one
      	collectionView = new java.util.AbstractCollection<V> () 
			{
        // and fill in the missing (abstract) methods
        	public java.util.Iterator<V> iterator() 
		  	{
          	return new AVLMapIterator( VALUE_ITERATOR );
        	}

        	public int size() 
		  	{
          	return AVLMap.this.size();
        	}

        	public boolean contains( Object target ) 
		  	{
          	return containsValue( ( V ) target );
        	}

        	public void clear() 
		  	{
          	AVLMap.this.clear();
        	}
      };
    }
    return collectionView;
  }//end collection V values() method
  
  public boolean isEmpty() 
  {
    return this.size() == 0;
  }

  /**
   * Return the number of entries in this map.
   * @return the number of entries in this map.
   */
  public int size() 
  {
    return this.size;
  }

  /**
   * Removes all the entries from this map.<P>
   * @post size() is 0
   */
  public void clear() 
  {
    this.size = 0;
    map.clear();
  }

  /**
   * Utility method to locate an entry in the hash table.
   * @param current the entry point to a hash chain
   * @param targetKey the key we are search for
   * @return null if the key was not found, a reference to its
   * entry otherwise
   */
  private Entry<K, V> find( Entry<K, V> current) 
  {
	 for(Entry e : map)
	 {
	 	if(current.key().equals(e.key()))
		{
			return current;
		}
	 }
	 System.out.println("Entry not found");
	return null;
  }

  /**
   * Compute a hash index for <code>key</code> in the range 0 to
   *  <code>this.capacity - 1</code>
   * @param <code>key</Code> the key for which we want a hash
   * index - cannot be null (not checked)
   * @return an integer in the range 0 to this.capacity - 1
   */

  
/************************************************
  may need to add resize method here
*************************************************/

	
	private class AVLMapIterator implements java.util.Iterator
	{
		/**
     * The bucket number of the currrent chain being
     * iterated over.
     */
		private int bucket;

    /**
     * Reference to the entry to be returned by the next call
     * to successor(); successor() makes cursor null when the entry has
     * been iterated over and hasNext() advances it to the
     * next entry to be returned.
     */
    	private LinkEntry<K, V> cursor;

    /**
     * Reference to the last entry returned by successor(). Use
     * this to advance through the chain for the bucket at
     * table[bucket].
     */
    	private LinkEntry<K, V> last;

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
     * the contract of remove() says that each call to remove()
     * must have been preceded by a call to successor() (they are
     * paired). So if there has been NO call to successor() prior to
     * a remove() or if there were two remove() calls without
     * an intervening successor() call, it is NOT ok to try to
     * remove an item.
     */
    	private boolean okToRemove;

    /**
     * The iterator type determines what kind of iterator
     * this is, which determines what is returned by successor():
     *  a key, a value or an entry.
     */
    	private int iteratorType;

    	public AVLMapIterator( int theType ) 
	 	{
      	iteratorType = theType;
      	bucket = -1;
      	cursor = last = null;
      	expectedModcount = modCount;
      	okToRemove = false;
    	}

    public boolean hasNext() 
	 {
      if ( expectedModcount != modCount ) 
		{
        throw new ConcurrentModificationException();
      }

      if ( bucket == size ) 
		{
        return false;
      }

      // see if client has consumed last entry found by
      // hasNext()
      if ( cursor != null ) 
		{
        return true;
      }

      // see if there are more entries in the current chain
      if ( last != null ) 
		{
        // get to next entry in the chain, if it exists
        cursor = last.successor();
        if ( cursor != null ) 
		  { // got an entry
          return true;
        }
        else 
		  { // exhausted this chain; advance in table
          last = null;
        }
      }

      // exhausted the last chain, advance to the next
      // non-empty bucket
      bucket++;
      while (  bucket < size ) 
		{
        bucket++;
      }
      if ( bucket >= size ) 
		{
        return false;
      }
      // at least one more entry to return
      if(bucket< size)
		{
			return true;
		}
		else
		{
      	return false;
		}
    }

    public Object next() 
	 {
      if ( !this.hasNext() ) 
		{
        throw new java.util.NoSuchElementException();
      }

      if ( expectedModcount != modCount ) 
		{
        throw new ConcurrentModificationException();
      }

      okToRemove = true;
      last = cursor;
      cursor = null;
      Object o = null;
      switch ( iteratorType ) 
		{
        case AVLMap.KEY_ITERATOR:
          o = ( Object ) last.key();
          break;
        case AVLMap.VALUE_ITERATOR:
          o = ( Object ) last.value();
          break;
        case AVLMap.ENTRY_ITERATOR:
          o = ( Object ) last;
      }
      return o;
    }

    /**
     * Remove the element returned by the last call to
     * <code>successor()</code>.
     * @throws <code>ConcurrentModificationException</code> if this
     * collection has been modified by a method outside of this
     * iterator.
     * @throws <code>IllegalStateException</code> if there has been
     *  no call to <code>successor()</code> for this iteration or if two
     * calls to <code>remove()</code> have been made with no
     * intervening call to <code>successor()</code>.
     */
    public void remove() 
	 {
      if ( expectedModcount != modCount ) 
		{
        throw new ConcurrentModificationException();
      }

      // check that there has been a successor() message to
      // provide an element to remove
      if ( !okToRemove ) 
		{
        throw new IllegalStateException();
      }

      expectedModcount++;
      okToRemove = false;
      AVLMap.this.remove( last.key() );
    }

	}//end AVLMapIterator class
}//end AVLMap class