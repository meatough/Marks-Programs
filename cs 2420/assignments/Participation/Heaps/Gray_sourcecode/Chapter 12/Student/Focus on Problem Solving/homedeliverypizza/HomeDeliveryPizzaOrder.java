package homedeliverypizza;

import java.util.List;
import java.util.ArrayList;

/**
 * Home Delivery Pizza System: Solution to Focus on Problem
 * Solving Section for Chapter 12.
 * <P>A home delivery order.</p>
 */
public class HomeDeliveryPizzaOrder {
  private Customer customer;
  private List<Pizza> pizzas;
  private java.util.Date timeOrdered;

  /**
   * Constructor - create an instance of a home delivery pizza
   * order for this customer and timestamp the order with the
   * current time. The pizzas will be added later.
   * @param <tt>theCustomer</tt> the customer who placed this
   *          order; cannot be null
   * @throws <tt>IllegalArgumentException</tt> if <tt>theCustomer</tt>
   *  is null
   */
  public HomeDeliveryPizzaOrder( Customer theCustomer ) {
    if ( theCustomer == null ) {
      throw new IllegalArgumentException();
    }

    this.customer = theCustomer;
    this.pizzas = new ArrayList<Pizza> ();
    this.timeOrdered = new java.util.Date();
  }

  /**
   * Constructor - create an instance of a home delivery pizza
   * order and timestamp it with the current time
   * @param <tt>theCustomer</tt> the customer who placed this
   *  order; cannot be null
   * @param <tt>thePizzas</tt> the pizzas this customer ordered;
   *  cannot be null and
   * length must be 1 or more
   * @throws <tt>IllegalArgumentException</tt> if either argument
   *  is null or if
   * the <tt>thePizzas</tt> is empty.
   */
  public HomeDeliveryPizzaOrder( Customer theCustomer,
                                 List<Pizza> thePizzas ) {
    if ( ( theCustomer == null ) || ( thePizzas == null ) ||
         ( thePizzas.size() < 1 ) ) {
      throw new IllegalArgumentException();
    }

    this.customer = theCustomer;
    this.pizzas = thePizzas;
    this.timeOrdered = new java.util.Date();
  }

  /**
   * Add the pizza to this order.
   * @param <tt>pizza</tt> the pizza to add; cannot be null
   * @throws <tt>NullPointerException</tt> if <tt>pizza</tt>
   * is <tt>null</tt>
   */
  public void add( Pizza pizza ) {
    if ( pizza == null ) {
      throw new NullPointerException();
    }
    this.pizzas.add( pizza );
  }

  /**
   * Return the <tt>Customer</tt> who placed this home
   *  delivery order.
   * @return the <tt>Customer</tt> who placed this order
   */
  public Customer customer() {
    return this.customer;
  }

  /**
   * Return a <tt>List</tt> of the <tt>Pizza</tt>s the
   * <tt>Customer</tt> ordered.
   */
  public List pizzas() {
    return this.pizzas;
  }

  /**
   * Return the time this order was submitted.
   */
  public java.util.Date timeOrdered() {
    return this.timeOrdered;
  }

  /**
   * Return the cost of this order. The cost is returned in
   ** pennies. So $15.40 would be returned as 1540 pennies.
   */
  public int cost() {
    int cost = 0;
    java.util.Iterator iter = pizzas.iterator();
    while ( iter.hasNext() ) {
      cost += ( ( Pizza ) iter.next() ).cost();
    }
    return cost;
  }

  /**
   * Overridden method from <tt>Object</Tt>.
   * @return A <tt>String</tt> version of this pizza
   */
  public String toString() {
    return this.customer.toString();
  }
}
