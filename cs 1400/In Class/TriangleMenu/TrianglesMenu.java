import java.util.Scanner;

public class TrianglesMenu
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Triangles myTriangles = new Triangles();
		char choice;
				
		do
		{
			System.out.println("    A . . . TriangleA ");
			System.out.println("    B . . . TriangleB ");
			System.out.println("    C . . . TriangleC ");
			System.out.println("    D . . . TriangleD ");
			choice = input.nextLine().charAt(0);

		
			switch (choice)
			{
				case 'A': 
				case 'a': 
					myTriangles.triangleA();
				break;
			
				case 'B': 
				case 'b': 
					myTriangles.triangleB();
				break;
			
				case 'C': 
				case 'c': 
					myTriangles.triangleC();
				break;

				case 'D': 
				case 'd': 
					myTriangles.triangleD();
				break;
			
				default:
					System.out.println("The End, okay... \n bye.. \nthats it... \ndo something else now... \n");
					System.out.println("go away please... \nbye.. \ni really mean bye this time... \nbye...");
			}
		}while("aAbBcCdD".indexOf(choice) != -1);
	}
}