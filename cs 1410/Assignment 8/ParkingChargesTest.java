/*********************************************************** 
 * Programming Assignment 8											*
 * Parking Garage program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 import java.util.Scanner; 
 
 class ParkingChargesTest
 {
 	public static void main (String[] args)
	{
		ParkingChargesTestSuite myTestSuite = new ParkingChargesTestSuite();
		 
		//junit.textui.TestRunner.run(ParkingChargesTestSuite.class);
		
		//junit.textui.TestRunner.run (myTestSuite.testMinTwo());


		
		Scanner input;
		input = new Scanner(System.in);
		
		ParkingGarage myParkingGarage = new ParkingGarage();
		
		System.out.println("enter number of hours customer was parked \n");
		myParkingGarage.hoursParked = input.nextDouble();
		
		
		myParkingGarage.calculateCharges(); 
		myTestSuite.testMaxTen();
		myTestSuite.testMinTwo();
	}
 }