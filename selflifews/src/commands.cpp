#include <sstream>
#include "otldb.h"
#include "include/soapH.h"


int sl__addCommand(struct soap *soap, struct BdCommandDt ct,int &result)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
        ostringstream sql;
    sql << "insert into bd_command_dt(ec_command_title,ec_command_shell,ec_cattag_code,"
           << "ec_command_time) values ( '"<< ct.ec_command_title << "'," 
           << ct.ec_cattag_code << ",'"
           << ct.ec_command_shell << "',Now())";
    result=otldb.execNonQuery(sql.str()) ;
    if(result< 0)
    {
         return SOAP_FAULT;
    }
     otldb.execNonQuery("commit");
          return SOAP_OK;
}

int sl__delCommand(struct soap *soap, int id,int &result)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
        ostringstream sql;
    sql << "delete from  bd_command_dt where ct_command_id="<< id;
    result=otldb.execNonQuery(sql.str()) ;
    if(result< 0)
    {
         return SOAP_FAULT;
    }
     otldb.execNonQuery("commit");
          return SOAP_OK;
}

int sl__getCommand(struct soap *soap,int id,struct BdCommandDt &command)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_command_id,ec_command_title ,ec_command_shell,ec_cattag_code from bd_command_dt where ec_command_id = " << id ;
     if(!otldb.execQuery(sql.str(), rset) || rset.eof())
     {
          return SOAP_FAULT;
     }
          rset >> command.ec_command_id >> command.ec_command_title >> command.ec_command_shell >> command.ec_cattag_code;
        rset.close();
          return SOAP_OK;
}

// int sl__getArray(struct soap *soap,int b,array &a)
// {
//   a[0] = 1;
//   a[1] = 4;
//             return SOAP_OK;
// }

// int sl__getVector(struct soap *soap,int b,vector1 *a)
// { 
//   a[0]=1;
//   // a.insert(a.begin+1,command);
//             return SOAP_OK;
// }



int sl__getAllCommandList(struct soap *soap,list<struct BdCommandDt> &commands)
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  commands.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_command_id,ec_command_title ,ec_command_shell,ec_cattag_code from bd_command_dt";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct BdCommandDt command;
  while(!rset.eof())
  {
          rset >> command.ec_command_id >> command.ec_command_title >> command.ec_command_shell >> command.ec_cattag_code;
          commands.push_back(command);
  }
  rset.close();
          return SOAP_OK;
}

int sl__queryCommandAllByTime ( struct soap *soap,list<struct Statics> &staticses) 
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  staticses.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select to_char(ec_command_time,'yyyy-mm') as time,"
             <<   " count(distinct ec_command_id) as num "
            << "from bd_command_dt t, bd_techcat_dt c "
             << "  where t.ec_cattag_code=c.ec_cattag_code "
              << " and ec_cattag_status=0 group by time";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct Statics statics;
  while(!rset.eof())
  {
          rset >> statics.name >> statics.count;
          staticses.push_back(statics);
  }
  rset.close();
          return SOAP_OK;
}
int sl__queryCommandAllByCattag (struct soap *soap, list<struct Statics> &staticses) 
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  staticses.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select  distinct t.ec_cattag_code as code,count(distinct ec_command_id) as num,"
           <<" c.ec_cattag_name as name"
            << " from bd_command_dt t, bd_techcat_dt c "
             << "  where t.ec_cattag_code=c.ec_cattag_code "
              << " and ec_cattag_status=0  group by code ,name order by code ";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct Statics statics;
  while(!rset.eof())
  {
          rset >> statics.code >> statics.count >> statics.name;
          staticses.push_back(statics);
  }
  rset.close();
          return SOAP_OK;
}
int sl__queryCommandAllByTimeCont(struct soap *soap, string name, list<struct BdCommandDt> &commands) 
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  commands.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_command_id,ec_command_title ,ec_command_shell,ec_cattag_code from bd_command_dt"
          << "where to_char(ec_command_time,'yyyy-mm')='" << name << "' "
            << "order by ec_command_id desc";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct BdCommandDt command;
  while(!rset.eof())
  {
          rset >> command.ec_command_id >> command.ec_command_title >> command.ec_command_shell >> command.ec_cattag_code;
          commands.push_back(command);
  }
  rset.close();
          return SOAP_OK;
}
int sl__queryCommandAllByCattagCont (struct soap *soap,int code ,list<struct BdCommandDt> &commands) 
{
COtlDB otldb;
 if(!otldb.connDB())
     {
          return SOAP_FAULT;
     }
  commands.clear();
     otl_stream rset;
        ostringstream sql;
     sql << "select ec_command_id,ec_command_title ,ec_command_shell,ec_cattag_code from bd_command_dt"
          << " where ec_cattag_code=" << code
           << " order by ec_command_id desc";
     if(!otldb.execQuery(sql.str(), rset))
     {
          return SOAP_FAULT;
     } 

  struct BdCommandDt command;
  while(!rset.eof())
  {
          rset >> command.ec_command_id >> command.ec_command_title >> command.ec_command_shell >> command.ec_cattag_code;
          commands.push_back(command);
  }
  rset.close();
          return SOAP_OK;
}


