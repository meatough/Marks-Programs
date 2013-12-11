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
 
 class FamilyContact extends BusinessContact
 {
 	ArrayList<String> familyContacts = new ArrayList<String>();	//initialize students arraylist and initialize with 5 names
   {
   	familyContacts.add("Steven \t\tWarren\t\t801123456789 \t\tswarren@yahoo.com");
      familyContacts.add("Mike \t\tWarren\t\t435123456789 \t\tmwarren@hotmail.com");
      familyContacts.add("Chris \t\tWarren\t\t282123456789 \t\tcwarren@gmail.com");
      familyContacts.add("Matt \t\tWarren\t\t801987654321 \t\tmattwarren@yahoo.com");
      familyContacts.add("Dan \t\tWarren\t\t435987654321 \t\tdwarren@hotmail.com");
 	}
		
	public void displayFamilyList()  //method to display students array list
  	{
   	System.out.println("\tFirst Name\tLast Name\tPhone Number\t\te-mail");
      
     	int index = 1;
      		
     	for (String c : familyContacts)
    	{
      	System.out.printf("%d\t%s \n", index, c);
        	index++;
     	}
 	}
	
	public void addFamilyContact()	//method to add a student to students arraylist
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
      familyContacts.add(newContact);
			
 	}//end add student method
   
  	public void deleteFamilyContact()	//method to delete student from students arraylist
 	{
    	int contactDelete;
		int arraySize = familyContacts.size();
		displayFamilyList();
		int removeContact = Integer.parseInt(JOptionPane.showInputDialog
		("\nOn which line is the contact you would like to delete? (line 1 - %d) ",arraySize));
		
		if (removeContact < 1 || removeContact > arraySize)
      	contactDelete = 1;
    	else
      	contactDelete = removeContact; 
      
     	int index = contactDelete-1;
      System.out.printf("\nFamily Contact: \n%s \nhas been removed.\n\n\n", familyContacts.get(index));
    	familyContacts.remove(familyContacts.get(index));
 	}
   
  	public void findFamilyContact()	//mehtod to find and display student from students arraylist
  	{
   	int contactSearch;
     	int arraySize = familyContacts.size();
     	displayFamilyList();
      
      System.out.printf("\nSelect the line of the contact you would like to find: (line 1 - %d) ", arraySize);
      int contactFind = input.nextInt();
      
      if (contactFind <1 || contactFind > arraySize)
      	contactSearch = 1;
     	else 
      	contactSearch = contactFind;
      
      int index = contactSearch-1;
      System.out.printf("\n%s \n has been found\n",familyContacts.get(index));
  	}
   
   public void countFamilyContacts()	//method to count the number of students in students arraylist
   {
    	int count = familyContacts.size();
    	System.out.printf("\n%d\n", count);
  }
 }
 