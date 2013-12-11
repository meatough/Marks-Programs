public class DeMorganExercise
{
	public static void main(String[] args)
	{
		int x = 3;
		int y = 5;
		
		/*********************************************
		*     De Morgan's Law:
		*
		*     !( A && B ) =  ( !A || !B )
      *     !( A || B ) =  ( !A && !B )
		*
		**********************************************/
		
		// Example:
	   System.out.printf("\n%23s = ", "!(x < 5) && !(y >= 7)");  //Original
		System.out.println( !(x < 5) && !(y >= 7) );	
		System.out.printf("%23s = ", "!((x < 5) || (y >= 7))");     //Equivalent
		System.out.println(!((x < 5) || (y >= 7)));	
		
		System.out.printf("\n%23s = ", "!(x == y) || !(y != 5)");   //Original	
		System.out.println(!(x == y) || !(y != 5));	
		System.out.printf("%23s = ", "!((x==y) && (y!5))"); 								   //Equivalent
		System.out.println(!((x==y) && (y !=5)));			

		System.out.printf("\n%23s = ", "!((x > 4) || (y <= 6) )");  //Original
		System.out.println(!((x > 4) || (y <= 6)));
		System.out.printf("%23s = ", "!(x > 4) && !(y <=6)"); 								   //Equivalent
		System.out.println(!(x > 4) && !(y <=6));			
	
		System.out.printf("\n%23s = ", "!(x != 3) && !(y < -2 )");  //Original
		System.out.println(!(x != 3) && !(y <-2));
		System.out.printf("%23s = ", "!((x !=3) && (y <-2))"); 							      //Equivalent
		System.out.println(!((x !=3) && (y <-2)));			
		
		}
}