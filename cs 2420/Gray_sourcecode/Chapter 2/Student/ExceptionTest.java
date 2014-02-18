import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Example illustrating catching exceptions.
 */
public class ExceptionTest {
    
  public static void doExceptionWithoutTry( boolean throwException ) throws Exception {
    System.out.println( "\n\ndoException without try block: throwException is " + throwException );
      if ( throwException )
        throw new Exception();
    System.out.println( "\tprintln immediately after throw statement" );
    System.out.println( "doException: last statement in the method" );
  }

  public static void doException( boolean throwException ) {
    System.out.println( "\n\ndoException without finally block: throwException is " + throwException );
    try {
      if ( throwException )
        throw new Exception();
      System.out.println( "\tprintln immediately after throw statement" );
    }
    catch ( Exception e ) {
      System.out.println( "caught " + e );
    }
    System.out.println( "doException: last statement in the method" );
  }

  public static void doExceptionWithFinally( boolean throwException ) {
    System.out.println( "\n\ndoExceptionWithFinally: throwException is " + throwException );
    try {
      if ( throwException )
        throw new Exception();
      System.out.println( "\tprintln immediately after throw statement" );
    }
    catch ( Exception e ) {
      System.out.println( "caught " + e );
    }
    finally {
      System.out.println( "doExceptionWithFinally: finally block" );
    }
    System.out.println( "doExceptionWithFinally: last statement in the method" );
  }
    
  public static void main( String []args ) throws Exception {
    doException( false );
    doException( true );
    doExceptionWithFinally( false );
    doExceptionWithFinally( true );
    doExceptionWithoutTry( false );
    doExceptionWithoutTry( true );
 }
}
