/**
 *  An example to illustrate the effect of inheritance on the
 *  type variable of a generic type. The code that is commented
 *  out generates compiler errors.
 */
import gray.misc.Pair;
import gray.adts.shapes.*;

public class ShapePairEx {
  public static void main( String args[] ) {
    Pair<Shape> shapePair = new Pair<Shape> ();

    shapePair.setFirstElement( new Circle( 5.0 ) );
    shapePair.setSecondElement( new Rectangle( 10, 20 ) );

//      shapePair.setFirstElement( new Object() );    // ERROR!
//      shapePair.setSecondElement( new Date() );     // ERROR!
    Shape shape = shapePair.getFirstElement();
    System.out.printf( "Area of the 1st element = %.1f\n",
                       shape.getSurfaceArea() );

    System.out.printf( "Area of the 2nd element = %.1f\n",
                       shapePair.getSecondElement().getSurfaceArea() );

//     System.out.printf( "Radius of the Circle = %.1f\n",
//            shapePair.getFirstElement().getRadius()); // ERROR!
    Circle circle = ( Circle ) shapePair.getFirstElement();
    System.out.printf( "The radius of the Circle is %.1f\n",
                       circle.getRadius() );
  }
}
