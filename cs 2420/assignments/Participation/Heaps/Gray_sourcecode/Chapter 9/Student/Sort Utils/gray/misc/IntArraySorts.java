package gray.misc;

/**
 * A collection of methods to sort arrays of ints.
 */
public class IntArraySorts {

  /**
   * The recursive Merge Sort algorithm.
   * @pre  The array arguments are not null
   * @pre  first and last are within the bounds of the inputArray
   * @post The inputArray is sorted in non-decreasing order.
   */
  private static void internalMergeSort( int[] inputArray, int[] tempArray,
                                         int first, int last ) {
    if ( ( last - first + 1 ) <= 1 ) {
      return; // base case - partition size is 1
    }

    // find the mid point of the partition from first to last
    int mid = first + ( ( last - first + 1 ) / 2 );
    int mid2 = ( first + last ) / 2;
    System.out.println( "internalMergeSort(): mid = " + mid + " \tmid2 = " +
                        mid2 );
    internalMergeSort( inputArray, tempArray, first, mid - 1 );
    internalMergeSort( inputArray, tempArray, mid, last );
    merge( inputArray, tempArray, first, mid, last );
  }

  private static void merge( int[] inputArray, int[] tempArray, int first,
                             int mid, int last ) {
    int tempSize = last - first + 1;
    int insertIndex = first, firstPartitionIndex = 0,
        secondPartitionIndex = mid;

    // copy the first partition to the temp array
    System.arraycopy( inputArray, first, tempArray, 0, mid - first );

    while ( ( firstPartitionIndex < ( mid - first ) ) &&
            ( secondPartitionIndex <= last ) ) {
      if ( tempArray[firstPartitionIndex] < inputArray[secondPartitionIndex] ) {
        inputArray[insertIndex] = tempArray[firstPartitionIndex];
        firstPartitionIndex++;
      }
      else {
        inputArray[insertIndex] = inputArray[secondPartitionIndex];
        secondPartitionIndex++;
      }
      insertIndex++;
    }
    // postcondition: one of the partitions is empty.

    // if the first partition is empty we are done since the second partition
    //   is already in inputArray

    // if the second partition is empty, copy the remainder of the first partition from tempArray
    while ( firstPartitionIndex < ( mid - first ) ) {
      inputArray[insertIndex] = tempArray[firstPartitionIndex];
      firstPartitionIndex++;
      insertIndex++;
    }
  }

  private static int partition( int[] array, int first, int last ) {
    int pivot = array[first];
    int pivotPosition = first;
    first++;
    while ( first <= last ) {
      while ( ( first <= last ) && ( array[first] < pivot ) ) { // scan right
        first++;
      }

      while ( ( last >= first ) && ( array[last] >= pivot ) ) { // scan left
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

  private static void swap( int[] array, int a, int b ) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  /**
   * Sort the array of integers using the Merge Sort algorithm.
   * @param inputArray The array of integers to be sorted.
   * @throws NullPointerException if the argument is null.
   */
  public static void mergeSort( int[] inputArray ) {
    if ( inputArray == null ) {
      throw new NullPointerException();
    }

    int tempArray[] = new int[inputArray.length / 2];
    internalMergeSort( inputArray, tempArray, 0, inputArray.length - 1 );
  }

  public static void quickSort( int[] array, int first, int last ) {

    if ( first >= last ) { // size of the partition is 1 or less
      return;
    }

    int pivotPosition = partition( array, first, last );
    quickSort( array, first, pivotPosition - 1 );
    quickSort( array, pivotPosition + 1, last );
  }

  /**
   * Sort an array of integers in ascending order using selection sort.
   * @param a the array of integers to sort
   * @throws NullPointerException if the array object is null
   */
  public static void selectionSort( int[] a ) {
    if ( a == null ) {
      throw new NullPointerException();
    }

    // while the size of the unsorted section is > 1
    for ( int unsortedSize = a.length; unsortedSize > 1; unsortedSize-- ) {
      // find the position of the largest element in the unsorted part
      int maxPos = 0;
      for ( int pos = 1; pos < unsortedSize; pos++ ) {
        if ( a[pos] > a[maxPos] ) {
          maxPos = pos;
        }
      }
      // postcondition: maxPos is the position of the largest element in
      //                the unsorted part

      // Swap the largest value with the last value in the unsorted part
      int temp = a[unsortedSize - 1];
      a[unsortedSize - 1] = a[maxPos];
      a[maxPos] = temp;
    }
  }

  /**
   * Sort an array of integers in ascending order using insertion sort.
   * @param a the array of integers to sort
   * @throws NullPointerException if the array object is null
   */
  public static void insertionSort( int[] a ) {
    int target; // the element we want to insert
    int targetPos; // position of the first element of the unsorted section
    int pos;

    if ( a == null ) {
      throw new NullPointerException();
    }

    // while the size of the unsorted section is greater than 0
    // when targetPos reaches a.length, there are no more unsorted elements
    for ( targetPos = 1; targetPos < a.length; targetPos++ ) {
      // get a copy of the first element in the unsorted section
      target = a[targetPos];

      // while there are elements in the unsorted section to examine AND
      //  we haven't found the insertion point for target
      for ( pos = targetPos - 1; ( pos >= 0 ) && ( a[pos] > target ); pos-- ) {
        // the element at pos is > target, so move it up in the array
        a[pos + 1] = a[pos];
      }
      // loop postcondition: pos == -1 or a[pos] <= target,
      //    so pos + 1 is the new home for target

      // insert target in its final sorted position
      a[pos + 1] = target;
    }
  }

}
