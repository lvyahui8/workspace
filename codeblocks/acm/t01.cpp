#include <stdio.h>
#include <STRING.H>
#include <stdlib.h>
#include <QUEUE>
#include <STACK>

using namespace std;
//#define MAXN 512
//�ڽӾ���
typedef struct G_MATRIX{
	int n , e;				//	���㣬�ߵĸ���
	int eg[512][512];		//	�ڽӾ���
	bool acces[512];		//	��¼�����Ƿ񱻷���
} G_MATRIX;
//�ڽӱ�
typedef struct G_Node{
	int id;			//����Ķ�����
	int weight;		//���ﶥ���·��Ȩ��
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

