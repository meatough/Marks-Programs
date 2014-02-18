import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Focus on Problem Solving solution. Encoding a text file using
 * Huffman coding.
 */
public class HuffmanView extends JFrame implements ActionListener {

    // The menu items for the main window
    private JMenuItem openMenuItem = new JMenuItem("Open File...");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    private JTextArea infoText     = new JTextArea( 5, 22 );
    private String srcfileName     = null;
    private String compressedFileName = null;
    private HuffmanCompress huffmanCompress;

    public HuffmanView( String title ){

        // first we do all the GUI-related stuff
        super( title );

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar( menuBar );

        // Create the File menu bar entry, add items to it,
        // then add the menu to the menu bar
        JMenu fileMenu = new JMenu("File");
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

        infoText.setFont( new Font( "SansSerif", Font.PLAIN, 12) );
        infoText.setText(
         "This program will compress an ASCII text file using\n" +
         "Huffman Coding. Use File->Open to select the file to\n" +
         "compress. The compressed file will be written to a\n" +
         "file with the same name and a .hfc extension. For \n" +
         "example: largeFile.txt will be stored in largeFile.hfc\n"
         );
        infoText.setBackground( Color.blue );
        infoText.setForeground( Color.white );
        infoText.setEditable( false );
        infoText.setMaximumSize( new Dimension( 400, 40 ) );

        getContentPane().add( infoText );
        getContentPane().setSize( 450, 400 );
        pack();
        setVisible( true );

        // now we do the Huffman-related stuff
        huffmanCompress = new HuffmanCompress();
    }

    // the ActionListener method - called whenever 
    // a Menu Item is selected
    public void actionPerformed( ActionEvent event ) {
        File srcFile, compressedFile;
       
        // get a reference to the selected menu item
        Object eventSrc = event.getSource();   
        // File Menu Options
        if ( eventSrc == openMenuItem ) {
            srcfileName = getFileName( "Input file", 
                                       FileDialog.LOAD );
            if ( srcfileName != null ) {
                compressedFileName = 
                      huffmanCompress.compressFile( srcfileName );
                if ( compressedFileName != null ) {
                   srcFile = new File( srcfileName );
                   compressedFile = new File( compressedFileName );

                   JOptionPane.showMessageDialog(null,srcfileName +
                    " has been compressed\n\n" +
                    "Source file:  " + srcFile.getName() + " (" + 
                    srcFile.length() + " bytes)\n" +
                    "Compressed file:  " +compressedFile.getName()+
                    " (" + compressedFile.length() + " bytes)\n",
                    "Results", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                   JOptionPane.showMessageDialog( null, 
                      "An error has occurred.\n" +
                      " The file has NOT been processed",
                      "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if ( eventSrc == exitMenuItem ) {
            System.exit(0);
        }
        repaint();
   }

    private String getFileName( String title, int mode ){
       FileDialog fileDialog = new FileDialog(this, title, mode );
       fileDialog.setSize(450, 300);
       fileDialog.setVisible(true);
 
       return fileDialog.getFile() == null ? null : 
                  fileDialog.getDirectory() + fileDialog.getFile();
    }

    // inner class to handle closing the window via the X option
    class CloseWindow extends WindowAdapter {
        public void windowClosing( WindowEvent event ) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        HuffmanView huffmanView = 
                          new HuffmanView( "Huffman Compresser" );
        huffmanView.setSize( 300, 150 );
        huffmanView.setVisible( true );
    }
}