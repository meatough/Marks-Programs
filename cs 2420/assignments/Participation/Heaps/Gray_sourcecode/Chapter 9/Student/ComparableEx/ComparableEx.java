/**
 * Illustrate sorting based on Comparable.compareTo().
 */
import gray.misc.ArrayUtils;
import java.util.Date;
import java.util.Calendar;

public class ComparableEx {

  public static void main( String[] args ) {
    // First, sort a bunch of String objects
    String[] c = new String[5];

    System.out.println( "\nFirst, sort some String objects" );
    c[0] = new String( "In the Heat of the Night" );
    c[1] = new String( "The Dish" );
    c[2] = new String( "Farewell My Concubine" );
    c[3] = new String( "Tea With Mussolini" );
    c[4] = new String( "My Life as a Dog" );

    System.out.println( "The unsorted Strings (movie titles):" );
    ArrayUtils.print( ( Object[] ) c, 0, c.length - 1 );
    ArrayUtils.selectionSort( c, c.length );
    System.out.println( "\nThe sorted Strings:" );
    ArrayUtils.print( ( Object[] ) c, 0, c.length - 1 );

    // Now sort a bunch of Date objects
    Date[] dates = new Date[5];
    Calendar calendar = Calendar.getInstance();

    System.out.println( "\n\nNow, sort some Date objects" );
    //  Set a date                  Put the date in the array
    calendar.set( 1957, 11, 4 );
    dates[0] = calendar.getTime();
    calendar.set( 2001, 10, 4 );
    dates[1] = calendar.getTime();
    calendar.set( 2001, 0, 1 );
    dates[2] = calendar.getTime();
    calendar.set( 1957, 10, 1 );
    dates[3] = calendar.getTime();
    calendar.set( 1952, 6, 15 );
    dates[4] = calendar.getTime();

    System.out.println( "The unsorted Dates:" );
    ArrayUtils.print( dates, 0, dates.length - 1 );
    ArrayUtils.selectionSort( dates, dates.length );
    System.out.println( "\nThe sorted Dates:" );
    ArrayUtils.print( dates, 0, dates.length - 1 );
  }
}
