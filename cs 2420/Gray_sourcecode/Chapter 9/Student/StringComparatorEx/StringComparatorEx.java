/**
 * String Comparator Example.
 * Sorting Strings using Merge Sort and an instance of the Comparator interface.
 */
import gray.misc.ArrayUtils;
import java.util.Comparator;

public class StringComparatorEx {
  public static void main( String[] args ) {
    String[] c = new String[5];

    final Comparator stringComparator = new Comparator() {
      public int compare( Object o1, Object o2 ) {
        return ( ( String ) o1 ).compareTo( ( String ) o2 );
      }
    };

    c[0] = new String( "In the Heat of the Night" );
    c[1] = new String( "The Dish" );
    c[2] = new String( "Farewell My Concubine" );
    c[3] = new String( "Tea With Mussolini" );
    c[4] = new String( "My Life as a Dog" );

    ArrayUtils.print( ( Object[] ) c, 0, c.length - 1 );
    ArrayUtils.mergeSort( c, c.length );
    ArrayUtils.mergeSort( c, c.length, stringComparator );
    System.out.println();
    ArrayUtils.print( ( Object[] ) c, 0, c.length - 1 );
  }
}
