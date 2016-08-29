
#include<stdio.h>
#include<stdlib.h>

int f[550],sum=0;
void Father(void)
{
	for(int i=1;i<505;i++)
		f[i]=i;
}

struct Tree
{
	int x;
	int y;
	int w;
}school[550000];

int cmp(const void *a,const void *b)
{
	return(((Tree *)a)->w-((Tree *)b)->w);
}

void union_set(int x,int y,int sz)
{
	f[x]=y;
	sum+=sz;
}

int CMP(const void *a,const void *b)
{
	return(*(int*)a-*(int*)b);
}
int main()
{
	int n,housenum,inputnum,beside[55000];
	scanf("%d",&n);
	while(n--)
	{
		int i,x,y,count=0; sum=0; Father();
		scanf("%d%d",&housenum,&inputnum);
		for(i=0;i<inputnum;i++)
			scanf("%d%d%d",&school[i].x,&school[i].y,&school[i].w);
		qsort(school,inputnum,sizeof(school[0]),cmp);
		for(i=0;i<inputnum;i++)
		{                                    //printf("w=%d ",school[i].w);
			for(x=school[i].x;x!=f[x];x=f[x])
				f[i]=f[f[i]];
			for(y=school[i].y;y!=f[y];y=f[y])
				f[y]=f[f[y]];
			if(x!=y)
			{
				union_set(x,y,school[i].w);
				count++;
				if(count==housenum) break;
			}
		}
		for(i=0;i<housenum;i++)
			scanf("%d",&beside[i]);
		qsort(beside,housenum,sizeof(beside[0]),CMP);    //printf("b=%d\n",beside[0]);
		printf("%d\n",beside[0]+sum);
	}
	return 0;
}
