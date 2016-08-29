#include <Windows.h>

int main()
{
	DeleteMenu(GetSystemMenu(GetConsoleWindow(), FALSE), SC_CLOSE, MF_BYCOMMAND);
	DrawMenuBar(GetConsoleWindow());
	system("pause");
	return 0;
}
