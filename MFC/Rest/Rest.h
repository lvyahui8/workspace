// Rest.h : main header file for the REST application
//

#if !defined(AFX_REST_H__82F091AC_68C1_4D06_BBBF_C2C155DB02FA__INCLUDED_)
#define AFX_REST_H__82F091AC_68C1_4D06_BBBF_C2C155DB02FA__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// CRestApp:
// See Rest.cpp for the implementation of this class
//

class CRestApp : public CWinApp
{
public:
	CRestApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CRestApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(CRestApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_REST_H__82F091AC_68C1_4D06_BBBF_C2C155DB02FA__INCLUDED_)
