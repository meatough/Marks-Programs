package spellchecker;

import gray.adts.binarysearchtree.*;
import java.io.*;

/**
 * The spell checker component. Allows a client to specify
 * which dictionary to load, search for a word in the dictionary,
 * add a word to the dictionary, remove a word from the dictionary,
 * save the dictionary to a file whose name is supplied by the
 * client.
 */
public class SpellChecker {
  private AVLTree<String> dictionary;
  private boolean modified;

  /**
   * Constructor - populate the dictionary from a text file.
   * @param <tt>wordsFile</tt> the name of the file
   *    containing the words for the dictionary
   */
  public SpellChecker( String wordsFile ) {
    this.dictionary = new AVLTree<String> ();
    populateDictionary( wordsFile );
    this.modified = false;
  }

  /**
   * Determine if <tt>word</tt> is in the dictionary.
   * @param <tt>word</tt> the word to search for
   * @return <tt>true</tt> if <tt>word</tt> is found in
   *   the dictionary, <tt>false</tt> otherwise
   */
  public boolean search( String word ) {
    return dictionary.contains( word );
  }

  /**
   * Remove the argument from the dictionary.
   * @param <tt>word</tt> the word to remove from the
   *  dictionary
   */
  public void remove( String word ) {
    dictionary.remove( word );
    this.modified = true;
  }

  /**
   * Add the argument to the dictionary.
   * @param <tt>word</tt> the word to add to the dictionary
   */
  public void add( String word ) {
    dictionary.add( word );
    this.modified = true;
  }

  /**
   * Return the modified status of the dictionary.
   * @return whether this dictionary has been modified
   * since initialization or the last save
   */
  public boolean modified() {
    return this.modified;
  }

  /**
   * Save the entries in the dictionary to the file
   * specified in the argument. The entries are saved in a
   * format suitable for loading by the dictionary: one entry
   * per line.
   * @param <tt>dest</tt> the name of the file to which to
   *     write the entries from the dictionary
   * @throws <tt>IllegalArgumentException</tt> if <tt>dest</tt>
   *      is null or empty
   */
  public void save( String dest ) {
    try {
      BufferedWriter out =
          new BufferedWriter(
              new OutputStreamWriter(
                  new FileOutputStream( dest ) ) );
      for ( String s : dictionary ) {
        out.write( s );
        out.newLine(); // make sure one entry per line
      }
      out.close();
      this.modified = false;
    }
    catch ( IOException ioe ) {
    }
  }

  /**
   * Populate the dictionary with entries from the file named
   * <tt>src</tt>. It is assumed that there is one word per
   * line in the input file.
   * @param <tt>src</tt> The name of the input file.
   */
  private void populateDictionary( String src ) {
    try {
      BufferedReader in =
          new BufferedReader(
              new InputStreamReader(
                  new FileInputStream( src ) ) );
      while ( in.ready() ) {
        String word = in.readLine();
        dictionary.add( word.trim() );
      }
      in.close();
    }
    catch ( IOException ioe ) {
    }
  }
}
