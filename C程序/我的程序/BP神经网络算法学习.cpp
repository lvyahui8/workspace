#include "stdafx.h"
#include <stdlib.h>
#include <time.h>
#include <math.h>
/*********************************************
inpoints Ϊ������Ԫ�������ɸı�
outpointsΪ�����Ԫ����
defaultpointsΪ������Ԫ����
datagroughΪ�������ݸ���
**********************************************

******�������ݶ�������޸�*****/
#define A 0
#define a 1
#define b 1
#define c 1
#define ALFA 0.85           
#define BETA 0.2      //ѧϰ��0~1
#define Total 20000
#define inpoints  9
#define outpoints 5
#define defaultpoints 28
#define datagrough 44
#define forecastdata 4

/**********�����������********/
double InpointData[datagrough][inpoints],OutpointData[datagrough][outpoints];                          /*            �����������             */
double InpointData_MAX[inpoints],InpointData_MIN[inpoints];                                            /*      ÿ�������������       */
double OutpointData_MAX[outpoints],OutpointData_MIN[outpoints];                                        /*      ÿ��������С����       */
double w[defaultpoints][inpoints],limen[defaultpoints],v[outpoints][defaultpoints];                    /*            ����Ȩֵ����ֵ           */
double dlta_w[defaultpoints][inpoints],dlta_limen[defaultpoints],dlta_v[outpoints][defaultpoints];     /*       ����Ȩ����ֵ����ֵ            */
double defaultOutpoint[defaultpoints],Outpoint_dp[outpoints],Outpoint_ep[datagrough];
/**************************�������ļ�******************************/
void ReadData()
{
	FILE *fp1,*fp2;
	int i,j;
	if((fp1=fopen("D:\\data\\ѵ������.txt","r"))==NULL)
	{
		printf("1can not open the file\n");
		exit(0);
	}
	for(i=0;i<datagrough;i++)
		for(j=0;j<inpoints;j++)
				fscanf(fp1,"%lf",&InpointData[i][j]);
         fclose(fp1);

	if((fp2=fopen("D:\\data\\ѵ�����.txt","r"))==NULL)
	{
		printf("2can not open the file\n");
		exit(0);
	}
	for(i=0;i<datagrough;i++)
		for(j=0;j<outpoints;j++)
				fscanf(fp2,"%lf",&OutpointData[i][j]);
         fclose(fp2);
}
/*****************************************************/

/*****************************************��һ��******************************************************/
void unitary()
{
	int i,j;
	int k=0;
	for(j=0;j<inpoints;j++)                       //�ҳ�ÿ�е������Сֵ���������InpointData_MAX[j]��InpointData_MIN[j]��
	{ 
		InpointData_MAX[j]=InpointData[0][j];
        InpointData_MIN[j]=InpointData[0][j];
       for(i=0;i<datagrough;i++)
		   if(InpointData_MAX[j]<InpointData[i][j])
                 InpointData_MAX[j]=InpointData[i][j];
		     else if(InpointData_MIN[j]>InpointData[i][j])
                    InpointData_MIN[j]=InpointData[i][j];
	}

	for(j=0;j<outpoints;j++)                       //�ҳ�ÿ�е������Сֵ���������OutpointData_MAX[j]��OutpointData_MIN[j]��
	{ 
		OutpointData_MAX[j]=OutpointData[0][j];
        OutpointData_MIN[j]=OutpointData[0][j];
       for(i=0;i<datagrough;i++)
		   if(OutpointData_MAX[j]<OutpointData[i][j])
                 OutpointData_MAX[j]=OutpointData[i][j];
		     else if(OutpointData_MIN[j]>OutpointData[i][j])
                    OutpointData_MIN[j]=OutpointData[i][j];
	}
	/***************�����ݹ�һ����,����֮�������ȫ����[0��1]֮��*************************/
	for(j=0;j<inpoints;j++)
      for(i=0;i<datagrough;i++)
		  if(InpointData_MAX[j]==0)
			  InpointData[i][j]=0;
		  else
			  InpointData[i][j]=(InpointData[i][j]-InpointData_MIN[j]+A)/(InpointData_MAX[j]-InpointData_MIN[j]+A);

	for(j=0;j<outpoints;j++)
      for(i=0;i<datagrough;i++)
		  if(OutpointData_MAX[j]==0)
			  OutpointData[i][j]=0;
		  else
			  OutpointData[i][j]=(OutpointData[i][j]-OutpointData_MIN[j]+A)/(OutpointData_MAX[j]-OutpointData_MIN[j]+A);

}
/*****************************************************/

/*********************��ʼ�����������ֵ**************************/
void Initialization()
{
	int i,j;
    srand((unsigned)time(NULL));                           //ͷ�ļ��� #include  <time.h>

	for(i=0;i<defaultpoints;i++)                                  //������㵽���������Ȩ�����ֵLianJie_w[i][j],��Щֵ��[0,1]
    	for(j=0;j<inpoints;j++)
		{ 
	    	w[i][j]=(rand()*2.0/RAND_MAX-1)/2; 
	    	dlta_w[i][j]=0;
		}

	for(i=0;i<defaultpoints;i++)
	{
		limen[i]=(rand()*2.0/RAND_MAX-1)/2;
	    dlta_limen[i]=0;
	}

	for(i=0;i<outpoints;i++) //�����㵽����������Ȩ����ֵ
		for(j=0;j<defaultpoints;j++)
		{
		  v[i][j]=(rand()*2.0/RAND_MAX-1)/2;
		  dlta_v[i][j]=0;
		}
}
/**********************�������ļ���������*******************************/
void out_sub1(int t)
{
	int i,j;
	double defaultInpoint[defaultpoints];
	double Outpoint_y[outpoints];
    Outpoint_ep[t]=0;
	for(i=0;i<defaultpoints;i++)
	{
		double sum=0;
		for(j=0;j<inpoints;j++)
			sum+=w[i][j]*InpointData[t][j];
		defaultInpoint[i]=sum+limen[i];
		defaultOutpoint[i]=1/(a+b*exp(-1*c*defaultInpoint[i]));//��O[i]
	}

	for(j=0;j<outpoints;j++)//��Y[i]
	{
		Outpoint_y[j]=0;
		for(i=0;i<defaultpoints;i++)
		Outpoint_y[j]+=v[j][i]*defaultOutpoint[i];
		Outpoint_dp[j]=OutpointData[t][j]-Outpoint_y[j];		
        Outpoint_ep[t]+=Outpoint_dp[j]*Outpoint_dp[j]/2;
	}
}
/*****************************����Ȩֵ******************************************/
void out_sub2(int t)
{
	 int i,j,k;
	 double s;
     for(i=0;i<defaultpoints;i++)
	 {
		 s=0;
		 for(j=0;j<outpoints;j++)
		 {  
			 dlta_v[j][i]=ALFA*dlta_v[j][i]+BETA*Outpoint_dp[j]*defaultOutpoint[i]; //
             s+=v[j][i]*Outpoint_dp[j];
			 v[j][i]+=dlta_v[j][i];
		 }
		 dlta_limen[i]=ALFA*dlta_limen[i]+BETA*defaultOutpoint[i]*(1-defaultOutpoint[i])*s;//
		 limen[i]+=dlta_limen[i];
		 for(k=0;k<inpoints;k++)
		 {
			 dlta_w[i][k]=ALFA*dlta_w[i][k]+BETA*defaultOutpoint[i]*(1-defaultOutpoint[i])*s*InpointData[t][k];//
			 w[i][k]=w[i][k]+dlta_w[i][k];
		 }	 
	 }
}
/*******************************************************/
void forecast()
{
	int i,j,t,k=0;
	double e,e1[forecastdata]={0};         //ѵ�����
	double  sss;
 	double InputData_x[forecastdata][inpoints],tp[forecastdata][outpoints];
	double defInpoint,defOutpoint[defaultpoints],y[forecastdata][outpoints];//y[forecastdata][outpoints]Ϊ����������
	FILE *fp1,*fp3;
		if((fp1=fopen("D:\\data\\Ԥ������.txt","r"))==NULL)   //������������
	{
		printf("3can not open the file\n");
		exit(0);
	}
	for(i=0;i<forecastdata;i++)
		for(j=0;j<inpoints;j++)
				fscanf(fp1,"%lf",&InputData_x[i][j]);
         fclose(fp1);

		 if((fp3=fopen("D:\\data\\Ԥ�����.txt","r"))==NULL)   //ʵ�ʼ��������
	{
		printf("31can not open the file\n");
		exit(0);
	}
	for(i=0;i<forecastdata;i++)
		for(j=0;j<outpoints;j++)
				fscanf(fp3,"%lf",&tp[i][j]);
         fclose(fp3);

    for(j=0;j<inpoints;j++)                           // �������ݹ�һ��
      for(i=0;i<forecastdata;i++)
		  if(InpointData_MAX[j]==0)
			  InputData_x[i][j]=0;
		  else
			  InputData_x[i][j]=(InputData_x[i][j]-InpointData_MIN[j]+A)/(InpointData_MAX[j]-InpointData_MIN[j]+A);

    for(j=0;j<outpoints;j++)
      for(i=0;i<forecastdata;i++)
		  if(OutpointData_MAX[j]==0)
			  tp[i][j]=0;
		  else
			  tp[i][j]=(tp[i][j]-OutpointData_MIN[j]+A)/(OutpointData_MAX[j]-OutpointData_MIN[j]+A);

    do
	{
    	Initialization(); //��ʼ������Ȩֵw[i][j],limen[i],v[k][i]
		k=0;
    	do
	{
	    e=0;
		for(t=0;t<datagrough;t++)
	{
		out_sub1(t);                //��������������
		out_sub2(t);                //������㣬����Ȩֵ
		e+=Outpoint_ep[t];          //����������
	}
		k++;
	}while((k<Total)&&(e>0.1));
     sss=0;                //�м����
     for(t=0;t<forecastdata;t++)
	 {
	    e1[t]=0;
        for(i=0;i<defaultpoints;i++)
		{
	    	double sum=0;
        	for(j=0;j<inpoints;j++)
			   sum+=w[i][j]*InputData_x[t][j];
	    	defInpoint=sum+limen[i];
	    	defOutpoint[i]=1/(a+b*exp(-1*c*defInpoint));
		}
    	for(j=0;j<outpoints;j++)
		{
	    	y[t][j]=0;
	    	for(i=0;i<defaultpoints;i++)
	    		y[t][j]+=v[j][i]*defOutpoint[i];
            e1[t]+=(y[t][j]-tp[t][j])*(y[t][j]-tp[t][j])/2;
	    	y[t][j]=y[t][j]*(OutpointData_MAX[j]-OutpointData_MIN[j]+A)+OutpointData_MIN[j]-A;
		}
      sss+=e1[t];
	 }
      sss=sss/forecastdata;
      printf("  %lf    %lf\n",e,sss);
	}while(sss>0.12);
}
/********************************************************/


void main()
{
    int i,j,k;
    FILE *fp2;
	ReadData();                          //��ѵ�����ݣ���������
	unitary();                           //��һ����������������ݹ�һ�������[0��1]��
    forecast();                   //�������
    if((fp2=fopen("D:\\data\\����Ȩֵ.txt","w"))==NULL)   //�ļ����ѵ���õ�Ȩֵ
	{
		printf("6can not open the file\n");
		exit(0);
	}
	 for(i=0;i<defaultpoints;i++)
	 {
		 for(k=0;k<inpoints;k++)
			 fprintf(fp2," %lf   ",w[i][k]);
		 fprintf(fp2,"\n");
	 }
	 fprintf(fp2,"\n");
     for(i=0;i<defaultpoints;i++)
		 fprintf(fp2," %lf   ",limen[i]);
	 fprintf(fp2,"\n\n");
     for(i=0;i<defaultpoints;i++)
	 {
		 for(j=0;j<outpoints;j++)
			  fprintf(fp2," %lf   ",v[j][i]);
		  fprintf(fp2,"\n");
	 }
	 fclose(fp2);
}
