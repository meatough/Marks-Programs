import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import gray.adts.shapes.*;

public class ShapeQ1
{
  public static void main( String[] args )
  {
    DecimalFormat p3 = new DecimalFormat( "#0.000" );
    String output;
    RectangularPrism rp1 = new RectangularPrism( 4, 5, 6 );
    Rectangle rect1 = rp1;

    // getShapename() is inherited from Shape
    output = "rp1 is a " + rp1.getShapeName() + "\n";
    output += "rect1 is a " + rect1.getShapeName() + "\n\n";

    // toString() is originally from Object & overridden
    // in the various shape classes.
    output += "rp1 = " + rp1.toString() + "\n";
    output += "rp1 surface area = "
        + p3.format( rp1.getSurfaceArea() ) + "\n";
    output += "rp1 volume = "
        + p3.format( rp1.getVolume() ) + "\n\n";
    output += "rect1 = " + rect1.toString() + "\n";
    output += "rect1 surface area = "
        + p3.format( rect1.getSurfaceArea() ) + "\n";
    JOptionPane.showMessageDialog( null, output,
                                   "Rectangle-RectangularPrism exercise",
                                   JOptionPane.INFORMATION_MESSAGE );
    System.exit( 0 );
  }
}
