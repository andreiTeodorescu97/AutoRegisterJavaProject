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
	Succes! Sunteti programat: |${appointmentXperson.firstName}| |${appointmentXperson.lastName}| pe date de: |${appointmentXperson.date}| la ora |${appointmentXperson.time}|
	
	<a href="${pageContext.request.contextPath}/appointment/list">Inapoi la programari</a>
	<a href="${pageContext.request.contextPath}">Meniu principal</a>
</body>

</html>