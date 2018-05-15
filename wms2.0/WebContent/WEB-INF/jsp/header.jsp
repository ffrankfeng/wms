<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fengf" uri="http://fengf.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
<script src="/demos/googlegg.js"></script>
<div id="wrapper">
	<div class="overlay"></div>
		<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
		<ul class="nav sidebar-nav">
		<li class="welcom"><h3>欢迎您！${USER.user_name}</h3></li>
		<li class="sidebar-brand">
				<a href="Index.jsp">
				   主页
				</a>
			</li>
			<li>
				<a href="<%=basePath%>product/list"><i class="fa fa-fw fa-home"></i> 货物管理</a>
			</li>
			<c:if test="${USER.user_aut<=2 }">
			<li>
				<a href="<%=basePath%>user/list"><i class="fa fa-fw fa-folder"></i> 用户管理</a>
			</li>
			</c:if>
			<li>
				<a href="<%=basePath%>product/newProduction"><i class="fa fa-fw fa-file-o"></i>新增货物</a>
			</li>
			<c:if test="${USER.user_aut==1 }">
				<li>
					<a href="<%=basePath%>user/newUser"><i class="fa fa-fw fa-file-o"></i> 新增管理员</a>
				</li>
			</c:if>
			<c:if test="${empty USER }">
				<li>
					<a href="<%=basePath%>login"><i class="fa fa-fw fa-cog"></i> 登录页</a>
				</li>
			</c:if>
			<li>
				<a href="<%=basePath%>exitlogin"><i class="fa fa-fw fa-cog"></i> 退出</a>
			</li>
		</ul>
	</nav>
	
	<div id="page-content-wrapper">
	  <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
		<span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
	  </button>
	  </div>
	 </div>
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap-3.3.4.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
	  var trigger = $('.hamburger'),
		  overlay = $('.overlay'),
		 isClosed = false;

		trigger.click(function () {
		  hamburger_cross();      
		});

		function hamburger_cross() {

		  if (isClosed == true) {          
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		  } else {   
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		  }
	  }
	  $('[data-toggle="offcanvas"]').click(function () {
			$('#wrapper').toggleClass('toggled');
	  });  
	});
</script>


