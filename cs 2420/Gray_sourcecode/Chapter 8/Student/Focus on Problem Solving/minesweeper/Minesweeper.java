package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Java version of a popular game that demonstrates
 * recursion.
 */
public class Minesweeper extends JFrame {
  private static final int EMPTY_CELL = 0;
  private static final int MINE_CELL = 9;
  private static final int MINE_FIELD_SIZE = 16;

  private MineFieldCell mineField[][];
  private int numberOfMines = 20;
  private int mineFlagCount = 20;
  private JToolBar toolBar;
  private JLabel minesLeftLabel;
  private JPanel mineFieldPanel;
  private int uncoveredCells = 0;
  private int totalNumberOfCells;

  /**
   * Constructor
   */
  public Minesweeper() {
    super( "Minesweeper" );
    createMainFrame();
  }

  /**
   * Create the main frame for the application.
   */
  private void createMainFrame() {

    mineField =
        new MineFieldCell[MINE_FIELD_SIZE][MINE_FIELD_SIZE];

    // do all the GUI stuff
    Container contentPane = getContentPane();
    contentPane.setLayout( new BorderLayout() );

    mineFieldPanel = new JPanel();
    mineFieldPanel.setLayout( new GridLayout( MINE_FIELD_SIZE,
                                              MINE_FIELD_SIZE ) );

    // allocate the mine mineField and add them to the gameboard

    MineFieldCellEventHandler cellEventHandler =
        new MineFieldCellEventHandler();
    for ( int row = 0; row < MINE_FIELD_SIZE; row++ ) {
      for ( int col = 0; col < MINE_FIELD_SIZE; col++ ) {
        mineField[row][col] = new MineFieldCell( row, col );
        mineField[row][col].addMouseListener( cellEventHandler );
        mineFieldPanel.add( mineField[row][col] );
      }
    }

    createMenu();
    createToolBar();
    initializeGame();

    contentPane.add( toolBar, BorderLayout.NORTH );
    contentPane.add( mineFieldPanel, BorderLayout.CENTER );

    setSize( 378, 430 );
    setVisible( true );
  }

  /**
   * Initialize all mineField to empty and then assign
   * the mines and clues
   */
  private void initializeGame() {
    for ( int row = 0; row < MINE_FIELD_SIZE; row++ ) {
      for ( int col = 0; col < MINE_FIELD_SIZE; col++ ) {
        mineField[row][col].clear();
      }
    }

    assignMines();
    assignClues();
    uncoveredCells = 0;
    totalNumberOfCells = MINE_FIELD_SIZE * MINE_FIELD_SIZE;
    mineFlagCount = numberOfMines;
    minesLeftLabel.setText( "Mines Remaining: " + mineFlagCount );
  }

  /**
   * Create the toolbar and place the mine count label on it
   */
  private void createToolBar() {
    toolBar = new JToolBar();
    minesLeftLabel = new JLabel( "Mines Remaining: " +
                                 mineFlagCount );
    toolBar.add( minesLeftLabel );
  }

  /**
   * Create the menu bar and menu items
   */
  private void createMenu() {
    JMenuBar menuBar;
    JMenu gameMenu, helpMenu;
    JMenuItem newItem, exitItem, uncoverItem, aboutItem;

    menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    //Build the first menu.
    gameMenu = new JMenu( "Game" );
    gameMenu.setMnemonic( KeyEvent.VK_G );
    menuBar.add( gameMenu );

    // The New Game menu item that starts a new game
    newItem = new JMenuItem( "New Game" );
    newItem.addActionListener(
        new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        initializeGame();
      }
    }
    );
    gameMenu.add( newItem );

    // The Uncover Minefield menu item that uncovers the grid
    uncoverItem = new JMenuItem( "Uncover Minefield" );
    uncoverItem.addActionListener(
        new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        revealGrid();
      }
    }
    );
    gameMenu.add( uncoverItem );

    exitItem = new JMenuItem( "Exit" );
    exitItem.addActionListener(
        new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        System.exit( 0 );
      }
    }
    );
    gameMenu.add( exitItem );
  }

  /**
   * Reveal the entire grid
   */
  private void revealGrid() {
    for ( int row = 0; row < MINE_FIELD_SIZE; row++ ) {
      for ( int col = 0; col < MINE_FIELD_SIZE; col++ ) {
        mineField[row][col].setSelected( true );
        if ( mineField[row][col].clue() > EMPTY_CELL &&
             mineField[row][col].clue() < MINE_CELL ) {
          mineField[row][col].setText( "" +
                                       mineField[row][col].clue() );
        }
      }
    }
  }

  /**
   * Randomly select locations for the hidden mines
   */
  private void assignMines() {
    int xPos, yPos;

    for ( int x = 0; x < numberOfMines; ++x ) {
      xPos = ( int ) ( Math.random() * MINE_FIELD_SIZE );
      yPos = ( int ) ( Math.random() * MINE_FIELD_SIZE );

      // Do not put a mine on a mine
      while ( mineField[yPos][xPos].clue() != 0 ) {
        xPos = ( int ) ( Math.random() * MINE_FIELD_SIZE );
        yPos = ( int ) ( Math.random() * MINE_FIELD_SIZE );
      }
      // Place a mine
      mineField[yPos][xPos].setClue( MINE_CELL );
      mineField[yPos][xPos].setMine();
    }
  }

  /**
   * Scan the game array and place clues
   */
  private void assignClues() {
    for ( int y = 0; y < MINE_FIELD_SIZE; ++y ) {
      for ( int x = 0; x < MINE_FIELD_SIZE; ++x ) {
        // Ignore mineField with mines
        if ( mineField[y][x].clue() != MINE_CELL ) {
          int clueCount = EMPTY_CELL;
          // look around

          // look west
          if ( ( x - 1 >= 0 ) &&
               ( mineField[y][x - 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look east
          if ( ( x + 1 < MINE_FIELD_SIZE ) &&
               ( mineField[y][x + 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look north
          if ( ( y - 1 >= 0 ) &&
               ( mineField[y - 1][x].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look south
          if ( ( y + 1 < MINE_FIELD_SIZE ) &&
               ( mineField[y + 1][x].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look north west
          if ( ( y - 1 >= 0 ) && ( x - 1 >= 0 ) &&
               ( mineField[y - 1][x - 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look north east
          if ( ( y - 1 >= 0 ) && ( x + 1 < MINE_FIELD_SIZE ) &&
               ( mineField[y - 1][x + 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look south west
          if ( ( y + 1 < MINE_FIELD_SIZE ) && ( x - 1 >= 0 ) &&
               ( mineField[y + 1][x - 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }
          // look south east
          if ( ( y + 1 < MINE_FIELD_SIZE ) &&
               ( x + 1 < MINE_FIELD_SIZE ) &&
               ( mineField[y + 1][x + 1].clue() == MINE_CELL ) ) {
            ++clueCount;
          }

          mineField[y][x].setClue( clueCount );
        }
      }
    }
  }

  private boolean outOfBounds( int yPos, int xPos ) {
    return ( ( xPos < 0 ) || ( yPos < 0 ) ||
             ( xPos >= MINE_FIELD_SIZE ) ||
             ( yPos >= MINE_FIELD_SIZE ) );
  }

  /**
   * The recursive routine to uncover mineField
   * Base cases:
   *   cell position is out of grid bounds
   *   cell hides a mine
   *   cell holds a clue
   *   cell is empty but has been uncovered
   * Recursive case:
   *   cell is empty and has not been uncovered
   * @param yPos
   * @param xPos
   */
  private void uncover( int row, int col ) {
    if ( outOfBounds( col, row ) ) {
      return;
    }

    MineFieldCell cell = mineField[row][col];
    int clue = cell.clue();

    // cell hides a mine or has been uncovered   - base cases
    if ( ( clue == MINE_CELL ) || !cell.isCovered() ) {
      return;
    }

    // the cell is either empty and hasn't been uncovered
    // OR it holdsa clue, so make it uncovered
    cell.makeUncovered();
    uncoveredCells++;

    // if this cell holds a clue, set its string value
    // and display it
    if ( clue != EMPTY_CELL ) {
      mineField[row][col].setText( "" + clue );
      this.repaint();
      return;
    }
    // invariant: the cell is empty AND was just uncovered

    this.repaint();

    // must be an empty cell - recursive case
    // let's see what this cell's neighbors can tell us by
    // recursively uncovering them
    uncover( row - 1, col ); // North
    uncover( row - 1, col + 1 ); // North-East
    uncover( row, col + 1 ); // East
    uncover( row + 1, col + 1 ); // South-East
    uncover( row + 1, col ); // South
    uncover( row + 1, col - 1 ); // South-West
    uncover( row, col - 1 ); // West
    uncover( row - 1, col - 1 ); // North-West
  }

  /**
   * The mandatory main that gets the ball rolling
   * @param args
   */
  public static void main( String args[] ) {
    Minesweeper window = new Minesweeper();

    window.addWindowListener(
        new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit( 0 );
      }
    }
    );
  }

  /**
   * Event handler for the toggle button.
   * Inner class of Minesweeper.
   */
  class MineFieldCellEventHandler extends MouseAdapter {
    /**
     * Capture when a mouse button is released
     * @param e the mouse event generated
     */
    public void mouseReleased( MouseEvent e ) {
      MineFieldCell cell = ( MineFieldCell ) e.getSource();

      // Check for RIGHT mouse button release
      if ( ( e.getModifiers() & InputEvent.BUTTON3_MASK ) ==
           InputEvent.BUTTON3_MASK ) {
        // see if the cell is still covered
        if ( cell.isCovered() ) {
          // check for Covered, Unflagged state
          if ( !cell.isFlagged() && ( mineFlagCount > 0 ) ) {
            // Place a flag as long as there are still mines
            // left to discover
            cell.makeFlagged( true );
            mineFlagCount--;
            minesLeftLabel.setText( "Mines Remaining: "
                                    + mineFlagCount );
          }
          else { // Covered, Flagged State; remove the flag
            // and increment the mine count
            cell.makeFlagged( false );
            if ( mineFlagCount < 20 ) {
              mineFlagCount++;
            }
            minesLeftLabel.setText( "Mines Remaining: "
                                    + mineFlagCount );
          }
        }
      }
      else { // LEFT mouse-button was released
        // Has the button been uncovered?
        if ( cell.isCovered() ) {
          // Cell is in (Covered, Flagged) or
          // (Covered, Unflagged) State. If there is a clue,
          //  uncover the cell, then display the clue
          if ( cell.clue() != EMPTY_CELL &&
               cell.clue() != MINE_CELL ) {
            cell.setText( "" + cell.clue() );
            cell.makeUncovered(); // move to Uncovered State
            uncoveredCells++;
          }
          else
          // if there is no clue then begin the recursive
          // uncovering of minefield cells
          if ( cell.clue() == EMPTY_CELL ) {
            uncover( cell.row(), cell.col() );
          }
          else {
            // You lose
            revealGrid();
            uncoveredCells = -100;
            minesLeftLabel.setText( "Y O U  L O S E !" );
          }
        }
      }
      if ( numberOfMines == totalNumberOfCells - uncoveredCells ) {
        minesLeftLabel.setText( "Y O U  W I N !" );
      }
    }
  } // End of MineFieldCellEventHandler event handler class
} // End of Minesweeper class
