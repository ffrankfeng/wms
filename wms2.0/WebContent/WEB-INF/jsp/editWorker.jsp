<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fengf" uri="http://fengf.com/common/"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>仓库管理系统</title>
<link rel="stylesheet" href="<%=basePath%>css/Change2.css">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">

</head>
<body><script src="/demos/googlegg.js"></script>
<jsp:include page="header.jsp"></jsp:include>
	<!-- Page Content -->
	<div id="page-content-wrapper">
	  <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
		<span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
	  </button>
	  <div class="container">
      <div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">用户管理</h3>
	</div>
	<form action="${pageContext.request.contextPath }/user/update" method="post" >
	<table class="table"><input type="hidden" id="user_id" name="user_id"  value="${user.user_id }">
		<tr><td>姓名<input class="input3" id="user_name" name="user_name" value="${user.user_name }"></td>
		<td>联系方式<input class="input4"id="user_phone" name="user_phone" value="${user.user_phone }"></td></tr>
		<tr>
		<td>密码<input class="input4" id="user_password" name="user_password" placeholder="请输入新密码" ></td>
		<td>用户权限<select class="select" id="user_aut" name="user_aut" placeholder="用户权限" name="productType">
            			<option value="${user.user_aut}">${user.userDict.user_aut_dict }</option>
								<c:forEach items="${fromAut}" var="item">
									<c:if test="${user.userDict.user_aut_dict != item.user_aut_dict}">
										<option value="${item.user_aut}">${item.user_aut_dict }</option>
									</c:if>
								</c:forEach>
            			</select>
        </td></tr>
	</table>
	<div class="panel-heading" align="center">
		<input type="submit">
		<input type="reset" value="重置" class="submit">
		<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
	</div>
    </form>
    </div>
	</div>
	</div>
	<!-- /#page-content-wrapper -->
<!-- /#wrapper -->

<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap-3.3.4.js"></script>


</body>
</html>