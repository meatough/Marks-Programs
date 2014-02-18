/**
 * Illustrate the use of Comparable.compareTo().
 */
public class IntegerCompareToEx {
  public static void main( String[] args ) {
    Integer int5 = new Integer( 5 );
    Integer int7 = new Integer( 7 );
    Integer intAnother5 = new Integer( 5 );

    if ( int5.compareTo( int7 ) < 0 ) {
      System.out.println( int5 + " is less than " + int7 );
    }

    if ( int5.compareTo( intAnother5 ) == 0 ) {
      System.out.println( int5 + " is equal to " + intAnother5 );
    }

    if ( int7.compareTo( int5 ) > 0 ) {
      System.out.println( int7 + " is greater than " + int5 );
    }
  }
}
