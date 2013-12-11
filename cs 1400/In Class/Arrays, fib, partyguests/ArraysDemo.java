import java.util.Arrays;

public class ArraysDemo
{
	public static void main(String[] args)
	{
		int[] iArray = new int[10];
		
		//print iArray
		printArray(iArray);
				
		Arrays.fill(iArray, 7);
		
		//print iArray
		
		printArray(iArray);
	}
	private static void printArray(int[] intArray)
	{
		for (int el : intArray)
		{
			System.out.printf("%d ", el);
		}
		System.out.println();
	}
}