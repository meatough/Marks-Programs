/*********************************************************** 
 * Programming Assignment 10
 * Map ADT program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 17, 2013
 * Modified  April 24, 2013
 * Modified by Mark Eatough
 ***********************************************************/ 
 import java.util.Scanner;
 
 //class I created
 
 public class MapApplication
 {
 	static int accountGenerator = 12345;
 
 	public static void main(String[] args)
	{
	
		AVLMap<Integer, AccountRecordSerializable> map = new AVLMap<Integer, AccountRecordSerializable>();
		
		AccountRecordSerializable record; // object to be written to List
      int accountNumber; // account number for record object
      String firstName; // first name for record object
      String lastName; // last name for record object
      double balance; // balance for record object
		
		
		//programatically create 5 accounts to work with
		
		//just need to add accounts to list
		
		//create first account
		accountNumber = 12345;
		firstName = "Sally";
		lastName = "Fudge";
		balance = 11.00;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );
		
		map.put(accountNumber, record);
		
		
		//create second account
		accountNumber = 12346;
		firstName = "Billy";
		lastName = "The Kid";
		balance = 1000000.00;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		map.put(accountNumber, record);
		
		
		//create third account
		accountNumber = 12347;
		firstName = "Jayde";
		lastName = "Rane";
		balance = 2183.57;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		map.put(accountNumber, record);
		
		
		//create fourth account
		accountNumber = 12348;
		firstName = "Bob";
		lastName = "Burke";
		balance = 32456.89;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		map.put(accountNumber, record);
		
		
		//create fifth account
		accountNumber = 12349;
		firstName = "Veng";
		lastName = "Greysen";
		balance = 146.72;
		
		record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );

		map.put(accountNumber, record);		
		
		
		Scanner accountInput = new Scanner(System.in);
		Scanner menuInput = new Scanner(System.in);
		char choice;
		
		do
  	   {
     		System.out.println("\n    1 . . . Add an account ");
        	System.out.println("    2 . . . Delete an account ");
        	System.out.println("    3 . . . Search for an account ");
			System.out.println("    4 . . . Edit An account ");
       	System.out.println("    Press any other key to exit ");
       	choice = menuInput.nextLine().charAt(0);
         
         
     		switch (choice)
       	{
         	case '1':  				//add an account											
						
					System.out.println();
      			System.out.print("Enter new account number: ");
      			accountNumber  = accountInput.nextInt();
	
					
					if(map.containsKey(accountNumber))
					{
						System.out.printf("Account number %d already exists, select 4 to edit account\n\n\n", 
												accountNumber);
					}
					else
					{
					
     					System.out.print("\nEnter account holder's first name: ");
      				firstName  = accountInput.nextLine(); 		
						
						System.out.println();	
					
      				System.out.print("\nEnter account holder's last name: ");
      				lastName  = accountInput.nextLine();
      					
      				System.out.print("\nEnter account balance: ");
      				balance  = accountInput.nextDouble();
  		
						AccountRecordSerializable newRecord; 
		
						newRecord = new AccountRecordSerializable( accountNumber,
               										firstName, lastName, balance );
						
						map.put(accountNumber, newRecord);
					}
          	break;
            
            case '2': 				//delete an account
            	System.out.println();
      			System.out.print("Enter account number of account you would like to delete: ");
      			accountNumber  = accountInput.nextInt();	
					
					//test against keys and call remove method
					if(map.containsKey(accountNumber))
					{
						record = map.remove(accountNumber);
						System.out.printf("Acct#: %d\nName(last, first): %s, %s\nBalance:%.2f\n has been deleted",
               	record.getAccount(), record.getLastName(),
               	record.getFirstName(), record.getBalance() );
					}
					else 
					{
						System.out.printf("Account number %d not found, nothing deleted\n\n\n", 
												accountNumber);
					}
            break;
            
          	case '3':  				//Search for an account
					System.out.println();
      			System.out.print("Enter account number of account you would like to find: ");
      			accountNumber  = accountInput.nextInt();
					
					//test against keys and call contains method
					
					if(map.containsKey(accountNumber))
					{
						record = map.get(accountNumber);
						System.out.println( "\n\n\n\nYour account has been found:");
						System.out.printf("Acct#: %d\nName(last, first): %s, %s\nBalance:%.2f\n",
               	record.getAccount(), record.getLastName(),
               	record.getFirstName(), record.getBalance() );
					}
					else
					{
						System.out.printf("Account number %d does not exist", accountNumber);
					}
         	break;
	
				case '4':  				//Edit an account
      	     	System.out.println();
      			System.out.print("Enter account number of account you would like to edit: ");
      			accountNumber  = accountInput.nextInt();
					
					if(map.containsKey(accountNumber))
					{
						System.out.print("\nEnter new first name: ");
      				firstName  = accountInput.nextLine(); 			
					
      				System.out.print("\nEnter new last name: ");
      				lastName  = accountInput.nextLine();
      					
      				System.out.print("\nEnter new account balance: ");
      				balance  = accountInput.nextDouble();
						
						AccountRecordSerializable editedRecord; 
		
						editedRecord = new AccountRecordSerializable( accountNumber,
                  	firstName, lastName, balance );
							
						map.put(accountNumber, editedRecord);
						
					}
					else
					{
						System.out.printf("Account number %d not found, select 1 to add new account\n\n\n", 
												accountNumber);
					}
       	 	break;
					            
        	  	default:
        			System.out.println("Goodbye");
       	}
 		}while("1234".indexOf(choice) != -1);
		//end do while loop
	}//end main method
 }//end test class