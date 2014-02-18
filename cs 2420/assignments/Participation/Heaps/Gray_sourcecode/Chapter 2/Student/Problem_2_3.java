/**
 * The code for Problem 3 in Chapter 2.
 */

public class Problem_2_3 {

    public static int doSomething( int array[], int n ) {
        int k = 0;
        for ( int i = 1; i < n; i++ )
            if ( array[i] > array[k] )
                k = i;
        int temp = array[0];
        array[0] = array[k];
        array[k] = temp;

        k = 1;
        for ( int i = 2; i < n; i++ )
            if ( array[i] > array[k] )
                k = i;
        return array[k];
    }

    public static void main( String []args ){
        int []array = new int[10];

        array[0] = 7;
        array[1] = 5;
        array[2] = 3;
        array[3] = 11;
        array[4] = 7;
        array[5] = 1;
        array[6] = 15;
        array[7] = 21;
        array[8] = 8;
        array[9] = 10;

        System.out.println( "doSomething produces " +
                doSomething( array, 10 ) );
        System.out.println( "array[0] is " + array[0] );
    }
}
