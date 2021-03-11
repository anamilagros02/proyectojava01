<%@page import="com.senati.web.jsps.servlets.vo.VOLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Control de Usuarios</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link 
		rel="stylesheet"
		type="text/css" 
		href="../css/bootstrap.min.css">
	<script 
		src="../js/bootstrap.min.js">
	</script>
	<script>
		function guardar(){
			var forma = document.getElementById("formaUsuarios");
			forma.action = "../adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value="guardar";
			forma.submit();
		}
		function actualizar(){
			var forma = document.getElementById("formaUsuarios");
			forma.action = "../adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value="actualizar";
			forma.submit();
		}
		function eliminar() {
			var forma = document.getElementById("formaUsuarios");
			forma.action = "../adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value="eliminar";
			forma.submit();
		}
	</script>
</head>
<body>
	<!--  Contenedor -->
	<div class="container">
	<!--  fila -->
		<div class="row">
			<!--  Grupo 1 de columnas -->			
			<div class="col-md-2">
								
			</div>
			<!--  Grupo 2 de columnas -->
			<div class="col-md-8">
				<h1 class="text-center">Escuela de Tecnologias de la Información</h1>
				<h2 class="text-center">Panel principal</h2>
				<h3 class="text-center">Sistema</h3>
				<p class="text-center">		
					<%= ((VOLogin)session.getAttribute("usuarioLogueado")).getNombre() %>
				</p>
				<form action="" method="post" id="formaUsuarios">
					<input type="hidden" name="accion" id="accion">
					<div class="form-group">
						<label>Usuario</label>
						<input type="text" name="usuario" class="form-control">
						<label>Clave</label>
						<input type="password" name="clave" class="form-control">
						<label>Nombres</label>
						<input type="text" name="nombre" class="form-control">
						<label>Edad</label>
						<input type="text" name="edad" class="form-control">
					</div>
					<input type="button" value="Guardar" class="btn  btn-primary" onclick="guardar();">
					<input type="button" value="Actualizar" class="btn  btn-default" onclick="actualizar();">
					<input type="button" value="Eliminar" class="btn  btn-success" onclick="eliminar();">					
				</form>
				<!--  Crea una tabla -->
				<table class="table table-condensed">
					<tr>
						<!--  crea la cabecera de la tabla  -->
						<th>Usuario</th>
						<th>Nombre</th>
						<th>Edad</th>						
					</tr>
					
				</table>
			</div>
			<!--  Grupo 3 de columnas -->
			<div class="col-md-2">
								
			</div>
			
		</div>	
	</div>

</body>
</html>