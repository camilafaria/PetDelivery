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
<c:import url="../../favicon.jsp" />
</head>
<body>
	<c:import url="headerPetshop.jsp" />
	<jsp:include page="menuPetshop.jsp">
        <jsp:param name="foto" value="${prestadorPetshopLogado.logotipo}"/>
    </jsp:include>	
	<jsp:useBean id="daoPrestador"
		class="br.com.petdelivery.jdbc.dao.PrestadorDAO" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
			
				<div class="page-title-container title col-sm-12 col-sm-offset-1 page-title wow fadeIn">
					<span aria-hidden="true" class="fa fa-gear"></span>
					<h1>Configura��es da conta</h1>
				</div>

				<!-- form action="alteraUsuario" class="form-horizontal"-->
				<form action="update-petshop" class="form-horizontal" method="post"
					enctype="multipart/form-data">
					<div class="form-group" style="vertical-align: middle;"
						align="center">
						<div class="container col-sm-10" style="vertical-align: middle;"
							align="center">
							<div class="contact-form col-sm-6 wow fadeInLeft col-md-offset-4"
								style="vertical-align: middle; " align="center">
								<!-- 1 -->
								<div class="form-group col-sm-12">
									<label for="contact-name">Nome</label> <input
										type="text" name="nome" value="${prestadorPetshopLogado.nome}"
										class="contact-name form-control">
								</div>
								<!-- 2 -->
								<div class="form-group col-sm-12">
									<label for="contact-name">CNPJ</label> <input type="number"
										name="cnpj" value="${prestadorPetshopLogado.cnpj}"
										class="contact-name form-control" readonly>
								</div>
								<div class="form-group col-sm-12">
									<label for="contact-email">Descri��o</label>
									<textarea name="descricao" cols="30" rows="10"
										class="contact-email form-control" id="experiencia"
										value="${prestadorPetshopLogado.descricao}"></textarea>
								</div>
								
								<div class="form-group col-sm-12">
									<label for="contact-name">E-mail</label> <input type="text"
										name="email" value="${daoPrestador.getEmailById (prestadorPetshopLogado.cnpj)}"
										class="contact-name form-control">
								</div>
								
								<div class="form-group col-sm-12">
									<label for="contact-name">Senha</label> <input type="password"
										name="senha" value="${daoPrestador.getSenhaById (prestadorPetshopLogado.cnpj)}"
										class="contact-name form-control">
								</div>
								
								<div class="form-group col-sm-11">
									<label for="contact-email">Foto (at� 16 MB)</label> <input
										type="file" name="file" class="contact-email form-control" accept=".png" />
								</div>
								
								<div class="form-group col-sm-12">
								<button type="submit" class="btn">Atualizar</button>
								</div>
							</div>
						</div>
					</div>
				</form>		
				
				<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
				<!-- JQUERY SCRIPTS -->
				<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
				<!-- BOOTSTRAP SCRIPTS -->
				<script src="assetsPosLogin/js/bootstrap.min.js"></script>
				<!-- METISMENU SCRIPTS -->
				<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
				<!-- CUSTOM SCRIPTS -->
				<script src="assetsPosLogin/js/custom.js"></script>
			</div>
		</div>

	</div>
	
			<c:import url="footer.jsp" />
</body>
</html>