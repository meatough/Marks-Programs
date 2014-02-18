/**
 * Focus on Problem Solving solution. Encoding a text file
 * using Huffman coding. If a HuffmanNode is a leaf, it stores
 * both a character and its frequency of occurrence in the input
 * text. If the HuffmanNode is an interior node of the Huffman
 * Tree, it stores only a weight, which is the sum of the weights
 * of its left and right children.
 */
public class HuffmanNode {
  private char character;
  private int weight;   // character's frequency if a leaf node
  private String code;  // character's Huffman encoding

  /**
   * Create a leaf HuffmanNode.
   * @param <code>c</code> a character from the frequency table
   * @param <code>weight</code> the frequency of occurrence of this
   *   character in the input
   * @throws <code>IllegalArgumentException</code> if <code>weight</code>
   * is less than 0
   */
  public HuffmanNode( char c, int weight ) {
    this( weight );
    this.character = c;
    this.code = null;
  }

  /**
   * Create an interior HuffmanNode.
   * @param <code>weight</code> the frequency of occurrence of this
   *  character in the input
   * @throws <code>IllegalArgumentException</code> if <code>weight</code>
   *  is less than 0
   */
  public HuffmanNode( int weight ) {
    if ( weight < 0 ) {
      throw new IllegalArgumentException();
    }
    this.weight = weight;
    this.code = null;
  }

  /**
   * Return the character stored in this HuffmanNode.
   * @return the character stored in this HuffmanNode.
   */
  public char character() {
    return character;
  }

  /**
   * Return the weight stored in this HuffmanNode.
   * @return the weight stored in this HuffmanNode.
   */
  public int weight() {
    return weight;
  }

  /**
   * Set the Huffman encoding for this HuffmanNode. This only
   * makes sense if this node is a leaf and contains a character.
   * @param <code>newCode</code> <code>String</code> version of the
   *  Huffman encoding for this node's character
   */
  public void setCode( String newCode ) {
    this.code = newCode;
  }

  /**
   * Accessor method for code acoderibute.
   * @return the code for this HuffmanNode.
   */
  public String code() {
    return this.code;
  }
}
