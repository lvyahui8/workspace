#include <transport/TSocket.h>
#include <transport/TBufferTransports.h>
#include <protocol/TBinaryProtocol.h>
#include <iostream>
#include <sstream>

#include "SSANAgent.h"

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;
using namespace ssan;

int main(int argc, char **argv) 
{
    if (argc < 3 || (strcmp(argv[1], "ping") && argc < 4))
    {
        printf("Usage: %s sync|async|ping ip-addr command ...\n", argv[0]);
        return -1;
    }

    ostringstream ss, addr;

    addr << argv[2];

    if (argc > 3)
    {
        ss << argv[3];
        for (int i = 4; i < argc; i++)
        {
            ss << " " << argv[i];
        }
    }

    boost::shared_ptr<TSocket> socket(new TSocket(addr.str().c_str(), 9090));
    boost::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
    boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));

    string output;

    SSANAgentClient client(protocol);
    transport->open();

    if (strcmp(argv[1], "ping") == 0)
    {
        bool result = client.ping();
        cout << (result ? "success" : "failed") << endl;
    }
    else if (strcmp(argv[1], "sync") == 0)
    {
        client.run(output, ss.str());
        cout << output << endl;
    }
    else if (strcmp(argv[1], "async") == 0)
    {
        client.runAsync(output, ss.str());
        cout << output << endl;
    }
    
    transport->close();

    return 0;
}
