public class CatTest
{
	public static void main(String[] args)
	{
		//create cat object
		Cat myCat = new Cat("Garfield");
		
		//print myCat info
		System.out.printf("\nName = %s, miceCount = %d", 
		  myCat.getName(), myCat.getMiceCount());
		  
		// catch some mice
		myCat.catchMice (2);
		myCat.catchMice (3);

		
		//my cat info
		System.out.printf("\nName = %s, miceCount = %d", 
		  myCat.getName(), myCat.getMiceCount());
	}
}