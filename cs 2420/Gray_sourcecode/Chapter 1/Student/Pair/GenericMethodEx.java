/**
 * Example illustrating the use of the generic method toArray()
 * specified in <code>Collection</code>.
 */
import gray.adts.collection.BasicCollection;
import java.util.Collection;

public class GenericMethodEx {

    public static void main( String args[] ) {
        Collection<String> names = new BasicCollection<String> ();

        names.add( "Bugs Bunny" );
        names.add( "Daffy Duck" );
        names.add( "Elmer Fudd" );
        names.add( "Foghorn Leghorn" );

        // the array needs to exist prior to the call
        String[] cartoonCharacters = new String[names.size()];
        names.toArray( cartoonCharacters );

        for ( String character : cartoonCharacters ) {
            System.out.println( character + " " );
        }
    }
}
