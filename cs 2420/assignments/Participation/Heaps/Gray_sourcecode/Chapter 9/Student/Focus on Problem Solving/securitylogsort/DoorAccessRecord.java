package securitylogsort;

import java.util.*;
import java.text.*;

/**
 * Data class that manages a byte array of data.
 */
public class DoorAccessRecord implements Comparable<DoorAccessRecord> {

  public static final int RECORD_LENGTH = 62;
  private byte accessRecord[] = new byte[RECORD_LENGTH];
  private Collator myCollator;

  /**
   * Default constructor for blank record
   */
  public DoorAccessRecord() {
    // initialize first 60 bytes to ASCII space code (32)
    for ( int x = 0; x < 60; ++x ) {
      accessRecord[x] = 32;
    }
    // Initialize last 2 bytes to CR and LF
    accessRecord[60] = 13;
    accessRecord[61] = 10;

    // The standard compareTo method in a String object is not
    // keyed to a users locale. The Collator object ensures
    // correct comparisons for any locale
    myCollator = Collator.getInstance( new Locale( "en", "US" ) );
  }

  /**
   * Constructor that creates an initialized record
   */
  public DoorAccessRecord( byte accessRecord[] ) {
    System.arraycopy( accessRecord, 0, this.accessRecord,
                      0, RECORD_LENGTH );
    // The standard compareTo method in a String object is
    // not keyed to a users locale. The Collator object
    // ensures correct comparisons for any locale
    myCollator = Collator.getInstance( new Locale( "en", "US" ) );
  }

  /**
   * Implemented as part of the Comparable interface so that
   *  Collections.sort() can be used
   * @param record The object to compare to
   * @return -1 if this <tt>DoorAccessRecord</tt> is less than
   *  <tt>record</tt>, 0 if they are equal, and 1 if
   * <tt>record</tt> is greater than this
   * <tt>DoorAccessRecord</tt>
   */
  public int compareTo( DoorAccessRecord record ) {
    // verify argument o is not null
    if ( record == null ) {
      return -1;
    }

    // Build strings to compare
    String thisRecord = getEmployee() + getDate() +
        getTime();
    String theOtherRecord = record.getEmployee() +
        record.getDate() + record.getTime();

    return myCollator.compare( thisRecord, theOtherRecord );
  }

  /**
   * Return a string containg the employee number from the
   *  byte array
   * @return The string with the employee number
   */
  public String getEmployee() {
    return new String( accessRecord, 0, 6 );
  }

  /**
   * Return a string containg the date from the byte array
   * @return The string with the date
   */
  public String getDate() {
    return new String( accessRecord, 8, 8 );
  }

  /**
   * Return a string containg the time from the byte array
   * @return The string with the time
   */
  public String getTime() {
    return new String( accessRecord, 18, 5 );
  }

  /**
   * Return a string containg the status from the byte array
   * @return The string with the status
   */
  public String getStatus() {
    return new String( accessRecord, 25, 4 );
  }

  /**
   * Return a string containg the room number from the byte array
   * @return The string with the room number
   */
  public String getRoomNumber() {
    return new String( accessRecord, 31, 7 );
  }

  /**
   * Return a string containg the room name from the byte array
   * @return The string with the room name
   */
  public String getRoomName() {
    return new String( accessRecord, 39, 21 );
  }

  /**
   * Return the entire byte array
   * @return The byte array
   */
  public byte[] getByteArray() {
    return accessRecord;
  }

  /**
   * Replace the current byte array with new values
   * @param setRecord The new byte array
   */
  public void setByteArray( byte setRecord[] ) {
    System.arraycopy( setRecord, 0, accessRecord,
                      0, RECORD_LENGTH );
  }
}
