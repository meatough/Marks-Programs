package spellchecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Provides the user's view of the spell checker application.
 * Solution to Focus on Problem Solving section for Chapter 11.
 */
public class SpellCheckerView extends JFrame implements ActionListener {

  private JTextField wordField = new JTextField( 12 );
  private JButton searchButton = new JButton( "Search for:" );
  private JButton addButton = new JButton( "Add the word" );
  private JButton removeButton = new JButton( "Remove the word" );
  private JButton clearButton =
      new JButton( "Clear for next search" );
  private Icon happyFace = new ImageIcon( "happy.gif" );
  private Icon sadFace = new ImageIcon( "sad.gif" );
  // display blank, success or failure for search
  private JLabel statusLabel = new JLabel();
  // display happy/sad smiley face
  private JLabel statusIcon = new JLabel();

  private String dictionaryName = new String( "Names.txt" );

  private SpellChecker checker =
      new SpellChecker( dictionaryName );

  public SpellCheckerView( String title ) {
    // first we do all the GUI-related stuff
    super( title );

    // create key shortcuts and tooltips for the buttons
    searchButton.setMnemonic( KeyEvent.VK_S );
    searchButton.setToolTipText(
        "Click this button to search for a word" );
    addButton.setMnemonic( KeyEvent.VK_A );
    addButton.setToolTipText( "Click this button to add " +
                              "the word to the dictionary" );
    removeButton.setMnemonic( KeyEvent.VK_R );
    removeButton.setToolTipText( "Click this button to " +
                                 "remove the word from the dictionary" );
    clearButton.setMnemonic( KeyEvent.VK_C );
    clearButton.setToolTipText(
        "Click this button to clear the text " +
        "entry for a new search" );

    // Setup the GUI's appearance
    Container pane = getContentPane();
    pane.setLayout( new GridLayout( 5, 1, 3, 4 ) );

    JPanel wordPanel = new JPanel();
    wordPanel.add( searchButton );
    wordPanel.add( wordField );
    wordPanel.setBorder(
        BorderFactory.createLineBorder( Color.black ) );

    JPanel statusPanel =
        new JPanel( new GridLayout( 1, 2, 8, 0 ) );
    statusPanel.add( statusLabel );
    statusPanel.add( statusIcon );
    statusLabel.setHorizontalAlignment( JLabel.CENTER );
    statusIcon.setHorizontalAlignment( JLabel.CENTER );
    statusPanel.setBorder(
        BorderFactory.createLineBorder( Color.black ) );

    // add the panels and buttons to the main pane
    pane.add( wordPanel );
    pane.add( statusPanel );
    pane.add( addButton );
    pane.add( removeButton );
    pane.add( clearButton );

    // add ActionListeners for all the buttons
    searchButton.addActionListener( this );
    wordField.addActionListener( this );
    clearButton.addActionListener( this );
    addButton.addActionListener( this );
    removeButton.addActionListener( this );

    addWindowListener( new CloseWindow() );
  }

  public void actionPerformed( ActionEvent event ) {

    if ( ( event.getSource() == searchButton ) ||
         ( event.getSource() == wordField ) ) {
      // SEARCH State
      String word = wordField.getText();
      if ( word.length() == 0 ) {
        return; // stay in SEARCH State
      }
      // force user to use Clear button
      wordField.setEditable( false );
      if ( checker.search( word ) ) { // found the word
        statusLabel.setText( "Found it!" );
        statusIcon.setIcon( happyFace );
        removeButton.setEnabled( true ); // goto REMOVE State
      }
      else { // failure - did not find the word
        statusLabel.setText( "Didn't find it" );
        statusIcon.setIcon( sadFace );
        addButton.setEnabled( true ); // go to ADD State
      }
    }
    else // REMOVE State - Remove button clicked
    if ( event.getSource() == removeButton ) {
      checker.remove( wordField.getText() );
      gotoSearchState(); // go to SEARCH state
    }
    else // ADD State - Add button clicked
    if ( event.getSource() == addButton ) {
      checker.add( wordField.getText() );
      gotoSearchState(); // go to SEARCH state
    }
    else if ( event.getSource() == clearButton ) {
      gotoSearchState();
    }
  }

  /**
   * Move the GUI into the Search State.
   */
  private void gotoSearchState() {
    // clear fields, labels and icons
    wordField.setText( "" );
    wordField.setEditable( true );
    statusLabel.setText( " " );
    statusIcon.setIcon( null );

    // enable/disable buttons
    searchButton.setEnabled( true );
    removeButton.setEnabled( false );
    addButton.setEnabled( false );

    wordField.requestFocus();
  }

  // inner class to handle closing the window via the
  // Close or X options. If the dictionary has been modified,
  // be sure to save it.
  class CloseWindow extends WindowAdapter {
    public void windowClosing( WindowEvent event ) {
      if ( checker.modified() ) {
        checker.save( dictionaryName );
      }
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) {
    SpellCheckerView spellChecker =
        new SpellCheckerView( "Simple Spell Checker" );
    spellChecker.setSize( 340, 280 );
    spellChecker.gotoSearchState(); // start in right state
    spellChecker.setVisible( true ); // now we are ready!
  }
}
