<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

	<c:import url="headerAutonomo.jsp" />	
	<jsp:include page="menuAutonomo.jsp">
        <jsp:param name="foto" value="${prestadorAutonomoLogado.foto}"/>
    </jsp:include>
	
	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	<jsp:useBean id="daoServicoAutonomo"
		class="br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO" />
	<jsp:useBean id="daoPrestador"
		class="br.com.petdelivery.jdbc.dao.PrestadorDAO" />
	<jsp:useBean id="daoAvaliacao"
		class="br.com.petdelivery.jdbc.dao.AvaliacaoDAO" />
	<jsp:useBean id="daoComentario"
		class="br.com.petdelivery.jdbc.dao.ComentarioDAO" />
	<jsp:useBean id="daoUsuario"
		class="br.com.petdelivery.jdbc.dao.UsuarioDAO" />		

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="title col-sm-12 wow fadeIn" >
					<span aria-hidden="true"></span>
					<h1  ><c:out value="${perfilPrestadorAutonomo.nome}"/></h1>
					<br>
					<br>
					<br>
					<h5 style="vertical-align: middle; margin-left: 24%;"><c:out value="${perfilPrestadorAutonomo.experiencia}"/></h5>
					<h5 style="vertical-align: middle; margin-left: 24%;"><b>M�dia de avalia��es: </b> 
						<c:out value="${perfilPrestador_nota}"/>
					</h5>
				</div>
<br><br><br><br><img src="/ESI2017/getImage?foto=${perfilPrestadorAutonomo.foto}" class="img-responsive img-circle col-sm-3 col-sm-offset-1" />
				
				<div class="form-group col-sm-7">					
					<div class="form-group col-sm-12">
						<label for="contact-name" class="table-header">Localiza��o: </label> <br>
						<c:out value="${perfilPrestadorAutonomo.rua}"/>, 
						<c:out value="${perfilPrestadorAutonomo.numero}"/> 
						<c:out value="${perfilPrestadorAutonomo.complemento}"/><br>
						<c:out value="${perfilPrestadorAutonomo.bairro}"/>
					</div>
					
					<div class="form-group col-sm-12">
						<label for="contact-name" class="table-header"><b>Servi�os oferecidos: </b></label>
						<table border="0" align="center" width="500px">
							<tr align="center" style="text-align:center;">
								<th></th>
								<th style="text-align:center;"><b>Pre�o</b></th>
								<th style="text-align:center;"><b>Condi��es</b></th>
								<th style="text-align:center;"><b>Delivery</b></th>
								<th></th>
							</tr>
							<c:forEach var="servico"
								items="${daoServicoAutonomo.getServico(perfilPrestadorAutonomo.cpf)}">
								<tr class="table-line">
									<td><b>${daoServico.getServicoById(servico.id_servico)}</b></td>
									<td>R$ ${servico.preco}</td>
									<td>${servico.condicoes}</td>
									<td>${servico.delivery eq 'true'? 'Sim' : 'N�o'}</td>									
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<br><br><br><br><br>
					<div class="form-group col-sm-12">
						<label for="contact-email">Coment�rios dos petlovers sobre voc�:</label>
						<c:forEach var="comment" items="${daoComentario.getComentsByIdPrestador(perfilPrestadorAutonomo.cpf)}">
						<tr class="table-line">
								<td>
									<img src="/ESI2017/getImage?foto=${daoUsuario.getFotoById(comment.cpf)}" class="img-responsive img-circle" width="50px" height="50px" />
								</td>
								<td>${daoUsuario.getNameById(comment.cpf)}</td>
								<td><br><br>${comment.comentario}</td>							
							</tr>
						</c:forEach>							
						
					</div>										
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