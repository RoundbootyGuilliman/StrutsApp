<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<div class="jumbotron text-center" style="margin-bottom:0">
	<h1>HOBOSTI</h1>
	<p><bean:message key="app.message" /> </p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<html:link page="/main.do" styleClass="navbar-brand">Main page</html:link>
	<ul class="navbar-nav">
		<li class="nav-item"><html:link page="/locale.do?method=english" styleClass="nav-link">English</html:link></li>
		<li class="nav-item"><html:link page="/locale.do?method=russian" styleClass="nav-link">Russian</html:link></li>
	</ul>
</nav>