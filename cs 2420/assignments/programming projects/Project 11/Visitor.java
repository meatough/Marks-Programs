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
 * Visitor for a Binary Search Tree.
 */
public interface Visitor<E extends Comparable<? super E>> 
{

  /**
   * Visit the specified node.
   * The implementation determines what, if anything,
   * will be done with the node.
   */
  public void visit( BSTNode<E> node );
}
