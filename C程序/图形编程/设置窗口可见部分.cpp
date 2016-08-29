#include "graphics.h"
int main()
{
    initgraph(640, 480);
    window_setviewport(100, 100, 400, 400);
    rectangle(0, 0, 200, 200);
    getch();
    closegraph();
    return 0;
}