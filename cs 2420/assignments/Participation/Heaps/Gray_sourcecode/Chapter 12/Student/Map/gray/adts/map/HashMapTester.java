package gray.adts.map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;
import java.util.ArrayList;

/**
 * Description:  JUnit test of the HashMap class
 */
public class HashMapTester extends TestCase {

  private HashMap<Integer, String> map1, map2;
  private Integer key0, key1, key2, key3, key4, key5, key6, key7, key10,
      key10Duplicate;
  private String value0, value1, value2, value3, value4, value5, value6,
      value7, value8, value9;
  Double f;

  /**
   * Constructs a <code>AVLTester</code> with
   * the specified name.
   *
   * @param name Test case name.
   */
  public HashMapTester( String name ) {
    super( name );
    key0 = new Integer( 0 );
    key1 = new Integer( 1 );
    key2 = new Integer( 2 );
    key3 = new Integer( 3 );
    key4 = new Integer( 4 );
    key5 = new Integer( 5 );
    key6 = new Integer( 6 );
    key7 = new Integer( 7 );
    key10 = new Integer( 10 );
    key10Duplicate = new Integer( 27 );

    value0 = new String( "value 0" );
    value1 = new String( "value 1" );
    value2 = new String( "value 2" );
    value3 = new String( "value 3" );
    value4 = new String( "value 4" );
    value5 = new String( "value 5" );
    value6 = new String( "value 6" );
    value7 = new String( "value 7" );
    value8 = new String( "value 8" );
    value9 = new String( "value 9" );
  }

  /**
   * Sets up the text fixture.
   *
   * Called before every test case method.
   */
  protected void setUp() {
    map1 = new HashMap<Integer, String> ();
    map1.put( key10, value0 );
  }

  /**
   * Tears down the text fixture.
   *
   * Called after every test case method.
   */
  protected void tearDown() {
    map1 = null;
    map2 = null;
  }

  /**
   * Hash two keys to the same bucket. Test that the chaining works.
   */
  public void testPutDuplicateHashValue() {
//        System.out.println("hashCode for key1 is " + key1.hashCode() );
    assertTrue( map1.containsKey( key10 ) );
    String value = map1.get( key10 );
    assertTrue( !map1.isEmpty() );
    assertTrue( map1.size() == 1 );
    assertTrue( value.equals( value0 ) );

    assertTrue( map1.put( key10Duplicate, value1 ) == null );
    value = map1.get( key10Duplicate );
    assertTrue( !map1.isEmpty() );
    assertTrue( map1.size() == 2 );
    assertTrue( value.equals( value1 ) );
    // now make sure we didn't detach the other entries in this chain
    value = map1.get( key10 );
    assertTrue( value.equals( value0 ) );
  }

  /**
   * Test that when an entry (k, v2 ) is put to the map, and key k is
   * already in the map, the old value associated with k is returned and
   * is no longer in the map. v2 should be in the map
   */
  public void testReplaceValue() {
    String value = map1.put( key10, value1 );
    assertTrue( map1.size() == 1 );
    assertTrue( value.equals( value0 ) );
    assertTrue( !map1.containsValue( value0 ) );
    assertTrue( map1.containsValue( value1 ) );
  }

  /**
   * Remove the only entry on a chain.
   */
  public void testRemoveSingleEntryChain() {
    String value = map1.remove( key10 );
    assertTrue( value.equals( value0 ) );
    assertTrue( map1.size() == 0 );
    assertTrue( map1.get( key10 ) == null );
  }

  /**
   * Remove the entry at the head of a chain of length > 1
   */
  public void testRemoveHeadOfChain() {
    // this will put a new entry at the head of the chain for index 10
    assertTrue( map1.put( key10Duplicate, value1 ) == null );
    assertTrue( map1.size() == 2 );
    String value = map1.remove( key10Duplicate );
    assertTrue( value.equals( value1 ) );
    assertTrue( map1.size() == 1 );
    assertTrue( map1.get( key10Duplicate ) == null );
    // make sure chain wasn't disconnected
    assertTrue( map1.get( key10 ).equals( value0 ) );
  }

  /**
   * Remove the entry at the tail of a chain of length > 1
   */
  public void testRemoveTailOfChain() {
    // this will put a new entry at the head of the chain for index 10
    assertTrue( map1.put( key10Duplicate, value1 ) == null );
    assertTrue( map1.size() == 2 );

    // now remove the last entry in this chain
    String value = map1.remove( key10 );
    assertTrue( value.equals( value0 ) );
    assertTrue( map1.size() == 1 );
    assertTrue( map1.get( key10 ) == null );
    // make sure chain wasn't disconnected
    assertTrue( map1.get( key10Duplicate ).equals( value1 ) );
  }

  /**
   * See if the iterator can successfully iterate over an empty map.
   */
  public void testContainsValueOnEmptyMap() {
    HashMap m = new HashMap<Integer, String> ();
    assertTrue( !m.containsValue( value0 ) );
  }

  /**
   * See if the iterator can successfully iterate over a chain containing
   * just 1 element.
   */
  public void testContainsValueOnSingleElementChain() {
    assertTrue( map1.containsValue( value0 ) );
  }

  /**
   * See if the iterator can successfully iterate over a chains containing
   * more than 1 element.
   */
  public void testContainsValueOnMultipleElementChain() {
    map1.put( key5, value1 );
    map1.put( key10Duplicate, value2 );
    assertTrue( map1.containsValue( value0 ) );
    assertTrue( map1.containsValue( value1 ) );
    assertTrue( map1.containsValue( value2 ) );
  }

  /**
   * See if values correctly iterates over the Map.
   */
  public void testValues() {
    map1.put( key5, value1 );
    map1.put( key2, value2 );
    map1.put( key7, value5 );
    List<String> expectedValues = new ArrayList<String> ();
    expectedValues.add( value0 );
    expectedValues.add( value1 );
    expectedValues.add( value2 );
    expectedValues.add( value5 );
    java.util.Collection<String> actualValues = map1.values();
    assertTrue( actualValues.size() == 4 );
    assertTrue( actualValues.containsAll( expectedValues ) );

    // add a (key, value) pair to the map and see if it is in the view
    map1.put( key4, value7 );
    assert ( actualValues.contains( value7 ) );

    // remove a key from the view and see if it is still in the map
    actualValues.remove( key2 );
    assert ( !map1.containsValue( value2 ) );

    // remove a key from the map and see if it is still in the view
    map1.remove( key5 );
    assert ( !actualValues.contains( value1 ) );
  }

  /**
   * See if keys correctly iterates over the Map.
   */
  public void testKeys() {
    map1.put( key5, value1 );
    map1.put( key2, value2 );
    map1.put( key7, value5 );
    List<Integer> expectedKeys = new ArrayList<Integer> ();
    expectedKeys.add( key10 );
    expectedKeys.add( key5 );
    expectedKeys.add( key2 );
    expectedKeys.add( key7 );
    java.util.Collection<Integer> keysView = map1.keys();
    assertTrue( keysView.size() == 4 );
    assertTrue( keysView.containsAll( expectedKeys ) );

    // add a (key, value) pair to the map and see if it is in the view
    map1.put( key4, value7 );
    assert ( keysView.contains( key4 ) );

    // remove a key from the view and see if it is still in the map
    assert ( map1.containsKey( key2 ) );
    keysView.remove( value2 );
    assert ( !map1.containsKey( key2 ) );

    // remove a key from the map and see if it is still in the view
    map1.remove( key5 );
    assert ( !keysView.contains( key5 ) );
  }

  /**
   * Make sure that we can insert and fetch something at hash position 0.
   */
  public void testIndex0() {
    map1.put( key0, value1 );
    assertTrue( map1.size() == 2 );
    String value = map1.get( key0 );
    assertTrue( value != null );
    assertTrue( map1.containsKey( key0 ) );
    assertTrue( map1.containsValue( value0 ) );
  }

  public void testResize() {
    map1.put( key0, value1 );
    map1.put( key1, value2 );
    map1.put( key2, value3 );
    map1.put( key3, value4 );
    map1.put( key4, value5 );
    map1.put( key5, value6 );
    map1.put( key6, value7 );
    map1.put( key7, value8 );
    map1.put( key10Duplicate, value9 );

    List<String> expectedValues = new ArrayList<String> ();
    expectedValues.add( value0 );
    expectedValues.add( value1 );
    expectedValues.add( value2 );
    expectedValues.add( value3 );
    expectedValues.add( value4 );
    expectedValues.add( value5 );
    expectedValues.add( value6 );
    expectedValues.add( value7 );
    expectedValues.add( value8 );
    expectedValues.add( value9 );
    java.util.Collection<String> actualValues = map1.values();
//        java.util.Iterator iter = actualValues.iterator();
//        System.out.println( "actual values: " );
//        while ( iter.hasNext() )
//              System.out.println ( iter.next() );
//
//        iter = expectedValues.iterator();
//        System.out.println( "expected values: " );
//        while ( iter.hasNext() )
//              System.out.println ( iter.next() );
    assertTrue( actualValues.containsAll( expectedValues ) );
  }

  /**
   * Assembles and returns a test suite for
   * all the test methods of this test case.
   *
   * @return A non-null test suite.
   */
  public static Test suite() {
    // Reflection is used here to add all
    // the testXXX() methods to the suite.
    TestSuite suite = new TestSuite( HashMapTester.class );
    return suite;
  }

  /**
   * The main show.
   */
  public static void main( String args[] ) {
    String[] testCaseName = {
        HashMapTester.class.getName()};
    //junit.textui.TestRunner.main(testCaseName);
    junit.swingui.TestRunner.main( testCaseName );
    //junit.ui.TestRunner.main(testCaseName);
  }

  public class MyString {
    private String name;
    public MyString( String n ) {
      this.name = n;
    }

    public String name() {
      return this.name;
    }

    public boolean equals( Object other ) {
      return this.name.charAt( 0 ) == ( ( MyString ) other ).name().charAt( 0 );
    }

    public int hashCode() {
      return ( int )this.name.charAt( 0 ) - 65;
    }
  }
}
