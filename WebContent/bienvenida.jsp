<%@page import="com.senati.web.jsps.servlets.vo.VOLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de control</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link 
	rel="stylesheet"
	type="text/css" 
	href="css/bootstrap.min.css">
<script 
	src="js/bootstrap.min.js">
</script>
</head>
<body>
	<div class="container">
		<div class="row">			
			<div class="col-md-2">
								
			</div>
			<div class="col-md-8">
				<h1 class="text-center">Escuela de Tecnologias de la Información</h1>
				<h2 class="text-center">Panel principal</h2>
				<h3 class="text-center">Sistema</h3>
				<p class="text-center">		
					<%= ((VOLogin)session.getAttribute("usuarioLogueado")).getNombre() %>
				</p>
				<br>
				<a href="usuarios/usuarios.jsp">Administración de Usuarios</a>
			</div>
			<div class="col-md-2">
								
			</div>
			
		</div>	
	</div>

</body>
</html>