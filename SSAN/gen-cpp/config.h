#ifndef _CONFIG_H
#define _CONFIG_H

#include <stdint.h>

typedef void * conf_handler;

conf_handler    conf_file_open(const char * filename);
void            conf_file_close(conf_handler handler);
void            conf_file_dump(conf_handler handler, FILE * fp);

int         conf_file_get(conf_handler handler, const char * key, char * value, int size);

int32_t     conf_file_int_get(conf_handler handler, const char * key, int32_t default_value);
uint32_t    conf_file_uint_get(conf_handler handler, const char * key, uint32_t default_value);
int64_t     conf_file_int64_get(conf_handler handler, const char * key, int64_t default_value);
uint64_t    conf_file_uint64_get(conf_handler handler, const char * key, uint64_t default_value);

double      conf_file_double_get(conf_handler handler, const char * key, double default_value);

#endif
