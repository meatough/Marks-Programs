import java.util.Date;
import gray.misc.ArrayUtils;

/**
 * Illustration of the use of implementing Comparable.
 */
public class NameSortEx {
  public static void main( String[] args ) {
    Name[] names = new Name[4];

    names[0] = new Name( "Simon", "Gray" );
    names[1] = new Name( "Tom", "Johnson" );
    names[2] = new Name( "Selena", "Gray" );
    names[3] = new Name( "Tom", "Jones" );

    ArrayUtils.print( names, 0, names.length - 1 );
    ArrayUtils.mergeSort( names, 0, names.length - 1 );
    System.out.println();
    ArrayUtils.print( names, 0, names.length - 1 );
  }
}
