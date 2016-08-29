#include <windows.h>   
 
typedef BOOL (WINAPI *PROCGETCONSOLEDISPLAYMODE)(LPDWORD);   
typedef BOOL (WINAPI *PROCSETCONSOLEDISPLAYMODE)(HANDLE,DWORD,LPDWORD);   
PROCGETCONSOLEDISPLAYMODE GetConsoleDisplayMode;   
PROCSETCONSOLEDISPLAYMODE SetConsoleDisplayMode;        // ȫ��API����   
   
void main(int argc, char* argv[])   
{   
    HANDLE hOut;                                        // �����������ı���   
    DWORD dwOldMode;                                    // ��ǰģʽ   
    DWORD dwNewMode;                                    // ��ģʽ   
    hOut=GetStdHandle(STD_OUTPUT_HANDLE);               // ��ȡ������   
    HMODULE hKernel32=GetModuleHandle("kernel32");      // ����Kernel32.dll   
    GetConsoleDisplayMode=(PROCGETCONSOLEDISPLAYMODE)GetProcAddress(hKernel32,"GetConsoleDisplayMode");   
    SetConsoleDisplayMode=(PROCSETCONSOLEDISPLAYMODE)GetProcAddress(hKernel32,"SetConsoleDisplayMode");   
                                                        // ����API   
    dwNewMode=1;                                        // ������ģʽΪȫ����������Ϊ0��   
    GetConsoleDisplayMode(&dwOldMode);                  // ��ȡ��ǰģʽ   
    SetConsoleDisplayMode(hOut,dwNewMode,&dwOldMode);   // ����Ϊ��ģʽ   
}  
