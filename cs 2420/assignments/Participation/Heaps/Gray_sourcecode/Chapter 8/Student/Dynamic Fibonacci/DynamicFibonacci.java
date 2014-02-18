/**
 * Dynamic programming version of the Fibonacci function.
 */
public class DynamicFibonacci {
  private long[] fibs;
  private int lastComputedFib;
  private int capacity;

  public DynamicFibonacci( int size ) {
    capacity = size;
    fibs = new long[capacity + 1];
    fibs[0] = 0;
    fibs[1] = 1;
    fibs[2] = 1;
    lastComputedFib = 2;
  }

  public long getNextFib() {
    if ( lastComputedFib > capacity ) {
      return -1;
    }
    lastComputedFib++;
    fibs[lastComputedFib] = fibs[lastComputedFib - 1] +
        fibs[lastComputedFib - 2];
    return fibs[lastComputedFib];
  }

  public long getFib( int n ) {
    int i;
    if ( n > capacity ) {
      return -1;
    }
    lastComputedFib++;
    for ( ; lastComputedFib <= n; lastComputedFib++ ) {
      fibs[lastComputedFib] = fibs[lastComputedFib - 1] +
          fibs[lastComputedFib - 2];
    }
    // undo the last ++ from the last iteration of the for loop
    lastComputedFib--;
    return fibs[n];
  }
}
