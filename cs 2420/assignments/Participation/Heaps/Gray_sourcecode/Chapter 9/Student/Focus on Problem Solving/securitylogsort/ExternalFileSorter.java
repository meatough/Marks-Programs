package securitylogsort;

import gray.adts.queue.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Splits the main file into smaller sorted files</p>
 */
public class ExternalFileSorter {

  // To work with larger files change these parameters
  private static final int MAX_FILES = 16; // queue size
  private static final int RECORDS_PER_FILE = 90;

  private CircularQueue<File> fileQueue;
  private RandomAccessFile srcFile;
  private long numberOfRecords;
  private long numberOfSplits;
  private File filePath;

  /**
   * Constructor
   */
  public ExternalFileSorter() {
    super();
    srcFile = null;
    numberOfRecords = 0;
    numberOfSplits = 0;
    filePath = null;
  }

  /**
   * Sorts file <tt>fileName</tt> using an external mergesort.
   * @param <tt>fileName</tt> The name of the file to sort
   * @return the name of the sorted file if successful,
   * <tt>null</tt> if there was an error
   */
  public String sortFile( String fileName ) {

    filePath = new File( System.getProperty( "user.dir" ) );
    try {
      srcFile = new RandomAccessFile( fileName, "r" );
      numberOfRecords =
          srcFile.length() / DoorAccessRecord.RECORD_LENGTH;
      numberOfSplits = numberOfRecords / RECORDS_PER_FILE;
      // Adjust for fractions
      if ( ( numberOfRecords % RECORDS_PER_FILE ) != 0 ) {
        ++numberOfSplits;
      }
      fileQueue =
          new CircularQueue<File> ( ( int ) numberOfSplits );

      splitFiles();
      srcFile.close();

      mergeFiles();
    }
    catch ( Exception e ) {
      System.err.println( "ExternalFileSorter-sortFile: " + e );
      cleanup();
      return null;
    }

    // Rename the sorted file
    File sortedFile = fileQueue.dequeue();
    String newName = getOutputFileName( fileName );
    sortedFile.renameTo( new File( newName ) );

    return newName;
  }

  /**
   * Split the main file into sorted smaller files.
   * @throws IOException Rethrows any IO exception
   * to caller.
   */
  private void splitFiles() throws Exception {
    long recordsWritten = 0;
    long length = 0;
    for ( int i = 0; i < numberOfSplits; i++ ) {
      RandomAccessFile splitFile = createTempFile();

      // determine how many records will be in this
      // temporary file
      if ( numberOfRecords - recordsWritten < RECORDS_PER_FILE ) {
        length = numberOfRecords - recordsWritten;
      }
      else {
        length = RECORDS_PER_FILE;
      }

      copyAndSortRecords( splitFile, i * RECORDS_PER_FILE,
                          length );
      recordsWritten += length;
      splitFile.close();
    }
  }

  /**
   * Copy the specified records from the main file into an
   * ArrayList, sort it, and write the records to a temporary file
   * @param srcFile The file to copy from
   * @param start The record number to start copying from
   * @param length The number of records to copy
   * @throws IOException Rethrows any exception to caller.
   */
  private void copyAndSortRecords( RandomAccessFile splitFile,
                                   int start, long length ) throws Exception {
    byte origRecord[] =
        new byte[DoorAccessRecord.RECORD_LENGTH];
    ArrayList<DoorAccessRecord> fileBlock =
        new ArrayList<DoorAccessRecord> ();
    for ( long curPos = start; curPos < ( start + length );
          ++curPos ) {
      srcFile.read( origRecord );
      fileBlock.add( new DoorAccessRecord( origRecord ) );
    }
    java.util.Collections.sort( fileBlock );
    java.util.Iterator<DoorAccessRecord> iter =
        fileBlock.iterator();
    while ( iter.hasNext() ) {
      DoorAccessRecord record = iter.next();
      splitFile.write( record.getByteArray() );
    }
  }

  /**
   * The merge algorithm merges the elements from the two files
   * into sort it, a new file.
   * @throws <tt>IOException</tt> Rethrows any exception to caller
   */
  private void mergeFiles() throws Exception {
    long insertIndex = 0,
        firstPartitionIndex = 0,
        secondPartitionIndex = 0;

    // Establish variables to manage the two files
    byte oneByteArray[] =
        new byte[DoorAccessRecord.RECORD_LENGTH];
    byte twoByteArray[] =
        new byte[DoorAccessRecord.RECORD_LENGTH];

    DoorAccessRecord oneAccessRecord = new DoorAccessRecord();
    DoorAccessRecord twoAccessRecord = new DoorAccessRecord();

    while ( fileQueue.size() >= 2 ) {
      insertIndex = 0;
      firstPartitionIndex = 0;
      secondPartitionIndex = 0;

      // Dequeue two files
      File one = fileQueue.dequeue();
      File two = fileQueue.dequeue();

      // Create the soon to be merged file and enqueue it
      RandomAccessFile oneFile =
          new RandomAccessFile( one, "rw" );
      RandomAccessFile twoFile =
          new RandomAccessFile( two, "rw" );
      RandomAccessFile target = createTempFile();

      long oneRecords =
          oneFile.length() / DoorAccessRecord.RECORD_LENGTH;
      long twoRecords =
          twoFile.length() / DoorAccessRecord.RECORD_LENGTH;

      while ( ( firstPartitionIndex < oneRecords ) &&
              ( secondPartitionIndex < twoRecords ) ) {
        oneFile.seek( firstPartitionIndex *
                      DoorAccessRecord.RECORD_LENGTH );
        oneFile.read( oneByteArray );
        oneAccessRecord.setByteArray( oneByteArray );
        twoFile.seek( secondPartitionIndex *
                      DoorAccessRecord.RECORD_LENGTH );
        twoFile.read( twoByteArray );
        twoAccessRecord.setByteArray( twoByteArray );

        if ( oneAccessRecord.compareTo( twoAccessRecord ) == -1 ) {
          target.write( oneAccessRecord.getByteArray() );
          ++firstPartitionIndex;
        }
        else {
          target.write( twoAccessRecord.getByteArray() );
          ++secondPartitionIndex;
        }
      }

      // If one of the files still has records then
      //   copy the records to the merged file
      if ( firstPartitionIndex < oneRecords ) {
        oneFile.seek( firstPartitionIndex *
                      DoorAccessRecord.RECORD_LENGTH );
        while ( firstPartitionIndex < oneRecords ) {
          oneFile.read( oneByteArray );
          oneAccessRecord.setByteArray( oneByteArray );
          target.write( oneAccessRecord.getByteArray() );
          ++firstPartitionIndex;
        }
      }
      else {
        twoFile.seek( secondPartitionIndex *
                      DoorAccessRecord.RECORD_LENGTH );
        while ( secondPartitionIndex < twoRecords ) {
          twoFile.read( twoByteArray );
          twoAccessRecord.setByteArray( twoByteArray );
          target.write( twoAccessRecord.getByteArray() );
          ++secondPartitionIndex;
        }
      }
      oneFile.close();
      twoFile.close();

      // To see the temporary files comment out the next
      // two lines
      one.delete();
      two.delete();

      // Files must be closed so that it can be renamed
      target.close();
    }
  }

  /**
   * Construct the name of the output file from the name of the
   * input file. This produces a full path.
   * @pre inFilename is not null (NOT VALIDATED)
   */
  private String getOutputFileName( String inFilename ) {
    File file = new File( inFilename );
    String path = file.getPath();

    int dotIndex = path.indexOf( "." );

    StringBuffer newName =
        new StringBuffer( path.substring( 0, dotIndex ) );
    newName.append( "_sorted.txt" );
    return newName.toString();
  }

  /**
   * Create a temporary File in the current directory and put it
   * in the fileQueue. Then create a RandomAccessFile to access
   * the file and return that to the caller.
   * @return a RandomAccessFile
   * @throws IOException Rethrows any exception to caller.
   */
  private RandomAccessFile createTempFile() throws Exception {
    File temp =
        File.createTempFile( "Access", ".tmp", this.filePath );
    temp.deleteOnExit();
    fileQueue.enqueue( temp );
    RandomAccessFile tempFile = new RandomAccessFile( temp, "rw" );
    return tempFile;
  }

  /**
   * An error must have occured. Close and delete all the
   * temporary files stored in the file queue.
   */
  private void cleanup() {
    System.out.println( "cleanup!" );
    try {
      while ( !fileQueue.isEmpty() ) {
        File file = fileQueue.dequeue();
        RandomAccessFile randomFile =
            new RandomAccessFile( file, "r" );
        randomFile.close();
        file.delete();
      }
    }
    catch ( IOException e ) {}
  }
}
