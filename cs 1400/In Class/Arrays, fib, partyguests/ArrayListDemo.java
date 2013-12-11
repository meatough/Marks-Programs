import java.util.ArrayList;

public class ArrayListDemo
{
	public static void main(String[] args)
	{
		ArrayList<String> destinations = new ArrayList<String>();
		//add three places
		destinations.add("Tokyo");
		destinations.add("Seattle");
		destinations.add("Hawaii\n");
				
		//add (inster a 4th place on index 1
		destinations.add(1, "Alaska");
				
		//print list
		for (String s : destinations)
		{
			System.out.printf("%s \n", s);
		}
		
		//remove a place
		
		destinations.remove("Alaska");
		
		//re-print ArrayList
		for (String s : destinations)
		{
			System.out.printf("%s ", s);
		}

		//test whether destinations include Italy
		boolean containsItaly = destinations.contains("Italy");
		System.out.printf("\nDestinations %s contain Italy", 
			containsItaly ? "does" : "does not");
			
		//find the index of Seattle
		int index = destinations.indexOf("Seattle");
		System.out.printf("\nThe index of Seattle is %d", index);
		
		//print element 2
		System.out.printf("\nDestinion on index 2: %s", destinations.get(2));
		
		//set (change) element 1 and afterwords print it's value again
		destinations.set(1, "Mexico");
		
		//re-re-print ArrayList
		for (String s : destinations)
		{
			System.out.printf("%s ", s);
		}
		
		System.out.printf("\nThe size of the array list is: %d", destinations.size());	
		
		//clear ArrayList and print size again
		destinations.clear();
		
		System.out.printf("\nThe size of the array list is: %d", destinations.size());
	}
}