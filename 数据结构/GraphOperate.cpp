#include <stdio.h>
#include "GraphDefine.h"
#include "Define.h"
#include <malloc.h>

//////////////////////////////////////////////////////////////////////////
//	邻接矩阵图的相关操作
//////////////////////////////////////////////////////////////////////////
Status CreateDG(MGraph &G);		// 构造有向图
Status CreateDN(MGraph &G);		// 构造有向网
Status CreateUDG(MGraph &G);	// 构造无向图
Status CreateUDN(MGraph &G);	// 构造无向网
int LocateVex(const MGraph &G,const VextexType &v);	// 获得顶点v在图中的位置
Status CreateGraph(MGraph &G,VextexType v){
	// 采用数组（邻接矩阵）表示法，构造图G
	int iType;
	scanf("%d%*c",&iType);
	G.kind = (GraphKind)iType;
	switch(G.kind) {
	case DG: return CreateDG(G);		// 构造有向图
	case DN: return CreateDN(G);		// 构造有向网
	case UDG:return CreateUDG(G);		// 构造无向图
	case UDN:return CreateUDN(G);		// 构造无向网
	default:
		return ERROR;
	}
}

Status CreateUDN(MGraph &G){
	//  采用数组（邻接矩阵）表示法，构造网G
	int i,j,k;
	int IncInfo;
	scanf("%d %d %d",&G.iVexNum,&G.iArcNum,&IncInfo);
	for(i=0;i<G.iVexNum;++i)			// 构造顶点向量
		scanf("%c%*c",&G.cVexs[i]);
	for(i=0;i<G.iVexNum;i++){
		for(j=0;j<G.iVexNum;j++){		// 初始化邻接矩阵
			G.arcs[i][j].Adj = INFINITY;
			G.arcs[i][j].Info =NULL;		
		}
	}
	VextexType v1,v2;
	int w;
	for(k=0;k<G.iArcNum;k++){			// 构造邻接矩阵
		scanf("%c %c %d%*c",&v1,&v2,&w);
		i = LocateVex(G,v1),j = LocateVex(G,v2);	// 确定v1,v2在G中的位置
		G.arcs[i][j].Adj = w;			// 弧<v1,v2>的权值
		if(IncInfo) scanf(INFO_FORM,G.arcs[i][j].Info);
		G.arcs[j][i] = G.arcs[i][j];	// 置<v1,v2>对称弧<v2,v1>
	}
	return OK;
}

//////////////////////////////////////////////////////////////////////////
//	十字链表图的相关操作
//////////////////////////////////////////////////////////////////////////
int LocateVex(const OLGraph &G,const VextexType &v);	// 获得顶点v在图中的位置

Status CreateDG(OLGraph &G){
	// 采用十字链表存储表示，构造有向图 G(G.kind = DG)
	InfoType IncInfo;
	scanf("%d %d %d",G.iVexNum,G.iArcNum,&IncInfo);
	int i;
	for(i=0;i<G.iVexNum;i++){			// 构造表头向量
		scanf(VEX_FORM "%*c",G.xlist[i].data);			// 输入顶点值
		G.xlist[i].firstIn = G.xlist[i].firstOut = NULL;// 初始化指针
	}
	int k,j;
	VextexType	v1,v2;
	ArcBox * p;
	for(k=0;k<G.iArcNum;k++){			// 输入各弧并构造十字链表 
		scanf(VEX_FORM VEX_FORM,&v1,&v2);			// 输入一条弧的始点和终点
		i = LocateVex(G,v1),j = LocateVex(G,v2);	// 确定V1和 V2在G中的位置
		p = (ArcBox*)malloc(sizeof(ArcBox));		// 假设有足够的空间
		// 对弧节点赋值
		p->iTailVex = v1,p->iHeadVex = v2;
		p->hLink = G.xlist[j].firstIn,p->tLink = G.xlist[i].firstOut;
		p->Info = NULL;
		G.xlist[j].firstIn = G.xlist[i].firstOut = p;	// 完成在入弧与出弧的链头的插入
		if(IncInfo) scanf(INFO_FORM,&p->Info);			//若含有相关信息，则输入
	}
	return OK;
}

//////////////////////////////////////////////////////////////////////////
//	深度优先搜索
//////////////////////////////////////////////////////////////////////////
bool visited[MAX_VERTEX_NUM];
Status(*VisitFunc)(int v);
int FirstAdjVex(MGraph,int);
int NextAdjVex(MGraph,int);

void  DFSTeaverse(MGraph G,Status (*Visit)(int v)){
	int v;
	VisitFunc = Visit;
	for(v=0;v<G.iVexNum;v++) visited[v] = false;
	for(v=0;v<G.iVexNum;v++)
		if(!visited[v]) DFS(G,v);
}

void DFS(MGraph G,int v){
	visited[v] = true;
	VisitFunc(v);
	int w;
	for(w = FirstAdjVex(G,v); w>0 ; w = NextAdjVex(G,v))
		if(!visited[w]) DFS(G,w);
}
//////////////////////////////////////////////////////////////////////////
//	广度优先搜索
//////////////////////////////////////////////////////////////////////////
//	队列相关函数
void InitQueue(int []);
void EnQueue(int []);
bool QueueEmpty(int []);
void DFSTeaverse(MGraph G,Status (*Visit)(int v)){
	int v;
	for (v=0;v<G.iVexNum;v++)
	{
		visited[v] = false;
	}
	int Q[MAX_VERTEX_NUM];
	InitQueue(Q);
	for(v=0;v<G.iVexNum;v++){
		if(!visited[v]){
			visited[v] = true;
			Visit(v);
			EnQueue(Q);
			while(!QueueEmpty(Q)){
				int u,w;
				DeQueue(Q,u);
				for( w = FirstAdjVex(G,u); w>=0 ; w = NextAdjVex(G,u))
					if(!visited[w]){
						visited[w] = true;
						Visit(w);
						EnQueue(Q,w);
					}
			}
		}
	}
}