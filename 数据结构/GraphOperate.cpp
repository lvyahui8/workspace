#include <stdio.h>
#include "GraphDefine.h"
#include "Define.h"
#include <malloc.h>

//////////////////////////////////////////////////////////////////////////
//	�ڽӾ���ͼ����ز���
//////////////////////////////////////////////////////////////////////////
Status CreateDG(MGraph &G);		// ��������ͼ
Status CreateDN(MGraph &G);		// ����������
Status CreateUDG(MGraph &G);	// ��������ͼ
Status CreateUDN(MGraph &G);	// ����������
int LocateVex(const MGraph &G,const VextexType &v);	// ��ö���v��ͼ�е�λ��
Status CreateGraph(MGraph &G,VextexType v){
	// �������飨�ڽӾ��󣩱�ʾ��������ͼG
	int iType;
	scanf("%d%*c",&iType);
	G.kind = (GraphKind)iType;
	switch(G.kind) {
	case DG: return CreateDG(G);		// ��������ͼ
	case DN: return CreateDN(G);		// ����������
	case UDG:return CreateUDG(G);		// ��������ͼ
	case UDN:return CreateUDN(G);		// ����������
	default:
		return ERROR;
	}
}

Status CreateUDN(MGraph &G){
	//  �������飨�ڽӾ��󣩱�ʾ����������G
	int i,j,k;
	int IncInfo;
	scanf("%d %d %d",&G.iVexNum,&G.iArcNum,&IncInfo);
	for(i=0;i<G.iVexNum;++i)			// ���춥������
		scanf("%c%*c",&G.cVexs[i]);
	for(i=0;i<G.iVexNum;i++){
		for(j=0;j<G.iVexNum;j++){		// ��ʼ���ڽӾ���
			G.arcs[i][j].Adj = INFINITY;
			G.arcs[i][j].Info =NULL;		
		}
	}
	VextexType v1,v2;
	int w;
	for(k=0;k<G.iArcNum;k++){			// �����ڽӾ���
		scanf("%c %c %d%*c",&v1,&v2,&w);
		i = LocateVex(G,v1),j = LocateVex(G,v2);	// ȷ��v1,v2��G�е�λ��
		G.arcs[i][j].Adj = w;			// ��<v1,v2>��Ȩֵ
		if(IncInfo) scanf(INFO_FORM,G.arcs[i][j].Info);
		G.arcs[j][i] = G.arcs[i][j];	// ��<v1,v2>�Գƻ�<v2,v1>
	}
	return OK;
}

//////////////////////////////////////////////////////////////////////////
//	ʮ������ͼ����ز���
//////////////////////////////////////////////////////////////////////////
int LocateVex(const OLGraph &G,const VextexType &v);	// ��ö���v��ͼ�е�λ��

Status CreateDG(OLGraph &G){
	// ����ʮ������洢��ʾ����������ͼ G(G.kind = DG)
	InfoType IncInfo;
	scanf("%d %d %d",G.iVexNum,G.iArcNum,&IncInfo);
	int i;
	for(i=0;i<G.iVexNum;i++){			// �����ͷ����
		scanf(VEX_FORM "%*c",G.xlist[i].data);			// ���붥��ֵ
		G.xlist[i].firstIn = G.xlist[i].firstOut = NULL;// ��ʼ��ָ��
	}
	int k,j;
	VextexType	v1,v2;
	ArcBox * p;
	for(k=0;k<G.iArcNum;k++){			// �������������ʮ������ 
		scanf(VEX_FORM VEX_FORM,&v1,&v2);			// ����һ������ʼ����յ�
		i = LocateVex(G,v1),j = LocateVex(G,v2);	// ȷ��V1�� V2��G�е�λ��
		p = (ArcBox*)malloc(sizeof(ArcBox));		// �������㹻�Ŀռ�
		// �Ի��ڵ㸳ֵ
		p->iTailVex = v1,p->iHeadVex = v2;
		p->hLink = G.xlist[j].firstIn,p->tLink = G.xlist[i].firstOut;
		p->Info = NULL;
		G.xlist[j].firstIn = G.xlist[i].firstOut = p;	// ������뻡���������ͷ�Ĳ���
		if(IncInfo) scanf(INFO_FORM,&p->Info);			//�����������Ϣ��������
	}
	return OK;
}

//////////////////////////////////////////////////////////////////////////
//	�����������
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
//	�����������
//////////////////////////////////////////////////////////////////////////
//	������غ���
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