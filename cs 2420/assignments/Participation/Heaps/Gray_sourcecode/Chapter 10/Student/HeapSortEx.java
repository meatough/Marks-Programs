import java.util.Comparator;
import gray.adts.heap.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Illustrate heapSort().
 */
public class HeapSortEx {

  public static<T> List<T> heapSort( Collection<? extends T> collection,
                                     Comparator<? super T>comparator ) {
    if ( collection == null || comparator == null ) {
      return null;
    }
    Heap<T> heap = new ArrayMinHeap<T> ( collection, comparator );
    List<T> list = new ArrayList<T> ();
    while ( !heap.isEmpty() ) {
      T e = heap.top();
      list.add( e );
    }
    return list;
  }

  public static void main( String[] args ) {
    List<Integer> ints = new ArrayList<Integer> ();
    for ( int i = 20; i > 0; i-- ) {
      ints.add( i );
    }

    for ( Integer i : ints ) {
      System.out.print( " " + i );
    }
    System.out.println();

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

    ints = heapSort( ints, intCompare );

    for ( Integer i : ints ) {
      System.out.print( " " + i );
    }
    System.out.println();
  }
}
