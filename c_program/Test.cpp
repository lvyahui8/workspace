#include <iostream>
#include <cstdio>
using namespace std;

const int MAXN = 100005;

typedef struct{
	int l;
	int r;
}box;
box b[MAXN];
int n;
bool fx = true;
long double sum;

void xtoyz(int x,int y){
	b[b[x].l].r = b[x].r;b[b[x].r].l = b[x].l;	
	b[b[y].l].r = x;b[x].r = y;b[x].l = b[y].l;b[y].l = x;
}

void xtoyy(int x,int y){
	xtoyz(x,b[y].r);
}

void swapxy(int x,int y){
	int tmp = b[x].r;
	xtoyz(x,y);
	xtoyz(y,tmp);
}

void js(){
	int i,k=0;
	sum=0;
	int tmp = n+1;
	if(fx){
		i=0;
		while(b[i].r!=tmp){
			//cout<<b[i].r;//<<" "<<b[i].l<<" ";
			if((++k)&1){sum+=b[i].r;//cout<<b[i].r;
			}
			i = b[i].r;
		}
	}else{
		i = tmp;
		while(b[i].l!=0){
			//cout<<b[i].l;
			if((++k)&1){sum+=b[i].l;//cout<<b[i].l;
			}
			i = b[i].l;
		}
	}
	//cout<<endl;
}

void fz(){
	fx = !fx;
}
int main()
{
	freopen("data.txt","r",stdin);
	int m;
	while(1){
		fx = true;
		cin>>n>>m;
		//init
		b[0].l=-1,b[0].r = 1;
		b[n+1].l=n;b[n+1].r = n+2;
		for(int i=1;i<=n;i++){
			b[i].l = i-1;
			b[i].r = i+1;
		}
		while(m--){
			int q,x,y;
			cin>>q>>x>>y;
			if(x==y) continue;
			switch(q){
			case 1:
				xtoyz(x,y);break;
			case 2:
				xtoyy(x,y);break;
			case 3:
				swapxy(x,y);break;
			case 4:
				fz();break;
			default :
				break;
			}
		}
		js();
		//cout<<sum<<endl;
		printf("%.0lf\n",sum);
	}
	return 0;
}