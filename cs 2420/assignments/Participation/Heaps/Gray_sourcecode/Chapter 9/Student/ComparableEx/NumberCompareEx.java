/**
 * Illustrate sorting based on Comparable.compareTo().
 */
import gray.misc.ArrayUtils;

public class NumberCompareEx {

  public static void main( String[] args ) {
    // First, sort a bunch of String objects
    Integer[] numbers = new Integer[5];
    String apples = new String( "It won't work" );
    Integer oranges = new Integer( 6 );

    // WARNING: The following line won't compile!
    int badCompare = apples.compareTo( oranges );

    System.out.println( "\nFirst, sort some String objects" );
    numbers[0] = new Integer( 17 );
    numbers[1] = new Integer( 10 );
    numbers[2] = new Integer( -5 );
    numbers[3] = new Integer( 25 );
    numbers[4] = new Integer( 3 );

    System.out.println( "The unsorted Numbers:" );
    ArrayUtils.print( numbers, 0, numbers.length - 1 );
    ArrayUtils.selectionSort( numbers, numbers.length );
    System.out.println( "\nThe sorted Numbers:" );
    ArrayUtils.print( numbers, 0, numbers.length - 1 );
  }
}
