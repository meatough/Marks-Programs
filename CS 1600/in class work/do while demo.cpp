//menu demo

#include<iostream>
#include<cstdlib>

using namespace std;

int main()
{
	char choice;
	
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Menu choice 1" << endl
			<<"2. Menu choice 2" << endl
			<<"3. Menu choice 3" << endl
			<<"4. Exit" << endl << endl
			<<"Your choice: ";
			
			//get a menu choice
			cin >> choice;
			
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
					cout << "Menu choice 1..." << endl;
					system("pause");
					break;
				case'2':
					system("cls");
					cout << "Menu choice 2..." << endl;
					system("pause");
					break;
				case'3':
					system("cls");
					cout << "Menu choice 3..." << endl;
					system("pause");
					break;
				case'4': break;
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end switch
	
	}while(choice != '4');
}//end main