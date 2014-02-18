/**
 * The <tt>Name</tt> class stores a person's first and last name.
 */
public class Name implements Comparable<Name> {

  private String firstName;
  private String lastName;

  /**
   * Construct a <tt>Name</tt> object and initialize it with
   * <tt>first</tt> as and <tt>last</tt> as the person's first
   * and last names.
   * @param first  The person's first name
   * @param last  The person's last name
   * @throws NullPointerException if <tt>first</tt> or
   *  <tt>last</tt> is null
   */
  public Name( String first, String last ) {
    if ( ( first == null ) || ( last == null ) ) {
      throw new NullPointerException();
    }
    this.firstName = first;
    this.lastName = last;
  }

  /**
   * Get the last name of this person.
   * @return this person's first name
   */
  public String firstName() {
    return this.firstName;
  }

  /**
   * Get the first name of this person.
   * @return this person's last name
   */
  public String lastName() {
    return this.lastName;
  }

  /**
   * Determine if this name is equal to the given argument.
   * @param o The <tt>Name</tt> object to which we are to compare
   *       this <tt>Name</tt>
   * @return  true if both the first and last name of this
   *   <tt>Name</tt> match the first and last names of the given
   *   argument; otherwise return false.
   */
  public boolean equals( Object o ) {
    if ( o instanceof Name ) {
      return this.compareTo( ( Name ) o ) == 0;
    }
    return false;
  }

  /**
   * Return the hashcode for this <tt>Name</tt>.
   * @return  The hashcode for this name.
   */
  public int hashCode() {
    return 31 * this.lastName.hashCode() +
        this.firstName.hashCode();
  }

  /**
   * Returns a <tt>String</tt> object representing this
   * <tt>Name</tt>'s value.
   * @return This <tt>Name</tt> as a <tt>String</tt>.
   */
  public String toString() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Compare this <tt>Name</tt> to the <tt>Name</tt> supplied in
   * the argument.
   * @param o The <tt>Name</tt> to which to compare this
   *  <tt>Name</tt>.
   * @return  -1 if this name is lexicographically less than the
   *     other name.<BR>
   * 0 if they are equal<BR>
   * 1 if this name is lexicographically greater than the
   *  other name
   * @throws <tt>IllegalArgumentException</tt> if
   *   <tt>other</tt> is <tt>null</tt>
   */
  public int compareTo( Name other ) {

    if ( other == null ) {
      throw new IllegalArgumentException();
    }

    int result = 0;
    if ( this.lastName.compareTo( other.lastName() ) < 0 ) {
      result = -1;
    }
    else if ( this.lastName.compareTo( other.lastName() ) == 0 ) {
      result = this.firstName.compareTo( other.firstName() );
    }

    return result;
  }
}
