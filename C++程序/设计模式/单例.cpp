#include <iostream>
using std::cout;
using std::endl;

class CBoss{
private:
	int m_iVar;
	static CBoss * m_pBoss;
protected:
/*
	CBoss(int iVar=0){
		if(NULL!=m_pBoss){
			exit(0);
		}
		else{
			m_pBoss = this;
		}
		this->m_iVar = iVar;
	}
	*/
	CBoss(int iVar = 0){
		this->m_iVar = iVar;
	}
public:
	static CBoss * AllocateMemory(int iVar=0){
		if(NULL == m_pBoss){
			m_pBoss = new CBoss(iVar);
		}
		return m_pBoss;
	}
	void ShowVar()const{
		cout<<"Boss"<<this->m_iVar<<".ShowVar()"<<endl;
	}
};

CBoss * CBoss::m_pBoss = NULL;

void main(){
/*
	CBoss	Boss0(0);
	Boss0.ShowVar();
	cout<<&Boss0<<endl;
*/
	CBoss * pBoss1 = CBoss::AllocateMemory(1);
	pBoss1->ShowVar();
	CBoss * pBoss2 = CBoss::AllocateMemory(2);
	pBoss2->ShowVar();
	cout<<pBoss1<<endl;
	cout<<pBoss2<<endl;
/*
	CBoss	Boss3(3);
	CBoss	Boss4(4);
	cout<<&Boss3<<endl;
	cout<<&Boss4<<endl;
*/
/*
	CBoss * pBoss5 = new CBoss(5);
	pBoss5->ShowVar();
*/
}