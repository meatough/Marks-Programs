/**
 * Recursive implementation of the Fibonacci function.
 */

public class FibonacciEx {

  public static long fibonacci( int n ) {
    if ( ( n == 0 ) || ( n == 1 ) ) {
      return n;
    }
    return fibonacci( n - 1 ) + fibonacci( n - 2 );
  }

  public static void main( String[] args ) {
    long start, end, fib = 0;
    long time = 0;

    System.out.println( "\n\nn   Fib(n)  time (in milliseconds)" );
    for ( int i = 41; i <= 45; i++ ) {
      time = 0;
      for ( int j = 0; j < 10; j++ ) { // get the average of 10 calls
        start = System.currentTimeMillis();
        fib = fibonacci( i );
        end = System.currentTimeMillis();
        time += end - start;
      }
      System.out.println( i + "\t" + fib + "    \t\t" + time / 10 );
    }
  }
}
