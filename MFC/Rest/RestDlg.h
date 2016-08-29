// RestDlg.h : header file
//

#if !defined(AFX_RESTDLG_H__BCC2F60C_79DD_4DAF_B719_A484010B81B4__INCLUDED_)
#define AFX_RESTDLG_H__BCC2F60C_79DD_4DAF_B719_A484010B81B4__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CRestDlg dialog

class CRestDlg : public CDialog
{
// Construction
public:
	CRestDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CRestDlg)
	enum { IDD = IDD_REST_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CRestDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CRestDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnBoard1();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_RESTDLG_H__BCC2F60C_79DD_4DAF_B719_A484010B81B4__INCLUDED_)
