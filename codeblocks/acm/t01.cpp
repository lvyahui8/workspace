#include <stdio.h>
#include <STRING.H>
#include <stdlib.h>
#include <QUEUE>
#include <STACK>

using namespace std;
//#define MAXN 512
//邻接矩阵
typedef struct G_MATRIX{
	int n , e;				//	定点，边的个数
	int eg[512][512];		//	邻接矩阵
	bool acces[512];		//	记录顶点是否被访问
} G_MATRIX;
//邻接表
typedef struct G_Node{
	int id;			//到达的顶点编号
	int weight;		//到达顶点的路径权重
	G_Node * end;
}G_Node;

typedef struct G_Table{
	G_Node vertexs[512];
	int n,e;
	bool acces[512];
};
void visit(G_MATRIX &g,int d){
	// dfs
	static stack<int> s;
	g.acces[d] = true;
	s.push(d);
	while(!s.empty()){
		int tp = s.top();
		printf("%d ",tp);
		s.pop();
		int i;
		for(i = 0;i<g.n;i++){
			if(g.eg[tp][i] && !g.acces[i]){
				visit(g,i);
			}
		}
		
	}
}
int main(){
	
	{
		G_MATRIX g;
		scanf("%d%d",&g.n,&g.e);
		// init
		memset(g.acces,0,sizeof(bool)*g.n);
		int i;
		for (i = 0; i < g.n;i++)
		{
			memset(g.eg[i],0,sizeof(g.eg[i]));
		}
		// input
		for (i=0;i<g.e;i++)
		{
			int x,y,m;
			scanf("%d%d%d",&x,&y,&m);
			g.eg[x][y] = m;
		}
		// output
		for (i = 0;i<g.n;i++)
		{
			int j;
			for (j = 0;j<g.n;j++)
			{
				printf("%2d",g.eg[i][j]);
			}
			printf("\n");
		}

		// acess
		// bfs
	/*
		queue<int> q ;
		q.push(0);
		g.acces[0] = true;
		while (!q.empty())
		{

			int front = q.front();
			printf("%d ",front);
			q.pop();
			for (i = 0;i<g.n;i++)
			{
				if (g.eg[front][i] && !g.acces[i])
				{
					q.push(i);
					g.acces[i] = true;
				}
			}
		}
	*/
		visit(g,0);
	}
	{
		G_Table gt;
		scanf("%d%d",&gt.n,&gt.e);
		int i;
		for(i == 0;i<gt.e;i++){
			int x,y,m;
			scanf("%d%d%d",&x,&y,&m);
			gt.vertexs[x].weight = m;
			gt.vertexs[x].id = y;
		}

	}


	//getchar();
	system("pause");
	return 0;
}

