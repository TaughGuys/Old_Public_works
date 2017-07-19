#include "lib/storageObj.h"
#include "lib/fileDB.h"
#include "lib/DBManager.h"
#include "lib/student.h"
#include "lib/lecturer.h"
#include <iomanip>
#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
	DBManager db;
	FileDB file;
	if(db.getCommand() == "select") {
		std::string obj = db.getObject();	
		if (db.isAttrAll())
		{ 
			file.searchObjectInDB(obj);
		}
		else if(db.getAttrSign() == "eq") { 
			std::string attr = db.getAttr();
			std::string value = db.getValue();
			file.searchObjectByAttrInDB(obj, attr, value);
		}else if(db.getAttrSign() == "neq") {
			std::string attr = db.getAttr();
			std::string value = db.getValue();
			std::cout<<attr<<" "<<value;
			file.searchObjectByNotEqualAttrInDB(obj, attr, value);
		}else {
			std::cout<<"Please input correct Attribute and value [attribute={!=}value]\n";
		}
	} else if(db.getCommand()  == "delete") {
		std::string obj = db.getObject();	
		if (db.isAttrAll())
		{ 
			file.deleteObjectInDB(obj);
		}
		else if(db.getAttrSign() == "eq") { 
			std::string attr = db.getAttr();
			std::string value = db.getValue();
			file.deleteObjectByAttrInDB(obj, attr, value);
		}else if(db.getAttrSign() == "neq") {
			std::string attr = db.getAttr();
			std::string value = db.getValue();
			file.deleteObjectByNotEqualAttrInDB(obj, attr, value);
		}else {
			std::cout<<"Please input correct Attribute and value [attribute={!=}value]\n";
		}
	}else if(db.getCommand() == "add") {
		if( db.getObject() == "student" ){
			Student st;
			file.inputToDB(&st);
		} else if(db.getObject() == "lecturer") {
			Lecturer le;
			file.inputToDB(&le);
		}
	}
}
