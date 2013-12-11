import java.util.Scanner;

public class TrianglesTest
{
	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		Triangles myTriangles = new Triangles();
		
		System.out.print("Pick a Triangle (1-4): ");
		int choice = input.nextInt();
		
		switch (choice)
		{
			case 1: myTriangles.drawOne();
			break;
			
			case 2: myTriangles.drawTwo();
			break;
			
			case 3: myTriangles.drawThree();
			break;
			
			case 4: myTriangles.drawFour();
			break;
		}
		
	}
}