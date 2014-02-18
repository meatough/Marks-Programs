package gray.adts.ch3;

import junit.framework.*;

public class TestDoublyLinkedList extends TestCase {
  private DoublyLinkedList<String> doublyLinkedList = null;

  protected void setUp() throws Exception {
    super.setUp();
    doublyLinkedList = new DoublyLinkedList<String> ();
  }

  protected void tearDown() throws Exception {
    doublyLinkedList = null;
    super.tearDown();
  }

  private boolean bidirectionalTraversal( DoublyLinkedList l ) {
    DLNode cursor = l.head;
    while ( cursor != l.tail ) {
      cursor = ( DLNode ) cursor.getSuccessor();
    }
    cursor = l.tail;
    while ( cursor != l.head ) {
      cursor = cursor.getPredecessor();
    }
    return true;
  }

  public void testdoublyLinkedList() {
    doublyLinkedList = new DoublyLinkedList();
    assertEquals( 0, doublyLinkedList.getLength() );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testAdd() {
    String e = new String( "one" );
    doublyLinkedList.add( e );
    assertEquals( 1, doublyLinkedList.getLength() );
    String eget = doublyLinkedList.getElementAt( 0 );
    assertEquals( eget, e );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testAddAtPosition0() {
    String e1 = new String( "one" );
    doublyLinkedList.add( e1 );
    String e2 = new String( "two" ); ;
    int p = 0;
    doublyLinkedList.add( e2, p );
    assertEquals( 2, doublyLinkedList.getLength() );

    String eget = ( String ) doublyLinkedList.getElementAt( 0 );
    assertEquals( eget, e2 );
    eget = doublyLinkedList.getElementAt( 1 );
    assertEquals( eget, e1 );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testAddAtMiddlePosition() {
    String e1 = new String( "one" );
    doublyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    doublyLinkedList.add( e2, 1 );
    String e3 = new String( "three" ); ;
    doublyLinkedList.add( e3, 1 );
    assertEquals( 3, doublyLinkedList.getLength() );

    String eget = doublyLinkedList.getElementAt( 0 );
    assertEquals( eget, e1 );
    eget = doublyLinkedList.getElementAt( 1 );
    assertEquals( eget, e3 );
    eget = doublyLinkedList.getElementAt( 2 );
    assertEquals( eget, e2 );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testRemoveSingleton() {
    String e1 = new String( "one" );
    doublyLinkedList.add( e1, 0 );
    String expectedReturn = e1;
    String actualReturn = doublyLinkedList.remove( 0 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 0, doublyLinkedList.getLength() );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testRemoveLast() {
    String e1 = new String( "one" );
    doublyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    doublyLinkedList.add( e2, 1 );
    String expectedReturn = e2;
    String actualReturn = ( String ) doublyLinkedList.remove( 1 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 1, doublyLinkedList.getLength() );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testRemoveMiddle() {
    String e1 = new String( "one" );
    doublyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    doublyLinkedList.add( e2, 1 );
    String e3 = new String( "three" ); ;
    doublyLinkedList.add( e3, 2 );
    assertEquals( 3, doublyLinkedList.getLength() );
    String expectedReturn = e2;
    String actualReturn = doublyLinkedList.remove( 1 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 2, doublyLinkedList.getLength() );
    this.assertTrue( bidirectionalTraversal( doublyLinkedList ) );
  }

  public void testBadIndexAdd() {
    try {
      String e1 = new String( "one" );
      doublyLinkedList.add( e1, 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Add - Exception should have been thrown" );
  }

  public void testBadIndexRemove() {
    try {
      doublyLinkedList.remove( 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Remove - Exception should have been thrown" );
  }

  public void testBadIndexFind() {
    try {
      doublyLinkedList.getElementAt( 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Find - Exception should have been thrown" );
  }

  public static Test suite() {
    // The simplest approach is to let Junit do all the work using
    // Java's reflection mechanism.
    return new TestSuite( TestDoublyLinkedList.class );
  }

  public static void main( String[] args ) {
    // Use Java's reflection mechanism to get the name of this class.
    String[] TestCaseName = {
        TestDoublyLinkedList.class.getName()};
    junit.swingui.TestRunner.main( TestCaseName );
    //junit.textui.TestRunner.run (suite());
    //junit.ui.TestRunner.main(TestCaseName);
  }
}
