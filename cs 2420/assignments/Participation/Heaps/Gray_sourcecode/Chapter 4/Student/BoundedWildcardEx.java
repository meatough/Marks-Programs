/**
 * An illustration of the need for and use of bounded wildcards.
 */
import gray.adts.shapes.*;
import gray.adts.collection.BasicCollection;
import java.util.Collection;

public class BoundedWildcardEx {
  public static void printAnyCollection(
      Collection<? > collection ) {
    for ( Object o : collection ) {
      System.out.println( o );
    }
  }

  public static double getTotalArea(
      Collection<? extends Shape> collection ) {
    double totalArea = 0.0;
    for ( Shape shape : collection ) {
      totalArea += shape.getSurfaceArea();
    }
    return totalArea;
  }

  public static void main( String args[] ) {
    Collection<Shape> shapes = new BasicCollection<Shape> ();
    shapes.add( new Circle( 5.0 ) );
    shapes.add( new Rectangle( 5, 10 ) );
    shapes.add( new Cube() );
    System.out.println( "The shapes are: " );
    printAnyCollection( shapes );
    System.out.printf( "\nTotal area of the shapes is %.1f\n",
                       getTotalArea( shapes ) );
    System.out.println();

    Collection<Circle> circles = new BasicCollection<Circle> ();
    circles.add( new Circle( 4.0 ) );
    circles.add( new Circle( 6.0 ) );
    circles.add( new Circle( 8.0 ) );
    System.out.println( "The circles are: " );
    printAnyCollection( circles );
    System.out.printf( "\nTotal area of the circles is %.1f\n",
                       getTotalArea( circles ) );
  }
}
