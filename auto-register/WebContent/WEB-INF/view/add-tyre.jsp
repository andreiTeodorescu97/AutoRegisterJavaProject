<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<title>Adauga anvelope</title>
	<style>
		.error{color:red}
	</style>
</head>

<body>
<div class="container-fluid">
	<div align="center" id="wrapper">
		<div id="header">
			<h2>Inregistreaza o anvelopa noua</h2>
		</div>
	</div>
	<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}">Meniu principal</a>
	<div id="contrainer">
		<div id="content">
			
	<form:form action="addTyre" modelAttribute="tyre">
	<br>
	<br>
	<hr>
	

	<div class="form-group">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			
			
			<div class="col-sm-6">
				<label for="exampleInputEmail1"> Dimensiune/Denumire(*)</label>
				<form:input placeholder="introduceti dimensiunea" path="dimension"/>
			</div>	
			<div class="col-sm-6">
				<br>
				<input type="submit" class="btn btn-success btn-xl" style="float:right" value="Inregistreaza"/>
			</div>
			
		</div>
		<div class="col-md-3"></div>
		
	</div>
		<br><br>
	</div>
		
		<form:hidden path="id"/>
		
	</form:form>
			
		</div>
	</div>
	</div>

</body>

</html>