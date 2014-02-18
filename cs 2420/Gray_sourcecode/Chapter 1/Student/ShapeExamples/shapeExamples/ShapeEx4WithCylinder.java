package shapeExamples;

import gray.adts.shapes.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ShapeEx4WithCylinder {

    public static void main ( String [] args ) {
        RectangularPrism rp1 = new RectangularPrism();
        Cylinder cyl1 = new Cylinder();
        DecimalFormat prec3 = new DecimalFormat( "#0.000" );
        String output;

        rp1.setHeight( 5.3 );   // method from Rectangle2
        rp1.setLength( 6.6 );   // method from Rectangle2
        rp1.setDepth( 7.2 );    // method from RectPrism

        cyl1.setRadius( 3.5 );   // method from Circle
        cyl1.setDepth( 19.5 );   // method from Cylinder

        // getShapename() is inherited from Shape
        output  = "rp1 is a " + rp1.getShapeName() + "\n";
        output += "cyl1 is a " + cyl1.getShapeName() + "\n\n";

        // toString() is originally from Object and overridden
        //  in the various shape classes.
        output += "rp1 = " + rp1.toString() + "\n";
        output += "rp1 surface area = "
                   + prec3.format( rp1.getSurfaceArea() ) + "\n";
        output += "rp1 volume = "
                   + prec3.format( rp1.getVolume() ) + "\n\n";
        output += "cyl1 = " + cyl1.toString() + "\n";
        output += "cyl1 surface area = "
                   + prec3.format( cyl1.getSurfaceArea() ) + "\n";
        output += "cyl1 volume = " + prec3.format( cyl1.getVolume() ) + "\n";

        JOptionPane.showMessageDialog( null, output,
				"3D shapes example",
                                JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
