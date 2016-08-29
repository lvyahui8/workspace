#ifndef __GRAPH_DEFINE_H__
#define __GRAPH_DEFINE_H__

#define INT_MAX			9999
#define INFINITY		INT_MAX			// ���ֵ
#define MAX_VERTEX_NUM	20				// ��󶥵����
#define VEX_FORM		"%c"			// ���������ʽ
#define INFO_FORM		"%d"			// ����Ϣ�����ʽ
typedef int InfoType;			// �������Ϣ����
typedef char VextexType;		// ������������
typedef int VRType;				// �����ϵ����,����Ȩͼ����0����1��ʾ�Ƿ����ڡ��Դ�Ȩͼ������Ȩֵ���͡�
typedef enum { DG,DN,UDG,UDN} GraphKind;// ͼ���� {����ͼ��������������ͼ��������}

//////////////////////////////////////////////////////////////////////////
//	�ڽӾ���洢�ṹ: �ɴ洢��������ͼ
//////////////////////////////////////////////////////////////////////////
typedef struct{
	VRType		Adj;
	InfoType	Info;					// �û������Ϣ
}ArcCell,AdjMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
typedef struct{
	char cVexs[MAX_VERTEX_NUM];			// ��������
	AdjMatrix arcs;						// �ڽӾ���
	int iVexNum,iArcNum;				// ͼ�е�ǰ�������ͻ���
	GraphKind kind;						// ͼ�������־
}MGraph;


//////////////////////////////////////////////////////////////////////////
//	�ڽӱ�洢�ṹ:	�ɴ洢�������͵�ͼ
//////////////////////////////////////////////////////////////////////////
typedef struct ArcNode{
	int				iAdjvex;		// �û���ָ��Ķ���λ��
	struct ArcNode	*nextarc;		// ָ����һ������ָ��
	InfoType		Info;			// �û������Ϣ
}ArcNode;
typedef struct VNode{
	VextexType	cData;				// ������Ϣ
	ArcNode		*firstarc;			// ָ���һ�������ö���Ļ���ָ��
}VNode,AdjList[MAX_VERTEX_NUM];
typedef struct {
	AdjList		vertices;
	int			iVexnum,iArcnum;	// ͼ�ĵ�ǰ��������ͻ���
	GraphKind	Kind;				// ͼ�������־
}ALGraph;

//////////////////////////////////////////////////////////////////////////
//	ʮ������洢�ṹ: ֻ�洢����ͼ
//////////////////////////////////////////////////////////////////////////
typedef struct ArcBox{
	int				iTailVex,iHeadVex;		// �û���β��ͷ�����λ��
	struct ArcBox	*hLink,*tLink;			// �ֱ�Ϊ��ͷ��ͬ�ͻ�β��ͬ������
	InfoType		Info;					// �û������Ϣ
}ArcBox;
typedef struct VexNode{
	VextexType		data;
	ArcBox			*firstIn,*firstOut;		// �ֱ�ָ���˸ö���ĵ�һ���뻡�ͳ���
}VexNode;
typedef struct OLGraph{
	VexNode		xlist[MAX_VERTEX_NUM];		// ��ͷ����
	int			iVexNum,iArcNum;			// ����ͼ��ǰ�������ͻ���
}OLGraph;

//////////////////////////////////////////////////////////////////////////
//	�ڽӶ��ر�:	�洢����ͼ
//////////////////////////////////////////////////////////////////////////
typedef enum {unvisited,visited}VisitIf;
typedef struct EBox{
	VisitIf			mark;			// ���ʱ��
	int				iIVex,iJVex;	// �����������������λ��
	struct EBox		*iLink,*jLink;	// �ֱ�ָ�������������������һ����
	InfoType		Info;			// �ñ���Ϣָ��
}EBox;
typedef struct VexBox{
	VextexType		data;
	EBox			*firstEdge;		// ָ���һ�������ö���ı�
}VexBox;
typedef struct {
	VexBox			adjmulist[MAX_VERTEX_NUM];
	int				iVexNum,iEdgeNum;	// ����ͼ��ǰ�������ͱ���
}
#endif//__GRAPH_DEFINE_H__