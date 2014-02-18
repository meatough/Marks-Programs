package homedeliverypizza;

import java.io.*;
import gray.adts.map.*;
import gray.adts.queue.*;

/**
 * Home Delivery Pizza System: Solution to Focus on
 * Problem Solving Section for Chapter 12.
 */
public class PizzaOrderModel {
  private Map<String, Customer> customerDB;
  private Queue<HomeDeliveryPizzaOrder> orders;
  private boolean customerDBModified;
  private String customerDBfilename =
      new String( "customers.dat" );

  /**
   * Constructor - initialize the model to handle orders.
   */
  public PizzaOrderModel() {
    customerDB = new HashMap<String, Customer> ();
    loadCustomerDB( customerDBfilename );

    this.orders = new ListQueue<HomeDeliveryPizzaOrder> ();
    this.customerDBModified = false;
  }

  /**
   * Add an <code>Order</code> for a home delivery.
   * @param <code>theOrder</Code> the <code>Order</code> to add
   * to the queue of orders; cannot be <code>null</code>
   * @throws <code>IllegalArgumentException</code> if
   * <code>theOrder</code> is <code>null</code>
   */
  public void add( HomeDeliveryPizzaOrder theOrder ) {
    if ( theOrder == null ) {
      throw new IllegalArgumentException();
    }
    orders.enqueue( theOrder );
  }

  /**
   * Add a <code>Customer</code> to the customer database.
   * @param  <code>theCustomer</code> the customer to add;
   * can't be <code>null</code>
   * @throws <code>IllegalArgumentException</code> if
   * <code>Customer</code> is <code>null</code>
   */
  public void add( Customer theCustomer ) {
    if ( theCustomer == null ) {
      throw new IllegalArgumentException();
    }
    this.customerDB.put( theCustomer.phoneNumber(),
                         theCustomer );
    this.customerDBModified = true;
  }

  /**
   * Find a customer profile in the customer database given a
   *  telephone number.
   * @param <code>phoneNumber</code> the phone number of the customer
   * @return <code>Customer</Code> a customer if
   * <code>phoneNumber</code> is found in the database, <code>null</code>
   * otherwise
   * @throws <code>IllegalArgumentException</code> if
   * <code>phoneNumber</code> is <code>null</code>
   */
  public Customer find( String phoneNumber ) {
    if ( phoneNumber == null ) {
      throw new IllegalArgumentException();
    }
    return ( Customer ) customerDB.get( phoneNumber );
  }

  /**
   * Shutdown the model. This gives the model a chance to save
   *  the customer database if it was modified.
   */
  public void shutdown() {
    if ( this.customerDBModified ) {
      saveCustomerDB( customerDBfilename );
    }
  }

  private void loadCustomerDB( String filename ) {

    try {
      FileInputStream fiStream =
          new FileInputStream( filename );
      ObjectInputStream oiStream =
          new ObjectInputStream( fiStream );
      this.customerDB =
          ( HashMap<String, Customer> ) ( oiStream.readObject() );
      oiStream.close();
    }
    catch ( FileNotFoundException fnfe ) {
      this.customerDB = new HashMap<String, Customer> ();
    }
    catch ( Exception e ) {
      System.out.println( "Error during input: " +
                          e.toString() );
    }
  }

  private void saveCustomerDB( String filename ) {
    try {
      FileOutputStream foStream =
          new FileOutputStream( filename );
      ObjectOutputStream ooStream =
          new ObjectOutputStream( foStream );
      ooStream.writeObject( this.customerDB );
      ooStream.flush();
      ooStream.close();
    }
    catch ( Exception e ) {
      System.out.println( "Error during output: " +
                          e.toString() );
    }
  }
}
