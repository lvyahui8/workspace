// DlgStudyDlg.h : header file
//

#if !defined(AFX_DLGSTUDYDLG_H__6A287C7B_A0FB_451F_A35C_E0D9737A5F0C__INCLUDED_)
#define AFX_DLGSTUDYDLG_H__6A287C7B_A0FB_451F_A35C_E0D9737A5F0C__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CDlgStudyDlg dialog

class CDlgStudyDlg : public CDialog
{
// Construction
public:
	CDlgStudyDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CDlgStudyDlg)
	enum { IDD = IDD_DLGSTUDY_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDlgStudyDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CDlgStudyDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnButton1();
	afx_msg void OnTuichu();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DLGSTUDYDLG_H__6A287C7B_A0FB_451F_A35C_E0D9737A5F0C__INCLUDED_)
