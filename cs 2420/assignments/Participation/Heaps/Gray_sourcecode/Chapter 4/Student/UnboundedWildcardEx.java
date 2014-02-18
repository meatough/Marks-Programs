/**
 * An illustration of the need for and use of unbounded wildcards.
 */
//import gray.adts.shapes.*;
//import gray.adts.collection.BasicCollection;
import java.util.Collection;

public class UnboundedWildcardEx {

  // This method is specific to a collection of Shape objects.
  // Note the variable type in the for loop.
  static void printShapeCollection(
      Collection<Shape> collection ) {
    for ( Shape shape : collection ) {
      System.out.println( shape );
    }
  }

  // The most general print method. It will print collections of
  // any kind of type. Note the variable type in the for loop.
  static void printAnyCollection( Collection<? > collection ) {
    for ( Object element : collection ) {
      System.out.println( element );
    }
  }

  public static void main( String args[] ) {
    Collection<Shape> shapes = new BasicCollection<Shape> ();
    shapes.add( new Circle( 5.0 ) );
    shapes.add( new Rectangle( 4.5, 21.2 ) );
    shapes.add( new Cube() );
    System.out.printf( "From printShapeCollection( shapes )\n" );
    printShapeCollection( shapes );

    Collection<Circle> circles = new BasicCollection<Circle> ();
    circles.add( new Circle( 5.0 ) );
    circles.add( new Circle( 15.0 ) );
    circles.add( new Circle( 25.0 ) );
    //printShapeCollection( circles );

    System.out.println(
        "\nFrom printAnyCollection( circles ): " );
    printAnyCollection( circles );

    System.out.println(
        "\nFrom printAnyCollection( shapes ): " );
    printAnyCollection( shapes );
  }
}
