#include <iostream>
#include <sstream>

#include "stubclient.h"
#include <jsonrpccpp/client/connectors/httpclient.h>

using namespace jsonrpc;
using namespace std;

int main(int argc, char ** argv)
{
	if (argc < 3)
	{
		printf("Usage: %s ip-addr command ...\n", argv[0]);
		return -1;
	}

	ostringstream ss, addr;

	addr << "http://" << argv[1] << ":8383";

	ss << argv[2];
	for (int i = 3; i < argc; i++)
	{
		ss << " " << argv[i];
	}

    HttpClient httpclient(addr.str());
    StubClient c(httpclient);
    
    try
    {
    	//cout << "Run command: " << ss.str() << endl;
        cout << c.runShellCommand(ss.str()) << endl;
    }
    catch (JsonRpcException e)
    {
        cerr << e.what() << endl;
    }
}