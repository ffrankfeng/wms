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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=basePath%>css/login.css" type="text/css" />
</head>
<body>
        <div class="col-md-1"><!--  target="submitFrame" -->
            <form class="form-signin"  method="post" action=" ${pageContext.request.contextPath }/login.action">
                <h2 class="form-signin-heading">登录到仓库管理系统</h2>
                <div class="table">
                <label for="inputName">用户名</label>
                <input type="text" id="cur_username" name="cur_username" class="form-control" placeholder="请输入用户名 " required autofocus><br>
                <label for="inputPassword">密码</label>
                <input type="password" id="cur_password" name="cur_password" class="form-control2" placeholder="请输入密码" required>
                </div>
                <div class="checkbox">
					<span></span>
				</div>
                <button type="submit" class="btn btn-primary" >登录</button>
            </form>
            <iframe style="display: none;" name="submitFrame" src="about:blank"></iframe>
        </div>
    <script src="<%=basePath%>js/jquery.min.js"></script>
</body>
</html>