#include "7-t3CDate.h"

class CPeople{
private:
	char m_aName[11];
	char m_aNumber[7];
	char m_aSex[3];
	CDate m_Birthday;
	char m_Id[16];
public:
	CPeople(char * name=NULL,char * number=NULL,char * sex=NULL,CDate * birthday=NULL,char * id=NULL);
	CPeople(CPeople &people);
	~CPeople(){}
	void fnEnter();
	void fnShow()const;
}
