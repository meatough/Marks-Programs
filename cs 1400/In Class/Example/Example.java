 public class Example
{
 	public void example1()
	{
		for (int i = 0; i<3; i++)
		{
			System.out.print("0");
			
			for (int j=0; j>(3-i); j++)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}