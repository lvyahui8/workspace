#ifndef __STUDENT__H
#define __STUDENT__H
class Student{
private:
	int No;					//����NoΪ˽�����ݳ�Ա
protected:
	int Age;				//����AgeΪ�������ݳ�Ա
public:
	char Sex;				//����SexΪ�������ݳ�Ա
	Student(int no,int age,char sex);
	int GetNo();
	int GetAge();
	void ShowS();			//��ʾ���ݳ�Ա
};
#endif//__STUDENT__H