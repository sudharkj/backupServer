<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/insert_user" var="insertUserUrl" />

<div id="container">
	Register new user:
	<form:form method="POST" modelAttribute="userDetails"
		action="${insertUserUrl}">
		<form:input path="id" type="hidden" />
	Username: <form:input path="username" type="text" />
		<br />
	Password: <form:input path="password" type="password" />
		<br />
	</form:form>
</div>