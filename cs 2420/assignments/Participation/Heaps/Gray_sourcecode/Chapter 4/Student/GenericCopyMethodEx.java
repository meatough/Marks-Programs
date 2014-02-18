/**
 *  Example illustrating the definition and use of generic methods.
 */
import gray.adts.collection.BasicCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GenericCopyMethodEx {

  static<T> Collection<T> copy( Collection<T> c ) {
    Collection<T> theCopy = new BasicCollection<T> ();
    for ( T element : c ) {
      theCopy.add( element );
    }
    return theCopy;
  }

  static<T> Collection<T> reverseCopy( Iterator<T> source ) {
    LinkedList<T> theCopy = new LinkedList<T> ();
    while ( source.hasNext() ) {
      theCopy.addFirst( source.next() );
    }
    return theCopy;
  }

  static<E> Collection<E> reverseCopy( Collection<E> source ) {
    LinkedList<E> theCopy = new LinkedList<E> ();
    for ( E element : source ) {
      theCopy.addFirst( element ); // add at front of list
    }
    return theCopy;
  }

  public static void main( String args[] ) {
    Collection<String> pets = new BasicCollection<String> ();

    pets.add( "Ginger Puppy" );
    pets.add( "Pepper Kitty" );
    pets.add( "Blue Dog" );
    pets.add( "Tense Turtle" );

    Collection<String> petsCopy = copy( pets );
    System.out.println( "Here is the copy: " );
    for ( String pet : petsCopy ) {
      System.out.print( pet + "    " );
    }

    petsCopy = reverseCopy( pets );
    System.out.println( "\n\nHere is the reversed copy: " );
    for ( String pet : petsCopy ) {
      System.out.print( pet + "    " );
    }

    petsCopy = reverseCopy( petsCopy.iterator() );
    System.out.println( "\n\nHere is the UN-reversed copy: " );
    for ( String pet : petsCopy ) {
      System.out.print( pet + "    " );
    }
  }
}
