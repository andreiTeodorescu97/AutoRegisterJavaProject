<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Appointments List</title>
	<style>
		.error{color:red}
	</style>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Adauga programare</h2>
		</div>
	</div>
	
	
	<div id="contrainer">
		<div id="content">
			
	<form:form action="addAppoinment" modelAttribute="appointmentXperson">
	
		 Nume(*): <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/>
		<br><br>
		
		 Prenume(*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		
		 CNP(*): <form:input path="uniqueNumber"/>
		<form:errors path="uniqueNumber" cssClass="error"/>
		<br><br>
		
		 Email(*): <form:input path="email"/>
		<form:errors path="email" cssClass="error"/>
		<br><br>
		
		 Data(*): <form:input type="date" path="date"/>
		<form:errors path="date" cssClass="error"/>
		<br><br>
		
		 Ora(*): <form:select path="time">
		 				<form:option value=""/>
		 				<form:option value="08:30"/>
		 				<form:option value="09:30"/>
		 				<form:option value="10:30"/>
		 				<form:option value="11:30"/>
		 				<form:option value="12:30"/>
		 				<form:option value="13:30"/>
		 				<form:option value="14:30"/>
		 				<form:option value="15:30"/>
		 				<form:option value="16:30"/>
		 		 </form:select>
		<form:errors path="time" cssClass="error"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
		
	</form:form>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>