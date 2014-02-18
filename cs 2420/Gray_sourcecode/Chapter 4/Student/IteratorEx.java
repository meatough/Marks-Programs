import java.util.Collection;
import java.util.Iterator;
import gray.adts.collection.*;

/**
 * Illustrate the use of an iterator on a BasicCollection object.
 */

public class IteratorEx {

  public static void main( String[] args ) {

    Collection<String> movies = new BasicCollection<String> ();
    movies.add( "Cinema Paradiso" );
    movies.add( "Lilies of the Field" );
    movies.add( "In the Heat of the Night" );

    System.out.println( "Here are the film titles in " +
                        "the collection:" );
    Iterator<String> iter;
    for ( iter = movies.iterator(); iter.hasNext(); ) {
      System.out.println( "   " + iter.next() );
    }

    // use iterator's remove() method to remove all titles
    // containing "of"
    iter = movies.iterator(); // need to get another iterator
    while ( iter.hasNext() ) {
      String str = iter.next();
      if ( str.indexOf( "of" ) != -1 ) {
        iter.remove();
      }
    }

    System.out.println( "\nAfter removing all titles " +
                        "containing \"of\", here is what is left:" );
    for ( String movie : movies ) {
      System.out.println( "   " + movie );
    }
  }
}
