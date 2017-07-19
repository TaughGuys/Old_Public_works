#include "DBManager.h"
#include <string.h>
#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>

DBManager::DBManager()
{
	std::cout<<">>";
	getline(std::cin, query, '\n');
	std::transform(query.begin(), query.end(), query.begin(), ::tolower);
} 

std::vector<std::string> DBManager::splitCommand()
{
	std::istringstream iss(query);
	std::vector<std::string> results((std::istream_iterator<std::string>(iss)),std::istream_iterator<std::string>());
	return results;
}

bool DBManager::checkQuery ()
{
	std::vector<std::string> cmdList = splitCommand();
	std::string select = cmdList[0];
	if(cmdList.size() != 4 and cmdList.size() != 2)
		return false;
	if (select != "select" and select != "add")
		return false;
	if ( cmdList.size()>2 ) { 
		std::string where = cmdList[2];
		if (where != "where")
			return false;
	}
	return true;
}
std::string DBManager::getCommand() 
{
	std::vector<std::string> cmdList = splitCommand();
	return cmdList[0];
}
std::string DBManager::getObject()
{
	std::vector<std::string> cmdList = splitCommand();
	std::string object = cmdList[1];
	return object;
}
std::string DBManager::getAttrAndValue()
{
	std::vector<std::string> cmdList = splitCommand();
	std::string attrAndValue = "";
	if (cmdList.size() > 3)
	     attrAndValue= cmdList[3];
	return attrAndValue;
}
bool DBManager::isAttrAll ()
{
	std::vector<std::string> cmdList = splitCommand();
	std::string attrAndValue = "";
	if (cmdList.size() > 3)
	     attrAndValue= cmdList[3];
	if(attrAndValue == "*")
		return true;
	return false;
}
std::string DBManager::getAttrSign()
{
	std::string attr = getAttrAndValue();
	if (attr.find("!=") != std::string::npos) {
		return "neq";
	}
	else if (attr.find("=") != std::string::npos) {
		return "eq";
	}
	else {
		std::cout<<"Inqorect query!\n";	
		return "err";
	}

}
std::string DBManager::getAttr() 
{
	std::string attr, attrAndValue = getAttrAndValue();
	if(getAttrSign() != "err") {
		if(getAttrSign() == "eq") {  
			attr = attrAndValue.substr(0, attrAndValue.find("="));
		} else {
			attr = attrAndValue.substr(0, attrAndValue.find("!="));
		}
	}
	return attr;
}
std::string DBManager::getValue() 
{
	std::string value, attrAndValue = getAttrAndValue();
	int len = attrAndValue.length();
	if(getAttrSign() != "err") {
		if(getAttrSign() == "eq") {  
			value = attrAndValue.substr(attrAndValue.find("=")+1, len);
		} else {
			value = attrAndValue.substr(attrAndValue.find("!=")+2, len);
		}
	}
	return value;
}
