<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/login" var="loginUrl" />
<c:url value="/show_register" var="showRegisterUrl" />

<div id="container">
	Login:
	<form:form method="POST" modelAttribute="userDetails"
		action="${loginUrl}">
	Username: <form:input path="username" type="text" />
		<br />
	Password: <form:input path="password" type="password" />
		<br />
		<button disabled="disabled">Submit</button>
	</form:form>
	<span>New User? <a href="${showRegisterUrl}">Register</a></span>
</div>