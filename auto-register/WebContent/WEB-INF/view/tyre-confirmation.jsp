<%@
	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<title>Confirmare anvelopa noua</title>
</head>

<body>
	Succes! Ati adaugat o noua dimensiune pentru anvelopa: 
	
	<p>Succes! S-a adaugat o noua anvelopa: </p>
	<p>Dimensiune: |<b>${tyre.dimension}</b>| </p>
	
	<a href="${pageContext.request.contextPath}/tyre/list">Inapoi la lista de anvelope</a>
</body>

</html>