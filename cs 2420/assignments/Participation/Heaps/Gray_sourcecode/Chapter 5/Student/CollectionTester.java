/**
 *  Demonstrate how LinkedList can work with other Collection
 *  types within the Java Collections Framework.
 */
import java.util.*; // we use lots of classes from this package

public class CollectionTester {
  static void printAnyCollection( Collection<? > collection ) {
    for ( Object element : collection ) {
      System.out.println( element );
    }
  }

  public static void main( String[] args ) {
    List<String> arrayList = new ArrayList<String> ();
    arrayList.add( 0, "cpi.doc" );
    arrayList.add( 1, "prog1.txt" );
    arrayList.add( 2, "p1.dat" );

    System.out.println( "Elements in the ArrayList object: " );
    printAnyCollection( arrayList );

    System.out.println( "\nElements in a LinkedList object " +
                        "populated using addAll( arrayList )" );
    // note use of fully qualified name here to avoid
    // confusing with java.util.LinkedList
    List<String> linkedList =
        new gray.adts.list.LinkedList<String> ();
    linkedList.addAll( arrayList );
    printAnyCollection( linkedList );

    System.out.println( "\nElements in a TreeSet object " +
                        "populated using new TreeSet( linkedList )" );
    Set<String> set = new TreeSet<String> ( linkedList );
    set.addAll( linkedList );
    printAnyCollection( set );
  }
}
