#include <fstream>
#include <iostream>
#include <cstdio>
#include <string>
#include <stdlib.h>
#include <iterator>
#include <algorithm>
#include "fileDB.h" 
#include <iomanip>

void FileDB::inputToDB(StorageObj *stObj)
{
	std::ofstream newData("DB.txt", std::ios::app);
	newData << stObj->getObject() << std::endl;
	newData.close();
}
void FileDB::searchObjectInDB(std::string  objName)
{
	std::ifstream DB("DB.txt");
	std::string obj, name, lastName, group;
	std::string  age;
	bool flag = true;

	while (DB >> obj >> name >> lastName >> group >> age){
		if ( obj== objName){
			if(flag) { 
				std::cout <<'|'<< std::setw(19) <<"Name" << '|' << std::setw(19) << "Lastname" << '|' << std::setw(19) << "Group" << '|' << std::setw(18) << "Age" <<'|'<< std::endl;
				std::cout << "--------------------------------------------------------------------------------" << std::endl;
			}
			flag = false;
			std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
		}
	}

	while (DB >> obj ){
		if (obj != objName){
			std::cout << "Nobody found"<< std::endl;
		}
	}
}
void FileDB::searchObjectByAttrInDB(std::string objName, std::string attr, std::string value)
{
	std::ifstream DB("DB.txt");
	std::string obj,name, lastName, group, age;
	std::transform(attr.begin(), attr.end(), attr.begin(), ::tolower);
	std::cout <<'|'<< std::setw(19) <<"Name" << '|' << std::setw(19) << "Lastname" << '|' << std::setw(19) << "Group" << '|' << std::setw(18) << "Age" <<'|'<< std::endl;
	std::cout << "--------------------------------------------------------------------------------" << std::endl;

	while (DB >> obj >> name >> lastName >> group >> age){
		if(obj == objName){
			if(attr == "name") {
				if ( name == value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("lastname"== attr){
				if ( lastName == value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("age"==attr){
				if ( age == value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("group"== attr){
				if ( group == value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
		}
	}
}
void FileDB::searchObjectByNotEqualAttrInDB(std::string objName, std::string attr, std::string value)
{
	std::ifstream DB("DB.txt");
	std::string obj,name, lastName, group, age;
	std::transform(attr.begin(), attr.end(), attr.begin(), ::tolower);
	std::cout <<'|'<< std::setw(19) <<"Name" << '|' << std::setw(19) << "Lastname" << '|' << std::setw(19) << "Group" << '|' << std::setw(18) << "Age" <<'|'<< std::endl;
	std::cout << "--------------------------------------------------------------------------------" << std::endl;

	while (DB >> obj >> name >> lastName >> group >> age ){
		if(obj == objName){
			if(attr == "name") {
				if ( name != value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("lastname"== attr){
				if ( lastName != value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("age"==attr){
				if ( age != value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
			if("group"==attr){
				if ( group != value){
					std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
				}
			}
		}
	}
}
void FileDB::deleteObjectInDB(std::string  objName)
{
	std::string  name;
	std::string  lastName;
	std::string age;
	std::string  group;
	std::string  obj;

	std::ifstream DB("DB.txt");
	std::ofstream DB2("tmp.txt", std::ios::app);
	if (!DB.eof()){
		while (DB >> obj >> name >> lastName >> group >> age){
			if (obj != objName)
			{
				DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group << ' ' << age << std::endl;
			}else if (obj == objName)
				std::cout <<'|'<< std::setw(19)<<name << '|' <<std::setw(19)<< lastName << '|' <<std::setw(19)<< group << '|' << std::setw(18) << age <<'|'<< std::endl ;
		}
		std::rename("tmp.txt", "DB.txt");
		DB.close();
		DB2.close();
	}
}
void FileDB::deleteObjectByAttrInDB(std::string  objName, std::string attr, std::string value)
{
	std::string  name;
	std::string  lastName;
	std::string age;
	std::string  group;
	std::string  obj;

	std::ifstream DB("DB.txt");
	std::ofstream DB2("tmp.txt", std::ios::app);
	bool flag=false;
	if (!DB.eof()){
		while (DB >> obj >> name >> lastName >> group >> age){
			if(obj == objName){
				if(attr == "name") {
					if ( name != value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' '  << group << ' ' <<  age << ' ' << std::endl;
					}
				}
				if("lastname"== attr){
					if ( lastName != value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group << ' ' << age << ' ' <<  std::endl;
					}
				}
				if("age"==attr){
					if ( age != value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group << ' ' << age << ' ' <<  std::endl;
					}
				}
				if("group"==attr){
					if ( group != value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group  << ' ' <<  age << std::endl;
					}
				}
			}else {
				DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group << ' ' << age << std::endl;
			}
		}
		if(flag)
			std::rename("tmp.txt", "DB.txt");
		DB.close();
		DB2.close();
	}
}
void FileDB::deleteObjectByNotEqualAttrInDB(std::string  objName, std::string attr, std::string value)
{
	std::string  name;
	std::string  lastName;
	std::string age;
	std::string  group;
	std::string  obj;

	std::ifstream DB("DB.txt");
	std::ofstream DB2("tmp.txt", std::ios::app);
	bool flag=false;
	if (!DB.eof()){
		while (DB >> obj >> name >> lastName >> group >> age ) {
			if(obj == objName){
				if(attr == "name") {
					if ( name == value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group <<' ' << age <<  std::endl;
					}
				}
				if("lastname"== attr){
					if ( lastName == value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group <<' ' << age <<  std::endl;
					}
				}
				if("age"==attr){
					if ( age == value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group <<' ' << age <<  std::endl;
					}
				}
				if("group"==attr){
					if ( group == value){
						flag=true;
						DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group <<' ' << age <<  std::endl;
					}
				}
			}else {
				DB2 << obj << ' ' << name << ' ' << lastName << ' ' << group <<' ' << age <<  std::endl;
			}
		}
		if(flag)
			std::rename("tmp.txt", "DB.txt");
		DB.close();
		DB2.close();
	}
}
