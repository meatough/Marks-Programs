import java.util.*;
import gray.adts.collection.*;

/**
 * ItereratorEx
 * Illustrate the use of an iterator on a BasicCollection object.
 */

public class IteratorEx {

  public static void main( String[] args ) {

    Collection<String> c = new BasicCollection<String> ();
    c.add( "Cinema Paradiso" );
    c.add( "Lilies of the Field" );
    c.add( "In the Heat of the Night" );

    System.out.println( "Here are the film titles in the collection:" );
    Iterator<String> iter = c.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }

    // use iterator's remove() method to remove all titles containing "of"
    iter = c.iterator(); // need to get another iterator
    while ( iter.hasNext() ) {
      String str = ( String ) iter.next();
      if ( str.indexOf( "of" ) != -1 ) {
        iter.remove();
      }
    }

    System.out.println( "\nAfter removing all titles containing \"of\"," +
                        " here is what is left:" );
    iter = c.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }
  }
}
