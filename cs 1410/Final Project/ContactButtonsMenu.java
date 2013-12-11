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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.JButton;

public class ContactButtonsMenu extends JFrame
{
	private JButton addBusinessContactJButton;
	private JButton deleteBusinessContactJButton;
	private JButton searchBusinessContactJButton;
	private JButton displayBusinessContactJButton;
	private JButton countBusinessContactsJButton;
	
	private JButton addFamilyContactJButton;
	private JButton deleteFamilyContactJButton;
	private JButton searchFamilyContactJButton;
	private JButton displayFamilyContactJButton;
	private JButton countFamilyContactsJButton;
	
	private JButton addFriendContactJButton;
	private JButton deleteFriendContactJButton;
	private JButton searchFriendContactJButton;
	private JButton displayFriendContactJButton;
	private JButton countFriendContactsJButton;
	
	private JButton displayAllContactJButton;
	private JButton countAllContactsJButton;
	
	FriendContact myFriendContact = new FriendContact();

	public ContactButtonsMenu()
	{
		super("Contact Menu Buttons");
		setLayout( new FlowLayout() );//set JFrame Layout
		
		addBusinessContactJButton = new JButton( "Add Business Contacts" );
		add( addBusinessContactJButton );
		
		deleteBusinessContactJButton = new JButton( "Delete Business Contacts" );
		add( deleteBusinessContactJButton );
		
		searchBusinessContactJButton = new JButton( "Search Business Contacts" );
		add( searchBusinessContactJButton );
		
		displayBusinessContactJButton = new JButton( "Display Business Contacts" );
		add( displayBusinessContactJButton );

		countBusinessContactsJButton = new JButton( "Count Business Contacts" );
		add( countBusinessContactsJButton );
		
		addFamilyContactJButton = new JButton( "Add Family Contacts" );
		add( addFamilyContactJButton );
		
		deleteFamilyContactJButton = new JButton( "Delete Family Contacts" );
		add( deleteFamilyContactJButton );
		
		searchFamilyContactJButton = new JButton( "Search Family Contacts" );
		add( searchFamilyContactJButton );
		
		displayFamilyContactJButton = new JButton( "Display Family Contacts" );
		add( displayFamilyContactJButton );

		countFamilyContactsJButton = new JButton( "Count Family Contacts" );
		add( countFamilyContactsJButton );
		
		addFriendContactJButton = new JButton( "Add Friend Contacts" );
		add( addFriendContactJButton );
		
		deleteFriendContactJButton = new JButton( "Delete Friend Contacts" );
		add( deleteFriendContactJButton );
		
		searchFriendContactJButton = new JButton( "Search Friend Contacts" );
		add( searchFriendContactJButton );
		
		displayFriendContactJButton = new JButton( "Display Friend Contacts" );
		add( displayFriendContactJButton );
		
		countFriendContactsJButton = new JButton( "Count Friend Contacts" );
		add( countFriendContactsJButton );
		
		displayAllContactJButton = new JButton( "Display All Contacts" );
		add( displayAllContactJButton );
		
		countAllContactsJButton = new JButton( "Count All Contacts" );
		add( countAllContactsJButton );
		
		ButtonHandler handler = new ButtonHandler();
		
		addBusinessContactJButton.addActionListener(handler);
		deleteBusinessContactJButton.addActionListener(handler);
		searchBusinessContactJButton.addActionListener(handler);
		displayBusinessContactJButton.addActionListener(handler);
		countBusinessContactsJButton.addActionListener(handler);
		
		addFamilyContactJButton.addActionListener(handler);
		deleteFamilyContactJButton.addActionListener(handler);
		searchFamilyContactJButton.addActionListener(handler);
		displayFamilyContactJButton.addActionListener(handler);
		countFamilyContactsJButton.addActionListener(handler);
		
		addFriendContactJButton.addActionListener(handler);
		deleteFriendContactJButton.addActionListener(handler);
		searchFriendContactJButton.addActionListener(handler);
		displayFriendContactJButton.addActionListener(handler);
		countFriendContactsJButton.addActionListener(handler);
		
		displayAllContactJButton.addActionListener(handler);
		countAllContactsJButton.addActionListener(handler);
	}//end Button Constructor
	
	public class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			//JOptionPane.showMessageDialog(ContactButtonsMenu.this, 
			//String.format("You pressed: %s", event.getActionCommand()));
			Object source = event.getSource();
			
			//String string = "";
						
			if(source == addBusinessContactJButton)
			{
				myFriendContact.addBusinessContact();
			}
			
			if(source == deleteBusinessContactJButton)
			{
				myFriendContact.deleteBusinessContact();
			}
			
			if(source == searchBusinessContactJButton)
			{
				myFriendContact.findBusinessContact();
			}
			
			if(source == displayBusinessContactJButton)
			{ 
				myFriendContact.displayBusinessList();
			}
			
			if(source == countBusinessContactsJButton)
			{
				myFriendContact.countBusinessContacts();
			}
			
			if(source == addFamilyContactJButton)
			{
				myFriendContact.addFamilyContact();
			}
			
			if(source == deleteFamilyContactJButton)
			{
				myFriendContact.deleteFamilyContact();
			}
			
			if(source == searchFamilyContactJButton)
			{
				myFriendContact.findFamilyContact();
			}
			
			if(source == displayFamilyContactJButton)
			{ 
				myFriendContact.displayFamilyList();
			}
			
			if(source == countFamilyContactsJButton)
			{
				myFriendContact.countFamilyContacts();
			}
			
			if(source == addFriendContactJButton)
			{
				myFriendContact.addFriendContact();
			}
			
			if(source == deleteFriendContactJButton)
			{
				myFriendContact.deleteFriendContact();
			}
			
			if(source == searchFriendContactJButton)
			{
				myFriendContact.findFriendContact();
			}
			
			if(source == displayFriendContactJButton)
			{ 
				myFriendContact.displayFriendList();
			}
			
			if(source == countFriendContactsJButton)
			{
				myFriendContact.countFriendContacts();
			}
			
			if(source == displayAllContactJButton)
			{ 
				myFriendContact.displayAllContacts();
			}
			
			if(source == countAllContactsJButton)
			{
				myFriendContact.countAllContacts();
			}

		}
	}//end private class
}//end ContactButtonMenu class