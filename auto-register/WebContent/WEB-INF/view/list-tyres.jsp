<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style>
.pull-right{
	float:right;
	margin-left:10px!important;
}
</style>
<title>Logs</title>
</head>

<body>
<div class="container">
	<div align="center" id="wrapper">
		<div id="header">
			<h2>Anvelope inregistrate</h2>
		</div>
	</div>
	<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}">Meniu principal</a>
	<a class="btn btn-primary pull-right" href="showFormForAddingTyre">Adauga anvelopa</a>
	<br><br>
	<br><br>
	<div id="contrainer">
	<div class="col-md-3"></div>
		<div id="content" class="col-md-6">
			
			<table class="table table-striped table-bordered table-hover table-responsive-md">
				<thead class="thead-dark">
					<tr>
						<th>Id</th>
						<th>Dimensiune</th>
					</tr>
				</thead>
				<tbody class="table-striped">
					<c:forEach var="tempVariable" items="${tyresForTheJsp}">
					<tr>
					<td> ${tempVariable.id} </td>
					<td> ${tempVariable.dimension} </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
</div>
</body>

</html>