/*********************************************************** 
 * Programming Assignment 8											*
 * Parking Garage program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
import org.junit.* ;
import static org.junit.Assert.* ;
import junit.framework.TestCase;
//import org.junit.Test;
 
 class ParkingChargesTestSuite
 {
 	@Test
	public void testMaxTen()
	{
		System.out.println(" \n\nTest if calculateCharges has max charge of $10...") ;
		ParkingGarage myParkingGarage = new ParkingGarage();
		assertTrue(myParkingGarage.parkingFee <= 10.0) ;
	}
	
	@Test
	public void testMinTwo()
	{
		System.out.println(" \n\nTest if calculateCharges has min charge of $2...") ;
		ParkingGarage myParkingGarage = new ParkingGarage();
		assertTrue(myParkingGarage.parkingFee >= 2.0);
	}

	/*public static Test Suite() 
	{
 		org.junit suite= new org.junit("All JUnit Tests");
 		suite.addTest(testMaxTen.suite());
 		return suite;
	}*/

 }