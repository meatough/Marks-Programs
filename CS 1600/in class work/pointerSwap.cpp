#include <iostream>
using namespace std;

void swap(int*, int*);

int main()
{
	//initialize ints
	int a = 5, b = 7;
	
	//initialize pointers
	//int &aPtr = a;
	//int &bPtr = b;

	
	cout 	<< "Swap routine using pointer\n\n"
			<<"Before swap\n"
			<<"a = " << a << '\n'
			<<"b = " << b << "\n\n";
			
			swap(&a, &b);
			
	
	
}//end main

void swap(int *x int *y
{
	int temp = *x;
	*x = *y;
	*y = temp;
}