/**
 * Focus on Problem Solving for Stacks in Chapter 5.
 * This class performs evaluation of simple integer
 * expressions provided in postfix format. The expressions are
 * read from the keyboard and can only use binary -, +, *, /.
 */
import gray.adts.stack.*;
import java.util.EmptyStackException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
  private static String PROMPT =
      "Enter expression (Enter to quit): ";
      private static Stack<Object> operandStack =
      new ListStack<Object> ();
  private static boolean error = false;

  private static void clearStack( Stack s ) {
    while ( !operandStack.isEmpty() ) {
      operandStack.pop();
    }
  }

  private static void dealWithError( String errmsg ) {
    System.out.println( errmsg );
    System.out.flush();
    clearStack( operandStack );
    error = true;
  }

  private static void parse( Scanner expression ) {
    Long longInt = null, op1, op2;
    Long result = null;
    boolean isaLong = false;
    // check to see if there is another expression
    while ( !error && expression.hasNext() ) {
      // inner loop handles a single expression
      isaLong = false;
      String token = expression.next();
      try {
        longInt = new Long( token );
        isaLong = true;
      }
      catch ( NumberFormatException ex ) {
        // okay for now, maybe it's an operator
      }

      if ( isaLong ) {
        operandStack.push( longInt );
      }
      else
      // ops have length of 1
      if ( token.length() != 1 ) {
        dealWithError( "Error: token isn't a " +
                       "number or an operator => "
                       + token );
      }
      else { // assume we have a legal binary operator
        try { // so get the operands from the stack
          op2 = ( Long ) operandStack.pop();
          op1 = ( Long ) operandStack.pop();
        }
        catch ( EmptyStackException ex ) {
          dealWithError( "Error: insufficient operands" );
          continue; // skip to the top of while
        }
        // so far, so good - extract the longs
        long operand1 = op1.longValue();
        long operand2 = op2.longValue();

        // apply the op to the operands and
        //   push the result
        switch ( token.charAt( 0 ) ) {
          case '+':
            result = new Long( operand1 + operand2 );
            operandStack.push( result );
            break;
          case '-':
            result = new Long( operand1 - operand2 );
            operandStack.push( result );
            break;
          case '*':
            result = new Long( operand1 * operand2 );
            operandStack.push( result );
            break;
          case '/':
            if ( operand2 == 0 ) {
              dealWithError( "Error: division by 0" );
            }
            else {
              result = new Long( operand1 / operand2 );
              operandStack.push( result );
            }
            break;
          default:
            dealWithError(
                "Error: illegal operand => "
                + token );
            break;
        }
      }
    } // reached the end of the expression
  }

  public static void main( String[] args ) {
    boolean expressionComplete = false;
    Long result = null;
    String input;
    Scanner kbd = new Scanner( System.in ).
        useDelimiter( Pattern.compile( "\\s" ) );

    System.out.print( "" );
    input = kbd.nextLine();
    while ( input.length() != 0 ) { // another expression
      Scanner expression = new Scanner( input );
      error = false;
      expressionComplete = false;
      parse( expression );
      // the result is all that should be on
      // the stack now
      if ( operandStack.isEmpty() ) {
        System.out.println( "Error: stack is empty" );
      }
      else {
        result = ( Long ) operandStack.pop();
        // popped the result, stack should be empty now
        if ( !operandStack.isEmpty() ) {
          System.out.println( "Error: too many operands" );
          clearStack( operandStack );
        }
        else {
          System.out.println( "\nThe result is "
                              + result );
        }
      }
      System.out.print(
          "\nEnter an expression (Enter to quit): " );
      input = kbd.nextLine();
    } // test to see if there are more expressions

    System.exit( 0 );
  }
}
