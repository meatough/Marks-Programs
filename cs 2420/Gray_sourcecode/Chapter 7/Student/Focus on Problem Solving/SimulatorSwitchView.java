import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Font;
import java.text.DecimalFormat;

public class SimulatorSwitchView extends JFrame implements ActionListener {

  private SimulatorSwitchModel simulatorModel = null;
  private int bucketSize = 0;
  private int frameReleaseRate = 0;
  private int simulationLength = 0;
  private int frameBurstSize = 0;
  private float frameBurstProbability = 0.0f;

  // labels, list and text boxes for the main window
  private JLabel bucketSizeLabel = new JLabel( "Bucket size" );
  private JLabel frameReleaseRateLabel = new JLabel( "Frame release rate" );
  private JLabel simLengthLabel = new JLabel( "Simulation length" );
  private JLabel frameBurstProbLabel = new JLabel( "Probability of frame burst" );
  private JLabel frameBurstSizeLabel = new JLabel( "Size of frame burst" );

  private JTextField bucketSizeField = new JTextField( 3 );
  private JTextField frameReleaseRateField = new JTextField( 3 );
  private JTextField simLengthField = new JTextField( 3 );
  private JTextField frameBurstProbField = new JTextField( 3 );
  private JTextField frameBurstSizeField = new JTextField( 3 );
  private JButton runButton = new JButton( "Run" );
  private JLabel resultsLabel = new JLabel( "Simulation Results: " );
  private JTextArea resultsField = new JTextArea( 12, 14 );
  private JScrollPane scrollableResults = new JScrollPane( resultsField );

  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;

  public SimulatorSwitchView( String title ) {
    super( title );

    Font font = new Font( "Monospaced", Font.PLAIN, 12 );
    resultsField.setFont( font );
    resultsField.setEditable( false );
    // get the main content pain and add our list and details panels to it
    Container pane = getContentPane();
    gbLayout = new GridBagLayout();
    pane.setLayout( gbLayout );

    gbConstraints = new GridBagConstraints();
    gbConstraints.fill = GridBagConstraints.BOTH;
    gbConstraints.weightx = 1;
    gbConstraints.weighty = 1;

    addComponent( bucketSizeLabel, 0, 0, 1, 1 );
    addComponent( bucketSizeField, 0, 1, 1, 1 );
    addComponent( frameReleaseRateLabel, 1, 0, 1, 1 );
    addComponent( frameReleaseRateField, 1, 1, 1, 1 );
    addComponent( simLengthLabel, 2, 0, 1, 1 );
    addComponent( simLengthField, 2, 1, 1, 1 );
    addComponent( frameBurstProbLabel, 3, 0, 1, 1 );
    addComponent( frameBurstProbField, 3, 1, 1, 1 );
    addComponent( frameBurstSizeLabel, 4, 0, 1, 1 );
    addComponent( frameBurstSizeField, 4, 1, 1, 1 );

    //runButton.setSize(4, 4);
    runButton.addActionListener( this );
    runButton.setBackground( Color.green );
    addComponent( runButton, 5, 1, 1, 1 );
    addComponent( resultsLabel, 6, 0, 1, 1 );
    addComponent( scrollableResults, 7, 0, 2, 1 );

    // add a listener for when the user clicks on the X to close the window
    addWindowListener( new CloseWindow() );
  }

  private void addComponent( Component component, int row, int col, int width,
                             int height ) {
    gbConstraints.gridy = row;
    gbConstraints.gridx = col;
    gbConstraints.gridwidth = width;
    gbConstraints.gridheight = height;

    gbLayout.setConstraints( component, gbConstraints );
    getContentPane().add( component );
  }

  public void actionPerformed( ActionEvent event ) {
    // Get the user's input
    try {
      bucketSize = Integer.parseInt( bucketSizeField.getText() );
      frameReleaseRate = Integer.parseInt( frameReleaseRateField.getText() );
      simulationLength = Integer.parseInt( simLengthField.getText() );
      frameBurstSize = Integer.parseInt( frameBurstSizeField.getText() );
      frameBurstProbability = Float.parseFloat( frameBurstProbField.getText() );
    }
    catch ( NumberFormatException e ) {
      JOptionPane.showOptionDialog( null, "Non-numeric value entered",
                                    "Error: Invalid Input",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.ERROR_MESSAGE,
                                    null, null, null );
      return;
    }

    // Verify the data are valid
    if ( ( bucketSize <= 0 ) ||
         ( frameReleaseRate <= 0 ) ||
         ( simulationLength <= 0 ) ||
         ( frameBurstSize <= 0 ) ||
         ( frameBurstProbability <= 0.0 )
        ) {
      JOptionPane.showOptionDialog( null, "All values must be > 0",
                                    "Error: Invalid Input",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.ERROR_MESSAGE,
                                    null, null, null );
      return;
    }

    // Create the simulator with the user's input
    simulatorModel = new SimulatorSwitchModel(
        simulationLength,
        bucketSize,
        frameReleaseRate,
        frameBurstSize,
        frameBurstProbability );

    // Run the simulation
    simulatorModel.runSimulator();

    // Get and display the results
    DecimalFormat frameBurst = new DecimalFormat( "###,###.00" );
    String results =
        "Simulation length:         " + simulationLength
        + "\nBucket size:               " + bucketSize
        + "\nFrame release rate:        " + frameReleaseRate
        + "\nFrame burst size:          " + frameBurstSize
        + "\nFrame burst probability:   " +
        frameBurst.format( frameBurstProbability )
        + "\n" + simulatorModel.getStatistics()
        + "\n======================================\n";
    resultsField.append( results );
  }

  // inner class to handle closing the window via the X option
  class CloseWindow extends WindowAdapter {
    public void windowClosing( WindowEvent event ) {
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) {
    SimulatorSwitchView simulatorView = new SimulatorSwitchView(
        "Leaky Bucket Simulator" );
    simulatorView.setSize( 300, 400 );
    simulatorView.setVisible( true );
  }
}
