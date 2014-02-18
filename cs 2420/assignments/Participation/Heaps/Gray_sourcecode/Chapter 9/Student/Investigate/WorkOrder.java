/**
 * A <tt>WorkOrder</tt> is a request for work to be done.
 * Every request has a person who submits the request, a date
 * on which the request was submitted and a department for
 * which the work is to be done.
 * <p>Work orders are ordered by the name of the requester.</p>
 */
import java.util.Date;

public class WorkOrder implements Comparable<WorkOrder> {
  private Name requester;
  private Date dateSubmitted;
  private String department;
  private String workDescription;

  /**
   * Construct a <tt>WorkOrder</tt> object and initialize it with
   * <tt>name</tt>, <tt>date</tt> and <tt>dept</tt>.
   * @param name The name of the person making the work order request.
   * @param date The date the work order was submitted.
   * @param dept The department for which the work is to be done.
   * @throws NullPointerException if any of the arguments are null.
   */
  public WorkOrder( Name name, Date date, String dept,
                    String description ) {
    if ( ( name == null ) || ( date == null ) || ( dept == null ) ||
         ( description == null ) ) {
      throw new NullPointerException();
    }
    this.requester = name;
    this.dateSubmitted = date;
    this.department = dept;
    this.workDescription = description;
  }

  /**
   * Return the <tt>Name</tt> of the person who requested this work.
   */
  public Name requester() {
    return this.requester;
  }

  /**
   * Return the <tt>Date</tt> this <tt>WorkOrder</tt> was submitted.
   */
  public Date dateSubmitted() {
    return this.dateSubmitted;
  }

  /**
   * Return the <tt>department</tt> for which this <tt>WorkOrder</tt>
   * was submitted.
   */
  public String department() {
    return this.department;
  }

  /**
   * Return the description of the work to be done for this
   * <tt>WorkOrder</tt>.
   */
  public String workDescription() {
    return this.workDescription;
  }

  /**
   * Determine if this <tt>WorkOrder</tt> is equal to the argument.
   * @param o The <tt>WorkOrder</tt> object to which we are to compare
   * this <tt>WorkOrder</tt>.
   * @returns true if the two <tt>WorkOrders</tt> are equal (have the same
   *         requester, same department and the same day submitted.
   */
  public boolean equals( Object o ) {
    if ( o instanceof WorkOrder ) {
      return this.compareTo( ( WorkOrder ) o ) == 0;
    }
    return false;
  }

  /**
   * Return the hashcode for this WorkOrder.
   * @return  The hashcode for this WorkOrder.
   */
  public int hashCode() {
    return 17 * this.requester.hashCode() + 31 * this.dateSubmitted.hashCode() +
        11 * this.department.hashCode() + this.workDescription.hashCode();
  }

  /**
   * Returns a <t>String</t> object representing this <t>WorkOrder</t>'s value.
   * @returns This <t>WorkOrder</t> as a <t>String</t>.
   */
  public String toString() {
    return this.requester + "  " + this.department + "  " +
        this.dateSubmitted + "  " + this.workDescription;
  }

  /**
   * Compare this <tt>WorkOrder</tt> to the <tt>WorkOrder</tt> supplied
   * in the argument.
   * @param wo The <tt>WorkOrder</tt> to which to compare this <tt>WorkOrder</tt>.
   * The comparison is done on the fields in the following order:
   * <OL>
   * <LI>  name of requester
   * <LI> date of submission
   * <LI> department to be billed
   * <LI> work order description
   * </OL>
   * @returns -1 if this <tt>WorkOrder</tt> is less than the
   * <tt>WorkOrder</tt> passed in.<BR>
   * 0 if they are equal.<BR>
   * 1 if this <tt>WorkOrder</tt> is greater than the
   * <tt>WorkOrder</tt> passed in.
   * @throws IllegalArgumentException if <tt>wo</tt> is null
   */
  public int compareTo( WorkOrder wo ) {
    if ( wo == null ) {
      throw new IllegalArgumentException();
    }

    int nameCmp = this.requester.compareTo( wo.requester() );
    if ( nameCmp != 0 ) {
      return nameCmp;
    }

    int dateCmp = this.dateSubmitted.compareTo( wo.dateSubmitted() );
    if ( dateCmp != 0 ) {
      return dateCmp;
    }

    int deptCmp = this.department.compareTo( wo.department() );
    if ( deptCmp != 0 ) {
      return deptCmp;
    }

    return this.workDescription.compareTo( wo.workDescription() );
  }
}
