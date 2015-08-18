<%@ page isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="self/life"/>
	<meta name="description" content="self/life"/> <title>selflife</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
     <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->	
	<link rel="shortcut icon" href="Images/icon.png">
	
  </head>
  <body>
  
  
<div class="jumbotron jumbotron_custom">
  <div class="container" style="margin:0 auto;width:90%;">
  <div class="panel-heading" style="text-align:center;margin-bottom:50px;background:#337AB7;">Selflife</div>
<form action="/loginPage/userLogin" id="loginform" name="loginform" method="post">
<div class="panel panel-primary" style="height:400px;">
<div style="color:red;">
<c:if test="${hashmap._ret==400}">
	参数格式错误!
</c:if>
<c:if test="${hashmap._ret==201}">
	用户不存在!
</c:if>
</div>
<div class="input-group"style="margin:0 auto ;text-align:center;width:90%;margin-top:100px;">
  <span class="input-group-addon" id="basic-addon1">用户名：</span>
  <input type="text" id="_user" name="_user" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1">
</div>
<div class="input-group"style="margin:0 auto;margin-top:10px;align:center;width:90%;">
  <span class="input-group-addon" id="basic-addon1">密&nbsp;&nbsp;&nbsp; 码：</span>
  <input type="password" id="_pwd" name="_pwd" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
</div>
<div style="margin:0 auto;margin-top:10px;text-align:center;width:80%;">
  
<button type="button" class="btn btn-default" id="loginBtn">登陆</button>

  <button type="button" id="resetBtn" class="btn btn-default" style="margin-left:20px;">重置</button>
</div>
</div>
</form>
  </div>
</div>


    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	$("#loginBtn").click(function(){
		$("#loginform").submit();
		
	});
	$("#resetBtn").click(function(){
		$("#_user").val("");
		$("#_pwd").val("");
		
	});
</script>
  </body>
</html>
