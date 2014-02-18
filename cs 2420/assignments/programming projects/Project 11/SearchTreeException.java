/*********************************************************** 
 * Programming Assignment 10
 * Map ADT program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 17, 2013
 * Modified  April 24, 2013
 * Modified by Mark Eatough
 ***********************************************************/ 

/**
 * The exception that is thrown whenever an operation on a
 * Binary Search Tree is in violation of a method precondition.
 */
public class SearchTreeException extends RuntimeException 
{

  public SearchTreeException() 
  {
    super();
  }

  public SearchTreeException( String errMsg ) 
  {
    super( " " + errMsg );
  }
}
