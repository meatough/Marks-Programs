/**
 * A class to time copying a two dimensional <tt>int</tt>
 * array using row order and column order access. This code
 * is presented in Chapter 2.
 */
public class ArrayCopyTimed {
    private static int[][] intArray, copy;
    private static final int NUM_ITERATIONS = 20;

    public static void main( String[] args ) {

        long start, finish;
        float rowCopyTime = 0, columnCopyTime = 0;

        if ( args.length == 0 ) {
            System.err.println( "array size missing" );
            System.exit( -1 );
        }

        int SIZE = Integer.parseInt( args[0] );
        intArray = new int[SIZE][SIZE];
        copy = new int[SIZE][SIZE];

        System.out.println( "Array size is " + SIZE );

        // initialize the matrix
        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                intArray[i][j] = i + j;
            }
        }

        // get a copy going row by row
        for ( int i = 0; i < NUM_ITERATIONS; i++ ) {
            start = System.currentTimeMillis();
            for ( int r = 0; r < SIZE; r++ ) {
                for ( int c = 0; c < SIZE; c++ ) {
                    copy[r][c] = intArray[r][c];
                }
            }
            finish = System.currentTimeMillis();
            rowCopyTime += finish - start;
        }

        // get a copy going column by column
        for ( int i = 0; i < NUM_ITERATIONS; i++ ) {
            start = System.currentTimeMillis();
            for ( int c = 0; c < SIZE; c++ ) {
                for ( int r = 0; r < SIZE; r++ ) {
                    copy[r][c] = intArray[r][c];
                }
            }
            finish = System.currentTimeMillis();
            columnCopyTime += finish - start;
        }

        System.out.print( "array copy time (row-column):     " +
                          ( rowCopyTime / NUM_ITERATIONS ) );
        System.out.print( "\narray copy times (column-row):     " +
                          ( columnCopyTime / NUM_ITERATIONS ) );
        System.out.println( "\n" );
    }
}
