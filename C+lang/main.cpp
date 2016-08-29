#include <iostream>

using namespace std;

struct emptyS{
};

class Point {
private :
    int x;
    int y;
public :
    explicit Point(int x = 0,int y = 0)
    :x(x),y(y){
        cout << "构造函数被调用" << endl;
    }

    Point(const Point & p){
        this->x = p.x;
        this->y = p.y;
        cout << "拷贝构造函数被调用" << endl;
    }

    ~Point(){
        cout << "析构函数被调用" << endl;
    }
    int getX(){
        return this->x;
    }
    int getY(){
        return this->y;
    }
    Point operator+(const Point & p){
        return Point(this->x + p.x,this->y + p.y);
    }

    Point & operator++ (){
        this->x++;
        this->y++;
        return *this;
    }

    Point operator++(int){
        Point tmp = * this;
        ++(*this);
        return tmp;
    }

    friend ostream& operator<< (ostream & out,const Point & p);

};

ostream& operator<< (ostream & out,const Point & p){
    out << p.x << "," << p.y;
    return out;
}

Point clonePoint(Point p){
    return p;
}

int main()
{
    cout << sizeof(struct emptyS) << endl;
    Point p(3,4);
    Point cp = clonePoint(p);
    cout << p << endl;
    return 0;
}
