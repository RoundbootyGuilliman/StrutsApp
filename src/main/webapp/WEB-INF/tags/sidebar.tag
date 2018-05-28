<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<div class="col-sm-4">
	<h2 id="loginmessage" hidden>You are not logged in</h2>
	<h2>${pageContext.request.remoteUser}</h2>
	<div id="av" class="fakeimg">Fake Image</div>
	<br>
	<h4 id="userRights" hidden>Your rights: User</h4>
	<h4 id="adminRights" hidden>Your rights: Admin</h4>
	<ul class="nav nav-pills flex-column">
		<li class="nav-item"><html:link page="/addforward.do" styleClass="btn btn-outline-success btn-block">Add news</html:link></li>
		<li id="adminpage" hidden class="nav-item"><html:link page="/newsDispatch.do?method=admin" styleClass="btn btn-outline-primary btn-block">Admin page</html:link></li>
		<li id="mypage" hidden class="nav-item"><html:link page="/newsDispatch.do?method=showUser" styleClass="btn btn-outline-primary btn-block">My page</html:link></li>
	</ul>
	<hr class="d-sm-none">
</div>