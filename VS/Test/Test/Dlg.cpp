// Dlg.cpp : 实现文件
//

#include "stdafx.h"
#include "Test.h"
#include "Dlg.h"


// CDlg

IMPLEMENT_DYNAMIC(CDlg, CWnd)

CDlg::CDlg()
{

}

CDlg::~CDlg()
{
}


BEGIN_MESSAGE_MAP(CDlg, CWnd)
	ON_COMMAND(IDOK, &CDlg::OnIdok)
END_MESSAGE_MAP()



// CDlg 消息处理程序




void CDlg::OnIdok()
{
	// TODO: 在此添加命令处理程序代码

}
