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
 
 class FriendContact extends FamilyContact
 {
 	ArrayList<String> friendContacts = new ArrayList<String>();	//initialize students arraylist and initialize with 5 names
   {
   	friendContacts.add("Alex \t\tWingleberry\t801123456789 \t\tmeatough@yahoo.com");
      friendContacts.add("Sally \t\tMuckinfudge\t435123456789 \t\tjmuckin@hotmail.com");
      friendContacts.add("Frank \t\tBerkowitz\t282123456789 \t\tsberks@gmail.com");
      friendContacts.add("John \t\tDoe\t\t801987654321 \t\tjanedoe@yahoo.com");
      friendContacts.add("Jane \t\tDoe\t\t435987654321 \t\tdoujones@hotmail.com");
 	}
		
	public void displayFriendList()  //method to display students array list
  	{
   	System.out.println("\tFirst Name\tLast Name\tPhone Number\t\te-mail");
      
     	int index = 1;
      		
     	for (String c : friendContacts)
    	{
      	System.out.printf("%d\t%s \n", index, c);
        	index++;
     	}
 	}
	
	public void addFriendContact()	//method to add a student to students arraylist
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
      friendContacts.add(newContact);  	
					
 	}//end add student method
   
  	public void deleteFriendContact()	//method to delete student from students arraylist
 	{
    	int contactDelete;
		int arraySize = friendContacts.size();
		displayFriendList();
		int removeContact = Integer.parseInt(JOptionPane.showInputDialog
		("\nOn which line is the contact you would like to delete? (line 1 - %d) ",arraySize));
		
		if (removeContact < 1 || removeContact > arraySize)
      	contactDelete = 1;
    	else
      	contactDelete = removeContact; 
      
     	int index = contactDelete-1;
      System.out.printf("\nFriend Contact: \n%s \nhas been removed.\n\n\n", friendContacts.get(index));
    	friendContacts.remove(friendContacts.get(index));
 	}
   
  	public void findFriendContact()	//mehtod to find and display student from students arraylist
  	{
   	int contactSearch;
     	int arraySize = friendContacts.size();
     	displayFriendList();
      
      System.out.printf("\nSelect the line of the contact you would like to find: (line 1 - %d) ", arraySize);
      int contactFind = input.nextInt();
      
      if (contactFind <1 || contactFind > arraySize)
      	contactSearch = 1;
     	else 
      	contactSearch = contactFind;
      
      int index = contactSearch-1;
      System.out.printf("\n%s \n has been found\n",friendContacts.get(index));
  	}
   
   public void countFriendContacts()	
	{
    	int count = friendContacts.size();
    	System.out.printf("\n%d\n", count);
  	}
	
	public void displayAllContacts()
	{
		System.out.println("\tFirst Name\tLast Name\tPhone Number\t\te-mail");
      
     	int index1 = 1;
      		
     	for (String c : businessContacts)
    	{
      	System.out.printf("%d\t%s \n", index1, c);
        	index1++;
     	}
		
		int index2 = 1;
		
		for (String d : familyContacts)
    	{
      	System.out.printf("%d\t%s \n", index1+index2-1, d);
        	index2++;
     	}
		
		int index3 = 1;
      		
     	for (String e : friendContacts)
    	{
      	System.out.printf("%d\t%s \n", index1+index2+index3-2, e);
        	index3++;
     	}
	}
	
	public void countAllContacts()	
	{
    	int count = businessContacts.size()+familyContacts.size()+friendContacts.size();
    	System.out.printf("\n%d\n", count);
  	}

 }
 