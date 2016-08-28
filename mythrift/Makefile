THRIFT_VER =thrift-0.8.0
USR_DIR    =/usr/local
INCS_DIRS  =-I${USR_DIR}/include -I${USR_DIR}/include/thrift
LIBS_DIRS  =-L${USR_DIR}/lib
CPP_DEFS   =-D=HAVE_CONFIG_H
CPP_OPTS   =-Wall -O2 -static
LIBS       =-lthrift -lpthread 

GEN_SRC    = gen-cpp/SSANAgent.cpp  \
             gen-cpp/ssan_types.cpp   \
             gen-cpp/ssan_constants.cpp
GEN_INC    = -Igen-cpp

default: server client

server: gen-cpp/SSANServer.cpp
	g++ ${CPP_OPTS} ${CPP_DEFS} -o ssan_server ${GEN_INC} ${INCS_DIRS} $^ ${GEN_SRC} ${LIBS_DIRS} ${LIBS}

client: gen-cpp/SSANClient.cpp
	g++ ${CPP_OPTS} ${CPP_DEFS} -o ssan_client ${GEN_INC} ${INCS_DIRS} $^ ${GEN_SRC} ${LIBS_DIRS} ${LIBS}

clean:
	rm -r CppClient CppServer
