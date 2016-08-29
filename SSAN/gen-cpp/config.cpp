#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>

#include "config.h"

typedef struct _conf_value_t
{
    char                    * key;
    char                    * value;
    struct _conf_value_t    * next;
}_conf_value;

#define _is_white(__a) ((__a) == ' ' || (__a) == '\t' || (__a) == '\n')

//
// copy [begin, end) to dst
//
inline void  _conf_copy (char * dst, const char * begin, const char * end)
{
    while (begin < end)
        * dst++ = * begin++;
    * dst = 0;
}

inline char * _conf_trunc (char * p)
{
    char * end = (p + strlen (p) - 1);
    
    for (; * p && _is_white (* p); p++)
        ;

    for (; end > p && _is_white (* end); end--)
        ;

   * (end + 1) = 0;

    return p;
}

inline char * _conf_malloc_and_copy (char * begin, char * end)
{
    char * p;
    if (begin >= end || ! (p = (char *)malloc (end - begin + 1)))
        return NULL;

    _conf_copy (p, begin, end);

    return p;    
}

inline void _conf_trunc_comment (char * p)
{
    while (* p && * p != '#')
        p ++;
        
    if (* p == '#')
        * p = 0;
}

conf_handler conf_file_open (const char * filename)
{
    char             buf[512], * p, * endp;
    _conf_value        * cp, * head;
    FILE             * fp = fopen (filename, "r");

    if (! fp) {
        return NULL;
    }
    
    head = 0;
    while (fgets (buf, sizeof (buf), fp))
    {
        _conf_trunc_comment (buf);

        p = _conf_trunc (buf);

        if (! * p)    continue;

        if ((cp = (_conf_value *)malloc (sizeof (_conf_value))) == NULL)
            break;
        
        endp = p;
        while (* endp && ! _is_white (* endp))
            ++ endp;
        
        if (! (cp->key = _conf_malloc_and_copy (p, endp)))
        {
            free (cp);
            break;
        }

        p = _conf_trunc (endp);

        endp = p;
        while (* endp && * endp != '\n')
            ++ endp;

        cp->value = _conf_malloc_and_copy (p, endp);
        
        cp->next    = head;
        head        = cp;
    }

    fclose (fp);

    return (conf_handler)head;
}

void conf_file_close (conf_handler handler)
{
    _conf_value * p = (_conf_value *)handler;
    _conf_value * tmp;
    
    while (p)
    {
        free (p->key);
        free (p->value);
        
        tmp = p->next;
        free (p);
        p = tmp;
    }
}

void conf_file_dump(conf_handler handler, FILE * fp)
{
    _conf_value * p = (_conf_value *)handler;

    while (p)
    {
        fprintf(fp, "\"%s\"=>\"%s\"\n", p->key, p->value);
        p = p->next;
    }
}

int conf_file_get (conf_handler handler, const char * key, char * value, int size)
{
    _conf_value * p = (_conf_value *)handler;
#ifdef _DEBUG
    printf ("conf_file_get: %s-->", key);    
#endif
    while (p)
    {
        if (strcmp (p->key, key) == 0)
        {
            if (p->value)
                strncpy (value, p->value, size);
            else if (size > 0)
                * value = 0;
#ifdef _DEBUG
            printf ("\"%s\"\n", size > 0 ? value : "<empty>");
#endif

            return 0;
        }
        p = p->next;
    }
#ifdef _DEBUG
    printf ("<no such key>\n");
#endif
    return -1;
}

int32_t conf_file_int_get (conf_handler handler, const char * key, int32_t default_value)
{
    char buf[256];

    if (conf_file_get (handler, key, buf, sizeof (buf)) == 0) {
        char * end;
        int32_t v;

        v = strtol(buf, & end, 10);
        if (* end == 0) {
            return v;
        }
    }

    return default_value;
}

uint32_t conf_file_uint_get (conf_handler handler, const char * key, uint32_t default_value)
{
    char buf[256];

    if (conf_file_get (handler, key, buf, sizeof (buf)) == 0) {
        char * end;
        uint32_t v;

        v = strtoul(buf, & end, 10);
        if (* end == 0 && errno == 0) {
            return v;
        }
    }

    return default_value;
}

int64_t conf_file_int64_get (conf_handler handler, const char * key, int64_t default_value)
{
    char buf[256];

    if (conf_file_get (handler, key, buf, sizeof (buf)) == 0) {
        char * end;
        int64_t v;

        v = strtoll(buf, & end, 10);
        if (* end == 0 && errno == 0) {
            return v;
        }
    }

    return default_value;
}

uint64_t conf_file_uint64_get (conf_handler handler, const char * key, uint64_t default_value)
{
    char buf[256];

    if (conf_file_get (handler, key, buf, sizeof (buf)) == 0) {
        char * end;
        uint64_t v;

        v = strtoull(buf, & end, 10);
        if (* end == 0 && errno == 0) {
            return v;
        }
    }

    return default_value;
}

double conf_file_double_get(conf_handler handler, const char * key, double default_value)
{
    char buf[256];

    if (conf_file_get (handler, key, buf, sizeof (buf)) == 0) {
        char * end;
        double v;

        v = strtod(buf, & end);
        if (* end == 0 && errno == 0) {
            return v;
        }
    }

    return default_value;
}

#ifdef _UNIT_TEST

int main (int argc, char ** argv)
{
    const char * keys[] = {"key1", "key2", "key3", "key4"};
    char value[512];
    int    i;
    conf_handler h;
    
    if (argc != 2)
        return -1;
    
    if (! (h = conf_file_open (argv[1])))
    {
        printf ("error: failed to open %s\n", argv[1]);
        return -2;
    }
    

    for (i = 0; i < sizeof (keys) / sizeof (keys[0]); i++)
    {
        printf ("%-10s", keys[i]);
        if (conf_file_get (h, keys[i], value, sizeof (value)))
            printf ("[not exist]\n");
        else
            printf ("%s\n", value);
    }
    
    conf_file_close (h);    
    return 0;
}

#endif
