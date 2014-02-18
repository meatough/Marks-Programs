/**
 * Which catch clause will catch this exception? Why?
 * Try compiling this code. What does the compiler say and why?
 */
public class ExceptionPuzzle {
    public static void main( String[] args ) {
        try {
            throw new NullPointerException();
        }
        catch ( Throwable e ) {
            System.out.println( "Caught " + e );
        }
        catch ( Exception e ) {
            System.out.println( "Caught " + e );
        }
        catch ( RuntimeException e ) {
            System.out.println( "Caught " + e );
        }
    }
}
