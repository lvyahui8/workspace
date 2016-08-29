#pragma once


// CDlg

class CDlg : public CDialogEx
{
	DECLARE_DYNAMIC(CDlg)

public:
	CDlg();
	virtual ~CDlg();

protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnIdok();
};


