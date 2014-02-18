package gray.adts.heap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * JUnit test program for the Heap ADT.
 */
public class HeapTester extends TestCase {

  private Heap<Integer> heap;
  private Comparator<Integer> integerComparator;
  /**
   * Sets up the text fixture.
   * Called before every test case method.
   */
  protected void setUp() {
    integerComparator = new Comparator<Integer> () {
      public int compare( Integer o1, Integer o2 ) {
        return o1.compareTo( o2 );
      }
    };
    heap = new ArrayMinHeap<Integer> ( integerComparator );
  }

  /**
   * Tears down the text fixture.
   * Called after every test case method.
   */
  protected void tearDown() {
    heap = null;
  }

  public void testEmptyInstantiation() {
    assertEquals( heap.size(), 0 );
    assertTrue( heap.isEmpty() );
  }

  public void testCollectionInstantiation() {
    List list = new ArrayList();

    list.add( 7 );
    list.add( 6 );
    list.add( 6 );
    list.add( 4 );
    list.add( 3 );
    list.add( 2 );
    list.add( 1 );
    list.add( 0 );
    java.util.Collections.shuffle( list );

    /*            final Comparator integerComparator = new Comparator() {
                   public int compare( Object o1, Object o2 ) {
                      return ((Integer)o1).compareTo( (Integer) o2 );
                   }
                };
     */
    Heap<Integer> heap = new ArrayMinHeap<Integer> ( list, integerComparator );

    int size = 8;
    assertEquals( heap.size(), size );

    List<Integer> heapList = new ArrayList<Integer> ();
    while ( !heap.isEmpty() ) {
      heapList.add( heap.top() );
      size--;
      assertTrue( heap.size() == size );
    }
    java.util.Collections.sort( list );
    assertTrue( list.equals( heapList ) );
  }

  public void testTopEmpty() {
    try {
      heap.top();
    }
    catch ( EmptyHeapException ex ) {
      return;
    }
    fail( "Should have raised an EmptyHeapException here" );
  }

  public void testAddReverseOrder() {
    List<Integer> list = new ArrayList<Integer> ();

    list.add( 7 );
    list.add( 6 );
    list.add( 5 );
    list.add( 4 );
    list.add( 3 );
    list.add( 2 );
    list.add( 1 );
    list.add( 0 );

    for ( Integer i : list ) {
      heap.add( i );
    }

    int size = 8;
    assertEquals( heap.size(), size );

    List<Integer> heapList = new ArrayList<Integer> ();
    while ( !heap.isEmpty() ) {
      heapList.add( heap.top() );
      size--;
      assertTrue( heap.size() == size );
    }
    java.util.Collections.sort( list );
    assertTrue( list.equals( heapList ) );
  }

  public void testClear() {
    heap.add( 1 );
    heap.add( 3 );
    heap.add( 5 );
    heap.add( 4 );
    heap.add( 7 );
    assertEquals( heap.size(), 5 );

    heap.clear();
    assertEquals( heap.size(), 0 );
    assertTrue( heap.isEmpty() );
  }

  public void testPeek() {
    heap.add( 1 );
    heap.add( 3 );
    heap.add( 5 );
    assertEquals( heap.size(), 3 );
    Integer theTop = heap.top();
    assertTrue( theTop.compareTo( 1 ) == 0 );
  }

//    public void testEnqueueDequeueOne() {
//        String aString = "www.nps.gov";
//        queue.enqueue( aString );
//        assertEquals( queue.size(), 1 );
//        assertTrue(!queue.isEmpty());
//        assertEquals( (String)queue.peek(), aString );
//        String poppedString = (String) queue.dequeue();
//        assertEquals( aString, poppedString );
//        assertEquals( queue.size(), 0 );
//        assertTrue( queue.isEmpty() );
//    }


  /**
   * Assembles and returns a test suite for
   * all the test methods of this test case.
   *
   * @return A non-null test suite.
   */
  public static Test suite() {
    TestSuite suite = new TestSuite( HeapTester.class );
    return suite;
  }

  /**
   * Main.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        HeapTester.class.getName()};
    //junit.textui.TestRunner.main(testCaseName);
    junit.swingui.TestRunner.main( testCaseName );
    //junit.ui.TestRunner.main(testCaseName);
  }
}
