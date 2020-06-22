<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<title>Vehicles List</title>
	<style>
		.error{color:red}
		
		.padding-top15{padding-top:15px;}
	</style>
</head>

<body>
<div class="container-fluid">
	<div align="center" id="wrapper">
		<div id="header">
			<h2>Inregistreaza un autovehicul</h2>
		</div>
	</div>
	<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}">Meniu principal</a>
	<div id="contrainer">
		<div id="content">
			
	<form:form action="addVehicle" modelAttribute="vehicleXperson">
	<br>
	<br>
	<hr>
	

	<div class="form-group">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="col-sm-4">
				<label for="exampleInputEmail1">Tip(*)</label>
				<form:select class="form-control" path="type">
				 				<form:option value=""/>
				 				<form:option value="Autoturism"/>
				 				<form:option value="Autobuz"/>
				 				<form:option value="Autocar"/>
				 				<form:option value="Motocicleta"/>
				 				<form:option value="Microbuz"/>
				 				<form:option value="Tractor"/>
				 		 </form:select>
				<form:errors path="type" cssClass="error"/>
			</div>
			
			<div class="col-sm-4">
				<label for="exampleInputEmail1">Marca(*)</label>
				<form:input  class="form-control" path="brand"/>
				<form:errors path="brand" cssClass="error"/>
			</div>
			
			<div class="col-sm-4">
				<label for="exampleInputEmail1">Model(*)</label>
				<form:input class="form-control" path="model"/>
				<form:errors path="model" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Numar inmatriculare(*)</label>
				<form:input class="form-control" path="plate"/>
				<form:errors path="plate" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Serie sasiu(*)</label>
				<form:input class="form-control" path="identificationNumber"/>
				<form:errors path="identificationNumber" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Capacitate cilindrica(*)</label>
				<form:input class="form-control"  path="cilindricCapacity"/>
				<form:errors path="cilindricCapacity" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Culoare(*)</label>
				<form:input class="form-control" path="color"/>
				<form:errors path="color" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Combustibil(*)</label>
				<form:select class="form-control" path="fuel">
			 				<form:option value=""/>
			 				<form:option value="Benzina"/>
			 				<form:option value="Motorina"/>
			 				<form:option value="Electric"/>
		 		 		</form:select>
				<form:errors path="fuel" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Cai Putere(*)</label>
				 <form:input class="form-control" path="power"/>
				 <form:errors path="power" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Data Productie(*)</label>
				<form:input class="form-control" type="date" path="productionDate"/>
				<form:errors path="productionDate" cssClass="error"/>
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">Norma Poluare(*)</label>
				<form:select class="form-control" path="polutionNumber">
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
			</div>
			
			<div class="col-sm-4 padding-top15">
				<label for="exampleInputEmail1">CNP Proprietar(*)</label>
				<form:input class="form-control" path="uniqueNumberForPerson"/>
				<form:errors path="uniqueNumberForPerson" cssClass="error"/>
			</div>
			
			<div class="col-sm-12 padding-top15">
				<input type="submit" class="btn btn-success btn-xl" style="float:right" value="Inregistreaza"/>
			</div>
		</div>
		<div class="col-md-3"></div>
		
	</div>
		<br><br>
	</div>
		
		<form:hidden path="vehicleId"/>
		
	</form:form>
			
		</div>
	</div>
	</div>
</body>

</html>