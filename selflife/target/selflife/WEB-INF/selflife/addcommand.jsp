<%@ page isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="self/life"/>
		<meta name="description" content="self/life"/> 
		<title>selflife</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
     <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->	
	<!--link rel="shortcut icon" href=""-->
	<style type="text/css">
	@media screen and (max-width: 1140px) {
	 #xinlang {
		   display: none;
	 }
	 #weixin {
		   display: none;
	 }
	}
	</style>
  </head>
  <body>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
   <div class="container">
    <div class="navbar-header"> 
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button> 
			<a class="navbar-brand" href="/queryCommand/queryStaticsesByCatTag" >Selflife</a>
    </div>
	 <div class="collapse navbar-collapse" id="navbar">
	 <ul class="nav navbar-nav">
           
           <li><a href="/queryCommand/queryStaticsesByCatTag">首页</a></li>
        <li><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">博客<b class="caret"></b></a>		
		 <ul class="dropdown-menu">
                <li>
                  <a href="/queryCommand/queryStaticsesByCatTag">标签</a>
                </li>
                <li>
                  <a href="/queryCommand/queryStaticsesByTime" >时间</a>
                </li>
                 <li>
                  <a href="/queryCommand/toCommandAdd">添加</a>
                </li>
                <li>
                  <a href="/queryCommand/toAddCatTag">添加标签</a>
                </li>
                 <li>
                  <a href="/queryCommand/cattagsList">标签列表</a>
                </li>
              </ul>
			  </li>
        <li><a href="znyd.html">项目</a></li>
        <li><a href="jCloud.html">软件</a></li>
          </ul>
      <ul class="nav navbar-nav navbar-right">
        
		<li><a href="/loginPage">注销</a></li>
      </ul> 
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container -->
</nav>
<div class="jumbotron jumbotron_custom">
  <div class="container">
  		<form action="/queryCommand/addcommand" id="loginform" name="loginform" method="post">
	<div class="panel panel-primary" >
	<div style="color:red;">
	
	</div>
	<div class="input-group"style="margin:0 auto ;text-align:center;width:90%;margin-top:10px;">
	  <span class="input-group-addon" id="basic-addon1">标题：</span>
	  <input type="text" id="_title" name="_title" class="form-control" placeholder="请输入标题" aria-describedby="basic-addon1">
	</div>
<div style="margin:0 auto ;text-align:center;width:90%;margin-top:10px;">
 <span class="input-group-addon" style="float:left;width:68px;height:30px;" id="basic-addon1">标签：</span>
  <span style="display:inline;"><select id="_code" name="_code">
  	  <c:forEach var="cattag1" items="${hashmap.cattags}">
 			<option value="${cattag1.code}">${cattag1.name}</option>
  		</c:forEach>  	
  </select></span>
</div>
<div style="margin:0 auto;margin-top:10px;align:center;width:90%;">
   <span class="input-group-addon" id="basic-addon1" style="text-align:left;">内容：</span>
  <span><textarea type="textarea" id="_shell" name="_shell" class="form-control" rows="20"></textarea>
	</span>
</div>
<div style="margin:0 auto;margin-top:10px;text-align:center;width:80%;">
  
<button type="button" class="btn btn-default" id="loginBtn">保存</button>

  <button type="button" id="resetBtn" class="btn btn-default" style="margin-left:20px;">取消</button>
</div>
</div>
</form>
  </div>
</div>


	<footer class="footer footer_custom"> <div class="container" align="center">
			<div class="row row_footer">
			  <div class="col-sm-3">
			  <p class="footer_bigfont">联系我</p>		  
			  <p><a href="http://mail.zhihot.com/" target="_blank" style="color: #999797;">liujinfeng98@126.com</a></p>
			   <p><a href="http://mail.zhihot.com/" target="_blank" style="color: #999797;">15901410075</a></p>
			  </div>
			  
			  <!-- Add the extra clearfix for only the required viewport -->
			  <div class="clearfix visible-xs-block"></div>
			  <div class="col-sm-3" id="xinlang"> <div style="float:left"></div>
						<div class="footer_erweima">
							<div>扫一扫</div>
							<div>新浪微博</div>
						</div>
			  </div>
			  <div class="col-sm-3" id="weixin"> <div style="float:left"></div>
						<div class="footer_erweima">
							<div>扫一扫</div>
							<div>关注微信</div>
						</div>
			  </div>
			</div>
				 
          </div>
        
        
        <div class="row footer-bottom" style="  margin-right: 0px; margin-left: 0px;">
          <ul class=" text-center" style="list-style-type:none;">
            <li style="color: #848484;font-size: 12px;clear: both;text-align: center;font-weight: bold;margin-top:30px;"></li>
          </ul>
        </div>
    </footer>	
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
	<a id="scrollUp" href="#"></a>
	<script src="/js/jquery.scrollUp.min.js"></script>
	<script src="/js/scrollup.js"></script>
  </body>
  	<script type="text/javascript">
	$("#loginBtn").click(function(){
		$("#loginform").submit();
		
	});
	$("#resetBtn").click(function(){
		$("#_title").val("");
		$("#_shell").val("");
		
	});
</script>
</html>
