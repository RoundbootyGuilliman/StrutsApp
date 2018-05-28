<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron text-center" style="margin-bottom:0">
	<h1>HOBOCTN</h1>
	<p><bean:message key="app.message"/> </p>
</div>
<script>
	function ok() {
		if (${pageContext.request.isUserInRole("Admin")}) {

			var chekboxes = document.getElementsByName("markDel");
			var i;
			for (i = 0; i < chekboxes.length; i++) {
				chekboxes[i].removeAttribute("hidden")
			}
			document.getElementById("adminRights").removeAttribute("hidden");
			document.getElementById("logout").removeAttribute("hidden");
			document.getElementById("adminpage").removeAttribute("hidden");
			document.getElementById("mypage").removeAttribute("hidden");
		} else if (${pageContext.request.isUserInRole("User")}) {
			document.getElementById("delete").setAttribute("hidden", "");
			var editButtons = document.getElementsByClassName("editButton")
			var i;
			for (i = 0; i < editButtons.length; i++) {
				editButtons[i].setAttribute("hidden", "");
			}
			document.getElementById("userRights").removeAttribute("hidden");
			document.getElementById("logout").removeAttribute("hidden");
			document.getElementById("mypage").removeAttribute("hidden");
		} else {
			document.getElementById("delete").setAttribute("hidden", "");
			document.getElementById("av").setAttribute("hidden", "");
			document.getElementById("loginmessage").removeAttribute("hidden");
			document.getElementById("signin").removeAttribute("hidden");
			document.getElementById("register").removeAttribute("hidden");
			var editButtons = document.getElementsByClassName("editButton")
			var i;
			for (i = 0; i < editButtons.length; i++) {
				editButtons[i].setAttribute("hidden", "");
			}
		}
	}
</script>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<html:link page="/main.do" styleClass="navbar-brand">Main page</html:link>
	<ul class="navbar-nav">
		<li class="nav-item"><html:link page="/locale.do?method=english" styleClass="nav-link">English</html:link></li>
		<li class="nav-item"><html:link page="/locale.do?method=russian" styleClass="nav-link">Russian</html:link></li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li id="signin" hidden class="nav-item"><html:link page="/logforward.do" styleClass="nav-link">Sign in</html:link></li>
		<li id="register" hidden class="nav-item"><html:link page="/regforward.do" styleClass="nav-link">Register</html:link></li>
		<li id="logout" hidden class="nav-item"><html:link page="/logout.do?method=logout" styleClass="nav-link">Log out</html:link></li>
	</ul>
</nav>