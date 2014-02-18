package courier;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class CourierModel implements Serializable {

  // where the CourierSlips are to be stored
  private List<CourierSlip> slipList;

  /**
   * Default constructor.
   */
  public CourierModel() {
    slipList = new ArrayList<CourierSlip> ();
  }

  /**
   * Add a slip to the CourierModel in the specified position.
   * @param position the position where slip is to be added;
   *   must be in the range 0 to getNumslips() inclusive.
   * @param slip the slip to add to the model
   * @throws IndexOutOfBoundsException if position is outside
   *      the range 0 to getNumslips() inclusive.
   */
  public void addSlip( int position, CourierSlip slip ) throws
      IndexOutOfBoundsException {
    slipList.add( position, slip );
  }

  /**
   * Remove the slip found at <tt>position</tt> from the
   * model.
   * @param position  the position of the slip to delete; must
   *   be in the range 0 to getNumslips() - 1 inclusive.
   * @throws IndexOutOfBoundsException if position is outside
   *    the range 0 to getNumslips() - 1 inclusive.
   */
  public void deleteSlip( int position ) throws IndexOutOfBoundsException {
    slipList.remove( position );
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
  public CourierSlip getSlip( int position ) throws IndexOutOfBoundsException {
    return ( CourierSlip ) slipList.get( position );
  }

  /**
   * Get the number of slips stored by the model.
   * @return the number of slips stored by the model
   */
  public int getNumSlips() {
    return slipList.size();
  }
}
