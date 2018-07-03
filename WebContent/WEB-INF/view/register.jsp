<%@ include file="../include/ext/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demos -> Form Control</title>
<%@ include file="../include/ext/javaScriptInclude.jsp"%>
<script type="text/javascript">
 function showMessage(){
	if($("#msg").text().trim()!=='')
		alert($("#msg").text());
 }
</script>
</head>
<body onload="showMessage()">
	<div style="display:none" id="msg">${message}</div>
	<br/>
	<form:form action="user.html" commandName="userObj" method="POST">
		<table>
			<tr>
				<td colspan="2" align="left">
					<input type="submit" class="btn btn-primary" value="List" name="List" style="width:65px;margin-bottom:8px;"/>
					<input type="reset" class="btn btn-primary" value="New" style="width:65px;margin-bottom:8px;"/>
					<input type="submit" class="btn btn-primary" value="Save" name="Save" style="width:75px;margin-bottom:8px;"/>
					<input type="submit" class="btn btn-primary" value="Delete" name="Delete" style="width:75px;margin-bottom:8px;"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="userCode">
						<spring:message text="User Code : " />
					</form:label></td>
				<td>
					<form:input path="firstName" placeholder="enter user code"/><form:hidden path="id"/>
					<font color="red"><form:errors path="code" /></font>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="firstName">
						<spring:message text="First Name : " />
					</form:label></td>
				<td>
					<form:input path="firstName" placeholder="enter first name"/>
					<font color="red"><form:errors path="firstName" /></font>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="lastName">
						<spring:message text="Last Name : " />
					</form:label></td>
				<td>
					<form:input path="lastName" placeholder="enter last name" />
					<font color="red"><form:errors path="lastName" /> </font>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="nrc">
						<spring:message text="NRC No." />
					</form:label></td>
				<td>
					<form:input path="nrc" placeholder="enter NRC No." /> 
					<font color="red"><form:errors path="nrc" /> </font>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="email">
						<spring:message text="Email" />
					</form:label>
				</td>
				<td>
					<form:input path="email" placeholder="enter date of birth" id="dob" /> 
					<font color="red"><form:errors path="email" /></font>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="phoneNo">
						<spring:message text="Phone No." />
					</form:label>
				</td>
				<td>
					<form:input path="phoneNo" placeholder="enter phone No."/>
					<font color="red"><form:errors path="phoneNo" /> </font>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>