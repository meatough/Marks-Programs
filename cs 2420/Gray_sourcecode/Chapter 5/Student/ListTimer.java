/**
 * Perform timings for accessing elements of an ArrayList and
 * a LinkedList.
 */

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import edu.ashland.jadt.adts.list.*;
import java.text.NumberFormat;

public class ListTimer {
  private static final int iterations = 50;

  public static void main( String[] args ) {
    int i = 0;
    int step = 20000;
    System.out.println( "  n \t #iterations   time/iteration" );
    System.out.println( "                     array    linked list" );
    System.out.println( "-----------------------------------------" );
    for ( int n = 20000; n <= 100000; n += step ) {
      List ra = new ArrayList();
      List sa = new LinkedList();
      for ( i = 0; i < n; i++ ) { // populate the random access list
        ra.add( i, new Integer( i ) );
      }

      sa.addAll( ra ); // populate the sequential access list

      long startTime = System.currentTimeMillis();
      long totalIterations = 0;
      do {
        for ( i = 0; i < iterations; i++ ) {
          ListIterator iter = ra.listIterator();
          while ( iter.hasNext() ) {
            Object item = iter.next();
          }
        }
        totalIterations += iterations;
      }
      while ( ( System.currentTimeMillis() - startTime ) < 1000 );
      long elapsedTime = System.currentTimeMillis() - startTime;
      NumberFormat realNF = NumberFormat.getInstance();
      NumberFormat intNF = NumberFormat.getInstance();
      intNF.setMinimumIntegerDigits( 3 );
      realNF.setMinimumIntegerDigits( 2 );
      realNF.setMinimumFractionDigits( 2 );
      realNF.setMaximumFractionDigits( 2 );
      System.out.print( n + "\t     " + intNF.format( totalIterations ) +
                        "     " +
                        realNF.format( ( ( float ) elapsedTime /
                                         totalIterations ) ) );
      // Do it all again for the sequential access list
      startTime = System.currentTimeMillis();
      totalIterations = 0;
      do {
        for ( i = 0; i < iterations; i++ ) {
          ListIterator iter = sa.listIterator();
          while ( iter.hasNext() ) {
            Object item = iter.next();
          }
        }
        totalIterations += iterations;
      }
      while ( ( System.currentTimeMillis() - startTime ) < 1000 );
      elapsedTime = System.currentTimeMillis() - startTime;
      System.out.println( "       " +
                          realNF.format( ( float ) elapsedTime /
                                         totalIterations ) );
//            System.out.println("ra.size() " + ra.size());
//            System.out.println("sa.size() " + sa.size());
    }
  }
}
