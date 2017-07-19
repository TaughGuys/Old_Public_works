#ifndef _DBMANAGER_H_
#define _DBMANAGER_H_
#include <string>
#include <vector>


class DBManager
{
	private:
		std::string query;
	public:
		DBManager();
		std::vector<std::string> splitCommand();
		bool checkQuery ();
		std::string getObject();
		std::string getAttrAndValue();
		std::string getAttr();
		bool isAttrAll ();
		std::string getAttrSign();
		std::string getValue();
		std::string getCommand();
};
#endif
