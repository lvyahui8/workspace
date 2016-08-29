#include <iostream>
#include <cstdio>
#include <cstring>


using namespace std;

int main(){

//freopen("data.in","r",stdin);
    string str;
    while(getline(cin,str)){

        int i = str.find("//");
        if(i>=0){
            str = str.substr(0,i);
        }
        if(!str.empty()){
            cout << str << endl;
        }
    }
    return 0;
}
