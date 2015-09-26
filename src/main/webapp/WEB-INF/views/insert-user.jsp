<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/insert_user" var="insertUserUrl" />
<c:url value="/show_login" var="showLoginUrl" />

<div id="container">
	Register new user:
	<form:form method="POST" modelAttribute="userDetails"
		action="${insertUserUrl}">
		<form:input path="id" type="hidden" />
	Username: <form:input path="username" type="text" />
		<br />
	Password: <form:input path="password" type="password" />
		<br />
		<button>Submit</button>
	</form:form>
	<span>Existing User? <a href="${showLoginUrl}">Login</a></span>
</div>