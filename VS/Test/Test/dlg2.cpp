// dlg2.cpp : 实现文件
//

#include "stdafx.h"
#include "Test.h"
#include "dlg2.h"
#include "afxdialogex.h"


// dlg2 对话框

IMPLEMENT_DYNAMIC(dlg2, CDialog)

dlg2::dlg2(CWnd* pParent /*=NULL*/)
	: CDialog(dlg2::IDD, pParent)
{

}

dlg2::~dlg2()
{
}

void dlg2::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(dlg2, CDialog)
END_MESSAGE_MAP()


// dlg2 消息处理程序
