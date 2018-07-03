<%@ include file="../include/ext/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SPRING MVC</title>
<%@ include file="../include/ext/javaScriptInclude.jsp"%>
<script type="text/javascript">
function editInfo(key){
	$("#pkey").val(key);
	$("#editData")[0].submit();
}
</script>
</head>
<body>
	<br/>
	<form id="stulistForm" action="user.html" method="GET">
		<input type="submit" class="btn btn-primary" value="New" style="width:65px;"/>
		<a href="userReportPdf.do">Export Pdf</a>|
		<a href="userReportExcel.do">Export Excel</a>
	</form>
	
	<form action="editUserInfo.html" id="editData" method="post"><input type="hidden" name="id" id="pkey"/></form>
	
	<table class="table table-striped table-hover">
		<thead>
			<tr><th></th><th>ID.</th><th>Name</th><th>NRC No.</th><th>Email</th><th>Phone No.</th></tr>
		</thead>
		<tbody>
			<c:forEach var = "user" items = "${userList}">
				<tr>
					<td><input type="submit" class="btn btn-primary" value="Edit" onclick="editInfo(${user.id})"/></td>
	               	<td><c:out value="${user.uid}"></c:out></td>
	                <td><c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></td>
	                <td><c:out value="${user.nrc}"></c:out></td>
	                <td><c:out value="${user.email}"></c:out></td>
	                <td><c:out value="${user.phoneNo}"></c:out></td>
                </tr>
            </c:forEach>
		</tbody>
	</table>
</body>
</html>