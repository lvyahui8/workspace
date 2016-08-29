
#include <string>
using std::string;
//CEmployee¿‡∂®“Â
class CEmployee{
private:
	string m_sName;
	string m_sAddress;
	string m_sCity;
	unsigned m_uZipCode;
public:
	CEmployee(const string &name,const string &address,
		const string &city,const unsigned &zipCode);
	CEmployee();
	void fnChange_Name(const string &name);
	void fnDisplay() const;
};

