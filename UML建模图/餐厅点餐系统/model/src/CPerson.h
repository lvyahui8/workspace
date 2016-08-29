
#ifndef __CPERSON_H__
#define __CPERSON_H__

#include "CString.h"

class CPerson{	
	private:
		CString m_strName;
		char m_cSex;
	public:
		CPerson();	
		CPerson(CString strName);		
};

#endif /*__CPERSON_H_*/

