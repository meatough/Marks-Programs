import java.lang.IllegalArgumentException;
import java.text.DecimalFormat;

public class SimulatorSwitchModel {
  private Switch networkSwitch;
  private int simulationLength;
  private int frameBurstSize;
  private float frameBurstProbability;

  private Frame lnkFrame;

  /**
   * Constructor.
   * @param simulationLength the number of "time units" the
   *    simulation is to run; must be > 0
   * @param bucketSize the number of Frames that can be stored
   *        in the switch; must be > 0
   * @param frameReleaseRate the number of frames to release in
   *         each time unit; must be > 0
   * @param frameBurstSize the maximum number of frames to send
   *         to the switch in a time unit; must be > 0
   * @param frameBurstProbability the probability that a frame
   *         burst will occur in a time unit; must be >= 0
   * @throws IllegalArgumentException if any of the parameter
   *         constraints are not met
   */
  public SimulatorSwitchModel( int simulationLength,
                               int bucketSize, int frameReleaseRate,
                               int frameBurstSize, float frameBurstProbability ) throws
      IllegalArgumentException {
    if ( ( simulationLength <= 0 ) || ( bucketSize <= 0 ) ||
         ( frameReleaseRate <= 0 ) || ( frameBurstSize <= 0 ) ||
         ( frameBurstProbability < 0.0 ) ) {
      throw new IllegalArgumentException();
    }

    this.simulationLength = simulationLength;
    this.frameBurstSize = frameBurstSize;
    this.frameBurstProbability = frameBurstProbability;
    this.networkSwitch = new Switch( bucketSize,
                                     frameReleaseRate );
  }

  /**
   *   Run the simulation.
   */
  public void runSimulator() {
    int currentTime;

    for ( currentTime = 0; currentTime < simulationLength;
          currentTime++ ) {
      if ( Math.random() <= frameBurstProbability ) {
        for ( int i = 0; i < frameBurstSize; i++ ) {
          networkSwitch.addFrame( new Frame(),
                                  currentTime );
        }
      }
      networkSwitch.releaseFrames( currentTime );
    }
  }

  /**
   * Generate a <TT>String</tt> containing the statistics for
   *  the simulation.
   * @return a <tt>String</tt> suitable for display containing
   *  statistics gathered from the switch.
   */
  public String getStatistics() {
    DecimalFormat waitTime = new DecimalFormat( "#.00" );
    String results =
        "Number of frames received: " +
        networkSwitch.numberFramesReceived() +
        "\nNumber of frames released: " +
        networkSwitch.numberFramesReleased() +
        "\nNumber of frames dropped:  " +
        networkSwitch.numberFramesDropped() +
        "\nAverage wait time:         " +
        waitTime.format( networkSwitch.averageWaitTime() );

    return results;
  }
}
