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
		<jsp:param name="foto" value="${usuarioLogado.foto}"/>
	</jsp:include>
	
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	<jsp:useBean id="daoTipoAnimal"
		class="br.com.petdelivery.jdbc.dao.Tipo_AnimalDAO" />
	<jsp:useBean id="daoRacaAnimal"
		class="br.com.petdelivery.jdbc.dao.Raca_AnimalDAO" />	

	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 page-title wow fadeIn">
								<span aria-hidden="true" class="fa fa-paw"></span>
								<h1>Meu Pet</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="confirmaEdicaoPet" class="form-horizontal" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<div class="container"  style="vertical-align: middle;" align="center">
							<div class="col-sm-6 col-sm-offset-2 contact-form wow">
								<div class="form-group">
									
									<input hidden type="text" name="id_animal" value="${animalSelecionado.id_animal}">
									
									<label for="contact-name">Nome</label><input type="text"
										name="nome" class="contact-name form-control" value="${animalSelecionado.nome}">
								</div>

								<div class="form-group">
									<label for="contact-name">Tipo de PET</label> 
									<select name="id_tipo" id="id_tipo">																			
										<option selected value="${daoRacaAnimal.getTipoByRaca(animalSelecionado.id_raca)}"> ${daoTipoAnimal.getTipoById(daoRacaAnimal.getTipoByRaca(animalSelecionado.id_raca))} </option>
									
										<c:forEach var="tipo" items="${daoTipoAnimal.getTiposAnimal()}">
											<c:if test="${tipo.id_tipo ne daoRacaAnimal.getTipoByRaca(animalSelecionado.id_raca)}">
												<option value="${tipo.id_tipo}"> ${tipo.nome} </option>
											</c:if>										
										</c:forEach>													
									</select>
								</div>		

								<div class="form-group">
									<label for="contact-name">Raça</label> <select name="id_raca"
										id="id_raca">
										<option>Selecione uma Raça</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Gênero</label> <br> 
									<c:if test="${animalSelecionado.genero eq 'm'}">
										<input type="radio" name="genero" value="m" checked> Macho <br>
										<input type="radio" name="genero" value="f"> Fêmea <br>
									</c:if>
									
									<c:if test="${animalSelecionado.genero eq 'f'}">
										<input type="radio" name="genero" value="m"> Macho <br>
										<input type="radio" name="genero" value="f" checked> Fêmea <br>
									</c:if>
								</div>

								<div class="form-group">
									<label for="contact-name">Pedigree</label> <br> 									
									<c:if test="${animalSelecionado.pedigree eq true}">
										<input type="radio" name="pedigree" value="true" checked> Sim <br>
										<input type="radio" name="pedigree" value="false"> Não
									</c:if>
									
									<c:if test="${animalSelecionado.pedigree eq false}">
										<input type="radio" name="pedigree" value="true"> Sim <br>
										<input type="radio" name="pedigree" value="false" checked> Não
									</c:if>
									<br>
								</div>

								<div class="form-group">
									<label for="contact-name">Porte</label> 
									<select name="porte">
									
									<c:if test="${animalSelecionado.porte eq 'Pequeno'}">										
										<option selected value="Pequeno">Pequeno</option>
										<option value="Médio">Médio</option>
										<option value="Grande">Grande</option>
									</c:if>
									
									<c:if test="${animalSelecionado.porte eq 'Médio'}">										
										<option value="Pequeno">Pequeno</option>
										<option selected value="Médio">Médio</option>
										<option value="Grande">Grande</option>
									</c:if>
									
									<c:if test="${animalSelecionado.porte eq 'Grande'}">										
										<option value="Pequeno">Pequeno</option>
										<option value="Médio">Médio</option>
										<option selected value="Grande">Grande</option>
									</c:if>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Como é o comportamento do seu pet?</label> 
									<input type="text" name="comportamento" value="${animalSelecionado.comportamento}"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Vacinas</label>
									<input type="text"
										name="vacinas"
										value="${animalSelecionado.vacinas}"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="img">Selecione sua foto</label> <input type="file"
										name="file" class="contact-email form-control" accept=".png" />
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn">Atualizar</button>
							</div>
						</div>
					</div>
				</form>

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