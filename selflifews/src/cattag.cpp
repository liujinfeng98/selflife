#include <sstream>
#include "otldb.h"
#include "include/soapH.h"

int sl__addCatTag(struct soap *soap,struct CatTag ct,int &result)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
        ostringstream sql;
	  sql << "insert into bd_techcat_dt( "         
	          <<  "ec_cattag_name,"	         	
	         	<< "ec_cattag_code,"
	         << "ec_cattag_time) values ('"<< ct.name << "'," << ct.code << ",Now())"; 
	  result=otldb.execNonQuery(sql.str()) ;
	  if(result< 0)
	  {
	       return SOAP_FAULT;
	  }
     
     otldb.execNonQuery("commit");
          return SOAP_OK;
}

int sl__queryCatTagAllSelect(struct soap *soap,list<struct CatTag> &cattags)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  cattags.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_cattag_id,ec_cattag_name,ec_cattag_code ,ec_cattag_status"
     		<<" from bd_techcat_dt where  ec_cattag_status=0";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct CatTag cattag;
  while(!rset.eof())
  {
          rset >> cattag.id >> cattag.name >> cattag.code >> cattag.status;
          cattags.push_back(cattag);
  }
  rset.close();
          return SOAP_OK;
}

int sl__queryCatTagAll(struct soap *soap,list<struct CatTag> &cattags)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  cattags.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_cattag_id,ec_cattag_name,ec_cattag_code ,ec_cattag_status"
     		<<" from bd_techcat_dt ";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct CatTag cattag;
  while(!rset.eof())
  {
          rset >> cattag.id >> cattag.name >> cattag.code >> cattag.status;
          cattags.push_back(cattag);
  }
  rset.close();
          return SOAP_OK;
}

int sl__queryCatTag(struct soap *soap,int id ,struct CatTag &cattag)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_cattag_id,ec_cattag_name,ec_cattag_code ,ec_cattag_status"
     		<<" from bd_techcat_dt where ec_cattag_id=" << id;
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  if(!rset.eof())
  {
          rset >> cattag.id >> cattag.name >> cattag.code >> cattag.status;
  }
  rset.close();
          return SOAP_OK;
}

int sl__queryCatTagByCode(struct soap *soap,int code ,struct CatTag &cattag)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_cattag_id,ec_cattag_name,ec_cattag_code ,ec_cattag_status"
     		<<" from bd_techcat_dt where ec_cattag_code=" << code;
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  if(!rset.eof())
  {
          rset >> cattag.id >> cattag.name >> cattag.code >> cattag.status;
  }
  rset.close();
          return SOAP_OK;
}
