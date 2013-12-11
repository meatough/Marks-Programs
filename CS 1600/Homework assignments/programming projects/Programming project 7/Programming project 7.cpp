/*********************************************************** 
 * Programming Assignment 7
 * Arrays part 2
 * Programmers: Mark Eatough
 * Course: CS 1600 
 * Created March 7, 2013
 
 *This program creates an array of 100 random integers 
 *between 1 and 100.  It them displays the smallest and 
 *largest numbers of the array, and sort the array in 
 *ascending order.  Through the program we can also generate 
 *a random number and check to see if it is found in the 
 *array.  The program is run through a simple menu. 
 ***********************************************************/
 
#include<iostream>

using namespace std;

//create function prototypes
void populateArray(int [], int);
void printArray(int [], int);
void sortArray(int [], int);
int generateRandom();
int findMax(int [], int);
int findMin(int [], int);
int findInt(int [], int, int);


//main function
int main()
{
	const int capacity = 100;
	int randArray [capacity];
	int maximum;
	int minimum;
	int target;
	int index;
	
	char choice;
	
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Populate Array" << endl
			<<"2. Print Array" << endl
			<<"3. Find Maximum" << endl
			<<"4. Find Minimum" << endl
			<<"5. Sort Array" << endl
			<<"6. Search Array" << endl
			<<"7. Exit" << endl << endl
			<<"Your choice: ";
			
			//get a menu choice
			cin >> choice;
						
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
					
					populateArray(randArray, capacity);

					system("pause");
					break;
					
				case'2':
					system("cls");
					
					printArray(randArray, capacity);

					system("pause");
					break;
					
				case'3':
					system("cls");
					
					maximum = findMax(randArray, capacity);
					cout << "Maximum of array = " <<maximum << endl;
					
					system("pause");
					break;
					
				case'4':
					system("cls");
					
					minimum = findMin(randArray, capacity);
					cout << "Minimum of array = " <<minimum << endl;

					system("pause");
					break;
					
				case'5':
					system("cls");
					
						sortArray(randArray, capacity);
											
					system("pause");
					break;
					
				case '6':
					system("cls");
					
					sortArray(randArray, capacity);
					
					target = generateRandom();
					
					index = findInt(randArray, capacity, target);
					if(index != -1)
					{
						cout << "your number " << target << " has been found at position " 
							<< index << endl;
					}
					else
					{
						cout << target << " does not exist in this array." << endl;
					}


					system("pause");
					break;

					
				case'7': break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end switch
	
	}while(choice != '7');
}//end main


//implement populateArray method
void populateArray(int random [], int cap)
{
	int element;
	
	for(int i = 0; i < cap; i++)
	{
		element = generateRandom();
		random[i] = element;
	}

}//end populateArray method

//implement printArray method
void printArray(int random [], int cap)
{
	for(int i = 0; i < cap; i++)
	{
		cout << random[i] << endl;
	}
}//end printArray method

//implement sortArray method
void sortArray(int random [], int cap)
{
	int i, j, min, minidx, temp;

  	for ( i = 0; i < (cap - 1); i++)
  	{
    	min = random[i];   // assume minimum is the first array element
    	minidx = i;     // index of minimum element
    	
		for(j = i + 1; j < cap; j++)
    	{
      	if (random[j] < min)   // if you've located a lower value
      	{                   // capture it
      		min = random[j];
      		minidx = j;
      	}
    	}//end inner for loop
    	if (min < random[i])  // check whether you have a new minimum
    	{                  // and if you do, swap values
      	temp = random[i];
      	random[i] = min;
      	random[minidx] = temp;
    	}
  	}//end outer for loop
}//end sortArray method

//method to generate a random element 1-100
int generateRandom()
{
	int element = rand()%100+1;
	return element;
}//end generateRandom method

//implement findMax method
int findMax(int random [], int cap)
{
	int max = 0;
	
	for(int i = 0; i < cap; i++)
	{
		if(max < random[i])
		{
			max = random[i];
		}
	}
	return max;
}//end findMax method

//implement findMin method
int findMin(int random [], int cap)
{
	int min = 101;
	
	for(int i = 0; i < cap; i++)
	{
		if(min > random [i])
		{
			min = random [i];
		}
	}
	return min;
}//end findMin method

//implement findInt method
int findInt(int random [], int cap, int target)
{
	//Find integer using binary search
	if(target < random[cap/2])
	{
		for (int i = cap/2; i >= 0; i--)
		{
			if (target == random [i])
			{
				return i;
			}
		}//end for statement
	}//end if statement
	
	else
	{
		for (int j  = cap/2; j < cap; j++)
		{
			if (target == random [j])
			{
				return j;
			}
		}//end for statement
	}
	return -1;
}//end findInt method