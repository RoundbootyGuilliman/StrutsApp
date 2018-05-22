<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<div class="col-sm-4">
	<h2>About Me</h2>
	<h5>Photo of me:</h5>
	<div class="fakeimg">Fake Image</div>
	<p>Some text about me in culpa qui officia deserunt mollit anim..</p>
	<h3>Some Links</h3>
	<p>Lorem ipsum dolor sit ame.</p>
	<ul class="nav nav-pills flex-column">
		<li class="nav-item"><html:link page="/addforward.do" styleClass="nav-link active">Add news</html:link></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a></li>
	</ul>
	<hr class="d-sm-none">
</div>