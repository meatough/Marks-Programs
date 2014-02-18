import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Examples of recursive methods.
 */
public class RecursiveCode {

  public static void quicksort( int[] data, int first, int n ) {
    int pivotIndex, n1, n2;
    if ( n > 1 ) {
      pivotIndex = partition( data, first, n );
      n1 = pivotIndex - first;
      n2 = n - n1 - 1;
      quicksort( data, first, n1 );
      quicksort( data, pivotIndex + 1, n2 );
    }
  }

  public static int partition( int[] data, int first, int n ) {
    int pivot = data[first];
    int tooBigIndex = first + 1;
    int tooSmallIndex = first + n - 1;
    while ( tooBigIndex < tooSmallIndex ) {
      while ( tooBigIndex < first + n && data[tooBigIndex] <= pivot ) {
        tooBigIndex++;
      }
      while ( data[tooSmallIndex] > pivot ) {
        tooSmallIndex--;
      }
      if ( tooBigIndex < tooSmallIndex ) {
        int temp = data[tooBigIndex];
        data[tooBigIndex] = data[tooSmallIndex];
        data[tooSmallIndex] = temp;
      }
    }
    if ( pivot > data[tooSmallIndex] ) {
      data[first] = data[tooSmallIndex];
      data[tooSmallIndex] = pivot;
    }
    return tooSmallIndex;
  }

  public static long factorial( int n ) {
    if ( n == 1 ) {
      return 1;
    }
    return n * factorial( n - 1 );
  }

  public static int sequentialSearch( int[] list, int first, int last,
                                      int target ) {
    if ( first > last ) {
      return -1;
    }
    if ( list[first] == target ) {
      return first;
    }
    return sequentialSearch( list, first + 1, last, target );
  }

  public static int binarySearch( int[] list, int first, int last, int target ) {
    int mid = ( first + last ) / 2;
    if ( first > last ) {
      return -1;
    }
    if ( list[mid] == target ) {
      return mid;
    }
    if ( list[mid] < target ) {
      return binarySearch( list, mid + 1, last, target );
    }
    else {
      return binarySearch( list, first, mid - 1, target );
    }
  }

  // print the elements of values in order from 0 to values.size - 1
  public static void printArray( int[] values, int n ) {
    if ( n == values.length ) { // base case
      return;
    }
    System.out.println( "value[" + n + "] = " + values[n] );
    n++;
    printArray( values, n ); // recursive case
  }

  public static void main( String[] args ) {
    int list[] = new int[10];
    Random rand = new Random( 117 );
    for ( int i = 0; i < 10; i++ ) {
      list[i] = rand.nextInt( 11 );
    }
    printArray( list, 0 );
    System.out.println( "Sequential Search" );
    System.out.println( "found 45 at position " + sequentialSearch( list, 0,
        list.length - 1, 45 ) );
    System.out.println( "found 8 at position " + sequentialSearch( list, 0,
        list.length - 1, 8 ) );
    System.out.println( "found 1 at position " + sequentialSearch( list, 0,
        list.length - 1, 1 ) );

    quicksort( list, 0, list.length );

    System.out.println( "Binary Search" );
    System.out.println( "found 45 at position " + binarySearch( list, 0,
        list.length - 1, 45 ) );
    System.out.println( "found 8 at position " + binarySearch( list, 0,
        list.length - 1, 8 ) );
    System.out.println( "found 1 at position " + binarySearch( list, 0,
        list.length - 1, 1 ) );

  }
}
