package gray.adts.binarysearchtree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;
import java.util.ArrayList;

/**
 * Description:  JUnit test of the BSTNode class
 * @author Simon Gray
 * @version 1.0
 */
public class SearchTreeTester extends TestCase {

  private LinkedBST tree, tree2, tree3, longLeft, longRight;

  /**
   * Constructs a <code>SearchTreeTester</code> with
   * the specified name.
   *
   * @param name Test case name.
   */
  public SearchTreeTester( String name ) {
    super( name );
  }

  /**
   * Sets up the text fixture.
   *
   * Called before every test case method.
   */
  protected void setUp() {
    tree = new LinkedBST();

    tree2 = new LinkedBST( new Integer( 2 ) );

    // Should produce a balanced tree storing the values 1 - 7
    tree3 = new LinkedBST( new Integer( 4 ) );
    tree3.add( new Integer( 2 ) );
    tree3.add( new Integer( 1 ) );
    tree3.add( new Integer( 3 ) );
    tree3.add( new Integer( 6 ) );
    tree3.add( new Integer( 5 ) );
    tree3.add( new Integer( 7 ) );
  }

  /**
   * Tears down the text fixture.
   *
   * Called after every test case method.
   */
  protected void tearDown() {
    tree = null;
    tree2 = null;
    tree3 = null;
  }

  public void testInstantiation() {
    // check out the tree made with the default constructor
    assert ( tree.size() == 0 );

    // now check out the tree made with the overloaded constructor
    assert ( tree2.size() == 1 );

    // see if we can create tree with a null element - this should throw
    //  an exception!
    try {
      tree2 = new LinkedBST( null );
    }
    catch ( IllegalArgumentException e ) {
      return; // caught the exception, so make sure we don't get to fail()
    }
    fail(
        "constructor with null argument - should have thrown IllegalArgumentException " );
    System.err.println( "done testInstantiation()" );
  }

  /**
   * This is a Testing and Debugging exercise for chapter 11.
   */
  public void testAddFromBook() {
    Integer i1 = new Integer( 1 );
    Integer i5 = new Integer( 5 );
    Integer i10 = new Integer( 10 );

    List expected = new ArrayList();

    assert ( tree.size() == 0 );
    tree.add( i10 );
    expected.add( i10 );
    assert ( tree.size() == 1 );
    assert ( tree.contains( i10 ) );

    tree.add( i5 );
    expected.add( i5 );
    assert ( tree.size() == 2 );
    assert ( tree.contains( i5 ) );

    tree.add( i1 );
    expected.add( i1 );
    assert ( tree.size() == 3 );
    assert ( tree.contains( i1 ) );

    List actual = toList( tree );
    assert ( actual.containsAll( expected ) );
    assert ( expected.containsAll( actual ) );
  }

  public void testAddChildren() {
    assertEquals( tree3.size(), 7 );

    List expectedTreeList = populateArrayList();

    ToListVisitor treeVisitor = new ToListVisitor();
    tree3.inOrderTraversal( treeVisitor );

    assert ( treeVisitor.list().equals( expectedTreeList ) );
    System.out.println( "done testAddChildren()" );
  }

  public void testContains() {
    assert ( tree3.contains( new Integer( 4 ) ) ); // root
    assert ( tree3.contains( new Integer( 2 ) ) ); // internal node
    assert ( tree3.contains( new Integer( 7 ) ) ); // leaf
  }

  public void testRemoveLeaf() {
    tree3.remove( new Integer( 1 ) );
    assert ( tree3.size() == 6 );

    List expectedTreeList = populateArrayList();
    expectedTreeList.remove( new Integer( 1 ) );

//        System.out.println("expectedTreeList:");
//        java.util.Iterator iter = expectedTreeList.iterator();
//        while ( iter.hasNext() )
//              System.out.print( iter.next() + " " );

    ToListVisitor treeVisitor = new ToListVisitor();
    tree3.inOrderTraversal( treeVisitor );
//        System.out.println("\nTree:");
//        iter = treeVisitor.list().iterator();
//        while ( iter.hasNext() )
//              System.out.print( iter.next() + " " );
    assert ( treeVisitor.list().equals( expectedTreeList ) );

    tree3.remove( new Integer( 7 ) );
    assert ( tree3.size() == 5 );
    expectedTreeList.remove( new Integer( 7 ) );
    treeVisitor = new ToListVisitor();
    tree3.inOrderTraversal( treeVisitor );
    assert ( treeVisitor.list().equals( expectedTreeList ) );
  }

  public void testRemoveInternal() {
    Integer target = new Integer( 2 );
    tree3.remove( target );
    assert ( tree3.size() == 6 );
    assert ( !tree3.contains( target ) );
    List expectedTreeList = populateArrayList();
    expectedTreeList.remove( target );
    ToListVisitor treeVisitor = new ToListVisitor();
    tree3.inOrderTraversal( treeVisitor );
    assert ( treeVisitor.list().equals( expectedTreeList ) );
  }

  public void testRemoveRoot() {
    Integer target = new Integer( 4 );
    tree3.remove( target );
    assert ( tree3.size() == 6 );
    assert ( !tree3.contains( target ) );
    List expectedTreeList = populateArrayList();
    expectedTreeList.remove( target );
    ToListVisitor treeVisitor = new ToListVisitor();
    tree3.inOrderTraversal( treeVisitor );
    assert ( treeVisitor.list().equals( expectedTreeList ) );
  }

  /**
   * The tree consists of just a single node, which we remove. Need to
   * make sure that root is null.
   */
  public void testRemoveOnlyNode() {
    Integer i = new Integer( 2 );
    tree2.remove( i );
    assert ( !tree2.contains( i ) );
    assert ( tree2.root() == null );
    assert ( tree2.size() == 0 );
  }

  /**
   * The tree consists of two nodes - the root, which we remove and a left
   * child. Need to make sure that root becomes the left child.
   */
  public void testRemoveRootWithLeftChild() {
    Integer i = new Integer( 2 );
    tree2.add( new Integer( 1 ) ); // root's left child
    tree2.remove( i ); // remove the root
    assert ( !tree2.contains( i ) );
    assert ( tree2.root().element.equals( new Integer( 1 ) ) );
    assert ( tree2.size() == 1 );
  }

  /**
   * The tree consists of two nodes - the root, which we remove and a right
   * child. Need to make sure that root becomes the right child.
   */
  public void testRemoveRootWithRightChild() {
    Integer i = new Integer( 2 );
    tree2.add( new Integer( 3 ) ); // root's right child
    tree2.remove( i ); // remove the root
    assert ( !tree2.contains( i ) );
    assert ( tree2.root().element.equals( new Integer( 3 ) ) );
    assert ( tree2.size() == 1 );
  }

  /**
   * The tree consists of three nodes - the root, which we remove and its
   * two children. Need to make sure that root becomes the right child.
   */
  public void testRemoveRootWithTwoChildren() {
    Integer i = new Integer( 2 );
    tree2.add( new Integer( 1 ) ); // root's left child
    tree2.add( new Integer( 3 ) ); // root's right child
    tree2.remove( i ); // remove the root
    assert ( !tree2.contains( i ) );
    assert ( tree2.root().element.equals( new Integer( 3 ) ) );
    assert ( tree2.size() == 2 );
  }

  private ArrayList toList( BinarySearchTree tree ) {
    java.util.Iterator iter = tree.iterator();
    ArrayList list = new ArrayList();
    while ( iter.hasNext() ) {
      list.add( iter.next() );
    }
    return list;
  }

  private ArrayList populateArrayList() {
    ArrayList expectedTreeList = new ArrayList();
    expectedTreeList.add( new Integer( 1 ) );
    expectedTreeList.add( new Integer( 2 ) );
    expectedTreeList.add( new Integer( 3 ) );
    expectedTreeList.add( new Integer( 4 ) );
    expectedTreeList.add( new Integer( 5 ) );
    expectedTreeList.add( new Integer( 6 ) );
    expectedTreeList.add( new Integer( 7 ) );
    return expectedTreeList;
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
    TestSuite suite = new TestSuite( SearchTreeTester.class );
    return suite;
  }

  /**
   * Main.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        SearchTreeTester.class.getName()};
    //junit.textui.TestRunner.main(testCaseName);
    junit.swingui.TestRunner.main( testCaseName );
    //junit.ui.TestRunner.main(testCaseName);
  }
}
