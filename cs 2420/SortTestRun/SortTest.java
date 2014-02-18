//CS2420
//Example program to demo VisualVM

import java.util.Random;
//import gray.adts.misc.*;

public class SortTest
{
	private Random random;
	private final int SIZE = 10000;
	Integer[] data = new Integer[SIZE]; 
	
	public SortTest()
	{
		random = new Random();
		for(int i=0; i<SIZE; i++)
			data[i] = random.nextInt(1000);
	}
	 
	public void runTest() throws InterruptedException
	{
			System.out.println("Selection sort...");
			ArrayUtils.selectionSort(data, data.length-1);
			//Thread.sleep(500);
			System.out.println("Merge sort...\n");
			ArrayUtils.mergeSort(data, 0, data.length-1);
			Thread.sleep(500);
	}//end runTest()

}
