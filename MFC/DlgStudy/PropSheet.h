#if !defined(AFX_PROPSHEET_H__3ACF9680_0B81_41EE_8B0D_4067A37D8D58__INCLUDED_)
#define AFX_PROPSHEET_H__3ACF9680_0B81_41EE_8B0D_4067A37D8D58__INCLUDED_

#include "Snack.h"	// Added by ClassView
#include "Drink.h"
#include "Entree.h"

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// PropSheet.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CPropSheet

class CPropSheet : public CPropertySheet
{
	DECLARE_DYNAMIC(CPropSheet)

// Construction
public:
	CPropSheet(UINT nIDCaption, CWnd* pParentWnd = NULL, UINT iSelectPage = 0);
	CPropSheet(LPCTSTR pszCaption, CWnd* pParentWnd = NULL, UINT iSelectPage = 0);

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CPropSheet)
	public:
	virtual BOOL OnInitDialog();
	//}}AFX_VIRTUAL

// Implementation
public:
	CSnack m_Snack;
	CDrink m_Drink;
	CEntree m_Entree;
	virtual ~CPropSheet();

	// Generated message map functions
protected:
	//{{AFX_MSG(CPropSheet)
		// NOTE - the ClassWizard will add and remove member functions here.
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_PROPSHEET_H__3ACF9680_0B81_41EE_8B0D_4067A37D8D58__INCLUDED_)
