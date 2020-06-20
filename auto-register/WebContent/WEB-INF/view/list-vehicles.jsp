<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Vehicles List</title>
<style>
.pull-right{
	float:right;
	margin-left:10px!important;
}
</style>
</head>

<body>
<div class="container-fluid">
	<div align="center" id="wrapper">
		<div id="header">
			<h2>Vehicule inregistrate</h2>
		</div>
	</div>
	<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}">Meniu principal</a>
	<a class="btn btn-primary pull-right" href="showFormForAddingVehicle">Adauga masina</a>
	
	<br><br>
	<div id="contrainer" >
		<div id="content" >

			<table class="table table-striped table-bordered table-hover table-responsive-md">
				<thead class="thead-dark">
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
				</thead>
				<tbody class="table-striped">
					<c:forEach var="tempVariable" items="${listVehicles}">
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
							<td><a class="btn btn-sm btn-success" href="${updateLink}">Update</a>
							  <a  class="btn btn-sm btn-warning" href="${deleteLink}"
								onclick="if(!(confirm('Stegeti vehiculul cu numarul de inmatriculare ${tempVariable.plate}'))) return false">Delete</a>
								  <a class="btn btn-sm btn-info" href="${viewLink}">Detalii</a>
						   </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			
			
		</div>
	</div>
</div>
</body>

</html>