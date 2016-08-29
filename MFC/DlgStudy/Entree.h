#if !defined(AFX_ENTREE_H__DE5B5200_F17D_411C_8B9E_6F2685FB4854__INCLUDED_)
#define AFX_ENTREE_H__DE5B5200_F17D_411C_8B9E_6F2685FB4854__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Entree.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CEntree dialog

class CEntree : public CPropertyPage
{
	DECLARE_DYNCREATE(CEntree)

// Construction
public:
	CEntree();
	~CEntree();

// Dialog Data
	//{{AFX_DATA(CEntree)
	enum { IDD = IDD_ENTREE };
		// NOTE - ClassWizard will add data members here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_DATA


// Overrides
	// ClassWizard generate virtual function overrides
	//{{AFX_VIRTUAL(CEntree)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	// Generated message map functions
	//{{AFX_MSG(CEntree)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ENTREE_H__DE5B5200_F17D_411C_8B9E_6F2685FB4854__INCLUDED_)
