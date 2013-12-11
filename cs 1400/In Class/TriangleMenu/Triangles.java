public class Triangles
{
	// field(s)
	
	// constructor(s)
	
	// method(s)
	public void triangleA()
	{
		for (int i = 1; i <= 7; i++)
		{
			for (int j = 1; j <= i; j++)
			    System.out.print("o");
			System.out.println();
		}
	}
	
	public void triangleB()
	{
		for (int i = 7; i >= 1; i--)
		{
			for (int j = 1; j <= i; j++)
				System.out.print("o");
			System.out.println();
		}
	}
	
	public void triangleC()
	{
		for (int i = 1; i <= 7; i++)
		{
			for (int j = 7 - i; j > 0; j-- )
			{
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--)
			{
				System.out.print("o");
			}
			System.out.println();
		}
				
	}
	
	public void triangleD()
	{
		for (int i = 7; i >= 1; i--)
		{
			for (int j = 0; j < 7 - i; j++)
			{
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--)
			{
				System.out.print("o");
			}
			System.out.println();
		}
	}
}