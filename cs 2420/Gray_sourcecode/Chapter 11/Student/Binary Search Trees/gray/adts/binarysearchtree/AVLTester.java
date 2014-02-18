package gray.adts.binarysearchtree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;
import java.util.ArrayList;

/**
 * JUnit test of the BSTNode class
 */
public class AVLTester extends TestCase {

  private AVLTree<Integer> tree, tree2, tree3;

  /**
   * Sets up the text fixture.
   *
   * Called before every test case method.
   */
  protected void setUp() {
    tree = new AVLTree<Integer> ();

    tree2 = new AVLTree<Integer> ( 20 );

    // Should produce a balanced tree storing the values 1 - 7
    tree3 = new AVLTree<Integer> ( 4 );
    tree3.add( 2 );
    tree3.add( 6 );
    tree3.add( 1 );
    tree3.add( 3 );
    tree3.add( 7 );
    tree3.add( 5 );
  }

  /**
   * Tears down the text fixture.
   * Called after every test case method.
   */
  protected void tearDown() {
    tree = null;
    tree2 = null;
    tree3 = null;
  }

  public void testInstantiation() {
    // check out the tree made with the default constructor
    assertTrue( tree.size() == 0 );

    // now check out the tree made with the overloaded constructor
    assertTrue( tree2.size() == 1 );

    // see if we can create tree with a null element - this should throw
    //  an exception!
    try {
      tree2 = new AVLTree<Integer> ( null );
    }
    catch ( IllegalArgumentException e ) {
      return; // caught the exception, so make sure we don't get to fail()
    }
    fail(
        "constructor with null argument - should have thrown IllegalArgumentException " );
    System.err.println( "done testInstantiation()" );
  }

  public void testAddChildren() {
    assertEquals( tree3.size(), 7 );

    List<Integer> expectedTreeList = populateArrayList();

    List<Integer> actualTreeList = dumpToList( tree3 );
//        System.out.println("\nTree:");
//        java.util.Iterator iter = actualTreeList.iterator();
//        while ( iter.hasNext() )
//              System.out.print( iter.next() + " " );

    assertTrue( actualTreeList.equals( expectedTreeList ) );
//        System.out.println("done testAddChildren()" );
  }

  public void testContains() {
    assertTrue( tree3.contains( 4 ) ); // root
    assertTrue( tree3.contains( 2 ) ); // internal node
    assertTrue( tree3.contains( 7 ) ); // leaf
  }

  private List dumpToList( AVLTree<Integer> t ) {
    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    t.inOrderTraversal( treeVisitor );
    return treeVisitor.list();
  }

  private boolean isOrdered( List<Integer> list ) {
    java.util.Iterator<Integer> iter = list.iterator();
    Integer n = iter.next();
    while ( iter.hasNext() ) {
      if ( n.compareTo( iter.next() ) > 0 ) {
        return false;
      }
    }
    return true;
  }

  private void printList( List<? > list ) {
    for ( Object o : list ) {
      System.out.println( o );
    }
  }

  public void testLLRotationSimple() {
    AVLTree<Integer> tree = new AVLTree<Integer> ();
    tree.add( 20 );
    tree.add( 15 );
    tree.add( 27 );
    tree.add( 10 );
    tree.add( 5 );
    assertTrue( tree.size() == 5 );

    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree );
    assertTrue( actualTreeList.size() == tree.size() );
    assertTrue( isOrdered( actualTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testLLRotationComplex() {
    AVLTree<Integer> tree = new AVLTree<Integer> ();
    tree.add( 20 );
    tree.add( 15 );
    tree.add( 27 );
    tree.add( 10 );
    tree.add( 17 );
    tree.add( 12 );
    assertTrue( tree.size() == 6 );
//       System.out.println("testLLRotationComplex - DONE adding nodes");
    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree );
//        printList( actualTreeList );
    assertTrue( actualTreeList.size() == tree.size() );
    assertTrue( isOrdered( actualTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRRRotationSimple() {
    AVLTree<Integer> tree = new AVLTree<Integer> ();
    tree.add( 15 );
    tree.add( 10 );
    tree.add( 20 );
    tree.add( 25 );
    tree.add( 30 );
    assertTrue( tree.size() == 5 );

    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree );
    assertTrue( actualTreeList.size() == tree.size() );
    assertTrue( isOrdered( actualTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRRRotationComplex() {
    AVLTree<Integer> tree = new AVLTree<Integer> ();
//        System.out.println("testRRRotationComplex - adding nodes");
    tree.add( 15 );
    tree.add( 10 );
    tree.add( 20 );
    tree.add( 22 );
    tree.add( 25 );
    tree.add( 30 );
    assertTrue( tree.size() == 6 );
//        System.out.println("testRRRotationComplex - DONE adding nodes");
    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree );
//        printList( actualTreeList );
    assertTrue( actualTreeList.size() == tree.size() );
    assertTrue( isOrdered( actualTreeList ) );
    assertTrue( checkHeightAndBalance( tree, ( AVLNode ) tree.root() ) );
  }

  public void testRemoveLeaf() {
    tree3.remove( 1 );
    assertTrue( tree3.size() == 6 );

    List<Integer> expectedTreeList = populateArrayList();
    expectedTreeList.remove( new Integer( 1 ) );

//        System.out.println("expectedTreeList:");
//        printList( expectedTreeList );
    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.inOrderTraversal( treeVisitor );
    List<Integer> actualList = treeVisitor.list();
//         System.out.println("actualTreeList:");
//        printList( actualList );

    assertTrue( treeVisitor.list().equals( expectedTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRemoveInternal1Child() {
    List<Integer> expectedTreeList = populateArrayList();

    int target = 1;
    expectedTreeList.remove( new Integer( target ) );
    tree3.remove( target );
    assertTrue( tree3.size() == 6 );
    assertTrue( !tree3.contains( target ) );

    target = 2;
    expectedTreeList.remove( new Integer( target ) );
    tree3.remove( target );
    assertTrue( tree3.size() == 5 );
    assertTrue( !tree3.contains( target ) );

    expectedTreeList.remove( new Integer( target ) );
    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.inOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRemoveInternal2Children() {
//        System.out.println("testRemoveInternal2Children() - entering");
    List<Integer> expectedTreeList = populateArrayList();

    int target = 6;
    expectedTreeList.remove( new Integer( target ) );
    tree3.remove( target );
    assertTrue( tree3.size() == 6 );
    assertTrue( !tree3.contains( target ) );

    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree3 );
//        printList( actualTreeList );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
//        java.util.Iterator iter = tree3.iterator();
//        while ( iter.hasNext() )
//              System.out.println( iter.next() );

    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRemoveSimpleLLCase() {
    List<Integer> expectedTreeList = populateArrayList();

    int target = 0;
    tree3.add( target );
    assertTrue( tree3.size() == 8 );
    assertTrue( tree3.contains( target ) );
    expectedTreeList.add( 0, target );

    // This will create an LL imbalance
    target = 3;
    expectedTreeList.remove( new Integer( target ) );
    tree3.remove( target );
    assertTrue( tree3.size() == 7 );
    assertTrue( !tree3.contains( target ) );

    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.inOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRemoveRoot() {
//        System.out.println( "testRemoveRoot()" );
    int target = 4;
    tree3.remove( target );
    assertTrue( tree3.size() == 6 );
    assertTrue( !tree3.contains( target ) );
    List<Integer> expectedTreeList = populateArrayList();
    expectedTreeList.remove( new Integer( target ) );
//        System.out.println("dumping to a list");
    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( tree3 );
//        printList( actualTreeList );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
    assertTrue( checkHeightAndBalance( tree3, ( AVLNode ) tree3.root() ) );
  }

  public void testRemoveLLCase() {
    AVLTree<Integer> t = makeTree();
    ArrayList<Integer> expectedTreeList = ( ArrayList ) dumpToList( t );

    int target = 55;
    t.remove( target );
    assertTrue( !t.contains( target ) );
    expectedTreeList.remove( new Integer( target ) );
    assertTrue( checkHeightAndBalance( t, ( AVLNode ) t.root() ) );
    ArrayList actualTreeList = ( ArrayList ) dumpToList( t );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
  }

  public void testRemoveRRCase() {
    AVLTree<Integer> t = makeTree();
    ArrayList<Integer> expectedTreeList = ( ArrayList ) dumpToList( t );

    int target = 5;
    t.remove( target );
    assertTrue( !t.contains( target ) );
    expectedTreeList.remove( new Integer( target ) );
    assertTrue( checkHeightAndBalance( t, ( AVLNode ) t.root() ) );
    ArrayList<Integer> actualTreeList = ( ArrayList ) dumpToList( t );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
  }

  public void testRemoveLRCase() {
    AVLTree<Integer> t = makeTree();
    ArrayList<Integer> expectedTreeList = ( ArrayList ) dumpToList( t );

    int target = 30;
    t.remove( target );
    assertTrue( !t.contains( target ) );
    expectedTreeList.remove( target );
    assertTrue( checkHeightAndBalance( t, ( AVLNode ) t.root() ) );
    ArrayList actualTreeList = ( ArrayList ) dumpToList( t );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
  }

  public void testRemoveRLCase() {
    AVLTree<Integer> t = makeTree();
    ArrayList<Integer> expectedTreeList = ( ArrayList ) dumpToList( t );

    int target = 40;
    t.remove( target );
    assertTrue( !t.contains( target ) );
    expectedTreeList.remove( new Integer( target ) );
    assertTrue( checkHeightAndBalance( t, ( AVLNode ) t.root() ) );
    ArrayList actualTreeList = ( ArrayList ) dumpToList( t );
    //printList( actualTreeList );
    assertTrue( actualTreeList.equals( expectedTreeList ) );
  }

  private AVLTree makeTree() {
    AVLTree<Integer> t = new AVLTree<Integer> ();
    t.add( 40 );
    t.add( 20 );
    t.add( 50 );
    t.add( 10 );
    t.add( 30 );
    t.add( 45 );
    t.add( 60 );
    t.add( 5 );
    t.add( 15 );
    t.add( 22 );
    t.add( 55 );
    t.add( 17 );
    return t;
  }

  private ArrayList populateArrayList() {
    ArrayList<Integer> expectedTreeList = new ArrayList<Integer> ();
    expectedTreeList.add( 1 );
    expectedTreeList.add( 2 );
    expectedTreeList.add( 3 );
    expectedTreeList.add( 4 );
    expectedTreeList.add( 5 );
    expectedTreeList.add( 6 );
    expectedTreeList.add( 7 );
    return expectedTreeList;
  }

  private boolean checkHeightAndBalance( AVLTree<Integer> t,
                                         AVLNode<Integer> node ) {
//        System.out.println("doInOrderTraversal");
    if ( node == null ) {
      return true;
    }

    boolean leftCheck = checkHeightAndBalance( t, ( AVLNode ) node.leftChild );
    boolean rightCheck = checkHeightAndBalance( t, ( AVLNode ) node.rightChild );
    //System.out.println( "traversal: visiting node " + node.element );
    int leftHeight = t.height( ( AVLNode ) node.leftChild );
    int rightHeight = t.height( ( AVLNode ) node.rightChild );
    int checkedHeight = ( leftHeight > rightHeight ? leftHeight : rightHeight ) +
        1;
    int checkedBalance = leftHeight - rightHeight;
    boolean thisCheck = ( checkedHeight == node.height ) &&
        ( checkedBalance == node.balance );
    if ( !leftCheck ) {
      System.out.println( "left check failed on " + ( AVLNode ) node.leftChild );
      System.out.println( "Expected: Balance: " + checkedBalance + " Height: " +
                          checkedHeight );
    }
    if ( !rightCheck ) {
      System.out.println( "right check failed on " +
                          ( AVLNode ) node.rightChild );
      System.out.println( "Expected: Balance: " + checkedBalance + " Height: " +
                          checkedHeight );
    }
    if ( !thisCheck ) {
      System.out.println( "this check failed on " + ( AVLNode ) node );
      System.out.println( "Expected: Balance: " + checkedBalance + " Height: " +
                          checkedHeight );
    }
//        System.out.println("checkHeightAndBalance: leftCheck = " + leftCheck +
//                       "  rightCheck = " + rightCheck + "  thisCheck = " + thisCheck );
    return leftCheck && rightCheck && thisCheck;
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
    TestSuite suite = new TestSuite( AVLTester.class );
    return suite;
  }

  /**
   * Main.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        AVLTester.class.getName()};
    //junit.textui.TestRunner.main(testCaseName);
    junit.swingui.TestRunner.main( testCaseName );
    //junit.ui.TestRunner.main(testCaseName);
  }
}
