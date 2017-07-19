#ifndef _FILEDB_H_
#define _FILEDB_H_
#include <string>
#include "storageObj.h"
class FileDB 
{
	private:
		int a;
	public:
		void inputToDB(StorageObj* stObj);
		void searchObjectInDB(std::string objName);
		void searchObjectByAttrInDB(std::string objName, std::string attr, std::string value);
		void searchObjectByNotEqualAttrInDB(std::string objName, std::string attr, std::string value);
		void deleteObjectInDB(std::string  objName);
		void deleteObjectByAttrInDB(std::string  objName, std::string attr, std::string value);
		void deleteObjectByNotEqualAttrInDB(std::string  objName, std::string attr, std::string value);
};
#endif
