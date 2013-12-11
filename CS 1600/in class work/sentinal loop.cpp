#include<iostream>
using namespace std;

//sentinal controlled loop
int main()
{
	double score, average;
	double sum = 0;
	int counter = 0;
	//int average;
	while(score >= 0)
	{
		cout << "enter test score (any negative number to quit)";
		cin >> score;
		
		if(score >= 0)
		{
			sum += score;
			counter++;
		}
	}
	
	if(counter > 0)
	{
		average = sum / counter;
	}
	else
	{
		average = 0;
	}
	
	cout << "Your average of " << counter << " test scores is " << average << endl;
}