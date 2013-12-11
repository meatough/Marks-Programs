#include<iostream>

using namespace std;

//function prototype
void printArray(int [], int);
int totalArray(int [], int);
int findInt(int [], int, int);

int main()
{
	const int SIZE = 5;
	int iArray[SIZE];
	int total;
	
	cout << iArray << endl << endl;
	
	for(int i = 0; i < SIZE; i++)
	{
		iArray[i] = i*2;
	}
	
	printArray(iArray, SIZE);
	
	total = totalArray(iArray, SIZE);
	
	cout <<"\n\nArray total = " << total; 
	
	int index = findInt(iArray, SIZE, 5);
	
	if(index != -1)
	{
		cout << "\n\nvalue found at index " << index;
	} 
	else
	{
		cout << "\n\nvalue not found";
	}
	cout << endl;
}//end main

void printArray(int arr [], int cap)
{
	cout << arr << endl << endl;
	for(int i = 0; i < cap; i++)
	{
		cout << arr[i] << endl;
	}
}//end printArray()

int totalArray(int arr [], int cap)
{
	int tot = 0;
		
	for (int i = 0; i < cap; i++)
	{
		tot += arr[i];
	}
	
	return tot;
}

int findInt(int arr [], int cap, int target)
{
	//linear search
	for (int i = 0; i < cap; i++)
	{
		if (target == arr[i])
		{
			return i;
		}
	}
	return -1;

}