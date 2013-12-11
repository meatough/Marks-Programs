import java.util.Scanner;

public class RectangleTest
{
	public static void main(String[] args) 
	{			
	
		Scanner input;
		input = new Scanner(System.in);
	
		Rectangle myRectangle=new Rectangle();
		
		System.out.print("length: ");
		int length = input.nextInt();
		System.out.print("width: ");
		int width = input.nextInt();
		
		myRectangle.setLength(length);
		myRectangle.setWidth(width);
		
		System.out.printf("Length = %d Width = %d\n", 
				myRectangle.setLength(), myRectangle.setWidth());
		myRectangle.displayArea();
		
	}
}