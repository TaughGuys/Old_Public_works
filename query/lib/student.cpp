#include <iostream>
#include <sstream>
#include "student.h"
#include "../utils/utils.cpp"

Student::Student(std::string _name, std::string _lastName, int _age, std::string _group)
{
	name = _name;
	lastName = _lastName;
	age = _age;
	group = _group;

}

Student::~Student()
{
}

Student::Student()
{
	std::cout<<"Enter student name: ";
	std::cin>>name;
	while(!isConteinNumber(name)) {
		std::cout<<"Pleace enter the correct name.\n";
		std::cin>>name;
	}
	std::cout<<"Enter student lastname: ";
	std::cin>>lastName;
	while(!isConteinNumber(lastName)) {
		std::cout<<"Pleace enter the correct lastname.\n";
		std::cin>>lastName;
	}
	std::cout<<"Enter the age of student: ";
	std::cin>>age;
	std::cout<<"Print student group: ";
	std::cin>>group;
}

void  Student::setName(std::string _name)
{
	name = _name;
}

void  Student::setLastName(std::string _lastName)
{
	lastName= _lastName;
}

void  Student::setAge(int _age)
{
	age=_age;
}

void  Student::setGroup(std::string _group)
{
	group = _group;
}
std::string Student:: getName()
{
	return name;
}
std::string Student:: getLastName()
{
	return lastName;
}
int   Student:: getAge()
{
	return age;
}
std::string Student:: getGroup()
{
	return group;
}
std::string  Student::getObject()
{

	std::ostringstream oss;
	oss <<"student"<<" "<< getName()<<" "<<getLastName()<<" "<<getGroup()<<" "<<getAge();
	std::string var = oss.str();	
	std::cout<<var<<"\n";
	return var;
}

