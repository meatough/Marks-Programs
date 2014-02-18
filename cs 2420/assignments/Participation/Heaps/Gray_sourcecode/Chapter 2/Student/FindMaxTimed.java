import java.util.*;

/**
 * A class to time searching for the largest integer in <tt>int</tt.
 * and an <tt>Integer</tt> arrays. This code is presented in Chapter 2.
 */
public class FindMaxTimed {
    private static int[] intArray;
    private static Integer[] intObjArray;
    private static final int NUM_ITERATIONS = 20;

    public static void main( String[] args ) {

        long start, finish, total;

        if ( args.length == 0 ) {
            System.err.println( "array size missing" );
            System.exit( -1 );
        }

        int SIZE = Integer.parseInt( args[0] );
        float intArrayTimeTotal = 0, intObjArrayTimeTotal = 0;

        System.out.println( "Array size is " + SIZE );
        // allocate and initialize the int array with
        // values from SIZE - 1 to 0
        intArray = new int[SIZE];
        for ( int j = 0, i = SIZE - 1; i >= 0; j++, i-- ) {
            intArray[j] = i;
        }

        // find the largest value in the int array
        for ( int i = 0; i < NUM_ITERATIONS; i++ ) {
            int largest = intArray[0];
            start = System.currentTimeMillis();
            for ( int j = 1; j < SIZE; j++ ) {
                if ( intArray[j] > largest ) {
                    largest = intArray[j];
                }
            }
            finish = System.currentTimeMillis();
            intArrayTimeTotal += finish - start;
        }
        System.out.println( "Done timing int array" );

        // force cleanup to prevent it happening while
        // looking for the largest in the Integer array
        intArray = null; // make the array garbage
        System.gc(); // invoke the garbage collector

        System.out.println( "Timing Integer array now" );
        // allocate and initialize the Integer array with
        // values from SIZE - 1 to 0
        intObjArray = new Integer[SIZE];
        for ( int j = 0, i = SIZE - 1; i >= 0; j++, i-- ) {
            intObjArray[j] = new Integer( i );
        }

        // find the largest value in the Integer object array
        for ( int i = 0; i < NUM_ITERATIONS; i++ ) {
            Integer largest = intObjArray[0]; ;
            start = System.currentTimeMillis();
            for ( int j = 1; j < SIZE; j++ ) {
                if ( intObjArray[j] > largest ) {
                    largest = intObjArray[j];
                }
            }
            finish = System.currentTimeMillis();
            intObjArrayTimeTotal += finish - start;
        }

        System.out.println( "Avg int array time            = " +
                            ( intArrayTimeTotal / NUM_ITERATIONS ) );
        System.out.println( "Avg Integer object array time = " +
                            ( intObjArrayTimeTotal / NUM_ITERATIONS ) );
        System.out.println();
    }
}
