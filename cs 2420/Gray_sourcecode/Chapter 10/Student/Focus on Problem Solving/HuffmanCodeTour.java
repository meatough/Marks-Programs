import gray.adts.binarytree.*;

/**
 * Focus on Problem Solving solution. Encoding a text file using Huffman coding.
 */
public class HuffmanCodeTour extends EulerTour {
  private String[] codeTable;
  private StringBuffer code;

  public HuffmanCodeTour( String[] theTable ) {
    codeTable = theTable;
    code = new StringBuffer( "" );
  }

  protected void visitLeaf( BinaryTreeNode node, TourResult result ) {
    HuffmanNode hnode = ( HuffmanNode ) node.element();
    StringBuffer code = ( StringBuffer ) result.finalResult;
    codeTable[ ( int ) hnode.character()] = new String( code );
    System.out.println( "LEAF: " + hnode.character() + " " + code.toString() );

  }

  protected void visitOnLeft( BinaryTreeNode node, TourResult result ) {
    StringBuffer code = ( StringBuffer ) result.finalResult;
    code.append( '0' );
    System.out.println( "\tleft: " + code.toString() );
  }

  protected void visitFromBelow( BinaryTreeNode node, TourResult result ) {
    StringBuffer code = ( StringBuffer ) result.finalResult;
    code.deleteCharAt( code.length() - 1 );
    System.out.println( "\tbelow: " + code.toString() );

  }

  protected void visitOnRight( BinaryTreeNode node, TourResult result ) {
    StringBuffer code = ( StringBuffer ) result.finalResult;
    if ( code.length() > 0 ) {
      code.deleteCharAt( code.length() - 1 );
    }
    code.append( '1' );
    System.out.println( "\tright: " + code.toString() );
  }

  protected void initResult( TourResult result ) {
    result.finalResult = new StringBuffer( "" );
  }
}
