<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>Home</title>
<!-- <link rel="stylesheet" href="../css/all.css" type="text/css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" />
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Registrul Auto Roman</h2>
		</div>
	</div>
	
	<div id="contrainer">
	
		<div class="navbar">
			<a href="appointment/list">Programari</a>
			<div class="dropdown">
    			<button class="dropbtn">Vehicule 
      				<i class="fa fa-caret-down"></i>
    			</button>
    			<div class="dropdown-content">
      				<a href="vehicle/showFormForAddingVehicle">Adauga</a>
      				<a href="vehicle/list">Lista</a>
    			</div>
  			</div> 
  			<div class="dropdown">
    			<button class="dropbtn">Anvelope 
      				<i class="fa fa-caret-down"></i>
    			</button>
    			<div class="dropdown-content">
      				<a href="tyre/showFormForAddingTyre">Adauga</a>
      				<a href="tyre/list">Lista</a>
    			</div>
  			</div> 
			<a href="statistics/showEmailForm">Statistici</a>
  			<a href="log/list">Loguri</a>
		</div>
		
	</div>
</body>

</html>