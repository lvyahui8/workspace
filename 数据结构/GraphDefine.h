#ifndef __GRAPH_DEFINE_H__
#define __GRAPH_DEFINE_H__

#define INT_MAX			9999
#define INFINITY		INT_MAX			// 最大值
#define MAX_VERTEX_NUM	20				// 最大顶点个数
#define VEX_FORM		"%c"			// 顶点输入格式
#define INFO_FORM		"%d"			// 边信息输入格式
typedef int InfoType;			// 弧相关信息类型
typedef char VextexType;		// 顶点数据类型
typedef int VRType;				// 顶点关系类型,对无权图，用0或者1表示是否相邻。对带权图，则是权值类型。
typedef enum { DG,DN,UDG,UDN} GraphKind;// 图类型 {有向图，有向网，无向图，无向网}

//////////////////////////////////////////////////////////////////////////
//	邻接矩阵存储结构: 可存储任意类型图
//////////////////////////////////////////////////////////////////////////
typedef struct{
	VRType		Adj;
	InfoType	Info;					// 该弧相关信息
}ArcCell,AdjMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
typedef struct{
	char cVexs[MAX_VERTEX_NUM];			// 顶点向量
	AdjMatrix arcs;						// 邻接矩阵
	int iVexNum,iArcNum;				// 图中当前顶点数和弧数
	GraphKind kind;						// 图的种类标志
}MGraph;


//////////////////////////////////////////////////////////////////////////
//	邻接表存储结构:	可存储任意类型的图
//////////////////////////////////////////////////////////////////////////
typedef struct ArcNode{
	int				iAdjvex;		// 该弧所指向的顶点位置
	struct ArcNode	*nextarc;		// 指向下一条弧的指针
	InfoType		Info;			// 该弧相关信息
}ArcNode;
typedef struct VNode{
	VextexType	cData;				// 顶点信息
	ArcNode		*firstarc;			// 指向第一条依附该顶点的弧的指针
}VNode,AdjList[MAX_VERTEX_NUM];
typedef struct {
	AdjList		vertices;
	int			iVexnum,iArcnum;	// 图的当前顶点个数和弧数
	GraphKind	Kind;				// 图的种类标志
}ALGraph;

//////////////////////////////////////////////////////////////////////////
//	十字链表存储结构: 只存储有向图
//////////////////////////////////////////////////////////////////////////
typedef struct ArcBox{
	int				iTailVex,iHeadVex;		// 该弧的尾和头顶点的位置
	struct ArcBox	*hLink,*tLink;			// 分别为弧头相同和弧尾相同的链域
	InfoType		Info;					// 该弧相关信息
}ArcBox;
typedef struct VexNode{
	VextexType		data;
	ArcBox			*firstIn,*firstOut;		// 分别指向了该顶点的第一条入弧和出弧
}VexNode;
typedef struct OLGraph{
	VexNode		xlist[MAX_VERTEX_NUM];		// 表头向量
	int			iVexNum,iArcNum;			// 有向图当前顶点数和弧数
}OLGraph;

//////////////////////////////////////////////////////////////////////////
//	邻接多重表:	存储无向图
//////////////////////////////////////////////////////////////////////////
typedef enum {unvisited,visited}VisitIf;
typedef struct EBox{
	VisitIf			mark;			// 访问标记
	int				iIVex,iJVex;	// 边依附的两个顶点的位置
	struct EBox		*iLink,*jLink;	// 分别指向依附这两个顶点的下一条边
	InfoType		Info;			// 该边信息指针
}EBox;
typedef struct VexBox{
	VextexType		data;
	EBox			*firstEdge;		// 指向第一条依附该顶点的边
}VexBox;
typedef struct {
	VexBox			adjmulist[MAX_VERTEX_NUM];
	int				iVexNum,iEdgeNum;	// 无向图当前顶点数和边数
}
#endif//__GRAPH_DEFINE_H__