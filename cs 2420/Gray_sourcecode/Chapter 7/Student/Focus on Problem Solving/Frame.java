/**
 * A Frame stores the time at which it arrives at the switch.
 */
public class Frame {
  // invariant: arrivalTime > 0
  private int arrivalTime;

  /**
   * Constructor. Create a <tt>Frame</tt> with an
   *   arrival time of 0.
   */
  public Frame() {
    this.arrivalTime = 0;
  }

  /**
   * @return the arrival time of this <tt>Frame</tt>
   */
  public int getArrivalTime() {
    return arrivalTime;
  }

  /**
   * Set the arrival time for this <tt>Frame</tt>.
   * @param currentTime the time at which this <tt>Frame</tt>
   *    arrived
   * @throws IllegalArgumentException if <tt>currentTime</tt>
   *    is less than 0
   */
  public void setArrivalTime( int currentTime ) {
    if ( currentTime < 0 ) {
      throw new IllegalArgumentException();
    }
    this.arrivalTime = currentTime;
  }
}
