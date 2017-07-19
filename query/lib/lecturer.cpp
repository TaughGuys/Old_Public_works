#include <iostream>
#include <sstream>
#include "lecturer.h"

Lecturer::Lecturer(std::string _name, std::string _lastName, std::string _group)
{
	name = _name;
	lastName = _lastName;
	group = _group;

}

Lecturer::~Lecturer()
{
}

Lecturer::Lecturer()
{
	std::cout<<"Enter lecturer name: ";
	std::cin>>name;
	std::cout<<"Enter lecturer lastname: ";
	std::cin>>lastName;
	std::cout<<"Print lecturer group: ";
	std::cin>>group;
}

void  Lecturer::setName(std::string _name)
{
	name = _name;
}

void  Lecturer::setLastName(std::string _lastName)
{
	lastName= _lastName;
}

void  Lecturer::setGroup(std::string _group)
{
	group = _group;
}
std::string Lecturer:: getName()
{
	return name;
}
std::string Lecturer:: getLastName()
{
	return lastName;
}
std::string Lecturer:: getGroup()
{
	return group;
}
std::string  Lecturer::getObject()
{

	std::ostringstream oss;
	oss <<"lecturer"<<" "<< getName()<<" "<<getLastName()<<" "<<getGroup()<<" " << "-"; 
	std::string var = oss.str();	
	std::cout<<var<<"\n";
	return var;
}

