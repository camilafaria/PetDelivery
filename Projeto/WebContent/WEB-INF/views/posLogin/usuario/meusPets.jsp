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
	
<c:import url="../favicon.jsp" />
</head>
<body>
	<c:import url="headerUsuario.jsp" />

	<jsp:include page="menuUsuario.jsp">
	<jsp:param name="foto" value="${usuarioLogado.foto}"/>
</jsp:include>

	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	<jsp:useBean id="daoRaca"
		class="br.com.petdelivery.jdbc.dao.Raca_AnimalDAO" />
	<jsp:useBean id="daoTipo"
		class="br.com.petdelivery.jdbc.dao.Tipo_AnimalDAO" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container title col-md-12 page-title wow fadeIn">
					<span aria-hidden="true" class="fa fa-paw"></span>
					<h1 align="center">Meus PETs </h1>
				</div>
				
				<div class="col-md-12">
				
					<c:if test="${empty daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
						<h4>Parece que você ainda não cadastrou seu pet :( <br> Que tal cadastrá-lo?</h4>
					</c:if>
				
					<c:if test="${not empty daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
					<br>
						<table border="0" align="center" width="500px">
							<tr align="center" class="table-header">
								<th></th>
								<th><b>Nome</b></th>
								<th><b>Tipo</b></th>
								<th><b>Raça</b></th>
								<th><b></b></th>
							</tr>					
						
							<c:forEach var="animal" items="${daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
								<tr class="table-line">
									<td>
										<img src="assetsPosLogin/img/find-user.png" class="img-responsive img-circle" width="50px" height="50px" />
									</td>
									<td href="">${animal.nome}</td>
									<td>${daoTipo.getTipoById(daoRaca.getTipoByRaca(animal.id_raca))}</td>
									<td>${daoRaca.getRacaById(animal.id_raca)}</td>
									<td><a href="editaPet?id=${animal.id_animal}">Detalhes</a></td>
								</tr>
							</c:forEach>			
						
						</table>
					</c:if>

				
					<br> <br>
					<form action="cadastro-pet">
						<button type="submit" class="btn">Cadastrar PET</button>
					</form>
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
</body>
</html>