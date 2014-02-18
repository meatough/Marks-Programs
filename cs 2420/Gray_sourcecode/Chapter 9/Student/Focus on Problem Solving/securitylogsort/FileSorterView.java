package securitylogsort;

import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Focus on Problem Solving solution. Sort a security log
 * file using external merge sort.
 */
public class FileSorterView extends JFrame implements ActionListener {

  // The menu items for the main window
  private JMenuItem openMenuItem = new JMenuItem( "Open File..." );
  private JMenuItem exitMenuItem = new JMenuItem( "Exit" );
  private JTextArea infoText = new JTextArea( 5, 22 );
  private String srcfileName = null;
  private String sortedFileName = null;
  private ExternalFileSorter externalFileSorter;

  public FileSorterView( String title ) {

    // first we do all the GUI-related stuff
    super( title );

    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    // Create the File menu bar entry, add items to it,
    // then add the menu to the menu bar
    JMenu fileMenu = new JMenu( "File" );
    fileMenu.add( openMenuItem );
    fileMenu.add( exitMenuItem );
    menuBar.add( fileMenu );

    // attach each File menu item to our action listener
    //   (see method actionPerformed() in this class)
    openMenuItem.addActionListener( this );
    exitMenuItem.addActionListener( this );

    // add a listener for when the user clicks on the X to
    // close the window
    addWindowListener( new CloseWindow() );

    infoText.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
    infoText.setText( "\n     Use File->Open File to select " +
                      "the file to sort." );
    infoText.setBackground( Color.blue );
    infoText.setForeground( Color.white );
    infoText.setEditable( false );
    infoText.setMaximumSize( new Dimension( 400, 40 ) );

    getContentPane().add( infoText );
    getContentPane().setSize( 450, 400 );
    pack();
    show();

    // now we do the external merge sort related stuff
    externalFileSorter = new ExternalFileSorter();
  }

  // the ActionListener method - called whenever a
  // Menu Item is selected
  public void actionPerformed( ActionEvent event ) {
    File srcFile, compressedFile;
    // get a reference to the selected menu item
    Object eventSrc = event.getSource();
    // File Menu Options
    if ( eventSrc == openMenuItem ) {
      srcfileName =
          getFileName( "Input file", FileDialog.LOAD );
      if ( srcfileName != null ) {
        sortedFileName =
            externalFileSorter.sortFile( srcfileName );
        if ( sortedFileName != null ) {
          JOptionPane.showMessageDialog( null,
                                         srcfileName + " has been sorted\n\n" +
                                         "Sorted file:  " + sortedFileName +
                                         "\n",
                                         "Results",
                                         JOptionPane.INFORMATION_MESSAGE );
        }
        else {
          JOptionPane.showMessageDialog( null,
                                         "An error has occurred.\n" +
                                         "The file has NOT been processed",
                                         "Error", JOptionPane.ERROR_MESSAGE );
        }
      }
    }
    else if ( eventSrc == exitMenuItem ) {
      System.exit( 0 );
    }
    repaint();
  }

  /**
   * Use a fileDialog box to get the name of the input file
   * @param <tt>title</tt> to indicate if we are looking for an
   *       input or an output file
   * @param <tt>mode</tt> either <tt>FileDialog.LOAD</tt> or
   *        <tt>FileDialog.SAVE</tt>
   */
  private String getFileName( String title, int mode ) {
    FileDialog fileDialog = new FileDialog( this, title, mode );
    fileDialog.setSize( 450, 300 );
    fileDialog.setVisible( true );
    return fileDialog.getFile() == null ? null :
        fileDialog.getDirectory() + fileDialog.getFile();
  }

  // inner class to handle closing the window via the X option
  class CloseWindow extends WindowAdapter {
    public void windowClosing( WindowEvent event ) {
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) {
    FileSorterView fileSorter =
        new FileSorterView( "File Sorter" );
    fileSorter.setSize( 300, 150 );
    fileSorter.setVisible( true );
  }
}
