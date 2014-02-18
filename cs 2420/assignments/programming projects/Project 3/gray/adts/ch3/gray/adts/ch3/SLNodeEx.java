package gray.adts.ch3;

/**
 * A demonstration of using the SLNode class.
 */
public class SLNodeEx {

  public static void printNodes( SLNode cursor ) {
    // null marks the end of the linked list
    while ( cursor != null ) {
      System.out.print( " " + cursor.getElement() );
      // advance to next node
      cursor = cursor.getSuccessor();
    }
    System.out.println();
  }

  public static void main( String[] args ) {

    // create several nodes, linking them together
    SLNode<String> n3 = new SLNode<String> ( "FooFoo", null );
    SLNode<String> n2 = new SLNode<String> ( "Bunny", n3 );
    SLNode<String> n1 = new SLNode<String> ( "Billy", n2 );

    // walk through and print out the element values
    printNodes( n1 );

    // reset the element field of n1
    n1.setElement( "Betty" );
    printNodes( n1 );

    // reset a successor field  - swap the first two nodes
    n1.setSuccessor( n2.getSuccessor() );
    n2.setSuccessor( n1 );
    printNodes( n2 ); // n2 is now head of the linked list
  }
}
