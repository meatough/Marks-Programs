import gray.adts.binarytree.*;
import java.util.List;
import java.util.Iterator;

/**
 * Example usage of the ListVisitor.
 */
public class ToListVisitorEx {

  public static void main( String[] args ) {
    BinaryTree<String> tree = new LinkedBinaryTree( "A" );
    BinaryTreeNode<String> root = tree.root();
    tree.makeLeftChild( root, "B" );
    tree.makeRightChild( root, "C" );
    BinaryTreeNode<String> child = root.leftChild();
    tree.makeLeftChild( child, "D" );
    tree.makeRightChild( child, "E" );
    child = root.rightChild();
    tree.makeLeftChild( child, "F" );
    tree.makeRightChild( child, "G" );

    System.out.println( "preorder traversal: " );
    ToListVisitor<String> listMaker =
        new ToListVisitor<String> ();
    tree.preOrderTraversal( listMaker );
    List<String> list = listMaker.list();

    for ( String s : list ) {
      System.out.print( "\t" + s + " " );
    }
    System.out.println();

    System.out.println( "\ninorder traversal: " );
    listMaker = new ToListVisitor<String> ();
    tree.inOrderTraversal( listMaker );
    list = listMaker.list();

    for ( String s : list ) {
      System.out.print( "\t" + s + " " );
    }
    System.out.println();

    System.out.println( "\npostorder traversal: " );
    listMaker = new ToListVisitor<String> ();
    tree.postOrderTraversal( listMaker );
    list = listMaker.list();

    for ( String s : list ) {
      System.out.print( "\t" + s + " " );
    }
    System.out.println();

    System.out.println( "\nlevelorder traversal: " );
    listMaker = new ToListVisitor();
    tree.levelOrderTraversal( listMaker );
    list = listMaker.list();

    for ( String s : list ) {
      System.out.print( "\t" + s + " " );
    }
    System.out.println();
  }
}
