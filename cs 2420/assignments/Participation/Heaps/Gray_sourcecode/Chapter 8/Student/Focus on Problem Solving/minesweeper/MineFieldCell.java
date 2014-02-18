package minesweeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Java version of a popular game that demonstrates recursion.
 * A <tt>MineFieldCell</tt> represents a single cell in a
 * mine field. It may be empty, contain a clue or a bomb.
 */
public class MineFieldCell extends JToggleButton {
  // the static fields only need to be set once
  static protected ImageIcon mineIcon, notSelectedIcon,
      selectedIcon, flagIcon;
  static protected Font font;
  private int row, col;
  private int clue = 0;
  private boolean flagged;
  private boolean covered;

  /**
   * Constructor
   * @param r the row in the grid where this cell is found
   * @param c the column in the grid where this cell is found
   */
  public MineFieldCell( int r, int c ) {

    // The cell knows its place in the grid
    this.row = r;
    this.col = c;

    // Set up so that clues will appear properly in the cell
    setHorizontalTextPosition( AbstractButton.CENTER );

    setBorderPainted( false );
    setMargin( new Insets( 0, 0, 0, 0 ) );

    // the static fields only need to be set once
    // Set clue font
    if ( font == null ) {
      font = new Font( "serif", Font.BOLD, 12 );
    }
    setFont( font );

    // Set up the icons
    if ( mineIcon == null ) {
      mineIcon = new ImageIcon( ".\\mine.gif" );
    }

    if ( selectedIcon == null ) {
      selectedIcon = new ImageIcon( ".\\selected.gif" );
    }

    if ( notSelectedIcon == null ) {
      notSelectedIcon = new ImageIcon( ".\\notSelected.gif" );
    }

    if ( flagIcon == null ) {
      flagIcon = new ImageIcon( ".\\flag.gif" );
    }

    // establish cell's initial appearance and state
    setIcon( notSelectedIcon );
    setSelectedIcon( selectedIcon );
    this.flagged = false;
    this.covered = true;
  }

  /**
   * Assign the clue value to the cell
   * @param clueVal an integer in the range 0 - 9
   * @pre clueVal is in the range - to 9 (NOT VALIDATED)
   */
  void setClue( int clueVal ) {
    this.clue = clueVal;
  }

  /**
   * Return the clue
   * @return the clue value stored in this cell
   */
  int clue() {
    return this.clue;
  }

  /**
   * Change the selected icon to a mine for the mine cell.
   */
  void setMine() {
    setSelectedIcon( mineIcon );
  }

  /**
   * Determine if this cell is covered or not.
   * @return <code>true</code> if this cell is still covered
   */
  public boolean isCovered() {
    return this.covered;
  }

  /**
   * Make this cell uncovered. Once uncovered, a cell cannot
   * be covered again.
   */
  void makeUncovered() {
    this.covered = false;
    this.setIcon( selectedIcon );
  }

  /**
   * Set the cell to the not selected state with a flagged.
   */
  void makeFlagged( boolean flag ) {
    this.flagged = flag;
    if ( flag ) {
      this.setIcon( flagIcon );
    }
    else {
      this.setIcon( notSelectedIcon );
    }
  }

  /**
   * Return the flagged state.
   * @return <tt>true</tt> if this cell has a flagged on it,
   *          <tt>false</tt> otherwise.
   */
  boolean isFlagged() {
    return flagged;
  }

  /**
   * Get the cell's row.
   */
  int row() {
    return row;
  }

  /**
   * Get the cell's column.
   */
  int col() {
    return col;
  }

  /**
   * Set all states to an unselected clueless cell.
   */
  void clear() {
    covered = true;
    flagged = false;
    setText( "" );
    setClue( 0 );
    setSelected( false );
    setIcon( notSelectedIcon );
    setSelectedIcon( selectedIcon );
  }
}
