<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Vehicles List</title>
	<style>
		.error{color:red}
	</style>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Inregistreaza un autovehicul</h2>
		</div>
	</div>
	
	<div id="contrainer">
		<div id="content">
			
	<form:form action="addVehicle" modelAttribute="vehicleXperson">
	
		Tip(*):<form:select path="type">
		 				<form:option value=""/>
		 				<form:option value="Autoturism"/>
		 				<form:option value="Autobuz"/>
		 				<form:option value="Autocar"/>
		 				<form:option value="Motocicleta"/>
		 				<form:option value="Microbuz"/>
		 				<form:option value="Tractor"/>
		 		 </form:select>
		<form:errors path="type" cssClass="error"/>
		<br><br>
	
		 Marca(*): <form:input path="brand"/>
		<form:errors path="brand" cssClass="error"/>
		<br><br>
		
		 Model(*): <form:input path="model"/>
		<form:errors path="model" cssClass="error"/>
		<br><br>
		
		 Numar inmatriculare(*): <form:input path="plate"/>
		<form:errors path="plate" cssClass="error"/>
		<br><br>
		
		 VIN(*): <form:input path="identificationNumber"/>
		<form:errors path="identificationNumber" cssClass="error"/>
		<br><br>
		
		 Capacitate cilindrica(*): <form:input path="cilindricCapacity"/>
		<form:errors path="cilindricCapacity" cssClass="error"/>
		<br><br>
		
		 Culoare(*): <form:input path="color"/>
		<form:errors path="color" cssClass="error"/>
		<br><br>
		
		 Combustibil(*): <form:select path="fuel">
			 				<form:option value=""/>
			 				<form:option value="Benzina"/>
			 				<form:option value="Motorina"/>
			 				<form:option value="Electric"/>
		 		 		</form:select>
		<form:errors path="fuel" cssClass="error"/>
		<br><br>
		
		 Cai Putere(*): <form:input path="power"/>
		<form:errors path="power" cssClass="error"/>
		<br><br>
		
		 Data Productie(*): <form:input type="date" path="productionDate"/>
		<form:errors path="productionDate" cssClass="error"/>
		<br><br>
		
		 Norma Poluare(*): <form:select path="polutionNumber">
			 				<form:option value=""/>
			 				<form:option value="EURO 1"/>
			 				<form:option value="EURO 2"/>
			 				<form:option value="EURO 3"/>
			 				<form:option value="EURO 4"/>
			 				<form:option value="EURO 5"/>
			 				<form:option value="EURO 6"/>
			 				<form:option value="ELECTRIC"/>
		 		 		</form:select>
		<form:errors path="polutionNumber" cssClass="error"/>
		<br><br>
		
		 CNP Proprietar(*) : <form:input path="uniqueNumberForPerson"/>
		<form:errors path="uniqueNumberForPerson" cssClass="error"/>
		<br><br>
		
		<form:hidden path="vehicleId"/>
		
		<input type="submit" value="Submit"/>
		
	</form:form>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>