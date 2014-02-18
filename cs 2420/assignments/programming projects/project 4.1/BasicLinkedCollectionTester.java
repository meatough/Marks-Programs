 /*********************************************************** 
 * Programming Assignment 4
 * Basic Linked Collection program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created February 13, 2013
 * Modified February 20, 2013
 * Modified by Mark Eatough
 ***********************************************************/

import junit.framework.*;
import junit.extensions.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.AbstractCollection;

public class BasicLinkedCollectionTester extends TestCase 
{
	//Collection<String> movies = new BasicLinkedCollection<String>(); 
	Collection cEmpty = new BasicLinkedCollection();
	Collection<String> movies= new BasicLinkedCollection<String>();
	//movies.add("Inception");
		
	/*public BasicLinkedCollectionTester( String name )
	{
    	super( name );
  	}*/

	//set up method
	protected void setUp() 
	{ 
    	movies.add(new String("Inception"));
    	movies.add(new String("Insomnia"));
    	movies.add(new String("Memento"));
		Collection nolanMovies = new BasicLinkedCollection(); 
		nolanMovies.addAll(movies);
 	}								
	
	
	//tear down method
	protected void tearDown() 
	{
    	movies = null;
  	}
	
	//method to test empty default collection
	public void testInstantiate() 
	{
    	assertEquals( cEmpty.size(), 0 );
    	assertTrue( cEmpty.isEmpty() );
  	}
	
	public void testSetUpCollection() 
	{
		assertEquals( "verify size after the 3 add ops", movies.size(), 3 );
    	assertTrue( !movies.isEmpty() );
    	assertTrue( movies.contains("Inception"));
    	assertTrue( movies.contains("Insomnia"));
    	assertTrue( movies.contains("Memento"));
    	assertTrue( !movies.contains( "Missing" ) );
  	}
	
	public void testAddElement() 
	{
    	assertTrue( movies.add( "The Prestige" ) );
		assertEquals( movies.size(), 4 );
    	assertTrue( movies.contains( "Inception" ) );
    	assertTrue( movies.contains( "Insomnia" ) );
    	assertTrue( movies.contains( "Memento" ) );
		assertTrue( movies.contains( "The Prestige" ) );
    	assertTrue( !movies.contains( "Missing" ) );
  	}
	
	public void testRemoveUniqueElement() 
	{
    	assertTrue( movies.remove( "Insomnia" ) );
    	assertEquals( movies.size(), 2 );
    	assertTrue( !movies.contains( "Insomnia" ) );
    	assertTrue( !movies.isEmpty() );
  	}
	
	public void testRemoveAllElements()
	{
		assertTrue(movies.removeAll(movies));
		assertTrue(movies.isEmpty());
		assertTrue( !movies.contains( "Inception" ) );
    	assertTrue( !movies.contains( "Insomnia" ) );
    	assertTrue( !movies.contains( "Memento" ) );
	}
	
	public void addAllElements()
	{
		Collection c = new BasicLinkedCollection();
		assertTrue( c.addAll (movies));
		assertEquals( "verify size after the 3 add ops", c.size(), 3 );
    	assertTrue( !c.isEmpty() );
    	assertTrue( c.contains( "Inception" ) );
    	assertTrue( c.contains( "Insomnia" ) );
    	assertTrue( c.contains( "Memento" ) );
    	assertTrue( !c.contains( "Missing" ) );
	}
	
	public void testSize()
	{
		assertEquals("verify size of empty collection", cEmpty.size(), 0 );
		assertEquals( "verify size after the 3 add ops", movies.size(), 3 );
		assertTrue( movies.add( "The Prestige" ) );
		assertEquals( "verify size after one more add op", movies.size(), 4 );
		assertTrue( movies.remove( "Inception" ) );
    	assertEquals( "verify size after remove op",movies.size(), 3 );
		assertTrue(movies.removeAll(movies));
		assertEquals( "verify size after removeall op",movies.size(), 0 );
	}

	public static TestSuite suite()
	{
		return new TestSuite(BasicLinkedCollectionTester.class);
	}	
		
	public static void main (String[] args) 
	{
		String[] TestCaseName = {BasicLinkedCollectionTester.class.getName()};
		junit.textui.TestRunner.main(TestCaseName);
	}//end main method
}//end BasicLinkedCollectionTest