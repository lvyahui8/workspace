#include <stdio.h>
#include <iostream>
#include <sstream>
#include "abstractstubserver.h"
#include <jsonrpccpp/server/connectors/httpserver.h>

using namespace jsonrpc;
using namespace std;

class MyStubServer : public AbstractStubServer
{
public:
    MyStubServer(AbstractServerConnector & connector);

    virtual std::string runShellCommand(const std::string& command);
    virtual std::string sayHello(const std::string& name);
};

inline MyStubServer::MyStubServer(AbstractServerConnector &connector) :
    AbstractStubServer(connector)
{
}

inline string MyStubServer::sayHello(const string &name)
{
    return "Hello " + name;
}

inline string MyStubServer::runShellCommand(const string &command)
{
	ostringstream ss;

	FILE * pp = popen(command.c_str(), "r");
	if (pp != NULL)
	{
		char buf[4096];

		while(fgets(buf, sizeof(buf), pp))
		{
			ss << buf;
		}
        
        pclose(pp);
	}
	else
	{
		ss << "Error: No such command " << command;
	}

    return ss.str();
}

int main(int argc, char ** argv)
{
	printf("Server is starting ...\n");
    HttpServer httpserver(8383);
    MyStubServer s(httpserver);
 
 	printf("Server is ready to run ...\n");
    s.StartListening();
    getchar();
    s.StopListening();

    return 0;
}