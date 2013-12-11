 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A2 
 ***********************************************************/ 
import java.util.Scanner;

public class A2_MarkEatough
{
	public static void main(String[] args)
	{
      // exmaple 0 done
		System.out.println("Example 0:");
      System.out.print("xxxx\n");
      System.out.print("x  x\n");
      System.out.print("xxxx\n");
      
      // example 1 done
		System.out.println("\n\nExample 1:");
      String name = "Susan";
      int age = 8;
      System.out.printf("Hi, I am %s.\n", name);
		System.out.printf("I am %d years old.", age);
      
      // example 2 done
		System.out.println("\n\nExample 2:");
      int num1 = 7;
		int num2 = 2;
      System.out.printf("%d + %d = %d", num1, num2, num1 + num2);

      // example 3 done 
		System.out.println("\n\nExample 3:");
      int side = 3;
      System.out.printf("The perimeter of a square with side %d is %d", side, side * 4);

      // example 4 done
		System.out.println("\n\nExample 4:");
      int y = 456;
      System.out.printf("3 digit number: %d\nHundreds: %d, Tens: %d, Ones: %d", y, y%1000/100, y%100/10, y%10);

      // example 5 done
		System.out.println("\n\nExample 5:");
      int number1 = 21;
		int number2 = 7;
      if (number1 % number2 == 0)
      {
         System.out.printf("%d is %d times %d", number1, number1/number2, number2 );
      }
      if (number1 % 7 != 0)
      {
         System.out.printf("%d is not a multiple of 7", number1);
      }

      // example 6
		System.out.println("\n\nExample 6:");
      String shape = "triangle";
      if (shape == "triangle")
      {
         System.out.println("o");
         System.out.println("oo");
         System.out.println("ooo");
			System.out.print("oooo");
      }
      		
		// example 7
		System.out.println("\n\nExample 7:");
		Scanner input;
		input = new Scanner(System.in);
		System.out.print("Number1: ");
		int n1 = input.nextInt();
		System.out.print("Number2: ");
		int n2 = input.nextInt();
		System.out.print("Number3: ");
		int n3 = input.nextInt();
		System.out.println("Number\t Square\t Cube");
		System.out.printf("%d \t %d \t %d\n", n1, n1 * n1, n1 * n1 * n1);
		System.out.printf("%d \t %d \t %d\n", n2, n2 * n2, n2 * n2 * n2);
		System.out.printf("%d \t %d \t %d\n", n3, n3 * n3, n3 * n3 * n3);

	}
}