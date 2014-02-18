package courier;

import java.io.Serializable;

/**
 * Store information about a single Courier slip. A slip consists
 * of:
 * <UL>
 * <LI>source - where the item is to be picked up
 * <LI>destination - where the item is to be dropped off
 * <LI>item - a brief description of the item to be delivered
 * </UL>
 * Each slip also has a priority which is not stored with the slip
 * and is determined by its position in the collection of slips.
 */
public class CourierSlip
    implements Serializable {

  private String source;
  private String destination;
  private String pickupItem;

  /**
   * Constructor. Create an empty slip.
   */
  public CourierSlip() {
    source = null;
    destination = null;
    pickupItem = null;
  }

  /**
   * Create a CourierSlip and populate it with the delivery details
   * provided in the parameters.
   * @param src - the address where <tt>item</tt> is to be picked up
   * @param dest - the address where <tt>item</tt> is to be delivered
   * @param item - a brief desription of the item to deliver
   */
  public CourierSlip(String src, String dest, String item) {
    setSource(src);
    setDestination(dest);
    setPickupItem(item);
  }

  /**
   * Set the pickup location for this <tt>CourierSlip</tt>.
   * @param src the address where the item is to be picked up
   */
  public void setSource(String src) {
    this.source = src.trim();
  }

  /**
   * Set the dropoff location for this <tt>CourierSlip</tt>.
   * @param dest the address where the item is to be dropped off
   */
  public void setDestination(String dest) {
    this.destination = dest.trim();
  }

  /**
   * Set the description of the item this <tt>CourierSlip</tt>.
   * @param item a brief description of the item to be delivered
   */
  public void setPickupItem(String item) throws IllegalArgumentException {
    this.pickupItem = item.trim();
  }

  /**
   * Get the pickup location for this <tt>CourierSlip</tt>.
   * @return the pickup location for this <tt>CourierSlip</tt>
   */
  public String getSource() {
    return this.source;
  }

  /**
   * Get the dropoff address for this <tt>CourierSlip</tt>.
   * @return the dropoff address for this <tt>CourierSlip</tt>
   */
  public String getDestination() {
    return this.destination;
  }

  /**
   * Get the item description for this <tt>CourierSlip</tt>.
   * @return the item description for this <tt>CourierSlip</tt>
   */
  public String getPickupItem() {
    return this.pickupItem;
  }

  /**
   * Produce a string version of this <tt>CourierSlip</tt>
   * suitable for display.
   * @return <tt>String</tt> version of this <tt>CourierSlip</tt>
   */
  public String toString() {
    return "Source:      " + this.source +
        "\nDestination: " + this.destination +
        "\nPickup Item: " + this.pickupItem;
  }
}
