import java.util.Scanner;

/**
 * Illustration of the use of exceptions.
 */
public class ExceptionEx {

    /**
     * Computer the quotient of numerator / denominator. Assumes
     * denominator is not 0.
     */
    public static int computeQuotient( int numerator,
                                       int denominator ) {
        return numerator / denominator;
    }

    public static void main( String[] args ) {
        Scanner kbd = new Scanner( System.in );
        int x, y, result;
        boolean done = false;
        String answer;

        while ( !done ) {
            System.out.print( "\nEnter two integers: " );
            x = kbd.nextInt();
            y = kbd.nextInt();
            result = computeQuotient( x, y );
            System.out.printf( "%d / %d = %d\n\n", x, y, result );

            System.out.print( "Execute again? (y/n): " );
            answer = kbd.next();
            // we are done if user gives us anything but y or Y
            done = ! ( answer.equals( "y" ) || answer.equals( "Y" ) );
        }
    }
}
