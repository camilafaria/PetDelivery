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

	<c:import url="headerUsuario.jsp" />

	<c:import url="menuUsuario.jsp" />

	<!-- /. NAV SIDE  -->

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

				<c:if test="${empty resultadoBuscaPrestador}">
					Não há há prestadores que atendam seu filtro

				<br><br>
				<button name="back" onclick="history.back()" class="btn btn-primary">Efetuar
					nova busca</button>
				</c:if>

				<c:if test="${not empty resultadoBuscaPrestador}">
					<h3>Prestadores Autonomos</h3>
					<br>
					<br>
					<table border="0" align="center" width="800px">
						<tr align="center">
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
								<td><a href="visualiza-autonomo?id=${result.id}"><c:out
											value="${result.nome}" /></a></td>
								<td><c:out value="${result.condicoes}" /></td>
								<td>R$ <c:out value="${result.preco}" /></td>
								<td>${result.delivery eq 'true'? 'Sim' : 'Não'}</td>
								<td><c:out value="${result.servico}" /></td>
								<td><c:out value="${result.bairro}" /></td>
								<td><c:out value="${result.nota}" /></td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<br>

					<br>
					<br>
					<button name="back" onclick="history.back()"
						class="btn btn-primary">Efetuar nova busca</button>
				</c:if>
			</div>
		</div>
	</div>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->

	<script language="javascript">
		function confirmaCadastroPet() {
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