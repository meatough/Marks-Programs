import gray.adts.collection.*;
import java.util.Collection;

/**
 *   Illustrating equals() and hashCode() from Object
 *   This class illustrates the behavior of the equals() and
 *   hashCode() methods inherited from the Object class when
 *   applied to instances of BasicCollection. It also illustrates
 *   the important relationship between equals() and hashCode().
 */

public class EqualsHashcodeEx {

  public static void main( String[] args ) {
    Collection<String> c1 = new BasicCollection<String> ();
    Collection<String> c2 = new BasicCollection<String> ();

    c1.add( "A" );
    c1.add( "B" );
    c1.add( "C" );
    System.out.println( "There are " + c1.size() + " elements in c1: " + c1 );

    c2.add( "A" );
    c2.add( "B" );
    c2.add( "C" );
    System.out.println( "There are " + c2.size() + " elements in c2: " + c2 );

    System.out.println( "c1.hashcode() = " + c1.hashCode() );
    System.out.println( "c2.hashcode() = " + c2.hashCode() );
    System.out.println( "c1.equals( c2 ) is " + c1.equals( c2 ) + "\n" );

    Collection c3 = c1;
    System.out.println( "There are " + c3.size() + " elements in c3: " + c3 );
    System.out.println( "c1.hashcode() = " + c1.hashCode() );
    System.out.println( "c3.hashcode() = " + c3.hashCode() );
    System.out.println( "c1.equals( c3 ) is " + c1.equals( c3 ) );
    System.out.println( "c3.equals( c1 ) is " + c3.equals( c1 ) );
  }
}
