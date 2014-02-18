package shapeExamples;

import gray.adts.shapes.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class PolyEx {

    public static void main ( String [] args ) {
        Rectangle rectangle = new Rectangle( 3.4, 4.5 );
        Circle circle = new Circle(4.2);
        RectangularPrism rectPrism =
                               new RectangularPrism( 5.3, 6.6, 7.2 );
        Cylinder cylinder = new Cylinder(3.5, 19.5 );
        Shape [] bunchOshapes = new Shape[4];
        DecimalFormat prec3 = new DecimalFormat( "#0.000" );
        String output = "\n";

        // populate the array of shapes with some real shapes
        bunchOshapes[0] = rectangle;
        bunchOshapes[1] = circle;
        bunchOshapes[2] = rectPrism;
        bunchOshapes[3] = cylinder;

        for ( int i = 0; i < bunchOshapes.length; i++ ) {
            output += bunchOshapes[i].toString() + "\n";
            output += "\tsurface area = "
                   + prec3.format( bunchOshapes[i].getSurfaceArea() )
                      + "\n";
            output += "\tperimeter = "
                      + prec3.format( bunchOshapes[i].getPerimeter() )
                      + "\n\n";;
        }

        JOptionPane.showMessageDialog( null, output,
				"Polymorphic shapes example",
                                JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
