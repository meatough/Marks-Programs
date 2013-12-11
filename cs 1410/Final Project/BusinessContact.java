/*********************************************************** 
 * Programming Final Projet											*
 * Contact Program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created May 1, 2012													*
 * Modified May 5, 2012													*
 * Modified by Mark Eatough											*
 ***********************************************************/
import java.util.Scanner;
import java.util.ArrayList; 

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
class BusinessContact extends Contact
{
	String newContact;
	Scanner input = new Scanner(System.in);
	Scanner stringInput = new Scanner(System.in);
	
	//String str = "\tFirst Name\tLast Name\tPhone Number\t\te-mail";
	
	//JTextField textField1;
	//char choice;
			
	ArrayList<String> businessContacts = new ArrayList<String>();	//initialize students arraylist and initialize with 5 names
   {
   	businessContacts.add("Tom \t\tRowley\t\t801123456789 \t\tmeatough@yahoo.com");
      businessContacts.add("Travis \t\tCasey\t\t435123456789 \t\tjmuckin@hotmail.com");
      businessContacts.add("Arron \t\tEngland\t\t282123456789 \t\tsberks@gmail.com");
      businessContacts.add("Mark \t\tOveson\t\t801987654321 \t\tjanedoe@yahoo.com");
      businessContacts.add("Brian \t\tBasset\t\t435987654321 \t\tdoujones@hotmail.com");
 	}
	
	public void displayBusinessList()  //method to display students array list
  	{
		System.out.println("\tFirst Name\tLast Name\tPhone Number\t\te-mail");
      
     	int index = 1;
      		
     	for (String c : businessContacts)
    	{
      	System.out.printf("%d\t%s \n", index, c);
        	index++;
     	}
 	}
	
	public void addBusinessContact()	//method to add a student to students arraylist
   {	
		String firstName = JOptionPane.showInputDialog("Enter contact's first name");
		String lastName = JOptionPane.showInputDialog("Enter contact's last name");
		long phoneNumber = Long.parseLong(JOptionPane.showInputDialog("Enter contact's phone number"));
		String eMail = JOptionPane.showInputDialog("Enter contact's e-mail address");
		
		setFirstName (firstName);
      setLastName (lastName);
      setPhoneNumber (phoneNumber);
      setEmail (eMail);
      
	   newContact = toString();
      businessContacts.add(newContact);			
 	}//end add student method
   
  	public void deleteBusinessContact()	//method to delete student from students arraylist
 	{
		int contactDelete;
		int arraySize = businessContacts.size();
		displayBusinessList();
		int removeContact = Integer.parseInt(JOptionPane.showInputDialog
		("\nOn which line is the contact you would like to delete? (line 1 - %d) ",arraySize));
		
		if (removeContact < 1 || removeContact > arraySize)
      	contactDelete = 1;
    	else
      	contactDelete = removeContact; 
      
     	int index = contactDelete-1;
      System.out.printf("\nBusiness Contact: \n%s \nhas been removed.\n\n\n", businessContacts.get(index));
    	businessContacts.remove(businessContacts.get(index));
    }
   
  	public void findBusinessContact()	//mehtod to find and display student from students arraylist
  	{
   	int contactSearch;
     	int arraySize = businessContacts.size();
     	displayBusinessList();
      
      System.out.printf("\nSelect the line of the contact you would like to find: (line 1 - %d) ", arraySize);
      int contactFind = input.nextInt();
      
      if (contactFind <1 || contactFind > arraySize)
      	contactSearch = 1;
     	else 
      	contactSearch = contactFind;
      
      int index = contactSearch-1;
      System.out.printf("\n%s \n has been found\n",businessContacts.get(index));
  	}
   
   public void countBusinessContacts()	//method to count the number of students in students arraylist
   {
    	int count = businessContacts.size();
    	System.out.printf("\n%d\n", count);
  }
}
 