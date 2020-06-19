<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>Logs</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Anvelope</h2>
		</div>
	</div>
	
	<div id="contrainer">
		<div id="content">
			
			<table>
				<tr>
					<th>Id</th>
					<th>Dimensiune</th>
				</tr>
				
				<c:forEach var="tempVariable" items="${tyresForTheJsp}">
					<tr>
					<td> ${tempVariable.id} </td>
					<td> ${tempVariable.dimension} </td>
					</tr>
				</c:forEach>
				
			</table>
			<a href="${pageContext.request.contextPath}">Meniu principal</a>
		</div>
	</div>
</body>

</html>