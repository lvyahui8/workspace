// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "SSANAgent.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>
#include <iostream>
#include <sstream>

using namespace std;
using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using boost::shared_ptr;

using namespace  ::ssan;

class SSANAgentHandler : virtual public SSANAgentIf {
 public:
  SSANAgentHandler() {
    // Your initialization goes here
  }

  /**
   * A method definition looks like C code. It has a return type, arguments,
   * and optionally a list of exceptions that it may throw. Note that argument
   * lists and exception lists are specified using the exact same syntax as
   * field lists in struct or exception definitions.
   */
  bool ping() {
    // Your implementation goes here
    printf("ping\n");
    return true;
  }

  void run(std::string& _return, const std::string& cmd) 
  {
    ostringstream ss;

    FILE * pp = popen(cmd.c_str(), "r");
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
        ss << "Error: No such command " << cmd;
    }

    _return = ss.str();
  }

  /**
   * This method has a oneway modifier. That means the client only makes
   * a request and does not listen for any response at all. Oneway methods
   * must be void.
   */
  void zip() {
    // Your implementation goes here
    printf("zip\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  shared_ptr<SSANAgentHandler> handler(new SSANAgentHandler());
  shared_ptr<TProcessor> processor(new SSANAgentProcessor(handler));
  shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}

