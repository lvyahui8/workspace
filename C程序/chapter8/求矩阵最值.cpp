#include <stdafx.h>
//����3��4�еľ�������ֵ
int m(int b[3][4])
{
	int max=b[0][0];

	for(int i=0;i<3;i++)
		for(int j=0; j<4; j++)
			if(b[i][j]>max)
				max=b[i][j];
	return max;
}