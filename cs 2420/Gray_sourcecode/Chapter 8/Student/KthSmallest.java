/**
 * Find the kth smallest element in an array by recursively partitioning
 * the array around a pivot value.
 */
public class KthSmallest {

  public static void swap( int[] array, int a, int b ) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static int partition( int[] array, int first, int last ) {
    int pivot = array[first];
    int pivotPosition = first;
    first++;
    while ( first <= last ) {
      // scan right
      while ( ( first <= last ) && ( array[first] < pivot ) ) {
        first++;
      }

      // scan left
      while ( ( last >= first ) && ( array[last] >= pivot ) ) {
        last--;
      }

      if ( first > last ) {
        swap( array, pivotPosition, last );
      }
      else {
        swap( array, first, last );
      }
    }
    return last;
  }

  public static int kthSmallest( int k, int[] array, int first, int last ) {
    int pivotPosition;

    pivotPosition = partition( array, first, last );
    if ( pivotPosition == ( k - 1 ) ) {
      return array[k - 1];
    }
    if ( ( k - 1 ) < pivotPosition ) {
      return kthSmallest( k, array, first, pivotPosition - 1 );
    }
    else {
      return kthSmallest( k, array, pivotPosition + 1, last );
    }
  }

  public static void main( String[] args ) {
    int[] array = { 79, 85, 52, 81, 11, 34, 90, 17, 95, 25 };

    System.out.println( "The array elements: " );
    for ( int i = 0; i < array.length; i++ )
      System.out.print( "  " + array[i] );

    System.out.println( "\n" );
    System.out.println( "1st smallest value is: " +
                        kthSmallest( 1, array, 0, array.length - 1 ) );
    System.out.println( "4th smallest value is: " +
                        kthSmallest( 4, array, 0, array.length - 1 ) );
    System.out.println( "7th smallest value is: " +
                        kthSmallest( 7, array, 0, array.length - 1 ) );
    System.out.println( "10th smallest value is: " +
                        kthSmallest( 10, array, 0, array.length - 1 ) );
  }
}
