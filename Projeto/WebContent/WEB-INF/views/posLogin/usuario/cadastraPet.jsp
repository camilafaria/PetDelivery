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

<c:import url="../favicon.jsp" />

<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assetsPosLogin/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assetsPosLogin/js/custom.js"></script>

 <script>
$(document).ready(function() {

$('#id_tipo').change(function(event) {
        var sports = $("select#id_tipo").val();
        $.get('JsonServlet', {
                id_tipo : sports
        }, function(response) {

        var select = $('#id_raca');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value.id_raca).text(value.nome).appendTo(select);
      });
        });
        });
});
</script>
	
</head>

<body>
	
	<c:import url="headerUsuario.jsp" />

	<jsp:include page="menuUsuario.jsp">
		<jsp:param name="foto" value="${usuarioLogado.foto}" />
	</jsp:include>

	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	<jsp:useBean id="daoTipo_Animal"
		class="br.com.petdelivery.jdbc.dao.Tipo_AnimalDAO" />

	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 page-title wow fadeIn">
								<span aria-hidden="true" class="fa fa-paw"></span>
								<h1>Cadastrar PET</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="inserePet" method="post" enctype="multipart/form-data"
					class="form-horizontal">
					<div class="form-group">
						<div class="container" style="vertical-align: middle;"
							align="center">
							<div class="col-sm-6 col-sm-offset-2 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Nome</label><input type="text"
										name="nome" placeholder="Digite o nome do seu pet"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Tipo de PET</label> <select
										name="id_tipo" id="id_tipo">

										<option selected disabled value="">Selecione um
											animal</option>

										<c:forEach var="tipo"
											items="${daoTipo_Animal.getTiposAnimal()}">
											<option value="${tipo.id_tipo}">${tipo.nome}</option>
										</c:forEach>

									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Ra�a</label> <select name="id_raca"
										id="id_raca">
										<option>Selecione uma Ra�a</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">G�nero</label> <br> <input
										type="radio" name="genero" value="m"> Macho <br>
									<input type="radio" name="genero" value="f"> F�mea <br>
								</div>

								<div class="form-group">
									<label for="contact-name">Pedigree</label> <br> <input
										type="radio" name="pedigree" value="true"> Sim <br>
									<input type="radio" name="pedigree" value="false"> N�o
									<br>
								</div>

								<div class="form-group">
									<label for="contact-name">Porte</label> <select name="porte">
										<option value="">Selecione...</option>
										<option value="Pequeno">Pequeno</option>
										<option value="M�dio">M�dio</option>
										<option value="Grande">Grande</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Como � o comportamento do seu
										pet?</label>
									<!-- <select
										name="comportamento">
										<option value="">Selecione...</option>
										<option value="Agitado">Agitado</option>
										<option value="Agressivo">Agressivo</option>
										<option value="Calmo">Calmo</option>
										<option value="D�cil">D�cil</option>
										<option value="Extrovertido">Extrovertido</option>
									</select>
									 -->
									<input type="text" name="comportamento"
										placeholder="Descreva seu PET � d�cil, agressivo, agitado..."
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Vacinas</label> <input type="text"
										name="vacinas"
										placeholder="Descreva detalhes sobre as vacinas de seu PET"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="img">Selecione sua foto</label> <input type="file"
										name="file" class="contact-email form-control" accept=".png" />
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn">Registrar</button>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>



	<c:import url="footer.jsp" />

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