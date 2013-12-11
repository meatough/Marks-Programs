 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 

public class Examples1
{
	//field
	
	public static double euroConversionRate = 0.69;
	
	//methods
	
	public static void createPalindrome(String word)
	{
		System.out.printf("%s", word);
		for (int i = word.length()-2; i>=0; i--)
		{
			System.out.printf("%s", word.charAt(i));
		}		
	}	
	public static void displayConeInfo(double height, double radius)
	{
		System.out.printf("Surface Area: %.2f\n",
		Math.PI * radius * Math.hypot(radius, height) + Math.PI * radius * radius);
		
		System.out.printf("Volume: %.2f\n", 
		radius * radius * height * Math.PI / 3);
	}

	public static double convertToEuros(double dollars)
	{
		return dollars;
	}
	
	public static void setEuroConversionRate(double myRate)
	{
		if (myRate > 0)
		{
		euroConversionRate = myRate;
		}
	}
}
	