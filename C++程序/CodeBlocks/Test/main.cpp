#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;
class Test{
private:
    static string toS;
    string name ;
    int id;
    public:
    Test(string n , int i){
        this->name = n ;
        this->id = i;
    }
    string toString(){
        char buf[255] = {0};
        sprintf(buf,"name:%s id:%d",this->name.c_str() , this->id);
        this->toS = "";
        this->toS.append(buf);
        return toS;
    }
};

string Test::toS = "";
int main()
{
    cout << "Hello world!" << endl;
    Test t("nihao",12);
    cout<<t.toString()<<endl;
    Test t2("hkdhf",34);
    cout<<t2.toString()<<endl;
    return 0;
}
