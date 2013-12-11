/*********************************************************** 
 * Pairded Distance Project
 * DistanceTest
 * Programmers:	Mark Eatough
 *						Derek Moulton
 *						Bryce Wengren
 * Course: 		CS 1600 
 * Created 		April 18, 2013
 * Modified:	April 25, 2013
 ***********************************************************/
#include "Distance.cpp"



int main()
{
	Distance d1;
	d1.showDistance();
	
	Distance d2(14, 11);
	d2.showDistance();
	
	d1.setFeet(1000);
	d1.setInches(5.5);
	
	d1.showDistance();
	
	cout << "Today I ran a whole " << d1.getFeet() << " feet and " 
			<< d1.getInches() << " inches and I didn't die" << endl;
	
	//char object used for selection in do while loop
	char choice;
	//int and double objects to be used in do while loop
	//int ft;
	//double in;
	//distance objects to be used in add/subtract methods
	Distance d3;
	Distance d4;
	Distance d5;
	Distance perimeter;
	Distance area;
	
	Distance a0(18,10);
	Distance a1(3,11);
	Distance a2(26,5);
	Distance a3(32,8);
	Distance a4(11,2);
	Distance a5(9,0);
	//distance array object 
	Distance distArray[6] = {	a0, a1, a2, a3, a4, a5};
	//object for distArray total
	Distance tot;
	
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Add Two Distances" << endl
			<<"2. Subtract Two Distances" << endl
			<<"3. Sum an array of Distances" << endl
			<<"4. Plot an array of distances as a bar graph" << endl
			<<"5. Calculate the perimeter and area of a rectangle" << endl
			<<"6. Exit" << endl << endl
			<<"Your choice: ";
			
			//get a menu choice
			cin >> choice;
						
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
					cout << "\n\nEnter first Distance" << endl;
					cin >> d3;
					
					cout << "\n\nEnter second Distance" << endl;
					cin >> d4;
					
					
					d5 = d3 + d4;
					
					cout << "\n\n\nYour total distance is " << d5;
					system("pause");
					break; 
					
				case'2':
					system("cls");
					
					cout << "\n\nEnter first Distance" << endl;
					cin >> d3;
					
					cout << "\n\nEnter second Distance" << endl;
					cin >> d4;
					
					d5 = d3-d4;
					
					cout << "Your total distance is " << d5;
					
					system("pause");
					break;
					
				case'3':
					system("cls");
					//print array
					for(int i = 0; i < 6; i++)
					{
						cout << distArray[i] << endl;
					}
					
					for(int j = 0; j < 6; j++)
					{
						tot = tot+distArray[j];
					}
					
					cout <<  "Your total Distance is: " << tot;
					
					system("pause");
					break;
					
				case'4':
					system("cls");
					
					cout << "\n\n\n" << endl;
					for(int i = 0; i < 6; i++)
					{
						cout << distArray[i] << "\t";
						
						for(int j = 0; j < convertToInches(distArray[i])/10; j++)
						{
							cout << "*";
						}
						cout << endl;
					}


					system("pause");
					break;
					
				case'5':
					system("cls");
					
					cout << "\n\nEnter length of rectangle" << endl;
					cin >> d3;
					
					cout << "\n\nEnter width of rectangle" << endl;
					cin >> d4;					
					perimeter = d3+d3+d4+d4;
					
					area = d3*d4;
					
					cout << "Your perimeter is: " << perimeter << endl;
					cout << "Your area is: " << area << endl;
					
											
					system("pause");
					break;
					
				case'6': break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end switch
	
	}while(choice != '6');
	return 0;
}