#include "string" 
#import "stllist.h"



// class vector1
// { public:
//   xsd__int *__ptr;
//   int __size;
//   struct soap *soap;
//   vector1();
//   vector1(int);
//   virtual ~vector1();
//   void resize(int);
//   int& operator[](int) const;
// };

struct BdCommandDt 
{
	 int ec_command_id;
	std::string ec_command_title;
	std::string ec_command_shell;
	 int ec_cattag_code;	
};


struct CatTag
{
	std::string name;
	 int code;
	 int id;
	 int status;
};


struct User 
{
	int userid ; 
	std::string username1 ; 
	std::string password1 ; 
 	int userlevel ; 
};

struct Statics{
 	int count;
	std::string name;
	 int code;
};


int sl__add(int a, int b, int &result) ;

int sl__addCatTag(struct CatTag ct,int &result);
int sl__queryCatTagAllSelect(std::list<struct CatTag> &cattags);
int sl__queryCatTagAll(std::list<struct CatTag> &cattags);
int sl__queryCatTag(int id ,struct CatTag &ct);
int sl__queryCatTagByCode(int code ,struct CatTag &ct);

int sl__addCommand(struct BdCommandDt command,int &result);
int sl__delCommand(int id,int &result);
int sl__getCommand(int id,struct BdCommandDt &command) ;
int sl__getAllCommandList(std::list<struct BdCommandDt> &commands) ;
int sl__queryCommandAllByTime(std::list<struct Statics> &staticses) ;
int sl__queryCommandAllByCattag(std::list<struct Statics> &staticses) ;
int sl__queryCommandAllByTimeCont(std::string name,std::list<struct BdCommandDt> &commands) ;
int sl__queryCommandAllByCattagCont (int code,std::list<struct BdCommandDt> &commands) ;

int sl__userLogin(std::string username,std::string password, struct User &user) ;

//int sl__getArray(int b, std::array &a);
// int sl__getVector(int b, vector1 *a);

