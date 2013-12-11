public class Cloudtest
{
	public static void main(String[] args)
	{
		Cloud myCloud = new Cloud ("Cumulonimbus");
		
		System.out.printf("Cloud classification = %s\n", 
		   myCloud.getcloudClassification());
		
		myCloud.rain();
		
	}
} 