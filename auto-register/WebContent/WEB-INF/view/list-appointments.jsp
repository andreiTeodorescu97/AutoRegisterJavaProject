<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>Appointments List</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Programari</h2>
		</div>
	</div>
	
	<div id="contrainer">
		<div id="content">
		
			<input type="button" value="Programeaza-te!" onclick="window.location.href='showFormForAdd'; return false;"></input>
			
			<table>
				<tr>
					<th>Data</th>
					<th>Ora</th>
				</tr>
				
				<c:forEach var="tempVariable" items="${appointmentsForTheJsp}">
					<tr>
					<td> ${tempVariable.date} </td>
					<td> ${tempVariable.time} </td>
					</tr>
				</c:forEach>
				
			</table>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>