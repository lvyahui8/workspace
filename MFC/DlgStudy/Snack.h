#if !defined(AFX_SNACK_H__240A4888_8188_47E8_8A60_6324C70ABFED__INCLUDED_)
#define AFX_SNACK_H__240A4888_8188_47E8_8A60_6324C70ABFED__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Snack.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CSnack dialog

class CSnack : public CPropertyPage
{
	DECLARE_DYNCREATE(CSnack)

// Construction
public:
	CSnack();
	~CSnack();

// Dialog Data
	//{{AFX_DATA(CSnack)
	enum { IDD = IDD_SNACK };
	CButton	m_Snack1;
	//}}AFX_DATA


// Overrides
	// ClassWizard generate virtual function overrides
	//{{AFX_VIRTUAL(CSnack)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	// Generated message map functions
	//{{AFX_MSG(CSnack)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SNACK_H__240A4888_8188_47E8_8A60_6324C70ABFED__INCLUDED_)
