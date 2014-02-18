import java.util.Comparator;
import gray.misc.ArrayUtils;

/**
 * Illustrate the use of Comparable.compareTo().
 */
public class IntegerSortSearchEx {

  public static void main( String[] args ) {
    Integer[] intArray = new Integer[20];
    for ( int i = intArray.length - 1; i >= 0; i-- ) {
      intArray[i] = new Integer( i );
    }
    Integer int0 = new Integer( 0 );
    Integer int4 = new Integer( 4 );
    Integer int19 = new Integer( 19 );
    Integer int20 = new Integer( 20 );
    int position;

    Comparator<Integer> intCompare = new Comparator<Integer> () {
      public int compare( Integer i1, Integer i2 ) {
        if ( i1 == i2 ) {
          return 0;
        }
        if ( i1 < i2 ) {
          return -1;
        }
        return 1;
      }
    };

    gray.misc.ArrayUtils.selectionSort( intArray, intArray.length, intCompare );
    if ( ( position = gray.misc.ArrayUtils.binarySearch( intArray, 0,
        intArray.length - 1, int0 ) ) != -1 ) {
      System.out.println( int0 + " was found in position " + position );
    }
    else {
      System.out.println( int0 + " was NOT found" );
    }

    if ( ( position = gray.misc.ArrayUtils.binarySearch( intArray, 0,
        intArray.length - 1, int4 ) ) != -1 ) {
      System.out.println( int4 + " was found in position " + position );
    }
    else {
      System.out.println( int4 + " was NOT found" );
    }

    if ( ( position = gray.misc.ArrayUtils.binarySearch( intArray, 0,
        intArray.length - 1, int19 ) ) != -1 ) {
      System.out.println( int19 + " was found in position " + position );
    }
    else {
      System.out.println( int19 + " was NOT found" );
    }

    if ( ( position = gray.misc.ArrayUtils.binarySearch( intArray, 0,
        intArray.length - 1, int20 ) ) != -1 ) {
      System.out.println( int20 + " was found in position " + position );
    }
    else {
      System.out.println( int20 + " was NOT found" );
    }
  }
}
