#include<stdio.h>
#include<string.h>
#define INF 0x7fffffff
const int MAXN=502;
int graph[MAXN][MAXN];
int Prim(int n)
{
	int lowcost[MAXN];
	int i,j,minm,mind,ans=0;
	for(i=2;i<=n;i++)
		lowcost[i]=graph[1][i];
	for(i=1;i<=n-1;i++)//n-1Ìõ±ß
	{
		minm=INF;
		for(j=2;j<=n;j++)
			if(lowcost[j]<minm&&lowcost[j]!=0)
			{minm=lowcost[j];mind=j;}
			ans+=minm;
			lowcost[mind]=0;
			for(j=2;j<=n;j++)
				if(lowcost[j]>graph[j][mind]&&lowcost[j]!=0)
					lowcost[j]=graph[j][mind];
	}
	return ans;
}
int main()
{
	int T,i,e,v,a,b,w;
	scanf("%d",&T);
	while(T--)
	{
		memset(graph,127,sizeof(int));
		scanf("%d%d",&v,&e);
		for(i=1;i<=e;i++)
		{
			scanf("%d%d%d",&a,&b,&w);
			graph[a][b]=graph[b][a]=w;
		}
		int cnt=Prim(v);
		int minm=INF;
		for(i=0;i<v;i++)
		{
			scanf("%d",&w);
			if(minm>w)minm=w;
		}
		printf("%d\n",cnt+minm);
	}
	return 0;
}
