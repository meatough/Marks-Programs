package courier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * CourierView provides the GUI frontend to the application. All data
 * is stored separately in CourierModel.
 *
 * Solution to the Focus on Problem Solving section from Chapter 3.
 */
public class CourierView extends JFrame implements
                            ActionListener, ListSelectionListener {

    private CourierModel courierModel;

    // the buttons for the main window
     private JButton addButton    = new JButton("Add");
     private JButton removeButton = new JButton("Remove");
     private JButton moveButton   = new JButton("Move");

     private JMenuItem exitMenuItem = new JMenuItem( "Exit" );

    // labels, list and text boxes for the main window
    private JLabel deliveryListLabel    = new JLabel("Delivery List");
    private JLabel deliveryDetailsLabel = new JLabel("Delivery Details");

    private DefaultListModel slipList = new DefaultListModel();
    private JList slips = new JList();
    private JScrollPane deliveryListField  = new JScrollPane( slips );
    private int selectedIndex;      // index of item selected in slips/slipList
    private JTextArea deliveryDetailsField = new JTextArea(9, 18);

    public CourierView( String title ) {
        super( title );

        courierModel = new CourierModel();
        // associate the slipList model with the JList object
        slips.setModel( slipList );
        slips.setVisibleRowCount( 9 );

        // Create the File menu bar entry, add items to it,
        // then add the menu to the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar( menuBar );
        JMenu fileMenu = new JMenu("File");
        fileMenu.add( exitMenuItem );
        menuBar.add( fileMenu );

        // attach each File menu item to our action listener
        //   (see method actionPerformed() in this class)
        exitMenuItem.addActionListener( this );


        // Create the panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout( 6, 1, 5, 5 ) );
        buttonPanel.add( new JLabel( " " ) );    // panel spacer
        buttonPanel.add( addButton );
        buttonPanel.add( new JLabel( " " ) );    // panel spacer
        buttonPanel.add( removeButton );
        buttonPanel.add( new JLabel( " " ) );    // panel spacer
        buttonPanel.add( moveButton );
        removeButton.setEnabled( false );
        moveButton.setEnabled( false );

        // make this object the listener for each button
        //   (see method actionPerformed() in this class)
        addButton.addActionListener( this );
        removeButton.addActionListener( this );
        moveButton.addActionListener( this );

        // build the panel that will store the label and text field for the
        // the Slip List information
        JPanel slipListPanel = new JPanel();
        slipListPanel.setLayout( new BoxLayout( slipListPanel, BoxLayout.Y_AXIS ) );
        slipListPanel.add( deliveryListLabel );
        slipListPanel.add( deliveryListField );
        // build the panel that will store the label and text field for the
        // the Slip Detail information
        JPanel slipDetailsPanel = new JPanel();
        slipDetailsPanel.setLayout( new BoxLayout( slipDetailsPanel, BoxLayout.Y_AXIS ) );
        slipDetailsPanel.add( deliveryDetailsLabel );
        slipDetailsPanel.add( deliveryDetailsField );

        deliveryDetailsField.setEditable( false );
        deliveryDetailsField.setText("");  // clear the Details text field

        // get the main content pane and add the button, list and details panels to it
        Container pane = getContentPane();
        pane.setLayout( new GridLayout( 1, 3, 15, 5 ) );
        pane.add( buttonPanel );
        pane.add( slipListPanel );
        pane.add( slipDetailsPanel );

        // add a listener for when the user clicks on the X to close the window
        addWindowListener( new CloseWindow() );

        // complete initialization of the JList object
        slips.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        slips.addListSelectionListener( this ); // see valueChanged() below
        selectedIndex = -1;   // no entries yet to select the Slip List field
        deliveryDetailsField.setText("");  // clear the Details text field
    }

    /**
     * The ListSelectionListener method
     * This method is automatically called when an entry from JList is selected
     * with a mouse or arrow key. Determine the index of the selected item and
     * have its details highlight in the Details Field.
     */
    public void valueChanged( ListSelectionEvent e ){
      selectedIndex = ((JList)e.getSource()).getSelectedIndex();
      displayCurrentSlip();
    }

    // Update the Slip List field and the Details text field with the
    //  currently selected slip
    private void displayCurrentSlip(){
        selectedIndex = slips.getSelectedIndex();
        getContentPane().invalidate();
        getContentPane().validate();

        if ( selectedIndex == -1 )
          selectedIndex = 0;

        if ( slipList.size() > 0 ) {    // bounds check
            slips.setSelectedIndex( selectedIndex );
            slips.ensureIndexIsVisible( selectedIndex );
            deliveryDetailsField.setText( courierModel.getSlip( selectedIndex ).toString() );
        }
        else    // nothing to display, so clear the detail field
            deliveryDetailsField.setText("");
    }

    /**
     * ActionListener method for the buttons on the main panel.
     * @param event the object (button) that generated the event
     */
    public void actionPerformed( ActionEvent event ) {
        Object eventSrc = event.getSource();      // get a reference to the selected button

        if ( eventSrc == addButton ) {
             addSlip();
        }
        else if ( eventSrc == removeButton ) {
             removeSlip();
        }
        else if ( eventSrc == moveButton ) {
             moveSlips();
        }
        else if ( eventSrc == exitMenuItem ) {
             System.exit(0);
        }

        int size = slipList.size();
        if ( size == 0 ) {
            removeButton.setEnabled( false );
        }
        else if ( size == 1 ) {
            removeButton.setEnabled(true);
            moveButton.setEnabled(false);
        }
        else {
            removeButton.setEnabled( true );
            moveButton.setEnabled( true );
        }

        // update the view
        displayCurrentSlip();
    }

    // inner class to handle closing the window via the X option
    class CloseWindow extends WindowAdapter {
        public void windowClosing( WindowEvent event ) {
            System.exit(0);
        }
    }

    // Move the currently selected slip to another position in the slip list
    private void moveSlips(){
        int destIndex = -1;
        int srcIndex = selectedIndex;
        // create an InputDialog box to ask for the new priority
        String slipToMove = courierModel.getSlip( srcIndex ).toString();
        String newPriority = JOptionPane.showInputDialog(this, slipToMove
               + "\nCurrent Priority: " + srcIndex + "\n\nEnter new priority: ");

        //  if the user didn't cancelled the dialog box, process the new priority
        if ( newPriority != null )  {
           try {
               destIndex = Integer.parseInt( new String( newPriority ) );
           }
           catch ( NumberFormatException e ) {
                 JOptionPane.showMessageDialog(this, "Priority given (" + newPriority + ") is not a number",
                                                   "Move Error Message", JOptionPane.ERROR_MESSAGE);
                 return;
           }
           // do a bounds check on the new priority - reject invalid priority
           if ( ( destIndex > slipList.size() - 1 ) || ( destIndex < 0 ) ){
                 JOptionPane.showMessageDialog(this,
                    "New priority must be in the range 0 to " + ( slipList.size() - 1 ),
                    "Move Message", JOptionPane.ERROR_MESSAGE);
                 return;
           }

           // everything checks out, so move the selected slip to its new position
           CourierSlip slip = courierModel.getSlip( srcIndex );
           slipList.remove( srcIndex );
           courierModel.deleteSlip( srcIndex );
           slipList.add( destIndex, slip.getSource() );
           courierModel.addSlip( destIndex, slip );
           selectedIndex = destIndex;
       }
    }

    // add a new slip to the model and the view
    private void addSlip() {
        // create a SlipDialog box to get the new slip information
        CourierSlip slip = new CourierSlip();
        StringBuffer priority =  new StringBuffer("");

        new SlipDialog( slip, priority );

        if ( priority.toString().equals( "Cancelled" ) )
             return;

        int pos = -1;
        try {
            pos = Integer.parseInt( new String( priority ) );
        }
        catch ( NumberFormatException e ) {
            JOptionPane.showMessageDialog(this, "Priority given (" + pos + ") is not a number",
                "Add Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // do a bounds check on the priority - reject invalid priority
        if ( ( pos > slipList.size() ) || ( pos < 0 ) ){
           JOptionPane.showMessageDialog(this,
                    "Priority must be in the range 0 to " + slipList.size(),
                    "Add Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // everything checks out - add the slip to the model and view
        courierModel.addSlip( pos, slip );
        slipList.add( pos, slip.getSource() );
        selectedIndex = pos;
    }

    // remove the selected slip from the model and the view
    private void removeSlip() {
        courierModel.deleteSlip( selectedIndex );
        slipList.removeElementAt( selectedIndex );

        // update selectedIndex: there are three special cases to check for
        int size = slipList.size();
        if ( size == 0 ) selectedIndex = -1;
        else if ( size == 1 ) selectedIndex = 0;
        else if ( selectedIndex == size ) selectedIndex--;
    }

   public static void main(String[] args) {
        CourierView courierView = new CourierView( "Courier View" );
        courierView.setSize(350, 250);
        courierView.setVisible( true );
    }
}
