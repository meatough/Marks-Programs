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
 
public class ContactTest
{
	public static void main(String[] args)
 	{	
			
      // call class
		//BusinessContact myBusinessContact = new BusinessContact();
		//myBusinessContact.addBusinessContact();
   	ContactButtonsMenu myButtons = new ContactButtonsMenu();
		myButtons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myButtons.setSize(950 , 200);
		myButtons.setVisible(true);
  	}//end main method
 }
 
 