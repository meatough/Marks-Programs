package shapeExamples;

import gray.adts.shapes.*;
import javax.swing.JOptionPane;

/**
 * Illustrate inheritance in a simple shapes hierarchy.
 */
public class ShapeEx1 {

    public static void main ( String [] args ) {
        Rectangle r = new Rectangle();
        Circle c = new Circle();
        String output;

        // use methods defined in Rectangle and Circle
        r.setLength( 4 );
	r.setHeight( 5 );
        c.setRadius( 6 );

        // use method inherited from Shape
        output = r.getShapeName() + ": length = " + r.getLength()
	             + " height = " + r.getHeight() + "\n";
	             output += c.getShapeName() + ": radius = " +
                               c.getRadius() + "\n";

        JOptionPane.showMessageDialog( null, output,
				       "Shape inheritance example",
                                       JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
