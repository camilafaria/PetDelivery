<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.AnimalDAO,
        br.com.petdelivery.jdbc.modelo.Animal"%>
        
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
<c:import url="../../favicon.jsp" />
</head>
<body>
 	<c:import url="headerPetshop.jsp" />
 	<jsp:include page="menuPetshop.jsp">
        <jsp:param name="foto" value="${prestadorPetshopLogado.logotipo}"/>
    </jsp:include>

	<jsp:useBean id="daoUnidade"
		class="br.com.petdelivery.jdbc.dao.Unidade_PetshopDAO" />
	
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

					<div class="page-title-container container row title col-md-12 col-sm-offset-2 page-title wow fadeIn">
						<span aria-hidden="true" class="fa fa-home"></span>
						<h1 align="center">Minhas unidades</h1>
					</div>
					
					<c:if test="${empty daoUnidade.getUnidadesByCNPJ(prestadorPetshopLogado.cnpj)}">								
						<h4 class="com-md-12 col-sm-offset-1"><br><br><br>Parece que você não tem unidades cadastradas ainda. Que tal cadastrar?</h4>
					</c:if>
					
					<c:if test="${not empty daoUnidade.getUnidadesByCNPJ(prestadorPetshopLogado.cnpj)}">					
						<br><br><br><br> <br><br><br>
						<table border="0" align="center" width="400px">
							<tr align="center" class="table-header">
								<th>Nome</th>
								<th>Rua</th>
								<th>Número</th>
								<th>Bairro</th>
							</tr>					
						
							<c:forEach var="unidade"
								items="${daoUnidade.getUnidadesByCNPJ(prestadorPetshopLogado.cnpj)}">
								<tr class="table-line">
									<td>${unidade.nome}</td>
									<td>${unidade.rua}</td>
									<td>${unidade.numero}</td>
									<td>${unidade.bairro}</td>
								</tr>
							</c:forEach>			
						
						</table>
					</c:if>				
					
					<br><br>
					<form action="cadastraUnidade">
						<button type="submit" class="btn">Cadastrar Unidade</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<c:import url="footer.jsp"/>
	
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