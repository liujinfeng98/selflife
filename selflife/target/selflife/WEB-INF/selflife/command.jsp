<%@ page isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="utf-8">
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
		<a class="navbar-brand" href="index.html" >Selflife</a>
    </div>
	 <div class="collapse navbar-collapse" id="navbar">
	 <ul class="nav navbar-nav">
           
           <li><a href="index.html">首页</a></li>
        <li><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">博客<b class="caret"></b></a>		
		 <ul class="dropdown-menu">
                <li>
                  <a href="http://v2.bootcss.com/getting-started.html" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-v2doc-起步'])">标签</a>
                </li>
                <li>
                  <a href="http://v2.bootcss.com/getting-started.html" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-v2doc-起步'])">时间</a>
                </li>
              </ul>
			  </li>
        <li><a href="znyd.html">项目</a></li>
        <li><a href="jCloud.html">软件</a></li>
          </ul>
      <ul class="nav navbar-nav navbar-right">
        
		<li><a href="english/index.html">English</a></li>
      </ul>    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container -->
</nav>
<div class="jumbotron jumbotron_custom">
  <div class="container">
	 <div style="background:#efeeee;font-size:20px;padding:20px;"><c:out value="${hashmap.command.ec_command_title}"/><span style="margin-right:10px;"><a href="/queryCommand/toCommandUpdate/${hashmap.command.ec_command_id}">修改</a></span></div>
	 <div style="background:#efeeee;font-size:16px;line-height:2.0;padding:10px;"><c:out value="${hashmap.command.ec_command_shell}"/></div>
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
</html>
