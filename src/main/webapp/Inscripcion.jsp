<%@page import="java.util.ArrayList"%>
<%@page import="cl.talentodigital.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  css bootstrap 5 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Inscripcion</title>
</head>
<%
ArrayList<CursoDTO> cursos = (ArrayList<CursoDTO>) request.getAttribute("cursosAtt");
ArrayList<FormaDePagoDTO> formasDePago = (ArrayList<FormaDePagoDTO>) request.getAttribute("formasDePagoAtt");
%>

<br>
<body>
	<!-- barra con menu -->
	<nav class="navbar navbar-expand-lg navbar-light  bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Mantenedor Cursos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="preListarInscripciones">Listado
							de cursos</a></li>
					<li class="nav-item"><a class="nav-link" href="preInscripcion">Inscribir
							en curso</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- formulario de inscripcion -->
	<div class="container">
		<form action="postInscripcion" method="get">
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre:</label> 
				<input type="text" class="form-control" id="nombre" name="nombre">
			</div>
			<div class="mb-3">
				<label for="telefono" class="form-label">Telefono:</label> 
				<input type="text" class="form-control" id="telefono" name="telefono">
			</div>
			<label for="idCurso">Cursos:</label> 
			<select name="idCurso" class="form-select">
				<%
				for (CursoDTO dto : cursos) {
				%>
				<option value="<%=dto.getIdCurso()%>">
					<%=dto.getDescripcion()%>
				</option>
				<%
				}
				%>
			</select> <br> 
			<label for="idFormaPago">Formas de Pago:</label>
			 <select name="idFormaPago" class="form-select">
				<%
				for (FormaDePagoDTO dto : formasDePago) {
				%>
				<option value="<%=dto.getIdFormaDePago()%>">
					<%=dto.getDescripcion()%>
				</option>
				<%
				}
				%>
			</select>

			<button type="submit" class="btn btn-success mt-3">Enviar</button>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>