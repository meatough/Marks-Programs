import gray.adts.binarytree.*;
import java.util.*;

/**
 * Example usage of the NodeCounterVisitor.
 */
public class NodeCountVisitorEx {
  public static void main( String[] args ) {
    BinaryTree<String> tree =
        new LinkedBinaryTree<String> ( "A" );
    BinaryTreeNode<String> root = tree.root();
    tree.makeLeftChild( root, "B" );
    tree.makeRightChild( root, "C" );
    BinaryTreeNode child = root.leftChild();
    tree.makeLeftChild( child, "D" );
    tree.makeRightChild( child, "E" );
    child = root.rightChild();
    tree.makeLeftChild( child, "F" );
    tree.makeRightChild( child, "G" );

    NodeCountVisitor<String> nodeCounter =
        new NodeCountVisitor<String> ();
    tree.preOrderTraversal( nodeCounter );
    System.out.println( "preorder traversal count is " +
                        nodeCounter.count() );

    nodeCounter = new NodeCountVisitor<String> ();
    tree.inOrderTraversal( nodeCounter );
    System.out.println( "inorder traversal count is " +
                        nodeCounter.count() );

    nodeCounter = new NodeCountVisitor<String> ();
    tree.postOrderTraversal( nodeCounter );
    System.out.println( "postorder traversal count is " +
                        nodeCounter.count() );

    nodeCounter = new NodeCountVisitor<String> ();
    tree.levelOrderTraversal( nodeCounter );
    System.out.println( "levelorder traversal count is " +
                        nodeCounter.count() );
  }
}
