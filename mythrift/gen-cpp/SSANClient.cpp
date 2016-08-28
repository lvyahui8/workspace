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
    if (argc < 3)
    {
        printf("Usage: %s ip-addr command ...\n", argv[0]);
        return -1;
    }

    ostringstream ss, addr;

    addr << argv[1];

    ss << argv[2];
    for (int i = 3; i < argc; i++)
    {
        ss << " " << argv[i];
    }

    boost::shared_ptr<TSocket> socket(new TSocket(addr.str().c_str(), 9090));
    boost::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
    boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));

    string output;

    SSANAgentClient client(protocol);
    transport->open();
    client.run(output, ss.str());
    cout << output << endl;
    transport->close();

    return 0;
}
