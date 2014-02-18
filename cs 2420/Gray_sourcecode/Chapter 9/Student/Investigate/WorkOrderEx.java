import java.util.Date;
import java.util.Calendar;
import gray.misc.ArrayUtils;

/**
 * Illustration of the use of implementing Comparable.
 */
public class WorkOrderEx {
  public static void main( String[] args ) {
    WorkOrder[] jobs = new WorkOrder[4];
    Calendar calendar = Calendar.getInstance();
    calendar.set( 2002, 5, 30, 15, 43 );
    jobs[0] = new WorkOrder( new Name( "Simon", "Gray" ), calendar.getTime(),
                             "Purchasing", "Fix the fan" );
    calendar.set( 2002, 5, 28, 8, 32 );
    jobs[1] = new WorkOrder( new Name( "Simon", "Gray" ), calendar.getTime(),
                             "IT", "Fix broken window" );
    calendar.set( 2002, 5, 30, 16, 50 );
    jobs[2] = new WorkOrder( new Name( "Selena", "Gray" ), calendar.getTime(),
                             "Purchasing", "blown fuse" );
    calendar.set( 2002, 5, 30, 16, 21 );
    jobs[3] = new WorkOrder( new Name( "Tom", "Jones" ), calendar.getTime(),
                             "IT", "Odd smell in AC duct" );

    ArrayUtils.print( jobs, 0, jobs.length - 1 );
    ArrayUtils.mergeSort( jobs, jobs.length );
    System.out.println();
    ArrayUtils.print( jobs, 0, jobs.length - 1 );
  }
}
