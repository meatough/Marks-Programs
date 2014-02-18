package shapeExamples;

import gray.adts.shapes.*;
import javax.swing.JOptionPane;

public class PolymorphEx {

    public static void main ( String [] args ) {
        Cube cube = new Cube();
        String output;

        /* use methods defined in Rectangle and Circle */
	cube.setLength( 4 );
	cube.setHeight( 5 );
	cube.setDepth( 6 );

        output = "Class name is " + cube.getClass().getName() + "\n";
        output += "r.toString() produces " + cube.toString() + "\n";
        output += "surface area = " + cube.getSurfaceArea() + "\n";
        output += "perimeter = " + cube.getPerimeter() + "\n";
        output += "volume = " + cube.getVolume() + "\n";

        JOptionPane.showMessageDialog( null, output,
				 "overridden toString() example for Box",
                                 JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
