
// DialogTest.h : PROJECT_NAME Ӧ�ó������ͷ�ļ�
//

#pragma once

#ifndef __AFXWIN_H__
	#error "�ڰ������ļ�֮ǰ������stdafx.h�������� PCH �ļ�"
#endif

#include "resource.h"		// ������


// CDialogTestApp:
// �йش����ʵ�֣������ DialogTest.cpp
//

class CDialogTestApp : public CWinApp
{
public:
	CDialogTestApp();

// ��д
public:
	virtual BOOL InitInstance();

// ʵ��

	DECLARE_MESSAGE_MAP()
};

extern CDialogTestApp theApp;