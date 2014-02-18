package gray.adts.stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.EmptyStackException;

/**
 * Implementation of the Stack ADT using a List as the underlying data
 * structure following the Adapter design pattern.
 */

public class StackTester extends TestCase {

  private Stack<String> stack;

  /**
   * Constructs a <code>StackTester</code> with
   * the specified name.
   *
   * @param name Test case name.
   */
  public StackTester( String name ) {
    super( name );
  }

  /**
   * Sets up the text fixture.
   *
   * Called before every test case method.
   */
  protected void setUp() {
    stack = new ListStack<String> ();
  }

  /**
   * Tears down the text fixture.
   *
   * Called after every test case method.
   */
  protected void tearDown() {
    stack = null;
  }

  public void testPopEmpty() {
    Stack<String> s = new ListStack<String> ();

    try {
      s.pop();
    }
    catch ( EmptyStackException ex ) {
      return;
    }
    fail( "Should have raised an EmptyStackException here" );
  }

  public void testPeekEmpty() {
    Stack<String> s = new ListStack<String> ();

    try {
      s.peek();
    }
    catch ( EmptyStackException ex ) {
      return;
    }
    fail( "Should have raised an EmptyStackException here" );
  }

  public void testPushPopOne() {
    String pushedString = "www.nps.gov";
    stack.push( pushedString );
    assertEquals( stack.size(), 1 );
    assertTrue( !stack.isEmpty() );
    assertEquals( ( String ) stack.peek(), pushedString );
    String poppedString = ( String ) stack.pop();
    assertEquals( pushedString, poppedString );
    assertEquals( stack.size(), 0 );
    assertTrue( stack.isEmpty() );
  }


  /**
   * Assembles and returns a test suite for
   * all the test methods of this test case.
   *
   * @return A non-null test suite.
   */
  public static Test suite() {
    // Reflection is used here to add all
    // the testXXX() methods to the suite.
    TestSuite suite = new TestSuite( StackTester.class );

    return suite;
  }

  /**
   * Main.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        StackTester.class.getName()};
    junit.swingui.TestRunner.main( testCaseName );
  }
}
