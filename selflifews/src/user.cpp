#include <stdio.h>
#include <sstream>
#include "otldb.h"
#include "list"
#include "include/soapH.h"
#include "include/sl.nsmap"

#include <unistd.h>
#ifdef _POSIX_THREADS
#include <pthread.h>    // use Pthreads
#endif

#define BACKLOG (100)   // Max. request backlog
#define MAX_THR (8)     // Max. threads to serve requests
#define SLEEP   (0)     // >0 will make each thread sleep to mimic work load


// User::User()
// {
// }
// User::~User()
// {
// }

int test();
int http_get(struct soap*);
void *process_request(void*);

int main(int argc, char **argv)
{ 
//  test();
  struct soap soap;
  soap_init(&soap);
  if (argc < 2)         // no args: assume this is a CGI application
  { soap_serve(&soap);  // serve request
    soap_destroy(&soap);// cleanup class instances
    soap_end(&soap);    // cleanup
  }
  else
  {
#ifdef _POSIX_THREADS
    pthread_t tid;
#endif
    SOAP_SOCKET m, s;
 // soap.accept_timeout = 60; // die if no requests are made within 1 minute
    int port = 9095;
    // register a HTTP GET handler
    soap.fget = http_get;
    m = soap_bind(&soap, NULL, port, 100);
    if (!soap_valid_socket(m))
    { soap_print_fault(&soap, stderr);
      exit(1);
    }
    fprintf(stderr, "Socket connection successful %d\n", m);
    for (int i = 1; ; i++)
    { s = soap_accept(&soap);
      if (!soap_valid_socket(s))
      { if (soap.errnum)
          soap_print_fault(&soap, stderr);
        else
          fprintf(stderr, "Server timed out\n");
        break;
       }
      fprintf(stderr, "%d: accepted %d IP=%d.%d.%d.%d ... ", i, s, (int)(soap.ip>>24)&0xFF, (int)(soap.ip>>16)&0xFF, (int)(soap.ip>>8)&0xFF, (int)soap.ip&0xFF);
#ifdef _POSIX_THREADS
      pthread_create(&tid, NULL, (void*(*)(void*))process_request, (void*)soap_copy(&soap));
#else
      soap_serve(&soap);        // process RPC skeletons
      fprintf(stderr, "served\n");
      soap_destroy(&soap);
      soap_end(&soap);  // clean up 
#endif
    }
  }
  soap_done(&soap);
  return 0;
}

#ifdef _POSIX_THREADS
void *process_request(void *soap)
{
  pthread_detach(pthread_self());
  soap_serve((struct soap*)soap);
  soap_destroy((struct soap*)soap);
  soap_end((struct soap*)soap);
  soap_free((struct soap*)soap);
  return NULL;
}
#endif

int http_get(struct soap * soap)
{ FILE *fd = NULL;
  char *s = strchr(soap->path, '?');
// if (!s || strcmp(s, "?wsdl"))
//   return SOAP_GET_METHOD;
  fd = fopen("include/sl.wsdl", "rb"); // open WSDL file to copy 
  if (!fd)
    return 404; // return HTTP not found error 
  soap->http_content = "text/xml"; // HTTP header with text/xml content 
  soap_response(soap, SOAP_FILE);
  for (;;)
  { size_t r = fread(soap->tmpbuf, 1, sizeof(soap->tmpbuf), fd);
    if (!r)
      break;
    if (soap_send_raw(soap, soap->tmpbuf, r))
      break; // can't send, but little we can do about that 
  }
  fclose(fd);
  soap_end_send(soap);
  return SOAP_OK;
}

int sl__add(struct soap *soap, int a, int b, int &result)
{  COtlDB otldb;
 if(!otldb.connDB())
     {  printf("bd_command_dt_seq is null\n");

          return 1;
     }
  
  int i=otldb.getNextVal("bd_command_dt_seq");
  printf("bd_command_dt_seq is %d\n", i);
  result = a + b;
  return  SOAP_OK;
}
int test()
{
  COtlDB otldb;
 if(!otldb.connDB())
     {  printf("bd_command_dt_seq is null\n");

          return 1;
     }
  
  int i=otldb.getNextVal("bd_command_dt_seq");
  printf("bd_command_dt_seq is %d\n", i);
  return i;
}
int sl__userLogin(struct soap *soap,string username,string password,struct User &user)
{
  COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_userid,ec_username,ec_password,ec_userlevel from bd_user_dt where ec_username = '" << username  << "' and ec_password = '"<< password << "'";
     if(!otldb.execQuery(sql.str(), rset) || rset.eof())
     {
          return SOAP_FAULT;
     }
        rset >> user.userid >> user.username1 >> user.password1 >> user.userlevel;
        rset.close();
      return SOAP_OK; 
}

