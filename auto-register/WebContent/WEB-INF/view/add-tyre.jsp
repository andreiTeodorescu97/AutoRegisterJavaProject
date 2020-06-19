<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Lista anvelope</title>
	<style>
		.error{color:red}
	</style>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Inregistreaza o anvelopa noua</h2>
		</div>
	</div>
	
	<div id="contrainer">
		<div id="content">
			
	<form:form action="addTyre" modelAttribute="tyre">
	
		 Dimensiune/Denumire(*): <form:input path="dimension"/>
		<!--<form:errors path="dimension" cssClass="error"/> -->
		<br><br>
		
		
		<form:hidden path="id"/>
		
		<input type="submit" value="Submit"/>
		
	</form:form>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>