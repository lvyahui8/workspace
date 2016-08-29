// Drink.cpp : implementation file
//

#include "stdafx.h"
#include "DlgStudy.h"
#include "Drink.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDrink property page

IMPLEMENT_DYNCREATE(CDrink, CPropertyPage)

CDrink::CDrink() : CPropertyPage(CDrink::IDD)
{
	//{{AFX_DATA_INIT(CDrink)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CDrink::~CDrink()
{
}

void CDrink::DoDataExchange(CDataExchange* pDX)
{
	CPropertyPage::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CDrink)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CDrink, CPropertyPage)
	//{{AFX_MSG_MAP(CDrink)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDrink message handlers
