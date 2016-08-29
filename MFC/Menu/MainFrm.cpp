// MainFrm.cpp : implementation of the CMainFrame class
//

#include "stdafx.h"
#include "Menu.h"

#include "MainFrm.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMainFrame

IMPLEMENT_DYNCREATE(CMainFrame, CFrameWnd)

BEGIN_MESSAGE_MAP(CMainFrame, CFrameWnd)
	//{{AFX_MSG_MAP(CMainFrame)
	ON_WM_CREATE()
	ON_COMMAND(IDM_TEST, OnTest)
	ON_UPDATE_COMMAND_UI(ID_EDIT_CUT, OnUpdateEditCut)
	ON_UPDATE_COMMAND_UI(ID_FILE_NEW, OnUpdateFileNew)
	ON_COMMAND(IDM_SHOW, OnShow)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

static UINT indicators[] =
{
	ID_SEPARATOR,           // status line indicator
	ID_INDICATOR_CAPS,
	ID_INDICATOR_NUM,
	ID_INDICATOR_SCRL,
};

/////////////////////////////////////////////////////////////////////////////
// CMainFrame construction/destruction

CMainFrame::CMainFrame()
{
	// TODO: add member initialization code here
//	m_bAutoMenuEnable = FALSE;
}

CMainFrame::~CMainFrame()
{
}

int CMainFrame::OnCreate(LPCREATESTRUCT lpCreateStruct)
{
	if (CFrameWnd::OnCreate(lpCreateStruct) == -1)
		return -1;
	
	if (!m_wndToolBar.CreateEx(this, TBSTYLE_FLAT, WS_CHILD | WS_VISIBLE | CBRS_TOP
		| CBRS_GRIPPER | CBRS_TOOLTIPS | CBRS_FLYBY | CBRS_SIZE_DYNAMIC) ||
		!m_wndToolBar.LoadToolBar(IDR_MAINFRAME))
	{
		TRACE0("Failed to create toolbar\n");
		return -1;      // fail to create
	}

	if (!m_wndStatusBar.Create(this) ||
		!m_wndStatusBar.SetIndicators(indicators,
		  sizeof(indicators)/sizeof(UINT)))
	{
		TRACE0("Failed to create status bar\n");
		return -1;      // fail to create
	}

	// TODO: Delete these three lines if you don't want the toolbar to
	//  be dockable
	m_wndToolBar.EnableDocking(CBRS_ALIGN_ANY);
	EnableDocking(CBRS_ALIGN_ANY);
	DockControlBar(&m_wndToolBar);
	//普通标记菜单
	//GetMenu()->GetSubMenu(0)->CheckMenuItem(0,MF_BYPOSITION | MF_CHECKED);
	//GetMenu()->GetSubMenu(0)->CheckMenuItem(ID_FILE_NEW,MF_BYCOMMAND | MF_CHECKED);
	//缺省菜单
	//GetMenu()->GetSubMenu(0)->SetDefaultItem(1,TRUE);
	//GetMenu()->GetSubMenu(0)->SetDefaultItem(ID_FILE_OPEN);
	//GetMenu()->GetSubMenu(0)->SetDefaultItem(5,TRUE);
// 获得系统 菜单标记位图的宽度和高度
//	CString str;
//	str.Format("x=%d,y=%d",GetSystemMetrics(SM_CXMENUCHECK),GetSystemMetrics(SM_CYMENUCHECK));
//	MessageBox(str);
	//位图标记菜单
//	m_bitmap.LoadBitmap(IDB_BITMAP1);
//	GetMenu()->GetSubMenu(0)->SetMenuItemBitmaps(0,MF_BYPOSITION,&m_bitmap,&m_bitmap);

	//禁用一个菜单项
	//需要在CMainFrame的构造函数中将m_bAutoMenuEnable设置为FALSE
												//使用序号索引 | 禁用 | 变灰
//	GetMenu()->GetSubMenu(0)->EnableMenuItem(1,MF_BYPOSITION | MF_DISABLED | MF_GRAYED);
	
	//取消整个菜单
//	SetMenu(NULL);
	//设置新菜单
/*
	//这样是不安全的
	//注意这里的menu是一个局部对象，这在程序中会出现问题，比如打印预览
	CMenu menu;
	menu.LoadMenu(IDR_MAINFRAME);
	SetMenu(&menu);
*/
	//这样是安全的
/*
	CMenu menu;
	menu.LoadMenu(IDR_MAINFRAME);
	SetMenu(&menu);
	menu.Detach();	//切断菜单句柄与菜单对象之间的联系，这样当局部的菜单对象析构时不会去销毁菜单窗口
*/
	return 0;
}

BOOL CMainFrame::PreCreateWindow(CREATESTRUCT& cs)
{
	if( !CFrameWnd::PreCreateWindow(cs) )
		return FALSE;
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return TRUE;
}

/////////////////////////////////////////////////////////////////////////////
// CMainFrame diagnostics

#ifdef _DEBUG
void CMainFrame::AssertValid() const
{
	CFrameWnd::AssertValid();
}

void CMainFrame::Dump(CDumpContext& dc) const
{
	CFrameWnd::Dump(dc);
}

#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMainFrame message handlers


void CMainFrame::OnTest() 
{
	// TODO: Add your command handler code here
	MessageBox("MainFrame Click.");
}

void CMainFrame::OnUpdateEditCut(CCmdUI* pCmdUI) 
{
	// TODO: Add your command update UI handler code here
	//if(2 == pCmdUI->m_nIndex)	//菜单项与工具栏的索引不一样，两者结果会不一样
	if(ID_EDIT_CUT == pCmdUI->m_nID)
		pCmdUI->Enable();
}

void CMainFrame::OnUpdateFileNew(CCmdUI* pCmdUI) 
{
	// TODO: Add your command update UI handler code here
//	if(ID_FILE_NEW == pCmdUI->m_nID);
//		pCmdUI->Enable(FALSE);
	if(0==pCmdUI->m_nIndex)
		pCmdUI->Enable(FALSE);
}

void CMainFrame::OnShow() 
{
	// TODO: Add your command handler code here
	MessageBox("MainFrame Show");
}
