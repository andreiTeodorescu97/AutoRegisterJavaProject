<%@
	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<title>Confirmare programare</title>
</head>

<body>
	Succes! Ati inregistrat autovehiculul: 
	
	<p>Succes! Ati inregistrat autovehiculul: </p>
	<p>Tipul: |${vehicleXperson.type}| </p>
	<p>Marca: |${vehicleXperson.brand}| </p>
	<p>Modelul: |${vehicleXperson.model}|   </p>
	<p>Capacitate cilindrica: |${vehicleXperson.cilindricCapacity}|</p>
	<p>Culoare: |${vehicleXperson.color}| </p>
	<p>Combustibil: |${vehicleXperson.fuel}| </p>
	<p>Putere: |${vehicleXperson.power}| </p>
	<p>Data fabricatie: |${vehicleXperson.productionDate}| </p>
	<p>CNP Proprietar: |${vehicleXperson.uniqueNumberForPerson}| </p>
	<p>Norma poluare: |${vehicleXperson.polutionNumber}| </p>
	
	<a href="${pageContext.request.contextPath}/vehicle/list">Inapoi la vehiculele inregistrate</a>
</body>

</html>