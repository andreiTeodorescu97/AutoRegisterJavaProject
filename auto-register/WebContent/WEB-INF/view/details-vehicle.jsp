<%@
	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<title>Detaliu vehicul</title>
	<style>
table, th, td {
  border: 2px inset coral;
  border-collapse: collapse;
}
</style>
</head>

<body>
	<h2>Detalii masina</h2>
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
	<hr>
	
	<h3>Dimensiuni avelope neasociate</h3>
	<table>
				<tr>
					<th>Id</th>
					<th>Dimensiune</th>
					<th>Actiuni</th>
				</tr>

				<c:forEach var="tempVariable" items="${nonExistingTyresForTheJsp}">
					<c:url var="addLink" value="/vehicle/addTyreToVehicle">
						<c:param name="vehicleIdToAdd" value="${vehicleXperson.vehicleId}" />
						<c:param name="tyreIdToAdd" value="${tempVariable.id}" />
					</c:url>
					<tr>
						<td>${tempVariable.id}</td>
						<td>${tempVariable.dimension}</td>
						<td><a href="${addLink}">Atribuie</a></td>
					</tr>
				</c:forEach>
			</table>
	<br><br><hr>
	<a href="${pageContext.request.contextPath}/vehicle/list">Inapoi la lista de vehicule</a>
</body>

</html>