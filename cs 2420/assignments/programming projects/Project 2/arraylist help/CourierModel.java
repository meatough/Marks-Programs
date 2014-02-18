package courier;

import java.io.Serializable;

/**
 * Stores the slips displayed by <tt>CourierView</tt>.
 * In this implementation, the priority of a <tt>CourierSlip</tt>
 * is determined by its position in the model, with 0 being
 * the highest priority.
 */
public class CourierModel
    implements Serializable 
{

  private CourierSlip slipList[];
  private static final int DEFAULT_SIZE = 50;
  private int capacity;
  private int numSlips;

  /**
   * Default constructor.
   */
  public CourierModel() {
    slipList = new CourierSlip[DEFAULT_SIZE];
    capacity = DEFAULT_SIZE;
    numSlips = 0;
  }

  /**
   * Add a slip to the CourierModel in the specified position.
   * @param position the position where slip is to be added;
   *   must be in the range 0 to getNumslips() inclusive.
   * @param slip the slip to add to the model
   * @throws IndexOutOfBoundsException if position is outside
   *      the range 0 to getNumslips() inclusive.
   */
  public void addSlip(int position, CourierSlip slip) throws
      IndexOutOfBoundsException 
		{
    if ( (position < 0) || (position > this.numSlips)) 
	 {
      throw new IndexOutOfBoundsException();
    }
    // if we are already at capacity, increase by 50%
    if (this.numSlips == this.capacity) 
	 {
      resize(this.capacity + this.capacity / 2);
    }
    // everything is okay, make room for the new slip
    // and insert it
    moveSlipsUp(position, this.numSlips);
    this.slipList[position] = slip;
    this.numSlips++;
  }

  /**
   * Remove the slip found at <tt>position</tt> from the
   * model.
   * @param position  the position of the slip to delete; must
   *   be in the range 0 to getNumslips() - 1 inclusive.
   * @throws IndexOutOfBoundsException if position is outside
   *    the range 0 to getNumslips() - 1 inclusive.
   */
  public void deleteSlip(int position) throws IndexOutOfBoundsException 
  {
    if ( (position < 0) || (position > this.numSlips - 1)) 
	 {
      throw new IndexOutOfBoundsException();
    }
    moveSlipsDown(position, this.numSlips - 1);
    this.numSlips--;
    this.slipList[this.numSlips] = null;
  }

  /**
   * Get the courier slip at the designated position.
   * @param position position of the slip to return; must be
   *  in the range of 0 to <tt>getNumSlips()</tt> - 1.
   * @return <tt>CourierSlip</tt> at position <tt>position</tt>
   *   in the model
   * @throws IndexOutOfBoundsException if <tt>position</tt> is
   *   outside the range of 0 to <tt>getNumSlips()</tt> - 1.
   */
  public CourierSlip getSlip(int position) throws IndexOutOfBoundsException 
  {
    if ( (position < 0) || (position > this.numSlips - 1)) 
	 {
      throw new IndexOutOfBoundsException();
    }
    return this.slipList[position];
  }

  /**
   * Get the number of slips stored by the model.
   * @return the number of slips stored by the model
   */
  public int getNumSlips() 
  {
    return this.numSlips;
  }

  // UTILITY METHODS
  /**
   * Move the slips from index start to finish UP a position.
   * @param start beginning position for the moves; no check is
   *    done to ensure that position is valid.
   * @param finish ending position for the moves; no check is
   *    done to ensure that position is valid.
   */
  private void moveSlipsUp(int start, int finish) 
  {
    for (int i = finish; i > start; i--) 
	 {
      this.slipList[i] = this.slipList[i - 1];
    }
  }

  /**
   * Move the slips from index start to finish DOWN a position.
   * @param start beginning position for the moves; no check is
   *    done to ensure that position is valid.
   * @param finish ending position for the moves; no check is
   *    done to ensure that position is valid.
   */
  private void moveSlipsDown(int start, int finish) 
  {
    for (int i = start; i < finish; i++) 
	 {
      this.slipList[i] = this.slipList[i + 1];
    }
  }

  /**
   * Bump up the size of the array
   * @param new_capacity the new capacity of the array.
   *  No check is done that this is a meaningful value.
   */
  private void resize(int new_capacity) 
  {
    CourierSlip[] temp = new CourierSlip[new_capacity];
    for (int i = 0; i < this.slipList.length; i++)
	  {
      temp[i] = this.slipList[i]; // make the copy
      this.slipList[i] = null; // for garbage collection
    }
    this.capacity = new_capacity;
    this.slipList = temp;
  }
}
