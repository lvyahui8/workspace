#include <iostream>
#include <Windows.h>
#include <stdio.h>
#include <stdarg.h>

using namespace std;

void cprintf(char* str, WORD color, ...);

int main() {
	cprintf("H", 10);
	cprintf("e", 9);
	cprintf("l", 12);
	cprintf("l", 11);
	cprintf("o", 13);
	cprintf(" ", 10);
	cprintf("W", 15);
	cprintf("o", 2);
	cprintf("r", 5);
	cprintf("l", 8);
	cprintf("d", 14);
	cprintf("!", 4);
	return 0;
}

void cprintf(char* str, WORD color, ...) {
	WORD colorOld;
	HANDLE handle = ::GetStdHandle(STD_OUTPUT_HANDLE);
	CONSOLE_SCREEN_BUFFER_INFO csbi;
	GetConsoleScreenBufferInfo(handle, &csbi);
	colorOld = csbi.wAttributes;
	SetConsoleTextAttribute(handle, color);
	cout << str;
	SetConsoleTextAttribute(handle, colorOld);
}