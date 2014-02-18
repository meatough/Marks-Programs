import javax.swing.JOptionPane;
import java.io.*;
import gray.adts.heap.*;
import gray.adts.binarytree.*;

/**
 * Focus on Problem Solving solution. Encoding a text file using
 *  Huffman coding.
 */
public class HuffmanCompress {

    private static final byte BITS_IN_A_BYTE = 8;
    private  int[] frequencyTable;
    private String[] ASCIIcodeTable;
    private byte[] binaryCodeTable;
    private byte numberOfCodes;   
    private Heap<BinaryTree<HuffmanNode>> treeHeap;
    private BinaryTree<HuffmanNode> huffmanTree;

    /**
     * Constructor - Allocate all the objects we'll need to build 
     * a Huffman Tree.
     */
    public HuffmanCompress(){
        frequencyTable = new int[128];
        treeHeap = new ArrayMinHeap<BinaryTree<HuffmanNode>>(
                                        new HuffmanComparator() );
        huffmanTree = null;
        numberOfCodes = 0;
        ASCIIcodeTable = new String[128];
        binaryCodeTable = new byte[128];
    }

    /**
     * Build the frequency table from the text found in file 
     * fileName.
     * @param inFilename is not null and is the name of a file that
     *  exists (NOT VALIDATED)
     */
    private void buildFrequencyTable( String inFilename ) 
                                       throws java.io.IOException {
        int len;
        char[] buffer = new char[128];
        BufferedReader in =
                 new BufferedReader(
                    new InputStreamReader( 
                       new FileInputStream( inFilename ) ) );

        while ( ( len = in.read( buffer, 0, 128 ) ) != -1 )
              for ( int i = 0; i < len; i++ ) {
                  // keep track of number of codes we'll generate
                  if ( frequencyTable[buffer[i]] == 0 )
                     numberOfCodes++;
                  frequencyTable[buffer[i]]++;
              }
        in.close();
    }

    /**
     * Compress the file specified in <tt>inFileName</Tt> using 
     * Huffman compression.
     * @param inFilename not null and is the name of a text file.
     * @return the name of the output file containing the 
     *  compressed data or null if there was a failure.
     */
    public String compressFile( String inFilename ){

        if ( inFilename == null )
           return null;

        // construct the frequency table for the characters that 
        // appear in the input string
        try {
            buildFrequencyTable( inFilename );
        } catch ( IOException ioe ){
            JOptionPane.showMessageDialog( null, 
                 "Error accessing input file: " + inFilename,
                 "File Access Error", JOptionPane.ERROR_MESSAGE );
            return null;
        }

        buildHuffmanTree();

        // construct the Huffman code for each character in the 
        // Huffman Tree
        buildHuffmanCodes( huffmanTree );

        String outFilename = getOutputFileName( inFilename );

        writeCompressedFile( inFilename, outFilename );

        return outFilename;
    }

    /**
     * Build the huffman tree based on the information in the
     * frequency table.
     */
    private void buildHuffmanTree(){
        // for each character in the frequency table...
        for ( int i = 0; i < frequencyTable.length; i++ )
            if ( frequencyTable[i] != 0 ) {
               // ...construct a Huffman Tree consisting of a 
               //  single  node that stores the character and 
               //  its frequency (weight)
               HuffmanNode node = 
                     new HuffmanNode( (char)i, frequencyTable[i] );
               BinaryTree huffTree = new LinkedBinaryTree( node );
               // add this Tree to the heap of Huffman Trees
               treeHeap.add( huffTree );
            }

        // while the size of the heap is greater than 1
        while ( treeHeap.size() > 1 ) {
            // remove the two Huffman Trees with the smallest 
            // weight at their roots
            LinkedBinaryTree t1 = (LinkedBinaryTree)treeHeap.top();
            LinkedBinaryTree t2 = (LinkedBinaryTree)treeHeap.top();
            HuffmanNode h1 = (HuffmanNode)t1.root().element();
            HuffmanNode h2 = (HuffmanNode)t2.root().element();
            HuffmanNode newHuffNode = 
                 new HuffmanNode( h1.weight() + h2.weight() );

            // merge these two trees into a single Huffman Tree 
            // whose root stores the sum of the weights of its 
            // two children
            BinaryTree newTree = 
                    new LinkedBinaryTree( t1, newHuffNode, t2 );

            // add this Huffman Tree to the heap
            treeHeap.add( newTree );
        }
        huffmanTree = (BinaryTree)treeHeap.top();
    }


    /**
     * Determine the bit code for each character in the Huffman
     * tree. This is done by recursively descending the tree 
     * until a leaf is encountered. It is in the leaves that the
     * characters are stored.
     * @pre huffTree is not null (NOT VALIDATED)
     * @param huffTree The Huffman Tree from which we build the
     * bit codes.
     */
    private void buildHuffmanCodes( BinaryTree huffTree ) {
        HuffmanNode huffNode = 
                    (HuffmanNode)huffTree.root().element();
        huffNode.setCode( new String("") );
        LinkedBinaryTreeNode<HuffmanNode> root = 
                    (LinkedBinaryTreeNode)huffTree.root();
        huffmanTreeTraversal( huffTree, root.leftChild() );
        huffmanTreeTraversal( huffTree, root.rightChild() );
    }

    /**
     * Starting at the root and moving down to the leaves, the 
     * algorithm builds the code for the characters in the leaves.
     * For each internal node starting with root's children
     *   if the internal node is a left child, it's code is 0 
     *      appended to its parent's code
     *   if the internal node is a right child, it's code is 1
     *      appended to its parent's code
     */
    private void huffmanTreeTraversal( BinaryTree huffTree, 
                                       BinaryTreeNode node ){
        // get references to the HuffmanNode for the child 
        //  and its parent
        BinaryTreeNode parent = node.parent();
        HuffmanNode huffChild = (HuffmanNode)node.element();
        HuffmanNode huffParent = (HuffmanNode)parent.element();

        // if this is a left child, it's code is its 
        // parent's code + "0"
        if ( node == parent.leftChild() ) {
            huffChild.setCode( huffParent.code() + "0" );
        }
        // if this is a right child, it's code is its 
        // parent's code + "1"
        else if ( node == parent.rightChild() ) {
            huffChild.setCode( huffParent.code() + "1" );
        }

        // if this node is a leaf, we are done and need to 
        // store the character's code in the code table and
        // make the corresponding binary code.
        if ( !node.isInternal() ) {
            ASCIIcodeTable[(int)huffChild.character()] = 
                  new String( huffChild.code() );
            makeBinaryCode( huffChild.character() );
        }
        else {  // this is an internal node so we need to 
                // visit its children
            huffmanTreeTraversal( huffTree, node.leftChild() );
            huffmanTreeTraversal( huffTree, node.rightChild() );
        }
    }

    /**
     * Construct the binary version of the character's bit code.
     * @param c a character from the Huffman Tree with entries 
     *   in ASCIIcodeTable and binaryCodetable
     */
    private void makeBinaryCode( char c ){
        String charCode = ASCIIcodeTable[ (int)c ];
        byte binCode = binaryCodeTable[ (int)c ];

        for ( int i = 0; i < charCode.length(); i++ ) {
            binCode <<= 1;  // make room for the new bit
            if ( charCode.charAt( i ) == '1' )
               binCode |= 0x1;
        }
        binaryCodeTable[ (int)c ] = binCode;
    }


    /**
     * Do the actual file compression using the information from
     * the binaryCodeTable.
     * @pre inFilename and outFilename are not null (NOT VALIDATED)
     * @param inFilename the name of the input text file to be 
     *   compressed
     * @param outFilename the name of the output binary file 
     *   containing the compressed data
     */
    private void writeCompressedFile( String inFilename, 
                                      String outFilename )   {
        int len, codeCount = 0;
        byte codeLength,    // number of bits in the binary code
            // number of bits left to use in the current byte
            bitsRemaining = BITS_IN_A_BYTE,  
            numBitsToShift = 0;
        char c;
        String charCode = null;
        short binCode = 0, code = 0, temp;
        char[] buffer = new char[128];
        byte[] codeArray = new byte[128];

        try {
            BufferedReader in = 
               new BufferedReader(
                  new InputStreamReader( 
                     new FileInputStream( inFilename ) ) );
            DataOutputStream out = 
                new DataOutputStream( 
                  new FileOutputStream( outFilename ) );

            writeCodeTable( out );
            // process input 128 bytes at a time
            while ( ( len = in.read( buffer, 0, 128 ) ) != -1 )
              for ( int i = 0; i < len; i++ ) {
                  c = buffer[i];
                  charCode = this.ASCIIcodeTable[ (int)c ];
                  binCode = this.binaryCodeTable[ (int)c ];
 
                  // the binary values are stored in a byte array
                  // if the byte array is full output it to the 
                  // output file
                  if ( codeCount == codeArray.length ) {
                    out.write( codeArray, 0, codeArray.length ); 
                    codeCount = 0;
                  }
                  // determine how many bits there are in this code
                  codeLength = (byte)charCode.length();  
                  
                  // is there room for the bit code in the current
                  // byte?
                  if ( codeLength <= bitsRemaining ) {   
                     // shift the word left by the size of the code
                      code <<= codeLength;                
                     bitsRemaining -= codeLength;
                     code |= binCode;                    

                     // if there is no more room in the current 
                     // byte, put it in the codeArray
                     if ( bitsRemaining == 0 ){
                        codeArray[ codeCount ] = (byte)code;
                        codeCount++;
                        code = 0;
                        bitsRemaining = BITS_IN_A_BYTE;
                     }
                  }
                  else { // the bitCode will have to be stored over
                         // two bytes.  bitsRemaining bits will go
                         // in the current byte and the rest will
                         // go in the next byte.
                      code <<= bitsRemaining;
                      temp = binCode;
                      temp >>>= ( codeLength - bitsRemaining );
                      code |= temp;
                      codeArray[ codeCount ] = (byte)code;
                      codeCount++;
                      if ( codeCount == codeArray.length ) {
                       out.write( codeArray, 0, codeArray.length );
                       codeCount = 0;
                      }
                      code = 0;
                      // clear the code bits we have already sent
                      temp = binCode;
                      temp <<= (BITS_IN_A_BYTE - bitsRemaining +1);
                      // now move the bits we want into position
                      temp = (short)( temp >>> 
                             (BITS_IN_A_BYTE - bitsRemaining + 1));
                      if ( temp < 0 )
                        temp = (short)-temp;
                      code |= temp;    // move bits into code byte
                      bitsRemaining = (byte)(BITS_IN_A_BYTE - 
                                     codeLength - bitsRemaining);
                  }
              }
              if ( ( bitsRemaining > 0 ) && 
                   ( bitsRemaining < BITS_IN_A_BYTE ) ) {
                 codeArray[codeCount] = 
                           (byte)( code << bitsRemaining );
                 codeCount++;
              }
              out.write( codeArray, 0, codeCount - 1 );
              in.close();
              out.close();
        } catch ( java.io.FileNotFoundException fnfe ){
             JOptionPane.showMessageDialog( null, "Input file " 
               + inFilename + " not found.",
               "File Not Found Error", JOptionPane.ERROR_MESSAGE );
        }
        catch( java.io.IOException ioe ) {
        }
    }

    /**
     * Construct the name of the output file from the name of 
     * the input file. This produces a full path.
     * @pre inFilename is not null (NOT VALIDATED)
     */
    private String getOutputFileName( String inFilename ){
        File file = new File( inFilename );
        String path = file.getPath();

        int dotIndex = path.indexOf( "." );

        StringBuffer newName = 
             new StringBuffer( path.substring( 0, dotIndex ) );
        newName.append( ".hfc" );
        return newName.toString();
    }

    /**
     * Write information about the code table to the compressed
     *  file so we have everything we need to do the uncompress. 
     * The information is a sequence of types in the following 
     * order:
     * number of codes, ( character, bit code )*
     * That is, the first byte is the number of codes in the table.
     * This is followed by that number of (character, bit code)
     * pairs.
     */
     private void writeCodeTable( DataOutputStream out ) 
                                          throws IOException {
        out.writeByte( numberOfCodes );
        for ( int i = 0; i < frequencyTable.length; i++ )
            if ( frequencyTable[i] != 0 ) {
                out.writeChar( i );
                out.writeByte( binaryCodeTable[i] );
            }
     }
}