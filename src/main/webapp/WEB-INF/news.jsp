<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<body>

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
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
