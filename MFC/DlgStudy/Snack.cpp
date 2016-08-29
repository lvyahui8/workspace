// Snack.cpp : implementation file
//

#include "stdafx.h"
#include "DlgStudy.h"
#include "Snack.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CSnack property page

IMPLEMENT_DYNCREATE(CSnack, CPropertyPage)

CSnack::CSnack() : CPropertyPage(CSnack::IDD)
{
	//{{AFX_DATA_INIT(CSnack)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CSnack::~CSnack()
{
}

void CSnack::DoDataExchange(CDataExchange* pDX)
{
	CPropertyPage::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CSnack)
	DDX_Control(pDX, IDC_SNACK1, m_Snack1);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CSnack, CPropertyPage)
	//{{AFX_MSG_MAP(CSnack)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CSnack message handlers
