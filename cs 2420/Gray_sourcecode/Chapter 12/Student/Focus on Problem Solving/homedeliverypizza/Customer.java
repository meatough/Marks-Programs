package homedeliverypizza;

/**
 * Home Delivery Pizza System: Solution to Focus on Problem
 * Solving Section for Chapter 12.</p>
 * This class stores information about a single customer.
 */
public class Customer implements java.io.Serializable {
  private String name = null;
  private String phoneNumber = null;
  private String address = null;
  private String instructions = null;

  /**
   * Constructor - create an empty customer. It is assumed that the creator
   * will eventually fill in the obligatory <code>name</code>,
   * <code>phoneNumber</code> and <code>address</code> fields.
   */
  public Customer() {
    name = null;
    phoneNumber = null;
    address = null;
    instructions = null;
  }

  /**
   * Constructor - <code>theName</code>, <code>thePhoneNumber</code>, and
   * <code>theAddress</code> cannot be null or empty.
   * @param <code>theName</code> the customer's name (first and last)
   * @param <code>thePhoneNumber</code> the customer's phone number
   * @param <code>theAddress</code> the customer's delivery address
   * @param <code>theComments</code> any comments from or about this customer
   * @throws <code>IllegalArgumentException</code> if <code>theName</code>,
   * <code>thePhoneNumber</code>, or <code>theAddress</code> is null or empty.
   */
  public Customer( String theName, String thePhoneNumber,
                   String theAddress, String theInstructions ) {
    setName( theName );
    setAddress( theAddress );
    setPhoneNumber( thePhoneNumber );
    this.instructions = theInstructions;
  }

  /**
   * Set the name for this customer.
   * @param <code>theName</code> the customer's name (first and last)
   * @throws <code>IllegalArgumentException</code> if <code>theName</code>
   *  is null or empty.
   */
  public void setName( String theName ) {
    if ( ( theName == null ) ) {
      throw new IllegalArgumentException();
    }
    this.name = theName.trim();
    if ( this.name.equals( "" ) ) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Set the delivery address for this customer.
   * @param <code>theAddress</code> the customer's delivery address
   * @throws <code>IllegalArgumentException</code> if <code>theAddress</code>
   *  is null or empty.
   */
  public void setAddress( String theAddress ) {
    if ( ( theAddress == null ) ) {
      throw new IllegalArgumentException();
    }
    this.address = theAddress.trim();
    if ( this.address.equals( "" ) ) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Set the phone number for this customer.
   * @param <code>thePhoneNumber</code> the customer's phone number
   * @throws <code>IllegalArgumentException</code> if <code>thePhoneNumber</code>
   *  is null or empty.
   */
  public void setPhoneNumber( String thePhoneNumber ) {
    if ( ( thePhoneNumber == null ) ) {
      throw new IllegalArgumentException();
    }
    this.phoneNumber = thePhoneNumber.trim();
    if ( this.phoneNumber.equals( "" ) ) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Set the instructions for this customer.
   * @param <code>theInstructions</code> the delivery instructions for this customer.
   * This value may be null or empty.
   */
  public void setInstructions( String theInstructions ) {
    this.instructions = theInstructions;
  }

  /**
   * Return this customer's name.
   */
  public String name() {
    return this.name;
  }

  /**
   * Return this customer's address.
   */
  public String address() {
    return this.address;
  }

  /**
   * Return this customer's phone number.
   */
  public String phoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Return comments about deliveries to this customer.
   */
  public String instructions() {
    return this.instructions;
  }

  /**
   * Overridden method from <code>Object</Code>.
   * @return A <code>String</code> version of this customer
   */
  public String toString() {
    return this.name + "\n" + this.address + "\n" +
        ( ( this.instructions == null ) ? "" : this.instructions );
  }

}
