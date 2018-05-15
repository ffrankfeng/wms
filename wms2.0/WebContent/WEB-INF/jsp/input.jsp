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
<title>仓库管理系统</title>
<link rel="stylesheet" href="<%=basePath%>css/Change.css">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">

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
      <div class="panel panel-default" style="margin-top: 10px">
	  <div class="panel-heading">
		<h3 class="panel-title">商品入库</h3>
	  </div>
	  <form action="${pageContext.request.contextPath }/product/saveInput"  onSubmit="return subcheck()">
	  <table class="table"><input type="hidden"id="pro_id" name="pro_id" value="${productinf.pro_id}">
		<tr><td>货物名称<input class="input1"  disabled="true" value="${productinf.pro_name }"></td>
			<td>销售价格<input class="input2" disabled="true" value="${productinf.pro_money }"></td>
		</tr>
		<tr><td>
            	货物类别<select class="select" id="productType" placeholder="用户权限" name="productType" disabled="disabled">
           		<option value=" ">${productinf.productDict.pro_dict_code}</option>
<%-- 					<c:forEach items="${proDictType}" var="item">
						<option value="${item.pro_dict_id}">${item.pro_dict_code }</option>
					</c:forEach> --%>
            	</select>
		   </td>
		   <td>入库数量<input class="input3" id="pro_input" name="pro_input" onkeyup="value=value.replace(/[^\d]/g,'')"></td>
		</tr>
		<tr>
		<td colspan="2">货物描述<textarea id="pro_inf" name="pro_inf" rows="3" cols="50" disabled="true" resize: none>${productinf.pro_inf}</textarea></td>
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
function subcheck(){
	var pro_output=$("#pro_input").val();
	if(pro_output==""){
		alert("入货为空！");
		return false;
	}
	if(pro_output==0){
		alert("入货不能为零！");
		return false;
	}
	return true;
}
</script>
</body>
</html>