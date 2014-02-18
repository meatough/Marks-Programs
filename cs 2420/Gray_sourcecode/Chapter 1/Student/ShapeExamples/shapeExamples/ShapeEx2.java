package shapeExamples;

import gray.adts.shapes.*;
import javax.swing.JOptionPane;

/**
 *  Illustrate the use of the overloaded toString() method.
 */
public class ShapeEx2 {

    public static void main ( String [] args ) {
        Rectangle r = new Rectangle();
        String output;

        // use methods defined in Rectangle and Circle
        r.setLength( 4 );
        r.setHeight( 5 );

        output = "Class name is " + r.getClass().getName() + "\n";
        output += "r.toString() produces " + r.toString() + "\n";

        JOptionPane.showMessageDialog( null, output,
				 "overridden toString() example for Rectangle",
                                 JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
