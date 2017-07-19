#ifndef _LECTURER_H_
#define _LECTURER_H_

#include <string>
bool isConteinNumber(std::string word)
{
	int i = 0;
	while(word[i] != '\0')
	{
		if (word[i] < 'A' or word[i] > 'z')
		{
			return false;
		}
		i++;
	}
	return true;
}

bool isValidAge(int age)
{
	if(age < 15 or age > 100 )
	{
		return false;
	}
	return true;
}
#endif
