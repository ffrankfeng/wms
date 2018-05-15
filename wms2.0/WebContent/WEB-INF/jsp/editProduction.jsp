<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
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
<title>仓库管理系统</title>
<link rel="stylesheet" href="<%=basePath%>css/Change.css">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/edit.css">

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
		<h3 class="panel-title">商品信息修改</h3>
	  </div>
	  <form action="${pageContext.request.contextPath }/product/update" method="post">
	<table class="table">
	<tr>
	<input type="hidden"id="pro_id" name="pro_id" value="${productinf.pro_id}">
		<th>货物名称<input class="in1" id="pro_name" name="pro_name" value="${productinf.pro_name}">
            	货物类别<select class="select" id="pro_type" name="pro_type" >
            		<option value="${productinf.productDict.pro_dict_id}" selected="selected">${productinf.productDict.pro_dict_code}</option>
								<c:forEach items="${productDictList}" var="item">、
									<c:if test="${productinf.productDict.pro_dict_code !=item.pro_dict_code }">
										<option value="${item.pro_dict_id}">${item.pro_dict_code }</option>
									</c:if>
								</c:forEach>
            		</select>
        </th>
        <th>销售价格<input class="in2" id="pro_money" name="pro_money" value="${productinf.pro_money}"></th>
     </tr>
     <tr>
        <th>货物库存<input class="in3" id="pro_count" name="pro_count" value="${productinf.pro_count}"></th>
        <th>货物描述
        <textarea id="pro_inf" name="pro_inf" rows="3" cols="20">${productinf.pro_inf}</textarea></th>
     </tr>
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