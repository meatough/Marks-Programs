import java.util.*;
import gray.adts.collection.*;

/**
 * Title:        CollectionDemo
 * Description:  Demonstrate the use of the BasicCollection class.
 */

public class CollectionDemo {

  public static void main( String[] args ) throws CloneNotSupportedException {
    // 1. create a collection object
    Collection<String> films = new BasicCollection<String> ();

    // 2. create some elements to add to the collection
    String film1 = new String( "Cinema Paradiso" );
    String film2 = new String( "Lilies of the Field" );
    String film3 = new String( "In the Heat of the Night" );

    // 3. add the elements to the collection
    films.add( film1 );
    films.add( film2 );
    films.add( film3 );

    // 4. traverse the collection, printing out the elements it stores
    System.out.println( "Here are the films added to the collection:" );
    Iterator iter = films.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }

    // 5. create a clone of the original array & check their sizes
    Collection cloneOfFilms = ( BasicCollection ) ( ( BasicCollection ) films ).
        clone();
    //Collection cloneOfFilms = (BasicCollection)(c).clone();
    System.out.println( "\nA clone of the original collection has been made." );
    System.out.println( "Size of the original is " + films.size() );
    System.out.println( "Size of the clone is " + cloneOfFilms.size() );

    // 6. determine if the original and the clone are equal (they should be)
    System.out.print( "The original and the clone are " );
    if ( films.equals( cloneOfFilms ) ) {
      System.out.println( "equal." );
    }
    else {
      System.out.println( "NOT equal." );
    }

    // 7. remove an element from the original collection & check the sizes
    films.remove( film1 );
    System.out.println( "\nRemoved title \"" + film1 +
                        "\" from the original collection." );
    System.out.println( "Size of the original is now " + films.size() );
    System.out.println( "Size of the clone is " + cloneOfFilms.size() );

    // 8. determine if the original and the clone are still equal (they should NOT be)
    System.out.print( "The altered original and the clone are " );
    if ( films.equals( cloneOfFilms ) ) {
      System.out.println( "equal." );
    }
    else {
      System.out.println( "NOT equal." );
    }
    System.out.println( "contents of the original" );
    iter = films.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }
    System.out.println( "contents of the clone" );
    iter = cloneOfFilms.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }

    System.out.println( "\nRemoving all elements containing the word \"of\"." );
    iter = cloneOfFilms.iterator();
    while ( iter.hasNext() ) {
      String str = ( String ) iter.next();
      System.out.println( "   " + str );
      if ( str.indexOf( "of" ) != -1 ) {
        iter.remove();
      }
      //cloneOfFilms.remove(film3);
      // iterator should throw an exception when it gets the next
      //    hasNext() message
    }
    System.out.println( "Here is what is left:" );
    iter = cloneOfFilms.iterator();
    while ( iter.hasNext() ) {
      System.out.println( "   " + iter.next() );
    }
  }
}
