<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      
      
      function drawChart() {
    	  var x = Number(document.getElementById("1").value);
    	  var y = Number(document.getElementById("2").value);
    	  var z = Number(document.getElementById("3").value);
          var data = google.visualization.arrayToDataTable([
            ['Vechime', 'Ani'],
            ['Mai vechi de 10 ani',     x],
            ['Intre 5 si 10 ani',      y],
            ['Pana in 5 ani',  z]
          ]);

          var options = {
            title: 'Vehiculele pe vechime'
          };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  	<div id="wrapper">
		<div id="header">
			<h2>Statistici</h2>
		</div>
	</div>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
    
	<div id="contrainer">
		<div id="content">
			
	<form:form action="sendMail" modelAttribute="statistics">
	
		 Email(*): <form:input path="email"/>
		<form:errors path="email" cssClass="error"/>
		<br><br>
		<input type="submit" value="Send"/>
		<form:hidden path="totalNumberOfVehicles"/>
		<form:errors path="totalNumberOfVehicles" cssClass="error"/>
		<br><br>
		
	    <form:hidden id="1" path="numberOfVehiclesOlderThan10"/>
		<form:errors path="numberOfVehiclesOlderThan10" cssClass="error"/>
		<br><br>
		
		<form:hidden id="2" path="numberOfVehiclesOlderBetween5and10"/>
		<form:errors path="numberOfVehiclesOlderBetween5and10" cssClass="error"/>
		<br><br>
		
		<form:hidden id="3" path="numberOfNewVehicles"/>
		<form:errors path="numberOfNewVehicles" cssClass="error"/>
		<br><br>
				
	</form:form>
			
		</div>
		<a href="${pageContext.request.contextPath}">Meniu principal</a>
	</div>
    
  </body>
</html>
