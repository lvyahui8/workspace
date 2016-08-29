#include<iostream> 
using namespace std; 
 
class Shape   
{ 
protected: 
 double s; 
public: 
 Shape(){s=0;} 
 virtual double Area() = 0;  
}; 
 
class Square:public Shape  
{ 
private: 
 double length; 
public: 
 Square(double l)   
 { 
  length = l;  
 } 
 double Area()  
 { 
  s = length*length; 
  return s; 
 } 
}; 
class Trapezoid:public Shape  
{ 
private: 
 double top;   
 double bottom; 
 double height;  
public: 
 Trapezoid(double t,double b,double h)     
 { 
  top=t; 
  bottom=b; 
  height=h; 
 } 
 double Area()  
 { 
  s=(top+bottom)*height/2; 
  return s; 
 } 
}; 
class Triangle:public Shape
{
private:
	double bottom;
	double height;
public:
Triangle(double b,double h)
{
	bottom=b;
	height=h;
}
double Area()
{
	s=bottom*height/2;
	return s;
}
};
void main() 
{ 
 Shape *pShape;  
 Square square(4);  
 Trapezoid trapezoid(3.5,5.5,7); 
 Triangle triangle(6,4);
 pShape = &square;    
 cout<<"正方形面积："<<pShape->Area()<<endl; 
 pShape = &triangle;   
 cout<<"三角形面积："<<pShape->Area()<<endl; 
 pShape = &trapezoid;  
 cout<<"梯形面积："<<pShape->Area()<<endl; 
}