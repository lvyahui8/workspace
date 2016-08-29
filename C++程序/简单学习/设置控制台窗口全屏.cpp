#include <windows.h>   
 
typedef BOOL (WINAPI *PROCGETCONSOLEDISPLAYMODE)(LPDWORD);   
typedef BOOL (WINAPI *PROCSETCONSOLEDISPLAYMODE)(HANDLE,DWORD,LPDWORD);   
PROCGETCONSOLEDISPLAYMODE GetConsoleDisplayMode;   
PROCSETCONSOLEDISPLAYMODE SetConsoleDisplayMode;        // 全局API声明   
   
void main(int argc, char* argv[])   
{   
    HANDLE hOut;                                        // 储存输出句柄的变量   
    DWORD dwOldMode;                                    // 当前模式   
    DWORD dwNewMode;                                    // 新模式   
    hOut=GetStdHandle(STD_OUTPUT_HANDLE);               // 获取输出句柄   
    HMODULE hKernel32=GetModuleHandle("kernel32");      // 载入Kernel32.dll   
    GetConsoleDisplayMode=(PROCGETCONSOLEDISPLAYMODE)GetProcAddress(hKernel32,"GetConsoleDisplayMode");   
    SetConsoleDisplayMode=(PROCSETCONSOLEDISPLAYMODE)GetProcAddress(hKernel32,"SetConsoleDisplayMode");   
                                                        // 载入API   
    dwNewMode=1;                                        // 设置新模式为全屏（窗口则为0）   
    GetConsoleDisplayMode(&dwOldMode);                  // 获取当前模式   
    SetConsoleDisplayMode(hOut,dwNewMode,&dwOldMode);   // 设置为新模式   
}  
