<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title>News</title>
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
<body>
<tag:header/>
<fmt:setLocale value="${pageContext.session.getAttribute('locale')}" />
<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<c:forEach var="news" items="${newsList}">
				<h2>${news.title}</h2>
				<h5>${news.author}, <fmt:formatDate value="${news.date}" dateStyle="LONG"/></h5>
				<div class="fakeimg">Fake Image</div>
				<p>${news.brief}...</p>

				<html:form action="/newsDispatch?method=show">
					<html:hidden property="id" value="${news.id}"/>
					<html:submit value="Читать далее онлайн без регистрации и смс..."/>
				</html:form>
				<html:form action="/newsDispatch?method=delete">
					<html:hidden property="id" value="${news.id}"/>
					<html:submit value="Удалить новость"/>
				</html:form>
				<br>
			</c:forEach>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
