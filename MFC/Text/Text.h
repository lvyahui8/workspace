// Text.h : main header file for the TEXT application
//

#if !defined(AFX_TEXT_H__5BD2FBD0_24CE_4659_A12D_7F4C56BC3137__INCLUDED_)
#define AFX_TEXT_H__5BD2FBD0_24CE_4659_A12D_7F4C56BC3137__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CTextApp:
// See Text.cpp for the implementation of this class
//

class CTextApp : public CWinApp
{
public:
	CTextApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTextApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CTextApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TEXT_H__5BD2FBD0_24CE_4659_A12D_7F4C56BC3137__INCLUDED_)
