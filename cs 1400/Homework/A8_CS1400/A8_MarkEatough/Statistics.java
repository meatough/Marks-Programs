 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 
 import java.util.Arrays;
 
 public class Statistics
 {
 	public static double min(double[] data)
	{
		double minimumF = 100;
		double minimumT = 0;
		
		for (int i = 1; i< data.length; i++)
		{
			if (data[i] < data[i -1])
			minimumT = data[i];
			else
			minimumT = data[i-1];
			
			if (minimumF < minimumT)
				minimumT = minimumF;
			else
				minimumF = minimumT;
		}
		return minimumF;
	}
	
	
	public static double max(double[] data)
	{
		double maximumT = 0;
		double maximumF = 0;
		
		for (int i = 1; i< data.length; i++)
		{
			if (data[i] > data[i -1])
			maximumT = data[i];
			else
			maximumT = data[i-1];
			
			if (maximumF > maximumT)
				maximumT = maximumF;
			else
				maximumF = maximumT;
		}

		return maximumF;

	}
	
	public static double mean(double[] mean)
	{
		double average = 0;
						
		for (int i = 0; i< mean.length; i++)
		{
			average += mean[i]/mean.length;
		}
		return average;		
	}
	
	public static double median(double[] median)
	{				
		Arrays.sort(median);
		double middle = 0;
		for(int i = 0; i < median.length; i++)
		{
			middle = median[i/2];
		}
		return middle;
	}
 }