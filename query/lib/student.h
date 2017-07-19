#ifndef _STUDENT_H_
#define _STUDENT_H_
#include <string>
#include <iostream>
#include "storageObj.h"

class Student : public StorageObj
{
	private:
		std::string  name;
		std::string  lastName;
		int age;
		std::string  group;
	public:
		Student(std::string  _name, std::string  _lastName, int _age, std::string  _group);
		~Student();
		Student();
		void setName(std::string  _name);
		void setLastName(std::string  _lastName);
		void setAge(int _age);
		void setGroup(std::string  _group);
		std::string  getName();
		std::string  getLastName();
		int   getAge();
		std::string  getGroup();
		std::string getObject();

};
#endif
