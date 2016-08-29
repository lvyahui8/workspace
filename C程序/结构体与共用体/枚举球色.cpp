#include <stdafx.h>

enum color {red,yellow,blue,white,black};


void main(){
	enum color i,j,k;
	int n=0;
	for(i=red;i<=black;i++)
		for(j=red;j<=black;j++)
			for(k=red;k<=black;k++)
				if(i!=j && i!=k && j!=k)
				{
					n++;
					printf("第%d种方案:\n\n");
					switch(i)
					{
					case red:printf("first:red\t");break;
					case yellow:printf("first:yellow\t");break;
					case blue:printf("first:blue\t");break;
					case white:printf("first:white\t");break;
					case black:printf("first:black\t");break;
					default :break;
					}
					switch(j)
					{
					case red:printf("second:red\t");break;
					case yellow:printf("second:yellow\t");break;
					case blue:printf("second:blue\t");break;
					case white:printf("second:white\t");break;
					case black:printf("second:black\t");break;
					default :break;
					}
					switch(k)
					{
					case red:printf("third:red\t");break;
					case yellow:printf("third:yellow\t");break;
					case blue:printf("third:blue\t");break;
					case white:printf("third:white\t");break;
					case black:printf("third:black\t");break;
					default :break;
					}
					printf("\n\n");	
				}

}