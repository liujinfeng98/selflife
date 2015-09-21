
#ifndef OTLDB_H
#define OTLDB_H

//#define OTL_ORA10G

//#include "../config.h"
//#ifdef Z_OS_WIN
#define OTL_ODBC
//#endif
#define OTL_ODBC_UNIX

#define OTL_STL
#define OTL_ANSI_CPP

#include "otlv4.h"
using namespace std;

class COtlDB
{
public:
     COtlDB();
     virtual ~COtlDB();

     bool connDB();
     bool connDB(string sSource, string sUser, string sPasswd);
     void closeDB();
     bool isConnect();
     bool execQuery(string sql, otl_stream &rset);
     int execNonQuery(string sql);
     int getNextVal(string sSeq);

private:
     static bool m_bFirst;
     bool m_bConn;
     otl_connect m_conn;
};

#endif
