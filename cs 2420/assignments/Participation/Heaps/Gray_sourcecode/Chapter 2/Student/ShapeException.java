package gray.adts.shapes;

/**
 * The exception that is thrown whenever an operation on a
 * shape is in violation of a method precondition.
 */
public class ShapeException extends RuntimeException {

    public ShapeException() {
        super();
    }

    public ShapeException( String errMsg ) {
        super( " " + errMsg );
    }
}
