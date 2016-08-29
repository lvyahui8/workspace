#if !defined(AFX_DRINK_H__65345DFC_9FFD_4A92_A851_8B132E04E479__INCLUDED_)
#define AFX_DRINK_H__65345DFC_9FFD_4A92_A851_8B132E04E479__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Drink.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CDrink dialog

class CDrink : public CPropertyPage
{
	DECLARE_DYNCREATE(CDrink)

// Construction
public:
	CDrink();
	~CDrink();

// Dialog Data
	//{{AFX_DATA(CDrink)
	enum { IDD = IDD_DRINK };
		// NOTE - ClassWizard will add data members here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_DATA


// Overrides
	// ClassWizard generate virtual function overrides
	//{{AFX_VIRTUAL(CDrink)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	// Generated message map functions
	//{{AFX_MSG(CDrink)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DRINK_H__65345DFC_9FFD_4A92_A851_8B132E04E479__INCLUDED_)
