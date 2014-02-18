/**
 * Using the DynamicFibonacci class to compute some
 * Fibonacci numbers.
 */
public class DynamicFibonacciEx {

  public static void main( String[] args ) {
    DynamicFibonacci dynoFib = new DynamicFibonacci( 45 );
    long start, end, time, f = 0;

    System.out.println( "\n\nn   Fib(n)  time (in milliseconds)" );
    for ( int i = 25; i <= 45; i++ ) {
      time = 0;
      for ( int j = 0; j < 10; j++ ) {
        start = System.currentTimeMillis();
        f = dynoFib.getFib( i );
        end = System.currentTimeMillis();
        time = end - start;
      }
      System.out.println( i + "\t" + f + "    \t\t" +
                          ( time / 10 ) );
    }
  }
}
