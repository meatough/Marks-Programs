import javax.swing.JOptionPane;
import gray.adts.shapes.*;

public class ShapeCylEx
{
  public static void main( String[] args )
  {
    String output;
    Cylinder c1 = new Cylinder( 3.5, 7.2 );
    Cylinder c2;
    Shape s = c1;
    c2 = ( Cylinder ) s;
    output = "c1 = " + c1.toString() + "\n";
    output += "c2 = " + c2.toString() + "\n";
    JOptionPane.showMessageDialog( null, output,
                                   "shape-cylinder cast exercise",
                                   JOptionPane.INFORMATION_MESSAGE );
    System.exit( 0 );
  }
}
