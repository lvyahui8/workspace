#pragma once


// CTEST �Ի���

class CTest : public CDialog
{
	DECLARE_DYNAMIC(CTest)

public:
	CTest(CWnd* pParent = NULL);   // ��׼���캯��
	virtual ~CTest();

// �Ի�������
	enum { IDD = IDD_TEST };

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV ֧��

	DECLARE_MESSAGE_MAP()
};
