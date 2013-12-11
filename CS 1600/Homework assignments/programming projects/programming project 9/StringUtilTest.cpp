/*********************************************************** 
 * Programming Assignment 9
 * String Utilities Test
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created April 11, 2013
 
 ***********************************************************/
#include<C:\\MyCPP\\StringUtils\\StringUtils.cpp>
using namespace stringUtilsNamespace;

int main()
{
	string str1 = "   Hello my name is Mark   ";
	string str2 = "Banana ";
	string str3	= "   GeE tHiS sEnTaNcE iS vErY aNnOyInG tO rEaD   ";
	
	//perform operations on first string
	cout << "The fist String says\n" << str1 << endl;
	cout << "After trimming the front and adding a period it looks like: \n" << trimFront(str1) << "." << endl;
	cout << "After trimming the rear and adding a period it looks like: \n" << trimRear(str1) << "." << endl;
	cout << "After capitalizing all letters it looks like: \n" << toUpperString(str1) << endl;
	cout << "After lower casing all letters it looks like: \n" << toLowerString(str1) << endl;
	cout << "And the word count is:   " << countWords(str1) << "\n\n\n" <<  endl;
	
	//perform operations on second string
	cout << "The second String says\n" << str2 << endl;
	cout << "After trimming the front and adding a period it looks like: \n" << trimFront(str2) << "." << endl;
	cout << "After trimming the rear it and adding a period looks like: \n" << trimRear(str2) << "." << endl;
	cout << "After capitalizing all letters it looks like: \n" << toUpperString(str2) << endl;
	cout << "After lower casing all letters it looks like: \n" << toLowerString(str2) << endl;
	cout << "And the word count is:   " << countWords(str2) << "\n\n\n" <<  endl;
	
	//perform operations on third string
	cout << "The third String says\n" << str3 << endl;
	cout << "After trimming the front and adding a period it looks like: \n" << trimFront(str3) << "." << endl;
	cout << "After trimming the rear and adding a period it looks like: \n" << trimRear(str3) << "." << endl;
	cout << "After capitalizing all letters it looks like: \n" << toUpperString(str3) << endl;
	cout << "After lower casing all letters it looks like: \n" << toLowerString(str3) << endl;
	cout << "And the word count is:   " << countWords(str3) << "\n\n\n" <<  endl;
}