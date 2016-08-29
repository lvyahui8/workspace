#include <iostream>
using std::cout;
using std::endl;

//struct Point{
class Point{
public:
	int x;
	int y;
	void output(){
		cout<<x<<endl<<y<<endl;
	}
};

void main(){
	Point pt;
	pt.x = 5;
	pt.y = 5;
	pt.output();
}