/*********************************************************** 
 * Programming Assignment 8											*
 * Parking Garage program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/
 
   class ParkingGarage
   {
   //fields
      public double hoursParked;
      public double parkingFee = 2;
   
   //methods
      public double calculateCharges()
      {	     
			if(hoursParked > 3)
			{
				hoursParked = Math.ceil(hoursParked);
				
				parkingFee += ((hoursParked-3)*0.5);
				
				if(parkingFee <= 10)      
        	 	{
					parkingFee = parkingFee;
				}
				
				else
				{
					parkingFee = 10;
				}
			}			
			System.out.printf("Customer will be charged $%.2f for the day.", parkingFee);
			return parkingFee;
      }
   }