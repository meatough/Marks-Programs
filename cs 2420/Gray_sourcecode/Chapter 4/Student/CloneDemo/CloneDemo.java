import java.util.*;
import java.awt.Dimension;
import gray.adts.collection.*;

/**
 *  This example illustrates that the clone() method from
 *  BasicCollection is still shallow at the level of the elements of
 *  the array. If a change is made to an element from the original
 *  collection, the clone reflects this change.
 */

public class CloneDemo {
  public static void main( String[] args ) throws CloneNotSupportedException {
    BasicCollection<Dimension> dimensions = new BasicCollection<Dimension> ();
    dimensions.add( new Dimension( 1, 2 ) );
    dimensions.add( new Dimension( 3, 4 ) );
    dimensions.add( new Dimension( 5, 6 ) );
    dimensions.add( new Dimension( 7, 8 ) );

    System.out.println( "contents of the original" );
    Iterator<Dimension> iter = dimensions.iterator();
    while ( iter.hasNext() ) {
      System.out.println( iter.next() );
    }
    BasicCollection<Dimension> cloneOfDimensions = ( BasicCollection<Dimension> )
        dimensions.clone();

    System.out.println( "\ncontents of the clone" );
    iter = cloneOfDimensions.iterator();
    while ( iter.hasNext() ) {
      System.out.println( iter.next() );
    }

    iter = dimensions.iterator();
    Dimension d = iter.next();
    System.out.println( "\nFirst Dimension from original is " + d );
    iter = cloneOfDimensions.iterator();
    Dimension d2 = iter.next();
    System.out.println( "\nFirst Dimension from clone is " + d2 );
    System.out.println( "d.equals(d2) should return true, actual value is :> "
                        + d.equals( d2 ) );

    System.out.println( "\nchanging width of dimension of original" );
    d.width = 5;

    System.out.println( "\nDimension of d is " + d );
    iter = dimensions.iterator();
    d = iter.next();
    System.out.println( "\nFirst Dimension from original is " + d );
    iter = cloneOfDimensions.iterator();
    d2 = iter.next();
    System.out.println( "\nFirst Dimension from clone is " + d2 );
    System.out.println( "\nIf the clone was a deep copy, d.equals(d2) should " +
                        "now return false, actual value is :> " + d.equals( d2 ) );

    dimensions.remove( d );
    System.out.println( " removing d (" + d +
                        ") from the original collection\n" );
    iter = dimensions.iterator();
    d = iter.next();
    System.out.println( "\nFirst Dimension from original is " + d );
    iter = cloneOfDimensions.iterator();
    d2 = iter.next();
    System.out.println( "\nFirst Dimension from clone is " + d2 );
    System.out.println( "\nIf the clone was a deep copy, d.equals(d2) should " +
                        "now return false, actual value is :> " + d.equals( d2 ) );

    System.out.printf( "size of original collection is %d\n", dimensions.size() );
    System.out.printf( "size of cloned collection is %d\n",
                       cloneOfDimensions.size() );
  }

}
