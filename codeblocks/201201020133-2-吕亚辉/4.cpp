/*
11
1 4
8 11
0 6
2 13
5 7
3 8
8 12
12 14
5 9
6 10
3 5
[1,4][8,11][0,6][2,13][5,7][3,8][8,12][12,14][5,9][6,10][3,5]
[1,4][3,5][0,6][5,7][3,8][5,9][6,10][8,11][8,12][2,13][12,14]
4
[1,4][5,7][8,11][12,14]
*/
#include <iostream>
#include <cstdio>
using namespace std;

class Activity{
private :
	int startTime;
	int endTime;
public :
    bool isOK;
    Activity(){this->isOK=false;}
	Activity(const Activity & act);
	int getStartTime()const{return this->startTime;}
	int getEndTime()const{return this->endTime;}
	void setStartTime(const int &startTime){this->startTime = startTime;}
	void setEndTime(const int &endTime){this->endTime = endTime;}
	bool operator<=(const Activity & act)const;
	bool operator>=(const Activity & act)const;
    friend ostream & operator<<(ostream &out,const Activity &act);
};

Activity::Activity(const Activity &act){
	this->startTime = act.startTime;
	this->endTime = act.endTime;
	this->isOK = act.isOK;
}

bool Activity::operator<=(const Activity & act)const{
	return this->endTime <= act.endTime;
}
bool Activity::operator>=(const Activity & act)const{
	return this->endTime >= act.endTime;
}
ostream & operator<<(ostream &out,const Activity &act){
    out<<"["<<act.startTime<<","<<act.endTime<<"]";
    return out;
}

template<typename T>
void mswap(T &a,T &b){
	T temp = a;
	a = b;
	b = temp;
}

//l数组的第一个元素索引，n数组元素个数，a数组首地址
template<typename T>
void mqsort(int l,int n,T * a){
    if(n<l+2) return;
    int p,e,r;
    p = l;                              //节点选在数组的第一个元素
    e = r = n;
    while(l<r){
        while(++l < e && a[l]<=a[p]);  //找出在[l,e]之中第一个比节点大的数
        while(--r > p && a[r]>=a[p]);  // 找出在[p,r]之中第一个比节点小的数（这个数一般更靠近r）
        //交换找出的这两个数，将小的放在节点前面，
        //大的放在节点后面。如果r已经小于l了，就必要交换了，结下来直接将节点放在r与l中间就行了
        if(l<r) mswap(a[l],a[r]);
    }
    mswap(a[p],a[r]);                    //将节点放到正确的位置上去
    //下面对节点左侧和右侧再重复上面的过程
    mqsort(p,r,a);                       //左侧
    mqsort(l,e,a);                       //右侧
}


void print(Activity *a,int n,bool isSelect){
    int i = 1;
    for(;i<=n;i++){
        if(!isSelect || a[i].isOK){
            cout<<*(a+i);
        }
    }
    cout<<endl;
}

int greedySelector(Activity * atcs,int n){
    atcs[1].isOK = true;
    int j=1;
    int c = 1;
    for(int i=2;i<=n;i++){
        if(atcs[i].getStartTime()>=atcs[j].getEndTime()){
            atcs[i].isOK = true;j=i;c++;
        }
    }
    return c;
}

int main(void){
	int n,i,j,k;
	Activity * acts = NULL;
	cin>>n;
	acts =  new Activity[n+1];
	for(i=1;i<=n;i++){
		int a,b;
		cin>>a>>b;
		acts[i].setStartTime(a),acts[i].setEndTime(b);
	}
	print(acts,n,false);
    mqsort(1,n+1,acts);
    print(acts,n,false);
    int c = greedySelector(acts,n);
    cout<<c<<endl;
    print(acts,n,true);
	delete acts;
	return 0;
}
