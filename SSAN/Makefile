CC = g++
PROXY = ssan_proxy.exe
AGENT = ssan_agent.exe
OPT = 
CFLAGS += $(OPT) -g -Wall -Werror -MMD -MP -I/libjson/include -I/libjson/win32-deps/include
LDFLAGS = -L/libjson/lib -L/libjson/win32-deps/lib
BIN = build/win32

SRCS = src/proxy.c src/agent.c

OBJS = $(addsuffix .o, $(basename $(SRCS)))

-include $(addsuffix .d, $(basename $(OBJS)))

all: $(AGENT) $(PROXY)

$(OBJS): %.o: %.c
	$(CC) $(CFLAGS) -o $@ -c $<

$(AGENT): src/agent.o
	mkdir -p $(BIN)
	$(CC) -o $(BIN)/$@ $^ $(LDFLAGS) -ljsoncpp -lcurl -ljsonrpccpp-common -ljsonrpccpp-client

$(PROXY): src/proxy.o
	mkdir -p $(BIN)
	$(CC) -o $(BIN)/$@ $^ $(LDFLAGS) -ljsoncpp -lmicrohttpd-10 -ljsonrpccpp-common -ljsonrpccpp-server

clean:
	rm -f src/*.o src/*.d $(BIN)/$(PROXY) $(BIN)/$(AGENT)

.PHONY: all clean