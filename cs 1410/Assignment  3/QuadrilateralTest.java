 /*********************************************************** 
 * Programming Assignment 2											*
 * Distance program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
import java.util.Scanner; 

public class QuadrilateralTest
{
 	public static void main(String[] args)
	{
		//initialize variables
		Scanner stringInput = new Scanner(System.in);
  		char choice;
		Trapezoid myTrapezoid = new Trapezoid();
		Parallelogram myParallelogram = new Parallelogram();
		Rectangle myRectangle = new Rectangle();
		Square mySquare = new Square();
		Points myPoints = new Points();
		
			do	//do-while statement to manage distance 
  			{	
				System.out.println("\n    1 . . . Build Trapezoid ");
				System.out.println("    2 . . . Build Parallelogram ");
         	System.out.println("    3 . . . Build Rectangle ");
				System.out.println("    4 . . . Build Square ");
         	System.out.println("    Press any other key to exit ");
         	choice = stringInput.nextLine().charAt(0);
           
     			switch (choice)
         	{	
					case '1':  				//display distance								
						/*buildTrapezoid();
						trapezoidArea();*/
						
						myTrapezoid.buildTrapezoid();
						myTrapezoid.trapezoidArea();
						myTrapezoid.trapezoidPoints();
       	   	break;
					
					case '2':  				//add a distance									
						/*buildParallelogram();
						parallelogramArea();*/
						
						myParallelogram.buildParallelogram();
						myParallelogram.parallelogramArea();	
						myParallelogram.parallelogramPoints();
       	   	break;
            
            	case '3': 				           		
						/*buildRectangle();
						rectangleArea();
						rectanglePoints();*/
						
						myRectangle.buildRectangle();
						myRectangle.rectangleArea();
						//myPoints.rectanglePoints();
						myRectangle.rectanglePoints();
            	break;
					
					case '4': 				//subtract a distance            		
						/*buildSquare();
						squareArea();
						squarePoints();*/
						
						mySquare.buildSquare();
						mySquare.squareArea();
						//myPoints.squarePoints();
						mySquare.squarePoints();
            	break;
					
					default:					//end program
            		System.out.println("Goodbye");
					}
		}while("1234".indexOf(choice) != -1);//end do-while statement
	}
}