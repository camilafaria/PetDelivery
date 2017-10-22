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
	
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	

	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
								<span aria-hidden="true" class="icon_profile"></span>
								<h1>Cadastrar PET</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="inserePet" class="form-horizontal" method="post">
					<div class="form-group">
						<div class="container"  style="vertical-align: middle; margin-left:20%;" align="center">
							<div class="col-sm-7 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Nome</label><input type="text"
										name="nome" placeholder="Digite o nome do seu pet"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Tipo de PET</label> 
									<select name="id_tipo" id="id_tipo">
																			
										<option selected disabled value="">Selecione um animal</option>
									
										<c:forEach var="animal"
											items="${daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
											<option value="${animal.id_animal}" }> ${animal.nome} </option>										
										</c:forEach>
													
									</select>
								</div>		

								<div class="form-group">
									<label for="contact-name">Raça</label> <select name="id_raca"
										id="id_raca">
										<option selected disabled value="">Selecione...</option>
										<option value="24">Afghan Hound</option>
										<option value="19">Beagle</option>
										<option value="21">American Pitbull</option>
										<option value="18">Bull Terrier</option>
										<option value="17">Bulldog</option> 
										<option value="16">Chihuahua</option>
										<option value="15">Dobermann</option>
										<option value="14">Golden Retriever</option>
										<option value="12">Labrador</option>
										<option value="11">Poodle</option>
										<option value="10">Rottweiler</option>
										<option value="9">Vira-Lata</option>
										<option value="8">Yorkshire Terrier</option>
										<option value="7">Outra</option>
								    </select>
								</div>

								<div class="form-group">
									<label for="contact-name">Gênero</label> <br> <input
										type="radio" name="genero" value="m"> Macho <br>
									<input type="radio" name="genero" value="f"> Fêmea <br>
								</div>

								<div class="form-group">
									<label for="contact-name">Pedigree</label> <br> <input
										type="radio" name="pedigree" value="true"> Sim <br>
									<input type="radio" name="pedigree" value="false"> Não
									<br>
								</div>

								<div class="form-group">
									<label for="contact-name">Porte</label> <select name="porte">
										<option value="">Selecione...</option>
										<option value="Pequeno">Pequeno</option>
										<option value="Médio">Médio</option>
										<option value="Grande">Grande</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Como é o comportamento do seu pet?</label> 
									<!-- <select
										name="comportamento">
										<option value="">Selecione...</option>
										<option value="Agitado">Agitado</option>
										<option value="Agressivo">Agressivo</option>
										<option value="Calmo">Calmo</option>
										<option value="Dócil">Dócil</option>
										<option value="Extrovertido">Extrovertido</option>
									</select>
									 -->
									<input type="text"
										name="comportamento"
										placeholder="Descreva seu PET é dócil, agressivo, agitado..."
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Vacinas</label>
									<input type="text"
										name="vacinas"
										placeholder="Descreva detalhes sobre as vacinas de seu PET"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="img">Selecione sua foto</label> <input type="file"
										name="foto" class="img form-control"
										accept="image/png, image/jpeg" multiple />
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn" onclick="confirmaCadastroPet()">Registrar</button>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>



	<c:import url="footer.jsp" />

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