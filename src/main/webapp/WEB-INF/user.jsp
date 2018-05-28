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
<body onload="ok()">
<tag:header/>
<fmt:setLocale value="${pageContext.session.getAttribute('locale')}" />
<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<h3>My news</h3>
			<c:forEach var="news" items="${newsList}">
				<h2>${news.title}</h2>
				<h5>${news.author}, <fmt:formatDate value="${news.date}" dateStyle="LONG"/></h5>
				<p>${news.brief}...</p>

				<html:form action="/newsDispatch?method=show">
					<html:hidden property="id" value="${news.id}"/>
					<html:submit value="Читать далее онлайн без регистрации и смс..."/>
				</html:form>
				<html:form action="/newsDispatch?method=openEdit">
					<html:hidden property="id" value="${news.id}"/>
					<html:submit value="Редактировать новость"/>
				</html:form>
				<div class="row">
					<div class="col-1" style="padding-right: 0; width: 25px;">
						<div class="checkbox-primary" style="width: 25px;" >
							<input style="width: 25px; height: 25px;" name="deleteNewsCheckbox" form="delete2" type="checkbox" value="${news.id}">
						</div>
					</div>
					<div style="padding:0;" class="col-11">
						<h5>Mark for deletion</h5>
					</div>
				</div>
				<hr>
			</c:forEach>
			<form name="newsForm" id="delete2" method="post" action="/newsDispatch.do?method=delete">
				<input type="submit" value="Удалить новости"/>
			</form>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
