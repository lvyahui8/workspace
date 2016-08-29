// Entree.cpp : implementation file
//

#include "stdafx.h"
#include "DlgStudy.h"
#include "Entree.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CEntree property page

IMPLEMENT_DYNCREATE(CEntree, CPropertyPage)

CEntree::CEntree() : CPropertyPage(CEntree::IDD)
{
	//{{AFX_DATA_INIT(CEntree)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CEntree::~CEntree()
{
}

void CEntree::DoDataExchange(CDataExchange* pDX)
{
	CPropertyPage::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CEntree)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CEntree, CPropertyPage)
	//{{AFX_MSG_MAP(CEntree)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CEntree message handlers
