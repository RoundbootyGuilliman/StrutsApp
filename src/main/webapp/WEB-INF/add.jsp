<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title>Add news</title>
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
			<html:form action="/newsDispatch?method=add">

				<br/>
				Title:
				<html:text property="news.title" size="20"/>
				<br/>
				Author:
				<html:text property="news.author" size="20"/>
				<br/>
				Brief:
				<html:text property="news.brief" size="20"/>
				<br/>
				Content:
				<html:text property="news.content" size="20"/>
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
