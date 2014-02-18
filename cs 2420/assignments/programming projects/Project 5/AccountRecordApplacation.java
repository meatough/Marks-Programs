/*********************************************************** 
 * Programming Assignment 5
 * Account records program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created February 27, 2013
 * Modified March 6, 2013
 * Modified by Mark Eatough
 ***********************************************************/
import java.util.*;
import java.util.List;
import java.util.ListIterator;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class AccountRecordApplacation implements Serializable
{
 	public static void main(String[] args)
	{	
		LinkedList<AccountRecordSerializable> accounts = new LinkedList<AccountRecordSerializable>();	
		ListIterator<AccountRecordSerializable> iter;
						
		AccountRecordSerializable record; // object to be written to List
      int accountNumber; // account number for record object
      String firstName; // first name for record object
      String lastName; // last name for record object
      double balance; // balance for record object
		
		ObjectOutputStream output;	//create new output stream object
		ObjectInputStream input;	//create new input stream object
		
		//create first account
		accountNumber = 12345;
		firstName = "Sally";
		lastName = "Fudge";
		balance = 11.00;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		accounts.add(record);
		
		
		//create second account
		accountNumber = 22345;
		firstName = "Billy";
		lastName = "The Kid";
		balance = 1000000.00;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		accounts.add(record);
		
		
		//create third account
		accountNumber = 32345;
		firstName = "Jayde";
		lastName = "Rane";
		balance = 2183.57;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		accounts.add(record);
		
		
		//create fourth account
		accountNumber = 42345;
		firstName = "Bob";
		lastName = "Burke";
		balance = 32456.89;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		accounts.add(record);
		
		
		//create fifth account
		accountNumber = 52345;
		firstName = "Veng";
		lastName = "Greysen";
		balance = 146.72;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		accounts.add(record);		
		

		
		//Print List using foreward traversal
		System.out.println("Display of entire list by traversing head to tail: \n");
		System.out.println("\taccount\t\tFirst Name\tLast Name\tBalance");
		iter = accounts.listIterator();
		
		while(iter.hasNext())
		{
			record = iter.next();
			System.out.printf( "\t%d\t\t%s\t\t%s\t\t%.2f\n",
               record.getAccount(), record.getFirstName(),
               record.getLastName(), record.getBalance() );
		}
		
		//Print List using backward traversal
		System.out.println("\n\nDisplay of entire list by traversing tail to head: \n");
		System.out.println("\taccount\t\tFirst Name\tLast Name\tBalance");
		iter = accounts.listIterator(accounts.size());
		
		while(iter.hasPrevious())
		{
			record = iter.previous();
			System.out.printf( "\t%d\t\t%s\t\t%s\t\t%.2f\n",
               record.getAccount(), record.getFirstName(),
               record.getLastName(), record.getBalance() );
		}
		
		//create sublist of indicies 1 - 3
		List <AccountRecordSerializable> subAcc = accounts.subList(1,4);
		//print sublist using foreward traversal
		System.out.println("\n\nDisplay of sublist of indicies 1-3 by traversing head to tail: \n");
		System.out.println("\taccount\t\tFirst Name\tLast Name\tBalance");
		iter = subAcc.listIterator();
		
		while(iter.hasNext())
		{
			record = iter.next();
			System.out.printf( "\t%d\t\t%s\t\t%s\t\t%.2f\n",
               record.getAccount(), record.getFirstName(),
               record.getLastName(), record.getBalance() );
		}
		
		//write to disk
		try
      {
   		//open file      
			output = new ObjectOutputStream(
            new FileOutputStream( "clients.ser" ) );
			
			//write file to disk
			iter = accounts.listIterator();
		
			while(iter.hasNext())
			{
				record = iter.next();
				output.writeObject(record);
			}
			
			//close file
			if ( output != null )
            output.close();
				
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error opening, writing or closing file." );
      } // end catch
		catch ( NoSuchElementException elementException )
      {
      	System.err.println( "Invalid input. System fail" );
      } // end catch
		
		//create new LinkedList object
		LinkedList<AccountRecordSerializable> savedAccounts = new LinkedList<AccountRecordSerializable>();
		
		//read from disk
		try 
      {
			//open file
         input = new ObjectInputStream(
            new FileInputStream( "clients.ser" ) );
			
			while ( true )
         {
            record = ( AccountRecordSerializable ) input.readObject();
				savedAccounts.add(record);
			}			
      } // end try
      catch ( IOException ioException )
      {
         System.err.println();
      } // end catch
		
		catch ( ClassNotFoundException classNotFoundException )
      {
         System.err.println( "Unable to create object." );
      } // end catch
		
		//Print List using foreward traversal
		System.out.println("\nDisplay of list created from disk by traversing head to tail: \n");
		System.out.println("\taccount\t\tFirst Name\tLast Name\tBalance");
		iter = savedAccounts.listIterator();
		
		while(iter.hasNext())
		{
			record = iter.next();
			System.out.printf( "\t%d\t\t%s\t\t%s\t\t%.2f\n",
               record.getAccount(), record.getFirstName(),
               record.getLastName(), record.getBalance() );
		}
	}//end main method
}//end application class