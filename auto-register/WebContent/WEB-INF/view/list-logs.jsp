<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>Logs</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Loguri</h2>
		</div>
	</div>
	
	<div id="contrainer">
		<div id="content">
			
			<table>
				<tr>
					<th>Tip</th>
					<th>Mesaj</th>
					<th>Data</th>
				</tr>
				
				<c:forEach var="tempVariable" items="${logsForTheJsp}">
					<tr>
					<td> ${tempVariable.type} </td>
					<td> ${tempVariable.message} </td>
					<td> ${tempVariable.dateMod} </td>
					</tr>
				</c:forEach>
				
			</table>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>