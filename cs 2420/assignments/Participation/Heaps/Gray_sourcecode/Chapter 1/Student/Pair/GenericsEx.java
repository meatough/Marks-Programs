/**
 * Illustrate the use of a generic type.
 */
public class GenericsEx {
    public static void main( String args[] ) {
        Pair<String> stringPair = new Pair<String> ( "string", "Pair" );
        Pair<Integer> intPair;

        intPair = new Pair<Integer> ( new Integer( 1 ), new Integer( 2 ) );

        System.out.println( "intPair is: " + intPair );
        System.out.println( "stringPair is: " + stringPair );

        intPair.swapElements();
        System.out.println( "\nAfter swapping elements, intPair is " +
                            intPair );

        intPair.setFirstElement( new Integer( -1 ) );

        stringPair.setSecondElement( "Generic types are useful" );

        System.out.println( "\nThe pairs after doing some resetting: " );
        System.out.println( "\tintPair is: " + intPair );
        System.out.println( "\tstringPair is: " + stringPair );

        Integer intElement1 = intPair.getFirstElement();
        String stringElement1 = stringPair.getFirstElement();

        System.out.println( "\nintElement1 is " + intElement1 +
                            " and stringElement1 is " + stringElement1 );

    }
}
