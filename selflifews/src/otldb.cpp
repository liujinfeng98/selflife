#include "otldb.h"

bool COtlDB::m_bFirst = true;

COtlDB::COtlDB()
{
     m_bConn = false;
     if(m_bFirst)
     {
	  m_bFirst = false;
#ifdef OTL_ORA10G
	  char nls_lang[] = "NLS_LANG=AMERICAN_AMERICA.AL32UTF8";
	  putenv(nls_lang);
#endif
	  otl_connect::otl_initialize();
     }
}

COtlDB::~COtlDB()
{
     if(isConnect())
     {
	  closeDB();
     }
}

bool COtlDB::connDB()
{
     return connDB("PostgreSQL", "etdomi_cloud", "boyi1234");
}

bool COtlDB::connDB(string sSource, string sUser, string sPasswd)
{
     string str = sUser + "/" + sPasswd + "@" + sSource;
     try
     {
	  m_conn.rlogon(str.c_str());
	  m_bConn = true;
     }
     catch(otl_exception &e)
     {
	  return false;
     }
     catch(...)
     {
	  return false;
     }
     return true;
}

void COtlDB::closeDB()
{
     try
     {
	  m_conn.logoff();
	  m_bConn = false;
     }
     catch(otl_exception &e)
     {
     }
     catch(...)
     {
     }
}

bool COtlDB::isConnect()
{
     return m_bConn;
}

bool COtlDB::execQuery(string sql, otl_stream &rset)
{
     if(!isConnect())
     {
	  return false;
     }
     bool bRes = true;
     try
     {
	  rset.close();
	  rset.open(50, sql.c_str(), m_conn);
     }
     catch(otl_exception &e)
     {
	  bRes = false;
     }
     catch(...)
     {
	  bRes = false;
     }
     if(!bRes)
     {
	  printf("\nsql error : %s\n", sql.c_str());
     }
     return bRes;
}

int COtlDB::execNonQuery(string sql)
{
     if(!isConnect())
     {
	  return -1;
     }
     int count = 0;
     try
     {
	  count = m_conn.direct_exec(sql.c_str(), otl_exception::enabled);
     }
     catch(otl_exception &e)
     {
	  count = -1;
     }
     catch(...)
     {
	  count = -1;
     }
     if(count < 0 && sql != "commit" && sql != "rollback")
     {
	  try
	  {
	       m_conn.direct_exec("rollback", otl_exception::enabled);
	  }
	  catch(otl_exception &e)
	  {
	  }
	  catch(...)
	  {
	  }
	  printf("\nsql error : %s\n", sql.c_str());
     }
     return count;
}

int COtlDB::getNextVal(string sSeq)
{
     otl_stream rset;
     string sql;
     int iVal = 0;
     sql = "select nextval('" + sSeq + "')";
     if(!execQuery(sql, rset))
     {
	  return -1;
     }
     if(!rset.eof())
     {
	  rset >> iVal;
     }
     rset.close();
     return iVal;
}
