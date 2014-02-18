package shapeExamples;

import gray.adts.shapes.*;
import javax.swing.JOptionPane;

/**
 *  Illustrates the use of the equals() method.
 */
public class ShapeEx3 {

    public static void main ( String [] args ) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(1, 2);
        Rectangle r3 = new Rectangle(3, 4);
        Rectangle r4 = r2;
        String output;

        // use methods inherited from Object
        output = "r1 = " + r1.toString() + "\n";
        output += "r2 = " + r2.toString() + "\n";
        output += "r3 = " + r3.toString() + "\n";
        output += "r4 = " + r4.toString() + "\n";
	    output += "r1.equals( r2 ) is " + r1.equals( r2 ) + "\n";
	    output += "r1.equals( r3 ) is " + r1.equals( r3 ) + "\n";
	    output += "r2.equals( r4 ) is " + r2.equals( r4 ) + "\n";

        JOptionPane.showMessageDialog( null, output,
				"generic equals() example for Rectangle2",
                                JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
