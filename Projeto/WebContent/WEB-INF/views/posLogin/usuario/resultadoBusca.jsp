<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.Raca_AnimalDAO"%>

<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

</head>

<body>

	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="home"><i class="fa fa-square-o "></i>&nbsp;Pet
						Delivery</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logout">Sair</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<c:import url="menuUsuario.jsp" />

	<!-- /. NAV SIDE  -->
	
	<c:forEach items="${sessionScope}" var="attr">
    ${attr.key}=${attr.value}<br>
	</c:forEach>
	
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
								<span aria-hidden="true" class="icon_profile"></span>
								<h1>Resultados</h1>
							</div>
						</div>
					</div>
				</div>
				
				<h3>Prestadores Autonomods</h3>
				<table border="0">
					<tr>
						<th>Nome</th>
						<th>Condicoes</th>
						<th>Preco</th>
						<th>Delivery</th>
						<th>Serviço</th>
						<th>Bairro</th>
						<th>Nota</th>
					</tr>
					
					<c:forEach items="${resultadoBuscaPrestador}" var="result">
						<tr>
					        <td><a href="visualiza-autonomo?id=${result.id}"><c:out value="${result.nome}"/></a></td>
					        <td><c:out value="${result.condicoes}"/></td>
					        <td><c:out value="${result.preco}"/></td>
					        <td><c:out value="${result.delivery}"/></td>
					        <td><c:out value="${result.servico}"/></td>
					        <td><c:out value="${result.bairro}"/></td>
					        <td><c:out value="${result.nota}"/></td>
					    </tr>
					</c:forEach>
				</table>
				
				<h3>Petshops</h3>
				
			</div>
		</div>
	</div>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->

	<script language="javascript">
	function confirmaCadastroPet(){
		  alert('Cadastro realizado com sucesso!');  
	}
	</script>
	
	<!-- JQUERY SCRIPTS -->
	<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assetsPosLogin/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assetsPosLogin/js/custom.js"></script>
</body>
</html>