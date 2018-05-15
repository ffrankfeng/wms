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
<script src="/demos/googlegg.js"></script>
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
		<h3 class="panel-title">新增货物</h3>
	  </div>
	  <form action="${pageContext.request.contextPath }/product/saveNewProduct" method="post" onsubmit="return checksub()">
	<table class="table">
	<tr>
		<th>货物名称<input class="in1" id="pro_name" name="pro_name" >
            	货物类别<select class="select" id="pro_type" name="pro_type" >
            		<option value="">--请选择--</option>
						<c:forEach items="${productDictList}" var="item">、
							<option value="${item.pro_dict_id}">${item.pro_dict_code }</option>
						</c:forEach>
            		</select>
        </th>
        <th>销售价格<input class="in2" id="pro_money" name="pro_money" onkeyup="value=value.replace(/[^\d]/g,'')"></th>
     </tr>
     <tr>
        <th>货物库存<input class="in3" id="pro_count" name="pro_count" onkeyup="value=value.replace(/[^\d]/g,'')"></th>
        <th>货物描述
        <textarea id="pro_inf" name="pro_inf" rows="3" cols="20"></textarea></th>
     </tr>
	</table>
	<div class="panel-heading">
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
<script type="text/javascript">
$(function(){
	//为输入框绑定事件
	$("#pro_inf").blur(function(){
		
		//1、失去焦点获得输入框的内容
		var pronameInput=$("#pro_name").val();
		var protypeInput=$("#pro_type").val();
		var promoneyInput=$("#pro_money").val();
		var procountInput=$("#pro_count").val();
		var proinfInput=$("#pro_inf").val();
		//2、去服务器端校验用户名是否存在--ajax
		$.post(
				"${pageContext.request.contextPath}/product/checkProname",
				{"proname":pronameInput,"protype":protypeInput,"promoney":promoneyInput,"proinf":proinfInput},
				function(data){
					var isExist=data.isExist;
					//3、根据返回的isExist动态显示信息
					var usernameInfo="";
					if(isExist==true){
						pronameInfo="该货物已存在";
						alert(pronameInfo);
						window.location.reload();
					}
				},
				"json"
		);
	});
});
function checksub(){
	var pronameInput=$("#pro_name").val();
	var protypeInput=$("#pro_type").val();
	var promoneyInput=$("#pro_money").val();
	var procountInput=$("#pro_count").val();
	var proinfInput=$("#pro_inf").val();
	
	if(pronameInput==""){
		pronameInput="货物名不能为空";
		alert(pronameInput);
		return false;
	}
	if(protypeInput==""){
		protypeInput="货物类别不能为空";
		alert(protypeInput);
		return false;
	}
	if(promoneyInput==""){
		promoneyInput="货物价格不能为空";
		alert(promoneyInput);
		return false;
	}
	if(procountInput==""||procountInput<=0){
		procountInput="库存不能为空";
		alert(procountInput);
		return false;
	}
	if(proinfInput==""){
		proinfInput="货物描述不能为空";
		alert(proinfInput);
		return false;
	}
	return true;
}
</script>

</body>
</html>