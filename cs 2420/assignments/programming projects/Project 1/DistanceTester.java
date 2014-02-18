 /*********************************************************** 
 * Programming Assignment 1
 * Distance program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created January 28, 2013
 * Modified January 31, 2013
 * Modified by Mark Eatough
 ***********************************************************/

import junit.framework.*;
import junit.extensions.*;

public class DistanceTester extends TestCase
{
	private Distance d1, d2, d3;	
		
		 //Setup for all tests
      public void setUp() 
		{
			d1 = new Distance();
			d2 = new Distance(3,3);
			d3 = new Distance(-3,3);	//intantiate illegal distance to test add/sub methods
      }
		
		//tear down for all tests
		protected void tearDown()
		{
			d1 = null;
			d2 = null;
			d3 = null;
		}
		
		//Test Case 1: 
		public void testInstantiateDefault()
		{
			Assert.assertEquals( 1, d1.getFeet() );
			Assert.assertEquals( 1, d1.getInches() );
		}
		
		//Test Case 2
		
		public void testInstantiateClient()
		{
			Assert.assertEquals( 3, d2.getFeet() );
			Assert.assertEquals( 3, d2.getInches() );
		}
				
		//Test Case 3
		
		public void testFeetMutatorLegal()
		{
			d2.setFeet(7);
			Assert.assertEquals(7, d2.getFeet());
		}
		
		//Test Case 4
		
		public void testInchesMutatorLegal()
		{
			d2.setInches(9);
			Assert.assertEquals(9, d2.getInches());
		}


		//Test Case 5
		
		public void testFeetMutatorIllegal()
		{
			try
			{
				d2.setFeet(-3);					//negative number illegal, exception should be thrown
				
				Assert.fail("Should raise IllegalArgumentException");
			}
			
			catch(IllegalArgumentException e)
			{
				Assert.assertTrue(true); //expected an exception so the test passes
				
			}
		}	
		
		//Test Case 6
		
		public void testInchesMutatorIllegal()
		{
			try
			{
				d2.setInches(-3);					//negative number illegal, exception should be thrown
				
				Assert.fail("Should raise IllegalArgumentException");
			}
			
			catch(IllegalArgumentException e)
			{
				Assert.assertTrue(true); //expected an exception so the test passes
				
			}
		}	
		
		//Test Case 7
		
		public void testGetDistance()
		{
			Assert.assertEquals( 39, d2.getDistance() );
		}
		
		//Test Case 8
		
		public void testAddMethodLegal()
		{
			d2.addDistance(d1);
			Assert.assertEquals(52, d2.getDistance());	
		}
		
		//Test Case 9
		
		public void testSubMethodLegal()
		{
			d2.subDistance(d1);
			Assert.assertEquals(26, d2.getDistance());	
		}
		
		//Test Case 10
		
		public void testAddMethodIllegal()
		{
			try
			{
				d2.addDistance(d3);					//negative number illegal, exception should be thrown
				
				Assert.fail("Should raise IllegalArgumentException");
			}
			
			catch(IllegalArgumentException e)
			{
				Assert.assertTrue(true); //expected an exception so the test passes				
			}			
		}
		
		//Test Case 11
		
		public void testSubMethodIllegal()
		{
			
			try
			{
				d2.subDistance(d3);					//negative number illegal, exception should be thrown
				
				Assert.fail("Should raise IllegalArgumentException");
			}
			
			catch(IllegalArgumentException e)
			{
				Assert.assertTrue(true); //expected an exception so the test passes				
			}			
	
		}
		
		public static TestSuite suite()
		{
			return new TestSuite(DistanceTester.class);
			
		}	
		
		 public static void main (String[] args) 
		 {
			String[] TestCaseName = {DistanceTester.class.getName()};
			junit.textui.TestRunner.main(TestCaseName);
		 }//end main method
}//end class