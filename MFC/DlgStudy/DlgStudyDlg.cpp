// DlgStudyDlg.cpp : implementation file
//

#include "stdafx.h"
#include "DlgStudy.h"
#include "DlgStudyDlg.h"
#include "PropSheet.h"
#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDlgStudyDlg dialog

CDlgStudyDlg::CDlgStudyDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CDlgStudyDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(CDlgStudyDlg)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CDlgStudyDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CDlgStudyDlg)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CDlgStudyDlg, CDialog)
	//{{AFX_MSG_MAP(CDlgStudyDlg)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_TUICHU, OnTuichu)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDlgStudyDlg message handlers

BOOL CDlgStudyDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon
	
	// TODO: Add extra initialization here
	
	return TRUE;  // return TRUE  unless you set the focus to a control
}

// If you add a minimize button to your dialog, you will need the code below
//  to draw the icon.  For MFC applications using the document/view model,
//  this is automatically done for you by the framework.

void CDlgStudyDlg::OnPaint() 
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, (WPARAM) dc.GetSafeHdc(), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR CDlgStudyDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

void CDlgStudyDlg::OnButton1() 
{
	// TODO: Add your control notification handler code here
	CPropSheet theSheet("菜单");
//	CButton bt;
//	bt.Create("woca", WS_CHILD | WS_VISIBLE | BS_PUSHBUTTON,CRect(0,0,100,100),&theSheet,123);
//	theSheet.CreateControl("cwin","woca",WS_CHILD | WS_VISIBLE,CRect(0,0,100,100),&theSheet,123);
	
	if(IDOK == theSheet.DoModal()){
		theSheet.m_Snack.UpdateData();
		if(theSheet.m_Snack.m_Snack1.GetCheck() == 1)
			MessageBox("按钮1被选中");
	}
}

void CDlgStudyDlg::OnTuichu() 
{
	// TODO: Add your control notification handler code here
/*
	MFC 中关闭窗口的几种方法
	退出程序用AfxGetMainWnd()->SendMessage(WM_CLOSE);
	关闭当前窗口用DestroyWindow( );
	关闭模式对话框用EndDialog(0);
*/
	//SendMessage(WM_CLOSE);
	//AfxGetApp()->m_pMainWnd->SendMessage(WM_CLOSE);
	if(IDOK == MessageBox("你确定要退出吗？","提示",MB_ICONWARNING | MB_OKCANCEL))
		AfxGetMainWnd()->SendMessage(WM_CLOSE);
}
