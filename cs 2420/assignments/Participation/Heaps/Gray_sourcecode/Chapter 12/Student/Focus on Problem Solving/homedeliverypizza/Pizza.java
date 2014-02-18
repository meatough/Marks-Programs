package homedeliverypizza;

/**
 * Home Delivery Pizza System: Solution to Focus on Problem
 * Solving Section for Chapter 12.
 * <P>This class represents a single pizza. An <code>Order</code>
 * can have several pizzas.</P>
 */
public class Pizza {
  /**
   * Pizza sizes and prices
   */
  public static final int SMALL = 300;
  public static final int MEDIUM = 500;
  public static final int LARGE = 600;

  /**
   * All prices are for a small pizza.
   */
  public static final int ANCHOVIE_PRICE = 100;
  public static final int PEPPERONI_PRICE = 100;
  public static final int SAUSAGE_PRICE = 125;
  public static final int ITALIAN_SAUSAGE_PRICE = 125;
  public static final int BLACK_OLIVES_PRICE = 50;
  public static final int MUSHROOMS_PRICE = 50;
  public static final int ONIONS_PRICE = 50;
  public static final int ROASTED_PEPPERS_PRICE = 50;

  private boolean hasAnchovies = false;
  private boolean hasPepperoni = false;
  private boolean hasSausage = false;
  private boolean hasItalianSausage = false;
  private boolean hasBlackOlives = false;
  private boolean hasMushrooms = false;
  private boolean hasOnions = false;
  private boolean hasRoastedPeppers = false;
  private int size = LARGE;

  public Pizza() {
  }

  // ACCESSORS for all the acodeributes
  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasAnchovies() {
    return this.hasAnchovies;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasPepperoni() {
    return this.hasPepperoni;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasSausage() {
    return this.hasSausage;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasItalianSausage() {
    return this.hasItalianSausage;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasBlackOlives() {
    return this.hasBlackOlives;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasMushrooms() {
    return this.hasMushrooms;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasOnions() {
    return this.hasOnions;
  }

  /**
   * Determine if this pizza has this topping.
   * @return <code>true</code> if this topping is on the pizza
   */
  public boolean hasRoastedPeppers() {
    return this.hasRoastedPeppers;
  }

  /**
   * Get the size of this pizza.
   * @return the size of this pizza: <code>SMALL</code>,
   * <code>MEDIUM</code> or <code>LARGE</code>
   */
  public int size() {
    return this.size;
  }

  public int cost() {
    int cost = this.size();

    if ( this.hasAnchovies() ) {
      cost += ANCHOVIE_PRICE;
    }

    if ( this.hasPepperoni() ) {
      cost += PEPPERONI_PRICE;
    }

    if ( this.hasSausage() ) {
      cost += SAUSAGE_PRICE;
    }

    if ( this.hasItalianSausage() ) {
      cost += ITALIAN_SAUSAGE_PRICE;
    }

    if ( this.hasBlackOlives() ) {
      cost += BLACK_OLIVES_PRICE;
    }

    if ( this.hasMushrooms() ) {
      cost += MUSHROOMS_PRICE;
    }

    if ( this.hasOnions() ) {
      cost += ONIONS_PRICE;
    }

    if ( this.hasRoastedPeppers() ) {
      cost += ROASTED_PEPPERS_PRICE;
    }

    return cost;
  }

  // MUTATORS for all the acodeributes
  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setAnchovies( boolean customerSelection ) {
    this.hasAnchovies = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setPepperoni( boolean customerSelection ) {
    this.hasPepperoni = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setSausage( boolean customerSelection ) {
    this.hasSausage = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   ** wants this topping or not
   */
  public void setItalianSausage( boolean customerSelection ) {
    this.hasItalianSausage = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   ** wants this topping or not
   */
  public void setBlackOlives( boolean customerSelection ) {
    this.hasBlackOlives = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setMushrooms( boolean customerSelection ) {
    this.hasMushrooms = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setOnions( boolean customerSelection ) {
    this.hasOnions = customerSelection;
  }

  /**
   * Add/remove this topping to/from the pizza.
   * @param <code>customerSelection</code> whether the customer
   *  wants this topping or not
   */
  public void setRoastedPeppers( boolean customerSelection ) {
    this.hasRoastedPeppers = customerSelection;
  }

  /**
   * Set the size of this pizza. Must be one of
   * <code>Pizza.SMALL</code>, <code>Pizza.MEDIUM</code> or
   * <code>Pizza.LARGE</code>.
   * @param <code>theSize</code> the size of this pizza
   * @throws <code>IllegalArgumentException</code> if the pizza
   *  size is invalid
   */
  public void setSize( int theSize ) {
    if ( ( theSize < Pizza.SMALL ) ||
         ( theSize > Pizza.LARGE ) ) {
      throw new IllegalArgumentException( "Bad pizza size" );
    }
    this.size = theSize;
  }

  /**
   * Overridden method from <code>Object</Tt>.
   * @return A <code>String</code> version of this pizza
   */
  public String toString() {
    StringBuffer thisPizza = new StringBuffer();
    switch ( this.size() ) {
      case Pizza.SMALL:
        thisPizza.append( "Small pizza with: " );
        break;
      case Pizza.MEDIUM:
        thisPizza.append( "Medium pizza with: " );
        break;
      case Pizza.LARGE:
        thisPizza.append( "Large pizza with: " );
        break;
    }

    if ( this.hasAnchovies() ) {
      thisPizza.append( "Anchovies   " );
    }

    if ( this.hasPepperoni() ) {
      thisPizza.append( "Pepperoni  " );
    }

    if ( this.hasSausage() ) {
      thisPizza.append( "Sausage  " );
    }

    if ( this.hasItalianSausage() ) {
      thisPizza.append( "Italian Sausage  " );
    }

    if ( this.hasBlackOlives() ) {
      thisPizza.append( "Black Olives  " );
    }

    if ( this.hasMushrooms() ) {
      thisPizza.append( "Mushrooms  " );
    }

    if ( this.hasOnions() ) {
      thisPizza.append( "Onions  " );
    }

    if ( this.hasRoastedPeppers() ) {
      thisPizza.append( "Roasted Pepper  " );
    }

    return thisPizza.toString();
  }
}
