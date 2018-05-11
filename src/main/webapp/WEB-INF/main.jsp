<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<logic:iterate name="mainForm" property="newsList" id="newsItem">

				<h2>${newsItem.title}</h2>
				<h5>${newsItem.author},
						${newsItem.date}</h5>
				<div class="fakeimg">Fake Image</div>
				<p>${newsItem.brief}...</p>

				<html:link page="/news.do"><p>Читать далее без регистрации и СМС...</p></html:link>
				<br>
			</logic:iterate>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
