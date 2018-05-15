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

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body><script src="/demos/googlegg.js"></script>
<jsp:include page="header.jsp"></jsp:include>
	<div id="page-content-wrapper">
	  <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
		<span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
	  </button>
 	  <div class="container">
		<div class="body-content" style="width: 960px">
             <div style="border:2px dashed white;height:60px;">
            	<h3 class="header">物资信息<button class="button1" onclick="window.open(
            	'${pageContext.request.contextPath }/product/outputExcel.action')">导出为Excel</button></h3>
            	<form  action="${pageContext.request.contextPath }/product/list.action" method="post">
            	<table style="border:2px dashed white;width:100%;height:60px;">
            		<tr>
            			<th>货物名称<input class="input">
            			货物类别<select class="select" id="productType" placeholder="用户权限" name="productType">
            			<option value="">--请选择--</option>
								<c:forEach items="${productDictList}" var="item">
									<option value="${item.pro_dict_id}">${item.pro_dict_code }</option>
								</c:forEach>
            			</select>
            			最近更新时间<input class="time" style="width: 180px">
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
						<td>货物名称</td>
						<td>货物类别</td>
						<td>销售价格</td>
						<td>货物库存</td>
						<td>最近更新时间</td>
						<td class="td1">操作</td>
					</tr>
					<c:forEach items="${page.rows}" var="row">
					<tr>
						<td>${row.pro_id}</td>
						<td>${row.pro_name}</td>
						<td>${row.productDict.pro_dict_code}</td>
						<td>${row.pro_money}</td>
						<td>${row.pro_count}</td>
						<td>${row.pro_uptime}</td>
						<td>
							<c:if test="${USER.user_aut<=2 }">
								<button class="b1" onclick="window.location.href='editProduction?id=${row.pro_id}'">修改</button>
								<button class="b1" onclick="deleteProduct(${row.pro_id})">删除</button>
							</c:if>
							<button class="b1" onclick="window.location.href='inputProduct?id=${row.pro_id}'">入库</button>
							<button class="b1" onclick="window.location.href='outputProduct?id=${row.pro_id}'">出库</button>
						</td>
					</tr>
					</c:forEach>
            	</table>
            	<div class="col-md-12 text-right">
							<fengf:page url="${pageContext.request.contextPath }/product/list.action" />
						</div>
			</div>
		</div>
	</div> 
	<!-- /#page-content-wrapper -->
<!-- /#wrapper -->
</div>
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>js/bootstrap-3.3.4.js"></script>
<script type="text/javascript">
	function deleteProduct(id) {
		if(confirm('确实要删除该货物吗?')) {
			$.post("<%=basePath%>product/delete.action",
					{"id":id},
					function(data){
				alert("货物删除更新成功！");
				window.location.reload();
			});
		}
	}
</script>

</body>
</html>