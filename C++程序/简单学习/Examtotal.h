#ifndef EXAMTOTAL__H
#define EXAMTOTAL__H
class Examtotal{
private:
	int num;			//ѧ��
	int score;			//���Է���
	static int count;	//������
public:
	static int sum;							//�����ܷ���
	friend void Display(Examtotal &s);		//��Ԫ����
	Examtotal(int m);
	static void Message();					//�����Ϣ
};
#endif//EXAMTOTAL__H