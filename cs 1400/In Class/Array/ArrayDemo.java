public class ArrayDemo
{
	public static void main(String[] args)
	{
		int[] intArray = new int[7];
		intArray[2] = 6;
		intArray[0] = 2;
		intArray[6] = 3;
		
		for (int i = 0; i< 7; i++)
		{
			System.out.printf("%d ", intArray[i]);
		}
	}
}