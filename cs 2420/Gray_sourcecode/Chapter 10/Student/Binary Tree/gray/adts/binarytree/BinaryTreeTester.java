package gray.adts.binarytree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;
import java.util.ArrayList;

/**
 * JUnit test of the BinaryTreeNode class
 */
public class BinaryTreeTester extends TestCase {

  private BinaryTree<Integer> tree, tree2, tree3,
      longLeft, longRight;
  private ArrayList<Integer> expectedTree3List;

  /**
   * Sets up the text fixture.
   * Called before every test case method.
   */
  protected void setUp() {
    tree = new LinkedBinaryTree<Integer> ();

    tree2 = new LinkedBinaryTree<Integer> ( 2 );

    tree3 = new LinkedBinaryTree<Integer> ( 2 );
    BinaryTreeNode<Integer> lchild =
        tree3.makeLeftChild( tree3.root(), 1 );
    BinaryTreeNode<Integer> rchild =
        tree3.makeRightChild( tree3.root(), 3 );
    tree3.makeLeftChild( lchild, 4 );
    tree3.makeRightChild( lchild, 5 );
    tree3.makeLeftChild( rchild, 6 );
    tree3.makeRightChild( rchild, 7 );

    expectedTree3List = new ArrayList();
    expectedTree3List.add( 1 );
    expectedTree3List.add( 2 );
    expectedTree3List.add( 3 );
    expectedTree3List.add( 4 );
    expectedTree3List.add( 5 );
    expectedTree3List.add( 6 );
    expectedTree3List.add( 7 );
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
    expectedTree3List = null;
  }

  public void testInstantiation() {
    // check out the tree made with the default constructor
    assertTrue( tree.size() == 0 );
    assertTrue( tree.root() == null );
    // see if we can add a root to this empty tree
    BinaryTreeNode<Integer> root = tree.makeRoot( 2 );
    assertTrue( root.element().equals( 2 ) );
    assertTrue( tree.size() == 1 );

    // now check out the tree made with the overloaded constructor
    assertTrue( tree2.size() == 1 );
    assertTrue( tree2.root() != null );
    BinaryTreeNode<Integer> root2 = tree2.root();
//        assertTrue( tree2.leftChild( root2 ) == null );
//        assertTrue( tree2.rightChild( root2 ) == null );

    // see if we can add a root to a non-empty tree - this should throw
    //  an exception!
    try {
      tree2.makeRoot( 0 );
    }
    catch ( TreeException e ) {
      return; // caught the exception, so make sure we don't get to fail()
    }
    fail( "makeRoot() should have thrown TreeException" );
  }

  public void testMergeTrees() {
    BinaryTree<Integer>
        mergedTree = new LinkedBinaryTree<Integer> ( tree2, 0, tree3 );
    assertEquals( mergedTree.size(), 9 );

    List<Integer> expectedTreeList = new ArrayList<Integer> ();
    expectedTreeList.add( 0 );
    expectedTreeList.add( 2 );
    expectedTreeList.add( 2 );
    expectedTreeList.add( 1 );
    expectedTreeList.add( 4 );
    expectedTreeList.add( 5 );
    expectedTreeList.add( 3 );
    expectedTreeList.add( 6 );
    expectedTreeList.add( 7 );

    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    mergedTree.preOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );

    mergedTree = new LinkedBinaryTree<Integer> ( null, 0, tree3 );
    assertEquals( mergedTree.size(), 8 );
    expectedTreeList.remove( 2 );
    treeVisitor = new ToListVisitor<Integer> ();
    mergedTree.preOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );

    // Now try with the right subtree null
    mergedTree = new LinkedBinaryTree<Integer> ( tree3, 0, null );
    assertEquals( mergedTree.size(), 8 );
    treeVisitor = new ToListVisitor<Integer> ();
    mergedTree.preOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );

  }

  public void testAddChildren() {
    BinaryTreeNode<Integer> root = tree2.root();

    BinaryTreeNode<Integer> lchild = tree2.makeLeftChild( root, 1 );
    assertTrue( tree2.size() == 2 );
    BinaryTreeNode<Integer> theLeftChild = root.leftChild();
    assert ( lchild == theLeftChild );
    assertTrue( lchild.element().equals( 1 ) );
    assertTrue( lchild.parent() == root );

    BinaryTreeNode<Integer> rchild = tree2.makeRightChild( root, 3 );
    assertTrue( tree2.size() == 3 );
    BinaryTreeNode<Integer> theRightChild = root.rightChild();
    assert ( rchild == theRightChild );
    assertTrue( rchild.parent() == root );
    assertTrue( rchild.element().equals( 3 ) );
  }

  /**
   * Verify that the traversals work. We do this by making a three node tree
   * which produces 1 2 3 when visited in order. A visitor is used that converts
   * the tree into a List. The order of elements in the list is compared against
   * the expected order from a particular traversal using List.equals().
   */
  public void testTraversals() {
    // first, make a 3 node tree with 2 at the root
    BinaryTreeNode<Integer> root = tree2.root();
    BinaryTreeNode<Integer> lchild = tree2.makeLeftChild( root, 1 );
    BinaryTreeNode<Integer> rchild = tree2.makeRightChild( root, 3 );

    List<Integer> orderedList = new ArrayList<Integer> ();
    orderedList.add( 1 );
    orderedList.add( 2 );
    orderedList.add( 3 );

    ToListVisitor<Integer> inOrder = new ToListVisitor<Integer> ();
    tree2.inOrderTraversal( inOrder );
    assertTrue( inOrder.list().equals( orderedList ) );

    orderedList = new ArrayList<Integer> ();
    orderedList.add( 2 );
    orderedList.add( 1 );
    orderedList.add( 3 );

    ToListVisitor<Integer> preOrder = new ToListVisitor<Integer> ();
    tree2.preOrderTraversal( preOrder );
    assertTrue( preOrder.list().equals( orderedList ) );

    orderedList = new ArrayList<Integer> ();
    orderedList.add( 1 );
    orderedList.add( 3 );
    orderedList.add( 2 );

    ToListVisitor<Integer> postOrder = new ToListVisitor<Integer> ();
    tree2.postOrderTraversal( postOrder );
    assertTrue( postOrder.list().equals( orderedList ) );

    // add another level of nodes for the level order test
    orderedList = new ArrayList<Integer> ();
    orderedList.add( 2 );
    orderedList.add( 1 );
    orderedList.add( 3 );
    orderedList.add( 4 );
    orderedList.add( 5 );
    orderedList.add( 6 );
    orderedList.add( 7 );
    ToListVisitor<Integer> levelOrder = new ToListVisitor<Integer> ();
    tree3.levelOrderTraversal( levelOrder );
    assertTrue( levelOrder.list().equals( orderedList ) );
  }

  /**
   * Looks at a linear tree down the left side (4 nodes)
   */
  public void testLongLeft() {
    longLeft = new LinkedBinaryTree<Integer> ( 1 );
    BinaryTreeNode<Integer> child = longLeft.makeLeftChild( longLeft.root(), 2 );
    child = longLeft.makeLeftChild( child, 3 );
    longLeft.makeLeftChild( child, 4 );
    assertTrue( longLeft.size() == 4 );

    List<Integer> expectedTreeList = new ArrayList<Integer> ();
    expectedTreeList.add( 1 );
    expectedTreeList.add( 2 );
    expectedTreeList.add( 3 );
    expectedTreeList.add( 4 );

    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    longLeft.preOrderTraversal( treeVisitor );
    assertTrue( treeVisitor.list().equals( expectedTreeList ) );
  }

  /**
   * Looks at a linear tree down the right side (4 nodes)
   */
  public void testLongRight() {
    BinaryTree<Integer> longRight = new LinkedBinaryTree<Integer> ( 1 );
    BinaryTreeNode<Integer>
        child = longRight.makeRightChild( longRight.root(), 2 );
    child = longRight.makeRightChild( child, 3 );
    longRight.makeRightChild( child, 4 );
    assertTrue( longRight.size() == 4 );

    List<Integer> expectedTreeList = new ArrayList<Integer> ();
    expectedTreeList.add( 1 );
    expectedTreeList.add( 2 );
    expectedTreeList.add( 3 );
    expectedTreeList.add( 4 );

    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    longRight.preOrderTraversal( treeVisitor );
    List<Integer> actualTreeList = ( List<Integer> ) treeVisitor.list();
    assertTrue( actualTreeList.equals( expectedTreeList ) );
  }

  public void testRemoveLeaf() {
    BinaryTreeNode<Integer> root = tree3.root();
    BinaryTreeNode<Integer> leaf = root.leftChild().leftChild();
    tree3.remove( leaf );
    assertTrue( tree3.size() == 6 );

    expectedTree3List.remove( leaf.element() );

    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.preOrderTraversal( treeVisitor );
    assert ( expectedTree3List.containsAll( treeVisitor.list() ) );
    assertTrue( treeVisitor.list().containsAll( expectedTree3List ) );
  }

  public void testRemoveInternal() {
    BinaryTreeNode<Integer> internal = tree3.root().leftChild();
    Integer target = internal.element();
    expectedTree3List.remove( target );
    tree3.remove( internal );
    assertTrue( tree3.size() == expectedTree3List.size() );
    assert ( !tree3.contains( target ) );
    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.preOrderTraversal( treeVisitor );
    assertTrue( expectedTree3List.containsAll( treeVisitor.list() ) );
    assertTrue( treeVisitor.list().containsAll( expectedTree3List ) );
  }

  public void testRemoveRoot() {
    BinaryTreeNode<Integer> root = tree3.root();
    Integer target = root.element();
    expectedTree3List.remove( target );
    tree3.remove( root );
    assertTrue( !tree3.contains( target ) );
    ToListVisitor<Integer> treeVisitor = new ToListVisitor<Integer> ();
    tree3.preOrderTraversal( treeVisitor );
    assertTrue( expectedTree3List.containsAll( treeVisitor.list() ) );
    assertTrue( treeVisitor.list().containsAll( expectedTree3List ) );
  }

  private void printList( String msg, List<Integer> list ) {
    System.out.println( msg );
    java.util.Iterator<Integer> iter = list.iterator();
    while ( iter.hasNext() ) {
      System.out.println( iter.next() );
    }
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
    TestSuite suite = new TestSuite( BinaryTreeTester.class );
    return suite;
  }

  /**
   * Main.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        BinaryTreeTester.class.getName()};
    //junit.textui.TestRunner.main(testCaseName);
    junit.swingui.TestRunner.main( testCaseName );
    //junit.ui.TestRunner.main(testCaseName);
  }
}
