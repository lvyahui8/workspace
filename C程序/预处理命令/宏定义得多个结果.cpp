#include <stdafx.h>

#define PI 3.1415926
#define CIRCLE(R,L,S,V) L=2*PI*R;S=PI*R*R;V=4.0/3.0*PI*R*R*R

void main()
{
	float r=1,l,s,v;
	CIRCLE(r,l,s,v);

	printf("r=%6.2f,l=%6.2f,s=%6.2f,v=%6.2f\n",r,l,s,v);
}