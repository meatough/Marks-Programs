import gray.adts.shapes.Rectangle;

/**
 * Illustrate the information provided by the detail message and
 * the stack trace when an exception is thrown.
 */
public class RectangleExceptionEx {
    public static void main( String[] args ) {
        Rectangle r1 = new Rectangle( 4, 5 ); // this is okay
        Rectangle r2 = new Rectangle( -1, 5 ); // this is NOT okay
        // once the exception is thrown by the constructor, the
        // program will exit since we don't make any attempt to
        // catch the exception.
    }
}
