package gray.adts.ch3;

import junit.framework.*;

public class TestSinglyLinkedList extends TestCase {
  private SinglyLinkedList<String> singlyLinkedList = null;

  protected void setUp() throws Exception {
    super.setUp();
    singlyLinkedList = new SinglyLinkedList<String> ();
  }

  protected void tearDown() throws Exception {
    singlyLinkedList = null;
    super.tearDown();
  }

  public void testSinglyLinkedList() {
    singlyLinkedList = new SinglyLinkedList<String> ();
    assertEquals( 0, singlyLinkedList.getLength() );
  }

  public void testAdd() {
    String e = new String( "one" );
    singlyLinkedList.add( e );
    assertEquals( 1, singlyLinkedList.getLength() );
    String eget = singlyLinkedList.getElementAt( 0 );
    assertEquals( eget, e );
  }

  public void testAddAtPosition0() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1 );
    String e2 = new String( "two" ); ;
    int p = 0;
    singlyLinkedList.add( e2, p );
    assertEquals( 2, singlyLinkedList.getLength() );

    String eget = singlyLinkedList.getElementAt( 0 );
    assertEquals( eget, e2 );
    eget = singlyLinkedList.getElementAt( 1 );
    assertEquals( eget, e1 );
  }

  public void testAddAtMiddlePosition() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    singlyLinkedList.add( e2, 1 );
    String e3 = new String( "three" ); ;
    singlyLinkedList.add( e3, 1 );
    assertEquals( 3, singlyLinkedList.getLength() );

    String eget = singlyLinkedList.getElementAt( 0 );
    assertEquals( eget, e1 );
    eget = singlyLinkedList.getElementAt( 1 );
    assertEquals( eget, e3 );
    eget = singlyLinkedList.getElementAt( 2 );
    assertEquals( eget, e2 );
  }

  public void testRemoveSingleton() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1, 0 );
    String expectedReturn = e1;
    String actualReturn = singlyLinkedList.remove( 0 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 0, singlyLinkedList.getLength() );
  }

  public void testRemoveLast() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    singlyLinkedList.add( e2, 1 );
    String expectedReturn = e2;
    String actualReturn = singlyLinkedList.remove( 1 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 1, singlyLinkedList.getLength() );
  }

  public void testRemoveBadIndexLast() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    singlyLinkedList.add( e2, 1 );
    try {
      singlyLinkedList.remove( singlyLinkedList.getLength() );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Remove - Exception should have been thrown" );
  }

  public void testRemoveMiddle() {
    String e1 = new String( "one" );
    singlyLinkedList.add( e1, 0 );
    String e2 = new String( "two" ); ;
    singlyLinkedList.add( e2, 1 );
    String e3 = new String( "three" ); ;
    singlyLinkedList.add( e3, 2 );
    assertEquals( 3, singlyLinkedList.getLength() );
    String expectedReturn = e2;
    String actualReturn = singlyLinkedList.remove( 1 );
    assertEquals( "return value", expectedReturn, actualReturn );
    assertEquals( 2, singlyLinkedList.getLength() );
  }

  public void testBadIndexAdd() {
    try {
      String e1 = new String( "one" );
      singlyLinkedList.add( e1, 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Add - Exception should have been thrown" );
  }

  public void testBadIndexRemove() {
    try {
      singlyLinkedList.remove( 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Remove - Exception should have been thrown" );
  }

  public void testBadIndexFind() {
    try {
      singlyLinkedList.getElementAt( 1 );
    }
    catch ( IndexOutOfBoundsException e ) {
      return;
    }
    fail( "Bad Index Find - Exception should have been thrown" );
  }

  public static Test suite() {
    // The simplest approach is to let Junit do all the work using
    // Java's reflection mechanism.
    return new TestSuite( TestSinglyLinkedList.class );
  }

  public static void main( String[] args ) {
    // Use Java's reflection mechanism to get the name of this class.
    String[] TestCaseName = {
        TestSinglyLinkedList.class.getName()};
    junit.swingui.TestRunner.main( TestCaseName );
    //junit.textui.TestRunner.run (suite());
    //junit.ui.TestRunner.main(TestCaseName);
  }
}
