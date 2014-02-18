import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Cheap version of text file copier. This version
 * does not exception handling if anything goes wrong.
 */
public class TextFileCopier2 {

    public static void copyFile( Scanner in, Formatter out ) {
        while ( in.hasNext() ) {
            String line = in.nextLine();
            out.format( "%s\n", line );
        }
    }

    public static void main( String[] args ) throws FileNotFoundException {
        if ( args.length != 2 ) {
            System.err.println( "usage: TextFileCopier src dest" );
            System.exit( 1 );
        }
        if ( args[0].equals( args[1] ) ) {
            System.err.println( "Source file and destination file " +
                                " can't be the same." );
            System.exit( 1 );
        }

        Scanner infile;
        Formatter outfile;

        infile = new Scanner( new File( args[0] ) );
        outfile = new Formatter( args[1] );
        copyFile( infile, outfile );
        infile.close();
        outfile.close();
    }
}
