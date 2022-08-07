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

<title>Listar Inscripciones</title>
</head>
<%
ArrayList<InscripcionDTO> inscripciones = (ArrayList<InscripcionDTO>) request.getAttribute("inscripcionesAtt");
%>

<br>
<body>
	<!-- barra con menu -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
					<li class="nav-item"><a class="nav-link"
						href="preListarInscripciones">Listado de cursos</a></li>
					<li class="nav-item"><a class="nav-link" href="preInscripcion">Inscribir en curso</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- formulario de inscripcion -->
	<div class="container">

		<p>Listado de inscripciones</p>
		<table class="table table-warning table-striped">
			<thead>
				<tr>
					<th>Id Inscripcion</th>
					<th>Nombre</th>
					<th>Telefono</th>
					<th>Id Curso</th>
					<th>Id Forma de Pago</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (InscripcionDTO dto : inscripciones) {
				%>
				<tr>
					<td><%=dto.getIdInsc()%></td>
					<td><%=dto.getNombre()%></td>
					<td><%=dto.getCelular()%></td>
					<td><%=dto.getIdCurso()%></td>
					<td><%=dto.getIdFormaDePago()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>