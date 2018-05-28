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
<body onload="ok()">

<tag:header/>

<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<html:form action="/newsDispatch?method=add">

				<html:hidden property="news.id"/>
				<br/>
				Title:
				<html:text style="width: 100%" property="news.title" size="20"/>
				<br/>
				Brief:
				<html:textarea style="width: 100%;" property="news.brief" rows="7"/>
				<br/>
				Content:
				<html:textarea style="width: 100%" property="news.content" rows="15"/>
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
