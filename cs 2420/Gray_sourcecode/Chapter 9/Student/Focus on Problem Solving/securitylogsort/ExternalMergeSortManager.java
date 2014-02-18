package securitylogsort;

import java.io.*;

/**
 * Controller class for the external merge sort.
 * THIS FILE IS OBSOLETE.
 */
public class ExternalMergeSortManager {

  private ExternalFileSorter splitAndSort;


  /**
   * The name of the file to sort is on the command line
   * @param args The command line parameters
   */
  public static void main( String[] args ) {
    if ( args.length == 0 ) {
      System.out.println( "Missing: file to sort." );
      System.exit( -1 );
    }
    new ExternalFileSorter( args[0] );
  }
}
