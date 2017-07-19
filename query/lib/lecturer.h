#ifndef _LECTURER_H_
#define _LECTURER_H_
#include <string>
#include <iostream>
#include "storageObj.h"

class Lecturer : public StorageObj
{
	private:
		std::string  name;
		std::string  lastName;
		std::string  group;
	public:
		Lecturer(std::string  _name, std::string  _lastName,  std::string  _group);
		~Lecturer();
		Lecturer();
		void setName(std::string  _name);
		void setLastName(std::string  _lastName);
		void setGroup(std::string  _group);
		std::string  getName();
		std::string  getLastName();
		int   getAge();
		std::string  getGroup();
		std::string getObject();
};
#endif
