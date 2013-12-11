//CS 1600
//PersonTest class
//#include <string>
//#include<iostream>
#include "Person.cpp"

//using namespace std;

int main()
{
	Person p1;
	//p1.showPerson();
	cout << p1;
	
	Person p2("Jack", 39);
	//p2.showPerson();
	cout << p2;
	
	Person p3("Jack", 39);
	//p3.showPerson();
	cout << p3;
	
	if(p1 == p3)
	{
		cout << "The people are the same" << endl;
	}
	else
	{
		cout << "The people are not the same" << endl;
	}
	
	p1.setName("Alice");
	p1.setAge(35);
	
	//p1.showPerson();
	cout << p1;
	
	cout << "My freind " << p1.getName() << " is " 
			<< p1.getAge() << " years old" << endl;
	
	return 0;
}