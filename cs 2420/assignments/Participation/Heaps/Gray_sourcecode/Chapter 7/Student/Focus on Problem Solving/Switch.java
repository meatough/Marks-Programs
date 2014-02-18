import gray.adts.queue.Queue;
import gray.adts.queue.ListQueue;

public class Switch {
  private int releaseRate;
  private int numberFramesReleased;
  private int numberFramesReceived;
  private int numberFramesDropped;
  private int totalWaitTime;

  /**
   * This is the "leaky bucket"; a FIFO queue of arriving frames.
   */
  private Queue bucket = null;

  /**
   * Constructor - a Switch is created with a queue of size
   * bucketSize
   * @param bucketSize the number of Frames that can be stored
   *    in this Switch at one time; must be > 0
   * @param releaseRate - the number of Frames that can be
   *    released in a single time unit; must be > 0
   * @throws IllegalArgumentException if the parameter
   *    constraints are not met
   */
  public Switch( int bucketSize, int releaseRate ) {
    if ( bucketSize <= 0 || releaseRate <= 0 ) {
      throw new IllegalArgumentException();
    }

    this.releaseRate = releaseRate;
    bucket = new ListQueue( bucketSize );
    numberFramesReleased = 0;
    numberFramesDropped = 0;
    numberFramesReceived = 0;
    totalWaitTime = 0;
  }

  /**
   * If there is room for it, add the <tt>Frame</tt> to this
   * switch's queue.
   * @param frame the <tt>Frame</tt> to add to this switch's
   *        queue
   * @param currentTime the simulator time at which this
   *    <tt>Frame</tt arrived at the switch; used to collect
   *    statistics
   */
  public void addFrame( Frame frame, int currentTime ) {
    if ( ( frame == null ) || ( currentTime < 0 ) ) {
      throw new IllegalArgumentException();
    }

    frame.setArrivalTime( currentTime );
    numberFramesReceived++;

    if ( !bucket.isFull() ) {
      bucket.enqueue( frame );
    }
    else {
      numberFramesDropped++;
    }
  }

  /**
   * Release up to <tt>releaseRate</tt> frames from the switch.
   * @param currentTime the current time of the simulation; used
   *    to collect statistics on the frames released
   */
  public void releaseFrames( int currentTime ) {
    int i;

    if ( currentTime < 0 ) {
      throw new IllegalArgumentException();
    }

    for ( i = 0; i < releaseRate && !bucket.isEmpty(); i++ ) {
      Frame frame = ( Frame ) bucket.dequeue();
      totalWaitTime = totalWaitTime + currentTime -
          frame.getArrivalTime();
    }
    numberFramesReleased += i;
  }

  /**
   * @return the total time frames waited in the switch
   */
  public int totalWaitTime() {
    return totalWaitTime;
  }

  /**
   * @return the total number of frames released from the switch
   */
  public int numberFramesReleased() {
    return numberFramesReleased;
  }

  /**
   * @return the total number of frames received by the switch
   */
  public int numberFramesReceived() {
    return numberFramesReceived;
  }

  /**
   * @return the total number of frames dropped by the switch
   *  due to lack of space
   */
  public int numberFramesDropped() {
    return numberFramesDropped;
  }

  /**
   * @return the total time frames waited in the switch
   */
  public float averageWaitTime() {
    return totalWaitTime / ( float ) numberFramesReleased;
  }
}
