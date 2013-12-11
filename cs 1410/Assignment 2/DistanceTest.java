 /*********************************************************** 
 * Programming Assignment 2
 * Distance program
 * Programmer: Mark Eatough
 * Course: CS1410 
 * Created February 2, 2012
 * Modified February 27, 2012
 * Modified by Mark Eatough
 ***********************************************************/ 

import java.util.Scanner;										//call scanner

public class DistanceTest
{
	public static void main(String[] args)
   {
		//initialize variables
		Scanner stringInput = new Scanner(System.in);	
  		char choice;

		DistanceOld myDistance = new DistanceOld();				//call Distance
				
			do	//do-while statement to manage distance 
  			{
				System.out.println("\n    1 . . . Display distance ");
				System.out.println("    2 . . . Add distance ");
         	System.out.println("    3 . . . Subtract distance ");
         	System.out.println("    Press any other key to exit ");
         	choice = stringInput.nextLine().charAt(0);
           
     			switch (choice)
         	{
					
					case '1':  				//display distance								
						System.out.printf("Your current distance is %s\n\n\n", myDistance);
       	   	break;
					
					case '2':  				//add a distance									
						myDistance.addDistance(myDistance);	
					
       	   	break;
            
            	case '3': 				//subtract a distance            		
						myDistance.subDistance(myDistance);
            	break;
				
					default:					//end program
            		System.out.println("Goodbye");
				}
			
			}while("123".indexOf(choice) != -1);//end do-while statement


		
	}
}//end distance test class