<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
	<title>${showForm.news.title}</title>
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
			<h2>${newsForm.news.title}</h2>
			<h5>${newsForm.news.author}, <fmt:formatDate value="${newsForm.news.date}" dateStyle="LONG"/></h5>
			<div class="fakeimg">Fake Image</div>
			<p>${newsForm.news.content}</p>
			<br>
			<html:form styleClass="editButton" action="/newsDispatch?method=openEdit">
				<html:hidden property="id" value="${newsForm.news.id}"/>
				<html:submit value="Редактировать новость"/>
			</html:form>
			<html:form styleId="delete" action="/newsDispatch?method=delete">
				<html:hidden property="id" value="${newsForm.news.id}"/>
				<html:submit><bean:message key="deleteNews"/></html:submit>
			</html:form>
			<c:choose>
				<c:when test="${fn:length(newsForm.news.comments) == 0}">
					<h3>There are no comments yet. Be the first!</h3>
				</c:when>
				<c:otherwise>
					<h3>${fn:length(newsForm.news.comments)} comments:</h3>
				</c:otherwise>
			</c:choose>
			<hr>
			<c:forEach var="comments" items="${newsForm.news.comments}">
				<b>${comments.username}:</b>
				<br>
				${comments.comment}
				<hr>
			</c:forEach>
			<c:choose>
				<c:when test="${not empty pageContext.request.remoteUser}">
					<h3>Write your comment:</h3>
					<html:form action="/newsDispatch?method=addComment">
						<html:hidden property="id" value="${newsForm.news.id}"/>
						<html:textarea style="width: 100%" property="comment" rows="7"/>
						<html:submit value="Комментировать"/>
					</html:form>
				</c:when>
				<c:otherwise>
					<h3>You have to log in to write comments</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
