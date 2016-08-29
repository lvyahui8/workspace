#include <cstdio>
#include <algorithm>

#define MAXS 1000000+5
using namespace std;

bool inset[MAXS];

int  main(){
    freopen("data.in","r",stdin);
	int n;
	while((scanf("%d",&n)==1)){
        for(int x=0;x<MAXS;x++){inset[x]=false;}
		for(int x=0;x<n;x++){
            int k,s;
            scanf("%d%d",&k,&s);
            switch(k){
            case 1:
                inset[s] = true;
                break;
            case 2:
                inset[s] = false;
                break;
            case 3:
                if(inset[s]){
                    int ct = 0;
                    for(int i=s;i>0;i--){
                        if(inset[i]){
                            ct++;
                        }
                    }
                    printf("%d\n",ct);
                }else{
                    printf("sorry\n");
                }
                break;
            default :
                break;
            }
		}

	}
	return 0;
}
