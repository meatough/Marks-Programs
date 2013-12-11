/*********************************************************** 
 * Programming Assignment 8
 * Grades I/O
 * Programmers: Mark Eatough
 * Course: CS 1600 
 * Created March 26, 2013
 
 *This program creates a multidimensional array, reads in 
 *grades from a text file, then figures out an average and 
 *a weighted average. Then the program will arrange averages 
 *so that smallest is fist, and largest is last.
 ***********************************************************/
 
 //PGM7-8.cpp and 7-18.cpp for sorting example
 //3 steps to read/write from file
 //1. open file
 //2. read/write file
 //3. close file
 //PGM8-5.cpp good read file example
 //PGM8-8.cpp good write file example
 
#include<iostream>
#include<fstream>
#include<iomanip>
#include <cstdlib>
#include <string>
using namespace std;

//create constant variables for rows and columns
const int ROWS = 5;
const int COLS = 7;

//function prototype
void display(int [ROWS] [COLS]);
void calcAve(int [ROWS] [COLS]);
void calcWtAve(int [ROWS] [COLS]);
void sortArray(int[ROWS][COLS]);
void writeFile(ofstream&, int[ROWS][COLS]);    

//main function
int main()
{
	//create array object
	int grades[ROWS][COLS];
	
	//read from file
	string filename = "grades.txt";
	int gradeIn;
	int gradeOut;
	ifstream inFile;
	
	inFile.open(filename.c_str());
	
	if (inFile.fail())  // check for successful open
  	{
    	cout << "\nThe file was not successfully opened"
         	<< "\n Please check that the file currently exists."
         	<< endl;
    	exit(1);
  	}
	
	//populate array with data from text file
	inFile >> gradeIn;
	while(!inFile.eof())
  	{
		int rownum, colnum, i = 1;
		for(rownum = 0; rownum < ROWS; rownum++)
		{
			for(colnum = 0; colnum < 5; colnum++)
			{
				if (colnum == 0)
				{
					grades[rownum][colnum] = i;
					i++;
					colnum++;
				}
				grades[rownum][colnum] = gradeIn;
				inFile >> gradeIn;
			}
		}
		
  	}
	//close the file we were reading from
	inFile.close();
	
	calcAve(grades);			//put average grades into array
	calcWtAve(grades);		//put average weighted grades into array
	display(grades);			//display all grades
	
	cout << "\n\n\n" << endl;
	
	sortArray(grades);		//sort the array in descending order
	display(grades);			//display all grades after sorting
	

	//write to file
	string fname = "final_grades.txt";
	
	ofstream outFile;	

  	outFile.open(fname.c_str());

  	if (outFile.fail())   // check for a successful open
  	{
   	cout << "\nThe output file " << fname << " was not successfully opened"
      		<< endl;
    	exit(1);
  	}
	
	//outFile << gradeOut;
	int rownum, colnum;
	
	for(rownum = 0; rownum < ROWS; rownum++)
	{
		for(colnum = 0; colnum < COLS; colnum++)
		{
			gradeOut = grades[rownum][colnum];
			outFile << gradeOut << "\t";
		}
		outFile << endl;
	}
	cout << "\nThe file has been successfully written." << endl;

}//end main function

//implement method to display array with column headers
void display(int nums[ROWS][COLS])
{
	cout << setw(10) << "Student" << setw(10) << "Grade 1"; 
	cout << setw(10) << "Grade 2" << setw(10) << "Grade 3"; 
	cout << setw(10) << "Grade 4" << setw(6) <<  "Ave";
	cout << setw(10) << "Wt Ave" << endl;

	int rownum, colnum;
	
	for(rownum = 0; rownum < ROWS; rownum++)
	{
		for(colnum = 0; colnum < COLS; colnum++)
		{
			if (colnum == 0)
			{
				cout << setw(5) <<nums[rownum][colnum];
			}
			else
			{
				cout << setw(10) << nums[rownum][colnum];
			}
		}
		cout << endl;
	}
}

//implement method to caculate the average scores
void calcAve(int nums[ROWS][COLS])
{
	int rownum, colnum;
	int ave;
	
	for(rownum = 0; rownum < ROWS; rownum++)
	{
		int sum = 0;
		for(colnum = 1; colnum < 5; colnum++)
		{
			sum += nums[rownum][colnum];
		}
		ave = sum/4;
		nums[rownum][colnum] = ave;
	}
}

//implement method to calculate weighted average of grades
void calcWtAve(int nums[ROWS][COLS])
{
	int rownum, colnum;
	
	for(rownum = 0; rownum < ROWS; rownum++)
	{
		int wtAve = 0;
		
		for(colnum = 1; colnum < 5; colnum++)
		{
			if (colnum == 1)
			{
				wtAve += nums[rownum][colnum]*0.2;
			}
			else if(colnum == 4)
			{
				wtAve += nums[rownum][colnum]*0.2;
			}
			else
			{
				wtAve += nums[rownum][colnum]*0.3;
			}
		}
		nums[rownum][6] = wtAve;
	}
}

//implement sortArray method						
void sortArray(int nums[ROWS][COLS])
{
	int i, j, k, l, m, n, minidx, min;
	int temp[COLS];
	int minim[COLS];
	
	for(i = 0; i < ROWS; i++)
	{
		min = nums[i][6];				//assume min is first index of wtAve
		minidx = i;						//index of for for of minimum wtAve
		
		for(j = i + 1; j < ROWS; j++)
		{
			if(nums[j][6] < min)				//if we locate a lower wtAve
			{
				for(k = 0; k < COLS; k++)	//capture entire row of array
				{
					minim[k] = nums[j][k];
				}
				min = nums[j][6];
				minidx = j;
			}
		}//end inner for loop
		if(min < nums[i][6])				//check whether we have a new minumum wtAve
		{
			for(l = 0; l < COLS; l++)	//and if we do swap entire rows
			{ 
				temp[l] = nums[i][l];
			}
			nums[i][6] = min;
			for(m = 0; m < COLS; m++)
			{
				nums[i][m] = minim[m];
			}
			for(n = 0; n < COLS; n++)
			{
				nums[minidx][n] = temp[n];
			}
		}
	}//end outer loop
}//end sortArray method