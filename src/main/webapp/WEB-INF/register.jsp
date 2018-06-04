<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title>Register</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<style>
		.fakeimg {
			height: 200px;
			background: #aaa;
		}
	</style>
</head>
<body onload="ok()">
<tag:header/>
<fmt:setLocale value="${pageContext.session.getAttribute('locale')}" />
<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div style="margin-left: 50px;" class="col-sm-1">
			<br/>
			Username:
			<br/>

			<br/>
			Password:
		</div>
		<div class="col-sm-1">
			<html:form action="/login?method=register">
				<c:set var="erruser"><html:errors property="common.username.err"/></c:set>
				<c:set var="errpass"><html:errors property="common.password.err"/></c:set>
				<br/>
				<html:text property="user.username" size="20" value="${erruser}"/>
				<br/>
				<br/>
				<html:password property="user.password" size="20" value="${errpass}"/>
				<br/><br/>
				<html:submit>
					Submit
				</html:submit>

			</html:form>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
