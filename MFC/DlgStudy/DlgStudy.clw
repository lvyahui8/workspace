; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CSnack
LastTemplate=CPropertySheet
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "DlgStudy.h"

ClassCount=6
Class1=CDlgStudyApp
Class2=CDlgStudyDlg

ResourceCount=5
Resource2=IDD_DRINK
Resource3=IDD_DLGSTUDY_DIALOG
Resource4=IDD_SNACK
Resource1=IDR_MAINFRAME
Class3=CSnack
Class4=CDrink
Class5=CEntree
Class6=CPropSheet
Resource5=IDD_ENTREE

[CLS:CDlgStudyApp]
Type=0
HeaderFile=DlgStudy.h
ImplementationFile=DlgStudy.cpp
Filter=N

[CLS:CDlgStudyDlg]
Type=0
HeaderFile=DlgStudyDlg.h
ImplementationFile=DlgStudyDlg.cpp
Filter=D
BaseClass=CDialog
VirtualFilter=dWC



[DLG:IDD_DLGSTUDY_DIALOG]
Type=1
Class=CDlgStudyDlg
ControlCount=2
Control1=IDC_BUTTON1,button,1342242816
Control2=IDC_TUICHU,button,1342242816

[DLG:IDD_SNACK]
Type=1
Class=CSnack
ControlCount=2
Control1=IDC_SNACK1,button,1342373888
Control2=IDC_SNACK2,button,1342242816

[DLG:IDD_DRINK]
Type=1
Class=CDrink
ControlCount=1
Control1=IDC_RADIO1,button,1342177289

[DLG:IDD_ENTREE]
Type=1
Class=CEntree
ControlCount=1
Control1=IDC_LIST1,listbox,1352728835

[CLS:CSnack]
Type=0
HeaderFile=Snack.h
ImplementationFile=Snack.cpp
BaseClass=CPropertyPage
Filter=D
VirtualFilter=idWC
LastObject=IDC_SNACK1

[CLS:CDrink]
Type=0
HeaderFile=Drink.h
ImplementationFile=Drink.cpp
BaseClass=CPropertyPage
Filter=D

[CLS:CEntree]
Type=0
HeaderFile=Entree.h
ImplementationFile=Entree.cpp
BaseClass=CPropertyPage
Filter=D

[CLS:CPropSheet]
Type=0
HeaderFile=PropSheet.h
ImplementationFile=PropSheet.cpp
BaseClass=CPropertySheet
Filter=W
VirtualFilter=hWC

