// PropSheet.cpp : implementation file
//

#include "stdafx.h"
#include "DlgStudy.h"
#include "PropSheet.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CPropSheet

IMPLEMENT_DYNAMIC(CPropSheet, CPropertySheet)

CPropSheet::CPropSheet(UINT nIDCaption, CWnd* pParentWnd, UINT iSelectPage)
	:CPropertySheet(nIDCaption, pParentWnd, iSelectPage)
{
	this->m_psh.dwFlags |= PSH_NOAPPLYNOW;
	AddPage(&m_Snack);
	AddPage(&m_Drink);
	AddPage(&m_Entree);
}

CPropSheet::CPropSheet(LPCTSTR pszCaption, CWnd* pParentWnd, UINT iSelectPage)
	:CPropertySheet(pszCaption, pParentWnd, iSelectPage)
{
	this->m_psh.dwFlags |= PSH_NOAPPLYNOW;
	AddPage(&m_Snack);
	AddPage(&m_Drink);
	AddPage(&m_Entree);
}

CPropSheet::~CPropSheet()
{
}


BEGIN_MESSAGE_MAP(CPropSheet, CPropertySheet)
	//{{AFX_MSG_MAP(CPropSheet)
		// NOTE - the ClassWizard will add and remove mapping macros here.
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CPropSheet message handlers

BOOL CPropSheet::OnInitDialog() 
{
	BOOL bResult = CPropertySheet::OnInitDialog();
	
	// TODO: Add your specialized code here
	CWnd *pWnd = GetDlgItem(IDHELP);
	if(pWnd && pWnd->GetSafeHwnd()){
		pWnd->ShowWindow(false);
	}
/*
// ����ĸ���ťȫ��ȡ�����������»����¿հף�����Ĵ�����������հ�
	GetDlgItem(IDOK)->ShowWindow(SW_HIDE); 
	GetDlgItem(IDHELP)->ShowWindow(SW_HIDE);
	GetDlgItem(IDCANCEL)->ShowWindow(SW_HIDE); 
	GetDlgItem(ID_APPLY_NOW)->ShowWindow(SW_HIDE);
	//��ȡ����ߴ�
	CRect btnRect;
	GetDlgItem(IDCANCEL)->GetWindowRect(&btnRect); 
	CRect wdnRect; 
	GetWindowRect(&wdnRect);
	//���������С     
	::SetWindowPos(this->m_hWnd, HWND_TOP, 0,0,wdnRect.Width(),wdnRect.Height() - btnRect.Height(), SWP_NOMOVE | SWP_NOZORDER);
*/
	return bResult;
}
