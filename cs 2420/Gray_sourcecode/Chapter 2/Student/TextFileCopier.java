import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Copy a text file to another file.
 */
public class TextFileCopier {
    private Scanner infile;
    private Formatter outfile;

    public TextFileCopier( String src, String dest ) {
        openInputFile( src );
        openOutputFile( dest );
        copyFile();
        infile.close();
        outfile.close();
    }

    public void openInputFile( String infileName ) {
        try {
            infile = new Scanner( new File( infileName ) );
        }
        catch ( FileNotFoundException e ) {
            System.err.printf( "Error opening input file: %s\n%s",
                               infileName, "Exiting application." );
            System.exit( 1 );
        }
    }

    public void openOutputFile( String outfileName ) {
        try {
            outfile = new Formatter( outfileName );
        }
        catch ( FileNotFoundException e ) {
            System.err.printf( "Error opening output file: %s\n%s",
                               outfileName, "Exiting application." );
            infile.close();
            System.exit( 1 );
        }
        catch ( SecurityException e ) {
            System.err.printf( "Error insufficient write access to " +
                               "create file: %s\n", outfileName );
            infile.close();
            System.exit( 1 );
        }
    }

    public void copyFile() {
        try {
            while ( infile.hasNext() ) {
                String line = infile.nextLine();
                outfile.format( "%s\n", line );
            }
        }
        catch ( FormatterClosedException e ) {
            System.err.println( "Error writing to output file; " +
                                "copying terminated" );
            return;
        }
    }

    public static void main( String[] args ) {
        if ( args.length != 2 ) {
            System.err.println( "usage: TextFileCopier src dest" );
            System.exit( 1 );
        }
        if ( args[0].equals( args[1] ) ) {
            System.err.println( "Source file and destination file " +
                                " can't be the same." );
        }
        else {
            new TextFileCopier( args[0], args[1] );
        }
    }
}
