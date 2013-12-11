/*********************************************************** 
 * Programming Final Projet											*
 * Contact Program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created May 1, 2012													*
 * Modified May 5, 2012													*
 * Modified by Mark Eatough											*
 ***********************************************************/
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
 class Contact extends JFrame
 {
 	//fields
 	public String firstName;  //contact first name
   {
   }
   
   public String lastName;	//contact last name
   {
   }
	
	public long phoneNumber;	//contact phone number
   {
   }
   	
   public String eMail;		//contact email
   {
   }

   //private int count;			//count of contacts
   //{
   //}
	
	//constructors
	public Contact()//default constructor
	{
		
	}
		
	public Contact(String fN, String lN, long pN, String eM)//int c		parameterized constructor
	{
		firstName = fN;
		lastName = lN;
		phoneNumber = pN;
		eMail = eM;
		//c = count;
	}
	
	//public methods
  	public void setFirstName(String fN)
  	{
   	firstName = fN;
   }
   
   public String getFirstName()
   {
   	return firstName;
   }
   	
 	public void setLastName(String lN)
 	{
   	lastName = lN;
  	}
   
  	public String getLastName()
  	{
   	return lastName;
  	}
	
	public void setPhoneNumber(long pN)
   {
    	phoneNumber = pN;
  	}
   
 	public long getPhoneNumber()
 	{
   	return phoneNumber;
  	}
	
	public void setEmail(String eM)
 	{
   	eMail = eM;
  	}
   
  	public String getEmail()
  	{
   	return eMail;
  	}
	
	@Override
   public String toString()
  	{
   	return String.format("%s\t\t%s\t\t%s\t\t%s",
      	firstName, lastName, phoneNumber, eMail);   
 	}
	
	//button menu
}
 