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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>人员管理</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
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
		<div class="body-content" style="width: 960px">
             <div style="border:2px dashed white;height:60px;">
            	<h3 class="header">用户信息</h3>
            			<form  action="${pageContext.request.contextPath }/user/list.action" method="post">
            	<table style="border:2px dashed white;width:100%;height:60px;">
            		<tr>
            			<th>姓名<input class="input" id="userName" name="userName">
            			联系方式<input class="time" style="width: 180px" id="userPhone" name="userPhone">
            			管理员权限<select class="select" id="userAut" placeholder="用户权限" name="userAut">
            			<option value="">--请选择--</option>
								<c:forEach items="${fromAut}" var="item">
									<option value="${item.user_aut}">${item.user_aut_dict }</option>
								</c:forEach>
            			</select>     
            			</th>
            			<th>
            				<button class="button" type="submit">查询</button>
            			</th>
            			</tr>
            			</table>
            			</form>
            		<table style="border:2px dashed white;width:100%;height:80px;">
					<tr>
						<td>ID</td>
						<td>用户名称</td>
						<td>联系方式</td>
						<td>用户权限</td>
					<c:if test="${USER.user_aut<2 }">	<td>操作</td></c:if>
					</tr>
					<c:forEach items="${page.rows }" var="row">
						<tr>
							<td>${ row.user_id}</td>
							<td>${ row.user_name}</td>
							<td>${ row.user_phone}</td>
							<td>${ row.userDict.user_aut_dict}</td>
							<c:if test="${USER.user_aut<2 }">
								<td><button onclick="window.location.href='editUser?id=${row.user_id}'">修改</button>
								<button onclick="deleteUser(${row.user_id})">删除</button></td>
							</c:if>

						</tr>						
					</c:forEach>
            	</table>
            		<div class="col-md-12 text-right">
						<fengf:page url="${pageContext.request.contextPath }/user/list.action" />
					</div>
			</div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->

<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap-3.3.4.js"></script>
<script type="text/javascript">
	function deleteUser(id) {
		if(confirm('确实要删除该管理员吗?')) {
			$.post("<%=basePath%>user/delete.action",
					{"id":id},
					function(data){
				alert("管理员删除更新成功！");
				window.location.reload();
			});
		}
	}
</script>

</body>
</html>