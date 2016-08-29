#pragma once


// dlg2 对话框

class dlg2 : public CDialog
{
	DECLARE_DYNAMIC(dlg2)

public:
	dlg2(CWnd* pParent = NULL);   // 标准构造函数
	virtual ~dlg2();

// 对话框数据
	enum { IDD = IDD_DLG };

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
};
