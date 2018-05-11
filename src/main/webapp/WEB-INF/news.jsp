<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html lang="en">
<head>
	<title><bean:write name="newsForm" property="news.title"/></title>
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
			<h2><bean:write name="newsForm" property="news.title"/></h2>
			<h5><bean:write name="newsForm" property="news.author"/>,
				<bean:write name="newsForm" property="news.date"/></h5>
			<div class="fakeimg">Fake Image</div>
			<p><bean:write name="newsForm" property="news.content"/></p>
			<br>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
