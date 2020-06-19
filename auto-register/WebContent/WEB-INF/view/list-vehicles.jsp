<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Vehicles List</title>
<style>
table, th, td {
  border: 2px inset coral;
  border-collapse: collapse;
}
</style>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Vehicule inregistrate</h2>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}">Meniu principal</a>
	<br><br>
	<div id="contrainer">
		<div id="content">

			<table>
				<tr>
					<th>Marca</th>
					<th>Model</th>
					<th>Numar inmatriculare</th>
					<th>VIN</th>
					<th>Culoare</th>
					<th>Capacitate cilindrica</th>
					<th>Putere (CP)</th>
					<th>Data productie</th>
					<th>Data inregistrare</th>
					<th>Taxa</th>
					<th>Impozit</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempVariable" items="${vehiclesForTheJsp}">
					<c:url var="deleteLink" value="/vehicle/delete">
						<c:param name="vehicleIdToDelete" value="${tempVariable.id}" />
					</c:url>

					<c:url var="updateLink" value="/vehicle/showFormForUpdate">
						<c:param name="vehicleIdToUpdate" value="${tempVariable.id}" />
					</c:url>

					<c:url var="viewLink" value="/vehicle/showFormForView">
						<c:param name="vehicleIdToView" value="${tempVariable.id}" />
					</c:url>
					<tr>
						<td>${tempVariable.brand}</td>
						<td>${tempVariable.model}</td>
						<td>${tempVariable.plate}</td>
						<td>${tempVariable.identificationNumber}</td>
						<td>${tempVariable.color}</td>
						<td>${tempVariable.cilindricCapacity}</td>
						<td>${tempVariable.power}</td>
						<td>${tempVariable.productionDate}</td>
						<td>${tempVariable.registrationDate}</td>
						<td>${tempVariable.tax}</td>
						<td>${tempVariable.anualTax}</td>
						<td><a href="${updateLink}">Update</a>
						 | <a href="${deleteLink}"
							onclick="if(!(confirm('Stegeti vehiculul cu numarul de inmatriculare ${tempVariable.plate}'))) return false">Delete</a>
							 | <a href="${viewLink}">Detalii</a>
					   </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>