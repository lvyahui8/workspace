// RunApp.cpp: implementation of the CRunApp class.
//
//////////////////////////////////////////////////////////////////////

#include "RunApp.h"

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
#include "GlobalFun.h"
#include "resource.h"
#include <iostream>
#include <iomanip>
#include <math.h>
#include <fstream>
#include <ctime>
#include <conio.h>
using namespace std;

CRunApp::CRunApp()
{
 	system("title #���ϵͳ#");
	SetWindowSize(WINDOW_MAX_WIDTH,WINDOW_MAX_HIGHT);
	//��Ϊ��ʱû���ҵ�ֱ�ӻ�ÿ���̨���ھ���ĺ���������ʹ�ü�ӷ�����þ��
	char  buffer[40];
	::GetConsoleTitle(buffer,40);			//��Ĵ��ڱ���
	HWND hWnd;
	hWnd=::FindWindow(NULL,buffer);	//����ǰ���д������ҵ�����Ϊbuffer�Ĵ��ڣ���������
	HINSTANCE hInst=::GetModuleHandle("�������ϵͳ.exe");		//���Ӧ�ó���ʵ�����
	::SendMessage(hWnd,WM_SETICON,ICON_SMALL,					//������Ϣ������ͼ��
		(LPARAM)::LoadIcon(hInst,MAKEINTRESOURCE(IDI_ICON1))); 
/*
//ɾ��������

	long lStyle = ::GetWindowLong(hWnd, GWL_STYLE);
	::SetWindowLong(hWnd, GWL_STYLE, lStyle & ~WS_CAPTION);	//ɾ���˵�
	::SetWindowPos(hWnd, NULL, 0, 0, 0, 0,SWP_NOSIZE			//�ػ�����
		| SWP_NOMOVE | SWP_NOZORDER | SWP_NOACTIVATE | SWP_FRAMECHANGED);
*/	
//ɾ������������󻯺͹رհ�ť
	::DeleteMenu(GetSystemMenu(hWnd, FALSE), SC_CLOSE, MF_BYCOMMAND);
	::DeleteMenu(GetSystemMenu(hWnd, FALSE), SC_MAXIMIZE, MF_BYCOMMAND);
	::DrawMenuBar(hWnd);		//�ػ��˵�

	m_pFoodMenu = NULL;
	m_pBoard =NULL;
	m_pWaiter =NULL;
	int i=0;

	ifstream ifTemp("major.dat");
	if(!ifTemp){
		exit(0);
		cout<<"��ʧ�ļ�major.dat"<<endl;
	}
	typedef struct{
			char bossName[255];
			char bossSex[25];
			char bossPassword[255];
			unsigned boardCount;
	}Major;
	Major theMajor;
	ifTemp.read((char*)&theMajor,sizeof(theMajor));
	m_pBoss = new CBoss(theMajor.bossPassword,theMajor.bossName,theMajor.bossSex);
	//���ط���Ա�Ͳ�������
	for(i=0;i<theMajor.boardCount && i < INIT_BOARD_COUNT;i++){
		m_pBoss->AddBoard(&m_pBoard);
	}
	ifTemp.close();
	//���ز˵�
	ifTemp.clear(ios::goodbit);//�����ڶ���һ���ļ�֮ǰ������� clear ���������״̬��
	ifTemp.open("Food.dat",ios_base::in);
	if(!ifTemp){
		exit(0);
		cout<<"��ʧ�ļ�Food.dat"<<endl;
	}
	typedef struct{ 
		char buffer[255];
		unsigned uType;
		double dPrice;
	}theFood;
	for(i=0;!ifTemp.eof();i++){
		theFood tempFood;
		if(!ifTemp.read((char*)&tempFood,sizeof(tempFood))){
			break;
		}
		m_pBoss->AddFoodMenuItem(&m_pFoodMenu,tempFood.uType,tempFood.buffer,tempFood.dPrice);
	}
	ifTemp.close();
	ifTemp.clear(ios::goodbit);//�����ڶ���һ���ļ�֮ǰ������� clear ���������״̬��
	ifTemp.open("waiter.dat",ios_base::in);
	if(!ifTemp){
		exit(0);
		cout<<"��ʧ�ļ�waiter.dat"<<endl;
	}
	typedef struct{
		unsigned uNumber;
		char sName[255];
		char sSex[25];
		double dAchieve;
		double dSalarys;
	}theWaiter;
	theWaiter tempWaiter;
	while(!ifTemp.eof()){
		if(!ifTemp.read((char*)&tempWaiter,sizeof(tempWaiter))){
			break;
		}
		m_pBoss->AddWaiter(&m_pWaiter,tempWaiter.uNumber,
			tempWaiter.dSalarys,tempWaiter.sName,tempWaiter.sSex,tempWaiter.dAchieve);
	}
	ifTemp.close();

}

CRunApp::~CRunApp()
{
	//�������в˵���Ϣ
	ofstream ofTemp("Food.dat");
	if(ofTemp){
		typedef struct{ 
			char buffer[255];
			unsigned uType;
			double dPrice;
		}theFood;
		theFood tempFood;
		for(int i=1;i<=CFoodMenu::m_unFoodCount;i++){
			CFoodMenu * pFood=GetPFood(i);
			strcpy(tempFood.buffer,pFood->m_Food.m_strFoodName.c_str());
			tempFood.uType=pFood->m_Food.m_uFoodType;
			tempFood.dPrice=pFood->m_Food.m_dPrice;
			ofTemp.write((char*)&tempFood,sizeof(tempFood));
			//m_pBoss->DelFoodMenuItem(&m_pFoodMenu,pFood->m_Food.m_strFoodName);
		}
	}
	ofTemp.close();
	//�������з���Ա����
	ofTemp.open("waiter.dat");
	if(ofTemp){
		typedef struct{
			unsigned uNumber;
			char sName[255];
			char sSex[25];
			double dAchieve;
			double dSalarys;
		}theWaiter;
		theWaiter tempWaiter;
		CWaiter *current;
		CWaiter **ppWaiter=&m_pWaiter;
		while((current = *ppWaiter)!=NULL){
			tempWaiter.uNumber = current->GetNumber();
			strcpy(tempWaiter.sName,current->GetName().c_str());
			strcpy(tempWaiter.sSex,current->GetSex().c_str());
			tempWaiter.dAchieve = current->GetAchievement();
			tempWaiter.dSalarys = current->GetSalary();
			ofTemp.write((char*)&tempWaiter,sizeof(tempWaiter));
			ppWaiter = &current->pNextWaiter;
		}
	}
	ofTemp.close();
	ofTemp.open("major.dat");
	if(ofTemp){
		typedef struct{
			char bossName[255];
			char bossSex[25];
			char bossPassword[255];
			unsigned boardCount;
		}Major;
		Major theMajor;
		strcpy(theMajor.bossName ,m_pBoss->GetName().c_str());
		strcpy(theMajor.bossSex,m_pBoss->GetSex().c_str());
		strcpy(theMajor.bossPassword,m_pBoss->GetPassword().c_str());
		theMajor.boardCount=CBoard::GetBoardCount();
		ofTemp.write((char*)&theMajor,sizeof(theMajor));
	}
	ofTemp.close();
// �ͷ��ڴ�ռ�
	unsigned unFoodCount	=	CFoodMenu::m_unFoodCount;
	unsigned unWaiterCount	=	CWaiter::GetWaiterCount();
	unsigned unBoardCount	=	CBoard::GetBoardCount();
	for(int i=1;i<=unFoodCount || i<= unWaiterCount || i<= unBoardCount;i++){
		if(i<=unFoodCount){
			m_pBoss->DelFoodMenuItem(&m_pFoodMenu,GetPFood(1)->m_Food.m_strFoodName);
		
		}
		if(i<=unWaiterCount){
			if( GetPWaiter(i)!= NULL)
				m_pBoss->DelWaiter(&m_pWaiter,GetPWaiter(i)->GetNumber());
		}
		if(i<=unBoardCount){
			m_pBoss->DelBoard(&m_pBoard);
		}
	}
	delete m_pBoss;
}

//����Ҫ���棺���в���
COORD CRunApp::DrawAllBoard(){
	CBoard **ppBoard = &m_pBoard;
	register CBoard * current;
	short i=0;
	SetTextColor(BACKGROUND_WHITE);
	//���ָ���
	for(i=0;i<WINDOW_MAX_HIGHT;i++){
		GotoPos(WINDOW_MAX_WIDTH-29,i);
		cout<<" ";
	}
	//������
	COORD rPos={0,0};
	while((current = *ppBoard) != NULL){
		GotoPos(rPos.X+3,rPos.Y+2);
		if(true == current->m_bFlags){
			SetTextColor(FOREGROUND_BLUE | BACKGROUND_RED | BACKGROUND_INTENSITY);
			cout<<"   ��ʹ����  ";
		}
		else{
			SetTextColor(FOREGROUND_PURPLE| BACKGROUND_GREEN | BACKGROUND_INTENSITY );
			cout<<"   ��������  ";
		}
		
		GotoPos(rPos.X+3,rPos.Y+3);
		cout<<setfill('0');
		cout<<"   ����:"<<setw(2)<<current->GetNumber()<<"   ";
		GotoPos(rPos.X+3,rPos.Y+4);
		cout<<setfill('\0');
		cout<<"   ����:"<<setw(2)<<current->GetManCount()<<"   ";
		GotoPos(rPos.X+3,rPos.Y+5);
		cout<<"             ";
		GotoPos(rPos.X+3,rPos.Y+5);
		cout<<"��ʼ:"<<current->GetStartTime();
		rPos.X+=28;
		if (rPos.X>WINDOW_MAX_WIDTH-30) {		//����
			rPos.X=0;
			rPos.Y+=WINDOW_MAX_HIGHT/6;
		}
		ppBoard = &current->pNextBoard;
	}
	SetTextColor(BACKGROUND_WHITE );
	TextOut(WINDOW_MAX_WIDTH-28,WINDOW_MAX_HIGHT/2-6," 1 ���                     ");
	TextOut(WINDOW_MAX_WIDTH-28,WINDOW_MAX_HIGHT/2-4," 2 ��̨����                 ");
	TextOut(WINDOW_MAX_WIDTH-28,WINDOW_MAX_HIGHT/2-2," 0 �˳�                     ");
	TextOut(WINDOW_MAX_WIDTH-28,WINDOW_MAX_HIGHT/2,  "   ���ѡ��:                ");
	
	SetTextColor(BACKGROUND_RED | BACKGROUND_INTENSITY);
	TextOut(WINDOW_MAX_WIDTH-20,4,"    ");
	SetTextColor(FOREGROUND_WHITE);
	cout<<" ʹ����";
	
	SetTextColor(BACKGROUND_GREEN | BACKGROUND_INTENSITY);
	TextOut(WINDOW_MAX_WIDTH-20,6,"    ");
	SetTextColor(FOREGROUND_WHITE);
	cout<<" ������";

	SetTextColor(FOREGROUND_GREEN |BACKGROUND_WHITE );
	COORD tmpPos={WINDOW_MAX_WIDTH-15,WINDOW_MAX_HIGHT/2};
	return tmpPos;	//���ؿɹ��û�����ĵ������
}
// ���ָ����Ų�����ָ��
CBoard * CRunApp::GetPBoard(const unsigned short & unNumber){
	CBoard **ppBoard = &m_pBoard;
	register CBoard * current;
	while((current = *ppBoard) != NULL && current->GetNumber() != unNumber){
		ppBoard = &current->pNextBoard;
	}
	return current;
}
// ���ָ����ŷ���Ա��ָ��
CWaiter * CRunApp::GetPWaiter(const unsigned short & unNumber){
	CWaiter **ppWaiter = &m_pWaiter;
	register CWaiter * current;
	while((current = *ppWaiter) != NULL && current->GetNumber() != unNumber){
		ppWaiter = &current->pNextWaiter;
	}
	return current;	
}
// ���ָ����Ų��ȵ�ָ��
CFoodMenu * CRunApp::GetPFood(const unsigned short & unNumber){
	CFoodMenu **ppFood = &m_pFoodMenu;
	register CFoodMenu * current;
	unsigned short i=0;
	while(i<unNumber && (current = *ppFood) != NULL){
		ppFood = &current->m_NextFood;
		i++;
	}
	return current;	
}
// ����ʼ����������
COORD CRunApp::DrawInitBoard(){
	CleanBuffer(WINDOW_MAX_WIDTH/3+2,WINDOW_MAX_HIGHT/4,
		2*WINDOW_MAX_WIDTH/3-1,3*WINDOW_MAX_HIGHT/4);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE);
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3);
	cout<<"�˲�����û���ã����ʼ�λ:     (���20��)";
	SetTextColor(wOldAttributes);
	COORD tmpPos={WINDOW_MAX_WIDTH/3+35,WINDOW_MAX_HIGHT/3};
	return tmpPos;
}
// ��ָ��������Ϣ
void CRunApp::DrawBoard(CBoard * pBoard){
	CleanBuffer(0,0,WINDOW_MAX_WIDTH/3-1,WINDOW_MAX_HIGHT-2);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE);
	GotoPos(0,0);
	cout<<setfill('0');
	cout<<"����: "<<setw(2)<<pBoard->GetNumber()<<setfill('\0')<<endl;
	if(false==pBoard->m_bFlags){
		cout<<"�˲������ڿ�����"<<endl;	
	}
	else{
		cout<<"��"<<pBoard->GetStartTime()<<"��ʼ"<<"������ʹ��"<<endl;
		cout<<"�Ͳ�����: "<<setw(2)<<pBoard->GetManCount()<<" ��"<<endl;
		cout<<"�����˵�:"<<endl;
		COORD pos={0,5};
		PrintBoardMenu(&pBoard->m_pBoardMenu,pos);
		GotoPos(pos.X,pos.Y);
		cout<<"�����ѽ��:  "<<pBoard->GetConsume()<<"Ԫ";
	}
	SetTextColor(wOldAttributes);
}
//��ָ�������˵�
void CRunApp::PrintBoardMenu(CBoardMenu** ppBoardMenu,COORD & pos){
	register CBoardMenu * current;
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE | COMMON_LVB_UNDERSCORE);
	CleanBuffer(WINDOW_MAX_WIDTH,0,2*WINDOW_MAX_WIDTH/3+1,38);
	GotoPos(pos.X,pos.Y);
	cout<<"����        ����      ����     ���    �㵥����Ա";
	while((current = *ppBoardMenu)!=NULL){
		pos.Y+=1;
		TextOut(pos.X,pos.Y,current->m_Food.m_strFoodName);
		TextOut(pos.X+13,pos.Y,current->m_Food.m_dPrice);
		TextOut(pos.X+23,pos.Y,current->m_uShare);
		TextOut(pos.X+33,pos.Y,current->m_dMoney);
		TextOut(pos.X+43,pos.Y,current->m_unWaiterNumber);
		ppBoardMenu = &current->m_pNextBoardFood;
	}
	pos.Y+=2;
	SetTextColor(wOldAttributes);
}
//��ӡ�������˵�
void CRunApp::PrintFoodMenu(){
	CleanBuffer(2*WINDOW_MAX_WIDTH/3+1,0,WINDOW_MAX_WIDTH-1,WINDOW_MAX_HIGHT-2);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE | COMMON_LVB_UNDERSCORE);
	register CFoodMenu * current;
	CFoodMenu ** ppBoardMenu= &m_pFoodMenu;
	GotoPos(FOODMENU_OUPUT_POSITION_X,
		FOODMENU_OUPUT_POSITION_Y-2);
	cout<<"�������в���";
	GotoPos(FOODMENU_OUPUT_POSITION_X,
		FOODMENU_OUPUT_POSITION_Y);
	short i=1;
	cout<<"���    ����        ����      ����    ";
	while((current = *ppBoardMenu)!=NULL){
		
		GotoPos(FOODMENU_OUPUT_POSITION_X,FOODMENU_OUPUT_POSITION_Y+i);
		cout<<setfill('0')<<setw(2)<<i<<setfill('\0');
		GotoPos(FOODMENU_OUPUT_POSITION_X+6,FOODMENU_OUPUT_POSITION_Y+i);
		cout<<current->m_Food.m_strFoodName;
		GotoPos(FOODMENU_OUPUT_POSITION_X+20,FOODMENU_OUPUT_POSITION_Y+i);
		switch(current->m_Food.m_uFoodType){
		case SNACK:cout<<"С��";
			break;
		case DRINK:cout<<"����";
			break;
		case ENTREE:cout<<"����";
			break;
		}
		GotoPos(FOODMENU_OUPUT_POSITION_X+30,FOODMENU_OUPUT_POSITION_Y+i);
		cout<<setw(2)<<current->m_Food.m_dPrice<<" Ԫ/��";
		i++;
		ppBoardMenu = &current->m_NextFood;
	}
	SetTextColor(wOldAttributes);
}
// ����һ������Ա������棨ѡ�����ţ�ѡ�����Ա��ţ�
COORD CRunApp::DrawWaiterInputOne(){
	WORD wOldAttributes;
	GetTextColor(&wOldAttributes);
	short i=4;
	CBoard ** ppBoard=&m_pBoard;
	CBoard * current;
	while((current=*ppBoard) != NULL){
		if(current->m_bFlags==true){
			SetTextColor(FOREGROUND_BLUE | BACKGROUND_RED | BACKGROUND_INTENSITY);
		}
		else{	
			SetTextColor(BACKGROUND_GREEN | BACKGROUND_INTENSITY );
		}
		GotoPos(12,i);
		cout<<"����"<<setfill('0')<<setw(2)<<current->GetNumber()<<setfill('\0');
		ppBoard = &current->pNextBoard;
		i++;
	}
	SetTextColor(BACKGROUND_WHITE |BACKGROUND_INTENSITY);
	for(i=0;i<WINDOW_MAX_HIGHT;i++){
		GotoPos(WINDOW_MAX_WIDTH/3,i);
		cout<<" ";
		GotoPos(2*WINDOW_MAX_WIDTH/3,i);
		cout<<" ";
	}
	SetTextColor(FOREGROUND_WHITE);
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3);
	cout<<"���������    :     ��������ȷֵ";
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3+1);
	cout<<"�������Ա���:     ��������ȷֵ";
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3+3);
	cout<<"0 �˳�";
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3+4);
	cout<<"����Ա���������  -1  Ϊ���˸���";
	COORD tmpPos={WINDOW_MAX_WIDTH/3+25,WINDOW_MAX_HIGHT/3};
	SetTextColor(wOldAttributes);
	return tmpPos;
}
//���ڶ�������Ա������棨bFlags == true ���  bFlags ==false  ɾ�����ȣ�
COORD CRunApp::DrawWaiterInputTwo(const bool &bFlags){
	CleanBuffer(WINDOW_MAX_WIDTH/3+2,WINDOW_MAX_HIGHT/4+2,
		2*WINDOW_MAX_WIDTH/3-1,3*WINDOW_MAX_HIGHT/4);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE);
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3-4);
	if(true == bFlags){
		cout<<"���ڵ��        ";
	}
	else{
		cout<<"����ɾ���ѵ����";
	}
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3-2);
	cout<<"0 : �˳�  -1 : ɾ���˵�";
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3);
	cout<<"���ȱ��        :     ��������ȷֵ";
	GotoPos(WINDOW_MAX_WIDTH/3+10,WINDOW_MAX_HIGHT/3+1);
	cout<<"����            :     ��������ȷֵ";
	COORD tmpPos={WINDOW_MAX_WIDTH/3+27,WINDOW_MAX_HIGHT/3};
	SetTextColor(wOldAttributes);
	return tmpPos;
}
//////////////////////////////////////////////////////////////////////////
//	����
//////////////////////////////////////////////////////////////////////////
void CRunApp::Run(){
	string strInput="";
	COORD currentPos;
	while(strInput!="0"){
		Cls();
		currentPos=this->DrawAllBoard();
		do{
			Input(strInput,currentPos,&strInput);
		}while(!("1"==strInput || "2" == strInput || "0"==strInput));

		
		if("1"==strInput){
			Order();
		}
		else if("2" == strInput){
			Administrate();
		}
		else{
			Cls();
			TextOut(WINDOW_MAX_WIDTH/2-9,WINDOW_MAX_HIGHT/2,"��ȷ��Ҫ�˳���? 1 ���� ����� �� :");
			currentPos.X=WINDOW_MAX_WIDTH/2+27;
			currentPos.Y=WINDOW_MAX_HIGHT/2;
			Input(strInput,currentPos,&strInput);
			if("1" != strInput)
				strInput = "0";
		}
	}
}
//////////////////////////////////////////////////////////////////////////
//	������
//////////////////////////////////////////////////////////////////////////

bool CRunApp::Order(){
	Cls();
	COORD currentPos;
	currentPos =DrawWaiterInputOne();
	PrintFoodMenu();
	int iInput;   //���������ʱ�������ֵ
	unsigned short unBoardNumber;
	unsigned short unWaiterNumber;
	//ѡ�����
	do{
		Input(unBoardNumber,currentPos);
	}while(unBoardNumber<0 || unBoardNumber> CBoard::GetBoardCount());
	if(0 == unBoardNumber) return false;
	CBoard * pBoard = GetPBoard(unBoardNumber);
	//�������Ա���
	currentPos.Y+=1;
	do{
		Input(iInput,currentPos);
	}while(!(iInput==-1 || iInput ==0 || (NULL != GetPWaiter(iInput))));

	if(-1 == iInput){
		Cls();
		GotoPos(WINDOW_MAX_WIDTH/2-12,WINDOW_MAX_HIGHT/2);
		if(false == pBoard->m_bFlags){
			cout<<"�˲���û��ʹ��  ";
			system("echo ����������� & pause > nul");
			return false;
		}
		DrawBoard(pBoard);
		GotoPos(WINDOW_MAX_WIDTH/2-12,WINDOW_MAX_HIGHT/2);
		currentPos.X=WINDOW_MAX_WIDTH/2+14;
		currentPos.Y=WINDOW_MAX_HIGHT/2;
		cout<<"��ȷ��Ҫ����(1:�� 0:����):";
		do {
			Input(iInput,currentPos);
		} while(!(1==iInput || 0==iInput));
		if(0 == iInput){
			return false;
		}
		pBoard->Clean();
		return true;
	}
	if(0 == iInput) return false;
	unWaiterNumber =iInput;
	CWaiter * pWaiter = GetPWaiter(unWaiterNumber);
	//�������δ��ʹ�á���ʼ������
	if(false == pBoard->m_bFlags){
		currentPos=DrawInitBoard();
		unsigned uManCount;
		do{
			Input(uManCount,currentPos);
		}while(uManCount<0  || uManCount >20);
		if(0 == uManCount) return false;
		pBoard->m_bFlags = true;
		pBoard->SetManCount(uManCount);
		pBoard->SetStartTime();
	}
	//���
	bool bFlags=true;
	
	do
	{
		DrawBoard(pBoard);
		currentPos=this->DrawWaiterInputTwo(bFlags);
		CFoodMenu * pFood;
		unsigned short unFoodNumber;
		unsigned short unShare;
		//ѡ�����
		do{
			Input(iInput,currentPos);
		}while(iInput<-1 || iInput>CFoodMenu::m_unFoodCount);
		if(-1 == iInput){
			bFlags=false;
			continue;
		}
		if(0 == iInput) break;
		unFoodNumber = iInput;
		currentPos.Y+=1;
		//ѡ�����
		do{
			Input(iInput,currentPos);
		}while(iInput<-1);
		if(-1 == iInput){
			bFlags=false;
			continue;
		}
		if(0 == iInput) break;
		unShare = iInput;
		pFood = GetPFood(unFoodNumber);
		char strTime[25];
		char buffer[80];
		time_t t;
		time(&t);
		sprintf(strTime,"%s",ctime(&t));
		if(true == bFlags){
			pWaiter->AddBoardMenuItem(pBoard,pFood->m_Food.m_uFoodType,
				pFood->m_Food.m_strFoodName,pFood->m_Food.m_dPrice,unShare);
			
			sprintf(buffer,"������������: %d ����: %d ����: %s ����: %d ʱ��: %s",
				pBoard->GetNumber(),pBoard->GetManCount(),pFood->m_Food.m_strFoodName.c_str(),unShare,strTime);
		}
		else{
			pWaiter->DelBoardMenuItem(pBoard,pFood->m_Food.m_strFoodName,unShare);
			sprintf(buffer,"ȡ����������: %d ����: %d ����: %s ����: %d ʱ��: %s",
				pBoard->GetNumber(),pBoard->GetManCount(),pFood->m_Food.m_strFoodName.c_str(),unShare,strTime);
		}
		ofstream ofTemp;
		if(SNACK == pFood->m_Food.m_uFoodType){
			ofTemp.open("Snack.txt",ios::app);
		}
		else if(DRINK ==pFood->m_Food.m_uFoodType){
			ofTemp.open("Drink.txt",ios::app);
		}
		else
			ofTemp.open("Entree.txt",ios::app);
		//system(buffer);
		if(ofTemp){
			ofTemp.write(buffer,sizeof(buffer));
		}
		ofTemp.close();
		if(false == bFlags) bFlags = true;
	}while(1);
	return true;
}
//��ӡ���з���Ա��Ϣ
void CRunApp::DrawAllWaiter(){
	CleanBuffer(2*WINDOW_MAX_WIDTH/3+1,0,
		WINDOW_MAX_WIDTH-1,WINDOW_MAX_HIGHT-4);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE | COMMON_LVB_UNDERSCORE);
	TextOut(FOODMENU_OUPUT_POSITION_X,
		FOODMENU_OUPUT_POSITION_Y-2,"�������з���Ա");
	TextOut(FOODMENU_OUPUT_POSITION_X,
		FOODMENU_OUPUT_POSITION_Y,"���    ����       �Ա�        ҵ��     ����");
	CWaiter ** ppWaiter = &m_pWaiter;
	CWaiter * current;
	int iTemp=FOODMENU_OUPUT_POSITION_Y+1;
	while((current = * ppWaiter) != NULL){
		GotoPos(FOODMENU_OUPUT_POSITION_X,iTemp);
		cout<<setfill('0')<<setw(2)<<current->GetNumber()<<setfill('\0');
		TextOut(FOODMENU_OUPUT_POSITION_X+6,iTemp,current->GetName());
		TextOut(FOODMENU_OUPUT_POSITION_X+20,iTemp,current->GetSex());
		TextOut(FOODMENU_OUPUT_POSITION_X+33,iTemp,current->GetAchievement());
		TextOut(FOODMENU_OUPUT_POSITION_X+40,iTemp,current->GetSalary());
		ppWaiter = &current->pNextWaiter;
		iTemp+=1;
	}
	SetTextColor(wOldAttributes);
}
//������ѡ��
COORD CRunApp::DrawAdminMenu(){
	CleanBuffer(0,0,
		WINDOW_MAX_WIDTH/3-1,WINDOW_MAX_HIGHT-4);
	WORD wOldAttributes=SetTextColor(BACKGROUND_WHITE);
	TextOut(5,5 ,"1 ��������      ");
	TextOut(5,7 ,"2 ���ٲ���      ");
	TextOut(5,9 ,"3 ��������Ա    ");
	TextOut(5,11,"4 ��ͷ���Ա    ");
	TextOut(5,13,"5 ���ù���      ");
	TextOut(5,15,"6 ��������      ");
	TextOut(5,17,"7 ɾ������      ");
	TextOut(5,19,"8 ��ѯӪҵ��    ");
	TextOut(5,21,"9 ��������      ");
	TextOut(5,23,"0 �˳�          ");
	TextOut(5,25,"  ����ѡ��:     ");
	SetTextColor(wOldAttributes);
	COORD tempPos={16,25};
	return tempPos;
}
//���������Ա���棨iFlags == SET_WAITER ���ķ���Ա��Ϣ  iFlag == ADD_WAITER  ��������Ա  iFlag == DEL_WAITER ��ͷ���Ա��
COORD CRunApp::DrawDisposeWaiter(const int &iFlags){
	CleanBuffer(WINDOW_MAX_WIDTH/5,WINDOW_MAX_HIGHT/5,
		3*WINDOW_MAX_WIDTH/5,3*WINDOW_MAX_HIGHT/5);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE);
	COORD tempPos={WINDOW_MAX_WIDTH/5+2,WINDOW_MAX_HIGHT/5-2};
	if(SET_WAITER == iFlags){
		TextOut(tempPos.X,tempPos.Y,      "���ķ���Ա����     ���� 0 ���˳�");
		TextOut(tempPos.X,tempPos.Y+2,    "����Ա���:    ��ȷ����ſ���ʹ��");
		TextOut(tempPos.X,tempPos.Y+3,    "����      :");
		tempPos.X+=11;
		tempPos.Y+=2;
		return tempPos;
	}
	if(ADD_WAITER == iFlags){
		TextOut(tempPos.X,tempPos.Y,  "��������Ա     ���� 0 ���˳�");
		TextOut(tempPos.X,tempPos.Y+3,"����      :");
		TextOut(tempPos.X,tempPos.Y+4,"�Ա�      :");
		TextOut(tempPos.X,tempPos.Y+5,"����      :");
	}
	else
		TextOut(tempPos.X,tempPos.Y,  "��ͷ���Ա     ���� 0 ���˳�");
	TextOut(tempPos.X,tempPos.Y+2,    "����Ա���:    ��ȷ����ſ���ʹ��");
	tempPos.X+=11;
	tempPos.Y+=2;
	SetTextColor(wOldAttributes);
	return tempPos;
}
// ������������˵����� ��bFlags == true ��������  bFlags ==false  ɾ�����ȣ�
COORD CRunApp::DrawDisposeFoodMenu(const bool &bFlags){
	CleanBuffer(WINDOW_MAX_WIDTH/5,WINDOW_MAX_HIGHT/5,
		3*WINDOW_MAX_WIDTH/5,3*WINDOW_MAX_HIGHT/5);
	WORD wOldAttributes=SetTextColor(FOREGROUND_WHITE);
	COORD tempPos={WINDOW_MAX_WIDTH/5+2,WINDOW_MAX_HIGHT/5-2};
	if(true == bFlags){
		TextOut(tempPos.X,tempPos.Y,  "��������     ���� 0 ���˳�");
		TextOut(tempPos.X,tempPos.Y+3,"����:");
		TextOut(tempPos.X,tempPos.Y+4,"�۸�:");
		TextOut(tempPos.X,tempPos.Y+6,"ע: 1 С��  2 ���� 3 ����");
		TextOut(tempPos.X,tempPos.Y+2,    "����:");
	}
	else{
		TextOut(tempPos.X,tempPos.Y,  "ɾ������     ���� 0 ���˳�");
		TextOut(tempPos.X,tempPos.Y+2,    "���:");
	}
	
	tempPos.X+=5;
	tempPos.Y+=2;
	SetTextColor(wOldAttributes);
	return tempPos;
}
//////////////////////////////////////////////////////////////////////////
//	Boss����
//////////////////////////////////////////////////////////////////////////

bool CRunApp::Administrate(){
	Cls();
	int iInput;
	COORD  currentPos;
	string strTemp1;
	string strTemp2;
	//��������
	TextOut(WINDOW_MAX_WIDTH/2-8,WINDOW_MAX_HIGHT/2  ,"����:");
	currentPos.X=WINDOW_MAX_WIDTH/2-3;
	currentPos.Y=WINDOW_MAX_HIGHT/2;
	do{
		TextOut(currentPos.X,currentPos.Y,"                 ");
		GotoPos(currentPos.X,currentPos.Y);
		char str[100];
		char * pStr = str;
		while((*pStr=getch()) != 13){		//��û�а��س�
			if(8 == *pStr){					//��������˸�
				if(pStr>str){
					cout<<'\b'<<' '<<'\b';
					pStr--;
				}
				
			}
			else{
				cout<<"*";
				pStr++;
			}
		}
		*pStr='\0';						//���ַ������Ͻ�β
		strTemp2.assign(str);			//���ַ����ӵ�string����β��
	}while(!(m_pBoss->GetPassword()==strTemp2 || "0"==strTemp2));	// ()������������ !()���ǵ�����������ʱ,ִ��ѭ��
	if("0"==strTemp2) return false;

	//�����˹������
	do{
		Cls();
		currentPos=DrawAdminMenu();
		do{
			Input(iInput,currentPos);
		}while(iInput<0 || iInput>9);
		switch(iInput){
		case 1:		//��������
			m_pBoss->AddBoard(&m_pBoard);
			TextOut(WINDOW_MAX_WIDTH/2,WINDOW_MAX_HIGHT/2,"������1������");
			system("echo �������ȷ��  & pause > nul");
			break;
		case 2:		//���ٲ���
			m_pBoss->DelBoard(&m_pBoard);
			TextOut(WINDOW_MAX_WIDTH/2,WINDOW_MAX_HIGHT/2,"������1������");
			system("echo �������ȷ��  & pause > nul");
			break;
		case 3:		//��������Ա
			do{
				currentPos=DrawDisposeWaiter(ADD_WAITER);
				DrawAllWaiter();
				unsigned uNumber;
				double dSalarys;
				do{
					Input(uNumber,currentPos);
				}while(uNumber!=0 && GetPWaiter(uNumber));
				if(0==uNumber) break;
				currentPos.Y+=1;
				Input(strTemp1,currentPos,&strTemp1);
				if("0" == strTemp1) break;
				currentPos.Y+=1;
				Input(strTemp2,currentPos,&strTemp2);
				if("0" == strTemp2) break;
				currentPos.Y+=1;
				do{
					Input(dSalarys,currentPos);
				}while(dSalarys<0);
				m_pBoss->AddWaiter(&m_pWaiter,uNumber,dSalarys,strTemp1,strTemp2);
			}while(1);
			break;
		case 4:		//��ͷ���Ա
			do{
				currentPos=DrawDisposeWaiter(DEL_WAITER);
				DrawAllWaiter();
				unsigned uNumber;
				do{
					Input(uNumber,currentPos);
				}while(uNumber!=0 && !GetPWaiter(uNumber));
				if(0==uNumber) break;
				m_pBoss->DelWaiter(&m_pWaiter,uNumber);
			}while(1);
			break;
		case 5:		//���÷���Ա����
			do{
				currentPos=DrawDisposeWaiter(SET_WAITER);
				DrawAllWaiter();
				unsigned uNumber;
				do{
					Input(uNumber,currentPos);
				}while(uNumber!=0 && !GetPWaiter(uNumber));
				if(0==uNumber) break;
				currentPos.Y+=1;
				double dSalarys;
				do{
					Input(dSalarys,currentPos);
				}while(dSalarys<0);
				m_pBoss->SetWaiterSalary(&m_pWaiter,uNumber,dSalarys);
			}while(1);
			break;
		case 6:		//���Ӳ���
			do{
				currentPos=DrawDisposeFoodMenu(true);
				PrintFoodMenu();
				unsigned uFType;
				double dPrice;
				Input(strTemp1,currentPos,&strTemp1);
				currentPos.Y+=1;
				if("0" == strTemp1) break;
				do{
					Input(uFType,currentPos);
				}while(!(1==uFType || 2==uFType || 3==uFType || 0==uFType));
				if(0==uFType) break;
				currentPos.Y++;
				do {
					Input(dPrice,currentPos);
				} while(dPrice<0);
				if(0==dPrice) break;
				m_pBoss->AddFoodMenuItem(&m_pFoodMenu,uFType,strTemp1,dPrice);
			} while(1);
			break;
		case 7:		//���ٲ���
			do{
				currentPos=DrawDisposeFoodMenu(false);
				PrintFoodMenu();
				do{
					Input(iInput,currentPos);
				}while(iInput<0 || GetPFood(iInput)==NULL);
				if(0 == iInput) break;
				m_pBoss->DelFoodMenuItem(&m_pFoodMenu,GetPFood(iInput)->m_Food.m_strFoodName);
			}while(1);
			break;
		case 8:		//�鿴Ӫҵ��
			CleanBuffer(2*WINDOW_MAX_WIDTH/3+1,0,
				WINDOW_MAX_WIDTH-1,WINDOW_MAX_HIGHT-4);
			char buffer[255];
			sprintf(buffer,"��Ӫҵ�� : %-.4lf",CBoard::GetDailySales());
			TextOut(2*WINDOW_MAX_WIDTH/3+3,4,buffer);
			sprintf(buffer,"С������ : %-.4lf",CBoard::GetSnackSales());
			TextOut(2*WINDOW_MAX_WIDTH/3+3,5,buffer);
			sprintf(buffer,"�������� : %-.4lf",CBoard::GetDrinkSales());
			TextOut(2*WINDOW_MAX_WIDTH/3+3,6,buffer);
			sprintf(buffer,"�������� : %-.4lf",CBoard::GetEntreeSales());
			TextOut(2*WINDOW_MAX_WIDTH/3+3,7,buffer);
			GotoPos(2*WINDOW_MAX_WIDTH/3+3,9);
			system("echo �����������  & pause > nul");
			break;
		case 9:		//�޸�����
			CleanBuffer(WINDOW_MAX_WIDTH/5,WINDOW_MAX_HIGHT/5,
				3*WINDOW_MAX_WIDTH/5,3*WINDOW_MAX_HIGHT/5);
			TextOut(WINDOW_MAX_WIDTH/5-2,WINDOW_MAX_HIGHT/5-2,"�µ�����:               (�����ַ���)");
			currentPos.X=WINDOW_MAX_WIDTH/5+9,currentPos.Y=WINDOW_MAX_HIGHT/5-2;
			Input(strTemp1,currentPos,&strTemp1);
			m_pBoss->ChangePassword(strTemp1);
			GotoPos(WINDOW_MAX_WIDTH/5-2,WINDOW_MAX_HIGHT/5+1);
			cout<<"���ĳɹ�! ����:"<<m_pBoss->GetPassword()<<" ���μ�";
			system("echo �����������  & pause > nul");
			break;
		case 0:
			return false;
		default:
			;
		}
	}while(1);
	return true;
}