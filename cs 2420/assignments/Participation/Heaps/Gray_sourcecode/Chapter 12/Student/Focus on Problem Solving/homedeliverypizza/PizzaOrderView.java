package homedeliverypizza;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: Home Delivery Pizza System: Solution to Focus on
 * Problem Solving Section for Chapter 12.
 */
public class PizzaOrderView extends JFrame implements ActionListener,
    ItemListener {

  private boolean traceOn = true;
  private static final int SEARCH_STATE = 0;
  private static final int CUSTOMER_FOUND_STATE = 1;
  private static final int CUSTOMER_NOT_FOUND_STATE = 2;
  private static final int ORDER_STARTED_STATE = 3;
  private static final int ORDER_FINISHED_STATE = 4;
  private static final int ORDER_SUBMITTED_STATE = 5;

  private static final int LARGE_SIZE_PIZZA = 2;

  // vars used by a number of methods as the order is filled
  private Customer customer = null;
  private HomeDeliveryPizzaOrder order = null;

  private PizzaOrderModel pizzaGuy = new PizzaOrderModel();

  // need to distinguish between new and existing customers to
  // know if the customer information entered should be put
  // to the model
  private boolean newCustomer = false;

  // Now for all the GUI stuff
  // for the Phone Panel
  private JButton phoneButton = new JButton( "Search Phone #" );
  private JTextField phoneField = new JTextField( 12 );

  // for the Customer Information Panel
  private JLabel nameLabel = new JLabel( "Name" );
  private JTextField nameField = new JTextField( 12 );
  private JLabel addressLabel = new JLabel( "Address" );
  private JTextField addressField = new JTextField( 12 );
  private JLabel instructionsLabel
      = new JLabel( "Instructions" );
  private JTextField instructionsField = new JTextField( 12 );
  private JButton updateButton
      = new JButton( "Update Customer Info" );

  // for the Toppings and Size Panels within the Order Panel
  // Note: the size of the JCheckBox arrays must match the size
  //  of the String arrays (below) that hold the labels for
  //  the JCheckBoxes
  private JCheckBox[] meatToppingBoxes = new JCheckBox[4];
  private JCheckBox[] veggieToppingBoxes = new JCheckBox[4];
  private JRadioButton[] pizzaSizeButtons = new JRadioButton[3];
  private ButtonGroup sizesGroup = new ButtonGroup();
  private JButton addToOrderButton =
      new JButton( "Add pizza to this order" );
  private JButton totalTheOrderButton =
      new JButton( "Total this order" );

  // size of these arrays must match their corresponding
  // JCheckBox and JRadioButton arrays
  private String[] meatToppings = {
      "Anchovies", "Pepperoni",
      "Sausage", "Italian Sausage"};
  private String[] veggieToppings = {
      "Black Olives", "Mushrooms",
      "Onions", "Roasted Peppers"};
  private String[] pizzaSizes = {
      "Small", "Medium", "Large"};

  private JTextArea orderSummaryField = new JTextArea( 5, 28 );
  private JButton submitButton = new JButton( "Submit" );
  private JButton clearButton = new JButton( "Clear" );
  private JTextArea employeeInstructionsField =
      new JTextArea( 4, 25 );

  public PizzaOrderView( String title ) {
    // first we do all the GUI-related stuff
    super( title );

    Container mainPanel = this.getContentPane();
    mainPanel.setLayout(
        new BoxLayout( mainPanel, BoxLayout.Y_AXIS ) );

    // From the top of the GUI to the bottom, create the panels
    // that make up the GUI and add them to the mainPanel.
    // The Phone Number Panel:

    mainPanel.add( initPhonePanel() );
    mainPanel.add( initCustomerInfoPanel() );
    mainPanel.add( initOrderPanel() );
    mainPanel.add( initOrderSummaryPanel() );
    mainPanel.add( initFinishUpPanel() );
    mainPanel.add( initInstructionsPanel() );

    // add a listener for when the user clicks on the X to
    //  close the window
    addWindowListener( new CloseWindow() );
  }

  private JPanel initPhonePanel() {
    JPanel phonePanel = new JPanel();
    phonePanel.setLayout( new GridLayout( 1, 2, 8, 0 ) );
    phonePanel.setBorder(
        BorderFactory.createTitledBorder( "Customer Phone Number" ) );
    phonePanel.add( phoneButton );
    phonePanel.add( phoneField );
    phoneButton.addActionListener( this );
    phoneField.addActionListener( this );
    return phonePanel;
  }

  private JPanel initCustomerInfoPanel() {
    // the Customer Information Panel
    JPanel customerPanel = new JPanel();
    customerPanel.setLayout(
        new BoxLayout( customerPanel, BoxLayout.Y_AXIS ) );
    customerPanel.setBorder(
        BorderFactory.createTitledBorder( "Customer Details" ) );
    JPanel namePanel = new JPanel(); // the customer's name
    namePanel.setLayout( new GridLayout( 1, 2, 8, 0 ) );
    nameLabel.setHorizontalAlignment( JLabel.CENTER );
    namePanel.add( nameLabel );
    namePanel.add( nameField );
    customerPanel.add( namePanel );
    JPanel addressPanel = new JPanel(); // the customer's address
    addressPanel.setLayout( new GridLayout( 1, 2, 8, 0 ) );
    addressLabel.setHorizontalAlignment( JLabel.CENTER );
    addressPanel.add( addressLabel );
    addressPanel.add( addressField );
    customerPanel.add( addressPanel );

    // instructions from the customer
    JPanel instructionsPanel = new JPanel();
    instructionsPanel.setLayout( new GridLayout( 1, 2, 8, 0 ) );
    instructionsLabel.setHorizontalAlignment( JLabel.CENTER );
    instructionsPanel.add( instructionsLabel );
    instructionsPanel.add( instructionsField );
    customerPanel.add( instructionsPanel );
    customerPanel.add( updateButton );
    updateButton.addActionListener( this );
    return customerPanel;
  }

  private JPanel initOrderPanel() {
    // The pizza order panel:
    JPanel orderPanel = new JPanel();
    orderPanel.setLayout(
        new BoxLayout( orderPanel, BoxLayout.Y_AXIS ) );
    orderPanel.setBorder(
        BorderFactory.createTitledBorder( "Pizza Orders" ) );

    JPanel toppingsPanel = new JPanel();
    toppingsPanel.setLayout(
        new BoxLayout( toppingsPanel, BoxLayout.X_AXIS ) );
    toppingsPanel.add( initMeatToppingsPanel() );
    toppingsPanel.add( initVeggieToppingsPanel() );

    orderPanel.add( toppingsPanel );
    orderPanel.add( initPizzaSizesPanel() );

    JPanel orderButtonsPanel = new JPanel();
    addToOrderButton.setBorder(
        BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
    orderButtonsPanel.add( addToOrderButton );
    totalTheOrderButton.setBorder(
        BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
    orderButtonsPanel.add( totalTheOrderButton );
    orderPanel.add( orderButtonsPanel );
    addToOrderButton.addActionListener( this );
    totalTheOrderButton.addActionListener( this );

    return orderPanel;
  }

  private JPanel initMeatToppingsPanel() {
    JPanel meatToppingsPanel = new JPanel();
    meatToppingsPanel.setSize( 150, 50 );
    meatToppingsPanel.setBorder(
        BorderFactory.createTitledBorder( " Meat toppings: " ) );
    meatToppingsPanel.setLayout(
        new BoxLayout( meatToppingsPanel, BoxLayout.Y_AXIS ) );

    for ( int i = 0; i < this.meatToppingBoxes.length; i++ ) {
      meatToppingBoxes[i] = new JCheckBox( meatToppings[i] );
      meatToppingBoxes[i].addItemListener( this );
      meatToppingsPanel.add( meatToppingBoxes[i] );
    }
    return meatToppingsPanel;
  }

  private JPanel initVeggieToppingsPanel() {
    JPanel veggieToppingsPanel = new JPanel();
    veggieToppingsPanel.setSize( 150, 50 );
    veggieToppingsPanel.setBorder(
        BorderFactory.createTitledBorder( " Veggie toppings: " ) );
    veggieToppingsPanel.setLayout(
        new BoxLayout( veggieToppingsPanel, BoxLayout.Y_AXIS ) );

    for ( int i = 0; i < this.veggieToppingBoxes.length; i++ ) {
      veggieToppingBoxes[i] = new JCheckBox( veggieToppings[i] );
      veggieToppingBoxes[i].addItemListener( this );
      veggieToppingsPanel.add( veggieToppingBoxes[i] );
    }
    return veggieToppingsPanel;
  }

  private JPanel initPizzaSizesPanel() {
    JPanel pizzaSizesPanel = new JPanel();
    pizzaSizesPanel.setBorder( BorderFactory.createTitledBorder(
        " Pizza sizes: " ) );
    for ( int i = 0; i < pizzaSizeButtons.length; i++ ) {
      pizzaSizeButtons[i] = new JRadioButton( pizzaSizes[i] );
      pizzaSizeButtons[i].addItemListener( this );
      pizzaSizesPanel.add( pizzaSizeButtons[i] );
      sizesGroup.add( pizzaSizeButtons[i] );
    }
    // make the "Large" button the default selected button
    pizzaSizeButtons[LARGE_SIZE_PIZZA].setSelected( true );
    return pizzaSizesPanel;
  }

  private JPanel initOrderSummaryPanel() {
    JPanel orderSummaryPanel = new JPanel();
    orderSummaryPanel.setBorder( BorderFactory.createTitledBorder(
        " Order Summary: " ) );
    orderSummaryField.setLineWrap( true );
    orderSummaryField.setEditable( false );
    orderSummaryField.setWrapStyleWord( true );
    JScrollPane summaryScrollPane = new JScrollPane( orderSummaryField );
    summaryScrollPane.setHorizontalScrollBarPolicy( JScrollPane.
        HORIZONTAL_SCROLLBAR_ALWAYS );
    summaryScrollPane.setVerticalScrollBarPolicy( JScrollPane.
                                                  VERTICAL_SCROLLBAR_ALWAYS );
    summaryScrollPane.setSize( new Dimension( 20, 50 ) );
    orderSummaryPanel.add( summaryScrollPane );
    return orderSummaryPanel;
  }

  private JPanel initFinishUpPanel() {
    JPanel finishUpPanel = new JPanel();
    finishUpPanel.setBorder( BorderFactory.createTitledBorder(
        " Finish the order: " ) );
    finishUpPanel.setLayout( new GridLayout( 1, 2, 8, 0 ) );
    finishUpPanel.add( submitButton );
    finishUpPanel.add( clearButton );
    submitButton.addActionListener( this );
    clearButton.addActionListener( this );
    return finishUpPanel;
  }

  private JPanel initInstructionsPanel() {
    JPanel instructionsPanel = new JPanel();
    instructionsPanel.setBorder( BorderFactory.createTitledBorder(
        " Employee Instructions: " ) );
    employeeInstructionsField.setEditable( false );
    employeeInstructionsField.setLineWrap( true );
    employeeInstructionsField.setWrapStyleWord( true );
    JScrollPane scrollPane = new JScrollPane( employeeInstructionsField );
    instructionsPanel.add( scrollPane );
    return instructionsPanel;
  }

  public void itemStateChanged( ItemEvent e ) {

  }

  /**
   * Cycle through all the toppings, setting/clearing them in the pizza order.
   * @param pizza - the pizza to add the toppings to; cannot be null (not checked)
   */
  private void addToppings( Pizza pizza ) {
    JCheckBox toppingButton;
    String toppingText;

    for ( int i = 0; i < this.meatToppingBoxes.length; i++ ) {
      toppingButton = meatToppingBoxes[i];
      toppingText = toppingButton.getText();

      if ( toppingText.equals( "Anchovies" ) ) {
        pizza.setAnchovies( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Pepperoni" ) ) {
        pizza.setPepperoni( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Sausage" ) ) {
        pizza.setSausage( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Italian Sausage" ) ) {
        pizza.setItalianSausage( toppingButton.isSelected() );
      }
    }
    // now do the veggie toppings
    for ( int i = 0; i < this.veggieToppingBoxes.length; i++ ) {
      toppingButton = veggieToppingBoxes[i];
      toppingText = toppingButton.getText();

      if ( toppingText.equals( "Black Olives" ) ) {
        pizza.setBlackOlives( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Mushrooms" ) ) {
        pizza.setMushrooms( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Onions" ) ) {
        pizza.setOnions( toppingButton.isSelected() );
      }
      else if ( toppingText.equals( "Roasted Peppers" ) ) {
        pizza.setRoastedPeppers( toppingButton.isSelected() );
      }
    }
  }

  /**
   * Cycle through all the sizes, set the chosen one in the pizza order.
   * @param pizza - the pizza to set the size for; cannot be null (not checked)
   */
  private void addSize( Pizza pizza ) {
    JRadioButton sizeButton;
    String sizeText;
    // only one of the buttons is set; stop looking when we find it
    for ( int i = 0; i < this.pizzaSizeButtons.length; i++ ) {
      sizeButton = pizzaSizeButtons[i];
      sizeText = sizeButton.getText();
      if ( traceOn ) {
        System.out.println( "addSize(): size is " + sizeText );
      }
      if ( sizeButton.isSelected() ) {
        if ( sizeText.equals( "Small" ) ) {
          pizza.setSize( Pizza.SMALL );
        }
        else if ( sizeText.equals( "Medium" ) ) {
          pizza.setSize( Pizza.MEDIUM );
        }
        else {
          pizza.setSize( Pizza.LARGE );
        }
        return;
      }
    }
  }

  private void resetOrderPanel() {
    for ( int i = 0; i < this.meatToppingBoxes.length; i++ ) {
      meatToppingBoxes[i].setSelected( false );
    }
    for ( int i = 0; i < this.veggieToppingBoxes.length; i++ ) {
      veggieToppingBoxes[i].setSelected( false );
    }
    pizzaSizeButtons[LARGE_SIZE_PIZZA].setSelected( true );

  }

  public void actionPerformed( ActionEvent e ) {
    // Search State
    if ( ( e.getSource() == phoneButton ) || ( e.getSource() == phoneField ) ) {
      if ( traceOn ) {
        System.out.println( "phone button or text field pressed" );
      }
      String phoneNumber = phoneField.getText().trim();
      if ( phoneNumber.length() == 0 ) {
        return; // stay in SEARCH State
      }
      customer = pizzaGuy.find( phoneNumber );
      if ( customer == null ) {
        gotoState( CUSTOMER_NOT_FOUND_STATE );
        return;
      }
      else {
        gotoState( CUSTOMER_FOUND_STATE );
        return;
      }
    }
    else if ( e.getSource() == updateButton ) {
      this.customer.setName( nameField.getText() );
      this.customer.setAddress( addressField.getText() );
      this.customer.setInstructions( instructionsField.getText() );

      // if the customer isn't new, we have a Customer object from
      // the model and will just change the fields in it. Otherwise,
      // we have to add the new Customer to the model's customer database.
      if ( newCustomer ) {
        this.customer.setPhoneNumber( phoneField.getText() );
        this.pizzaGuy.add( customer );
        this.newCustomer = false;
        gotoState( CUSTOMER_FOUND_STATE ); // only change state if this was a new customer
      }
    }
    else if ( e.getSource() == addToOrderButton ) {
      Pizza pizza = new Pizza();
      addToppings( pizza );
      addSize( pizza );
      order.add( pizza );
      resetOrderPanel();
      this.orderSummaryField.append( pizza.toString() + "\n\n" );
      gotoState( ORDER_STARTED_STATE );
    }
    else if ( e.getSource() == totalTheOrderButton ) {
      this.orderSummaryField.append( "\nCost: $" + ( order.cost() / 100 )
                                     + "." + order.cost() % 100 );
      gotoState( this.ORDER_FINISHED_STATE );
    }
    else if ( e.getSource() == submitButton ) {
      this.orderSummaryField.append( "\nOrder submitted at " +
                                     order.timeOrdered() );
      resetOrderPanel();
      gotoState( this.ORDER_SUBMITTED_STATE );
    }
    else if ( e.getSource() == submitButton ) {
      gotoState( this.SEARCH_STATE );
    }
    else if ( e.getSource() == clearButton ) {
      gotoState( this.SEARCH_STATE );
    }
  }

  private void gotoState( int state ) {
    switch ( state ) {
      case SEARCH_STATE:
        customer = null;
        order = null;
        newCustomer = false;
        phoneButton.setEnabled( true );
        updateButton.setEnabled( false );
        addToOrderButton.setEnabled( false );
        totalTheOrderButton.setEnabled( false );
        submitButton.setEnabled( false );
        phoneField.setText( "" );
        nameField.setText( "" );
        addressField.setText( "" );
        instructionsField.setText( "" );
        orderSummaryField.setText( "" );
        resetOrderPanel();
        employeeInstructionsField.setText(
            "Enter the customer's phone number." );
        this.phoneField.requestFocus();
        break;
      case CUSTOMER_FOUND_STATE:

        // only create an order when we know we
        // have a customer
        order = new HomeDeliveryPizzaOrder( customer );
        phoneButton.setEnabled( false );
        updateButton.setEnabled( true );
        addToOrderButton.setEnabled( true );
        nameField.setText( customer.name() );
        addressField.setText( customer.address() );
        instructionsField.setText(
            customer.instructions() );
        newCustomer = false;
        employeeInstructionsField.setText( "Take a" +
                                           " pizza order and press the" +
                                           " \"Add pizza to order\" button to add it" +
                                           " to the current order." );
        break;
      case CUSTOMER_NOT_FOUND_STATE:
        phoneButton.setEnabled( false );
        updateButton.setEnabled( true );
        customer = new Customer();
        newCustomer = true;
        employeeInstructionsField.setText( "Enter " +
                                           "customer information then press the " +
                                           " Update button before taking an order." );
        break;
      case ORDER_STARTED_STATE:
        totalTheOrderButton.setEnabled( true );
        employeeInstructionsField.setText( "Press " +
                                           "the Total button when the order is complete." );
        break;
      case ORDER_FINISHED_STATE:
        totalTheOrderButton.setEnabled( false );
        addToOrderButton.setEnabled( false );
        submitButton.setEnabled( true );
        employeeInstructionsField.setText( "Confirm " +
                                           "the order with the customer.\nThen press" +
                                           " the Submit button to submit the order." );
        break;
      case ORDER_SUBMITTED_STATE:
        pizzaGuy.add( order );
        submitButton.setEnabled( false );
        employeeInstructionsField.setText(
            "Order submitted.\n Press the Clear" +
            " button for the next customer." );
        break;
    }
  }

  // inner class to handle closing the window via the Close
  //  or X options
  class CloseWindow extends WindowAdapter {
    public void windowClosing( WindowEvent event ) {
      pizzaGuy.shutdown();
      System.exit( 0 );
    }
  }

  public static void main( String[] args ) {
    PizzaOrderView pizzaOrderSystem =
        new PizzaOrderView( "Home Delivery " +
                            "Pizza Ordering System" );
    pizzaOrderSystem.setSize( 340, 720 );
    // get us started in the correct state
    pizzaOrderSystem.gotoState( SEARCH_STATE );
    pizzaOrderSystem.setVisible( true ); // now we are ready!
  }

}
