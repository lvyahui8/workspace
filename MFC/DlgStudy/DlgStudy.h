// DlgStudy.h : main header file for the DLGSTUDY application
//

#if !defined(AFX_DLGSTUDY_H__A117B7E8_4803_4256_9DD7_CDC40CAF64BA__INCLUDED_)
#define AFX_DLGSTUDY_H__A117B7E8_4803_4256_9DD7_CDC40CAF64BA__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// CDlgStudyApp:
// See DlgStudy.cpp for the implementation of this class
//

class CDlgStudyApp : public CWinApp
{
public:
	CDlgStudyApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDlgStudyApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(CDlgStudyApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DLGSTUDY_H__A117B7E8_4803_4256_9DD7_CDC40CAF64BA__INCLUDED_)
