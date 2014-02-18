/**
 * Example illustrating the use of the generic method toArray()
 * specified in <code>Collection</code>.
 */
import gray.adts.collection.BasicCollection;
import java.util.Collection;

public class GenericMethodEx {

  public static void main( String args[] ) {
    Collection<String> pets = new BasicCollection<String> ();

    pets.add( "Ginger Puppy" );
    pets.add( "Blue Dog" );
    pets.add( "Pepper Kitty" );
    pets.add( "Tense Turtle" );

    // the array needs to exist prior to the call
    String[] petNames = new String[pets.size()];
    pets.toArray( petNames );

    for ( String pet : petNames ) {
      System.out.println( pet + " " );
    }
  }
}
