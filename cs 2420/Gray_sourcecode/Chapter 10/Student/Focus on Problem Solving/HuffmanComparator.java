/**
 * Compare two Huffman trees based on the weights stored in the
 * <tt>HuffmanNode</tt>s at their roots.
 */
import gray.adts.binarytree.BinaryTree;

public class HuffmanComparator 
         implements java.util.Comparator<BinaryTree<HuffmanNode>> {

    /**
     * This method meets the contract specified by
     * <tt>java.util.Comparator</tt>. The basis for comparison is 
     * the weight of the <tt>HuffmanNode</tt> stored in the root 
     * of each tree.
     * @param t1 the first <tt>BinaryTree</tt>.
     * @param t2 the second <tt>BinaryTree</tt>.
     * @return A positive integer if <tt>o1</tt> is "greater than"
     *    <tt>t2</tt>, a negative integer if <tt>t1</tt> is
     *     "less than" <tt>o2</tt>, and 0 if they are "equal".
     * @throws <tt>ClassCastException<tt> if the elements stored
     *  in the roots of <tt>t1</tt> and <tt>t2</tt> are not
     *  <tt>HuffmanNode</tt>s.
     * @throws <tt>NullPointerException</Code> if either argument
     *   is null.
     */
    public int compare( BinaryTree<HuffmanNode> t1, 
                        BinaryTree<HuffmanNode> t2 ){
        if ( ( t1 == null ) || ( t2 == null ) )
           throw new NullPointerException();

        // get the roots of both trees
        HuffmanNode h1 = (HuffmanNode)t1.root().element();
        HuffmanNode h2 = (HuffmanNode)t2.root().element();

        // get the weights stored in the roots of the 
        // two binary trees
        int weightHuff1 = h1.weight();
        int weightHuff2 = h2.weight();

        // do the relational comparison of the values at the roots
        if ( weightHuff1 > weightHuff2 )
           return 1;
        if ( weightHuff1 < weightHuff2 )
           return -1;
        return 0;  // they are equal
    }

    /**
     * Determine if the two objects are equal. In this 
     * implementation the two objects are "equal" if 
     * <tt>compare(o1, o2)</tt> returns 0.
     */
    public boolean equals( Object o1, Object o2 ){
        return compare( (BinaryTree<HuffmanNode>)o1, 
                        (BinaryTree<HuffmanNode>)o2 ) == 0;
    }
}