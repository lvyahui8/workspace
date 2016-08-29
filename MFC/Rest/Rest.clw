; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CRestDlg
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "Rest.h"

ClassCount=2
Class1=CRestApp
Class2=CRestDlg

ResourceCount=5
Resource1=IDR_MAINFRAME
Resource2=IDD_DRINK
Resource3=IDD_ENTREE
Resource4=IDD_REST_DIALOG
Resource5=IDD_SNACK

[CLS:CRestApp]
Type=0
HeaderFile=Rest.h
ImplementationFile=Rest.cpp
Filter=N

[CLS:CRestDlg]
Type=0
HeaderFile=RestDlg.h
ImplementationFile=RestDlg.cpp
Filter=D
LastObject=CRestDlg
BaseClass=CDialog
VirtualFilter=dWC



[DLG:IDD_REST_DIALOG]
Type=1
Class=CRestDlg
ControlCount=1
Control1=IDC_BOARD1,button,1342251008

[DLG:IDD_SNACK]
Type=1
Class=?
ControlCount=7
Control1=IDC_SNACK1,button,1342242816
Control2=IDC_SNACK2,button,1342242816
Control3=IDC_SNACK3,button,1342242816
Control4=IDC_SNACK4,button,1342242816
Control5=IDC_SNACK5,button,1342242816
Control6=IDC_SNACK6,button,1342242816
Control7=IDC_SNACK7,button,1342242816

[DLG:IDD_DRINK]
Type=1
Class=?
ControlCount=1
Control1=IDC_STATIC,static,1342308352

[DLG:IDD_ENTREE]
Type=1
Class=?
ControlCount=1
Control1=IDC_STATIC,static,1342308352

