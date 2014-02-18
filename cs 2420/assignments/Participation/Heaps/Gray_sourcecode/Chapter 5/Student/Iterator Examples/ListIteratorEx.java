import java.util.List;
import java.util.ListIterator;
import gray.adts.list.*;

/**
 * Illustrate the use of a list iterator on a List.
 */

public class ListIteratorEx {

  public static void main( String[] args ) {
    List<String> movies = new LinkedList<String> ();
    movies.add( 0, "Cinema Par" );
    movies.add( 1, "Lilies of the Field" );
    movies.add( 2, "In the Heat of the Night" );

    System.out.println( "Here are the film titles in the " +
                        " collection\nin a backward traversal:" );
    // create an iterator to do a backward traversal
    ListIterator<String> iter =
        movies.listIterator( movies.size() );
    while ( iter.hasPrevious() ) {
      System.out.println( "   " + iter.previous() );
    }

    // now print them with a forward traversal
    System.out.println( "\n... and in a forward traversal:" );
    for ( String movie : movies ) {
      System.out.printf( "%s  \n", movie );
    }

    System.out.println( "\n==============" );
    // use ListIterator's set() and remove() methods to change
    // the list do a forward traversal this time
    iter = movies.listIterator(); // need another iterator
    while ( iter.hasNext() ) {
      String str = iter.next();
      if ( str.equals( "Cinema Par" ) ) {
        iter.set( new String( "Cinema Paradiso" ) );
      }
      else if ( str.indexOf( "of" ) != -1 ) {
        iter.remove();
      }
    }

    System.out.println( "\nAfter fixing the title errors and " +
                        "removing all\ntitles containing \"of\", " +
                        "here is the list:" );
    for ( iter = movies.listIterator( movies.size() );
          iter.hasPrevious(); ) {
      System.out.println( "   " + iter.previous() );
    }

  }
}
