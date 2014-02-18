import java.util.Collection;
import java.util.Iterator;
import gray.adts.collection.*;
import payable.*;


public class IteratorPayable
{
	public static void main(Sring[] args)
	{
		Collection<Payable> payable = new BasicCollection<Payable>();
		
		payable.add(new Invoice ());
		payable.add(new SalariedEmployee ());
		
		System.out.println("Here are the payables due:");
		Iterator<Payable> iter payable.iterator();
		
		while (iter.hasnext()) 
		{
			System.out.println(iter.hasNext()) 
		}
	}
}