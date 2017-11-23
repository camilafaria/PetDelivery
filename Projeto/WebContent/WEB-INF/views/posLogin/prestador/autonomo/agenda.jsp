<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.AnimalDAO,
        br.com.petdelivery.jdbc.modelo.Animal"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">
<title>Pet Delivery</title>

<!-- BOOTSTRAP STYLES-->
<link href="assetsPosLogin/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assetsPosLogin/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assetsPosLogin/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css" />
<!-- FULL CALENDAR -->
<link rel='stylesheet' href='assetsPosLogin/css/fullcalendar.min.css'
	rel='stylesheet' />
<link rel='stylesheet'
	href='assetsPosLogin/css/fullcalendar.print.min.css' rel='stylesheet'
	media='print' />

<c:import url="../../favicon.jsp" />

</head>
<body>
	<c:import url="headerAutonomo.jsp" />
	<c:import url="menuAutonomo.jsp" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="col-md-12">

					<div class="page-title-container">
						<div class=" title col-md-12 page-title wow fadeIn">
							<span aria-hidden="true" class="fa fa-heart"></span>
							<h1 align="center">Agenda</h1>
						</div>
					</div>

					<div id="calendar"></div>

				</div>
			</div>
		</div>
	</div>


	<c:import url="footer.jsp" />

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assetsPosLogin/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assetsPosLogin/js/custom.js"></script>
	<!-- FULL CALENDAR -->
	<script src='assetsPosLogin/js/jqueryCalendar.min.js'></script>
	<script src='assetsPosLogin/js/momentCalendar.min.js'></script>
	<script src='assetsPosLogin/js/fullcalendar.min.js'></script>

	<script>

		$(document).ready(function() {			
			$('#calendar').fullCalendar({
				header: {
							left: 'prev,next today',
							center: 'title',
							right: 'month,agendaWeek,agendaDay,listWeek'
						},
				defaultDate: '2017-11-12',
				navLinks: true, // can click day/week names to navigate views
				editable: true,
				eventLimit: true, // allow "more" link when too many events
				events: {
					url: 'populaAgenda.json'	
				},
				eventClick: function(event) {
			        if (event.url) {
			            window.open(event.url, 'STATUS=no, TOP=10, LEFT=10, WIDTH=770, HEIGHT=400');
			            return false;       
			        }
			    }
			});		
		});
	</script>

</body>
</html>