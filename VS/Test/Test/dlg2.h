#pragma once


// dlg2 �Ի���

class dlg2 : public CDialog
{
	DECLARE_DYNAMIC(dlg2)

public:
	dlg2(CWnd* pParent = NULL);   // ��׼���캯��
	virtual ~dlg2();

// �Ի�������
	enum { IDD = IDD_DLG };

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV ֧��

	DECLARE_MESSAGE_MAP()
};
