#ifndef EXAMTOTAL__H
#define EXAMTOTAL__H
class Examtotal{
private:
	int num;			//学号
	int score;			//考试分数
	static int count;	//总人数
public:
	static int sum;							//考试总分数
	friend void Display(Examtotal &s);		//友元函数
	Examtotal(int m);
	static void Message();					//输出信息
};
#endif//EXAMTOTAL__H