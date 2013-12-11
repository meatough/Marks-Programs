//CS 1600
//Person class
#include <string>
#include<iostream>

using namespace std;

class Person
{
	friend ostream& operator <<(ostream&, const Person&);

	private:
		string name;
		int age;
		
	public:
		//default constructor
		Person();
		//Person(string = "", int = 0);
		//Person(string, int):name(n), age(a){}
		//parameterized constructor
		Person( string n, int a );
		
		//function prototype set methods
		void setName(string n);
		void setAge(int a);
		
		//get methods
		string getName()
		{
			return name;
		}
		int getAge()
		{
			return age;
		}
		
		bool operator ==(Person&);
		
		//function prototype utiltiy methods
		void showPerson();
		
	
};

Person::Person()
{
	name = "";
	age = 0;
}

Person::Person(string n, int a)
{
	name = n;
	age = a;
}

//set methods
void Person::setName(string n)
{
	name = n;
}
void Person::setAge(int a)
{
	age = a;
}
/*		
//get methods
string Person::getName()
{
	return name;
}
int Person::getAge()
{
	return age;
}
*/
//utiltiy method
void Person::showPerson()
{
	cout << name << " is " << age << " years old" << endl;
}

bool Person::operator ==(Person &p)
{ 
	return name == p.name && age == p.age;
}

ostream& operator <<(ostream& out, const Person& frnd)
{
	out << frnd.name << " is " << frnd.age << " years old." << endl;
	return out;
}