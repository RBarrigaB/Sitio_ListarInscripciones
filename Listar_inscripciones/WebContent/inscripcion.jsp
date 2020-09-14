<%@page import="com.edutecno.dto.CursoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int valorDescuento = 5;
	List<CursoDTO> cursos = (List<CursoDTO>)request.getAttribute("cursos");
%>
<form action="PostInscripcion" method="post">
	<h1>Formulario</h1><br>
	Nombre: <input type="text" name="nombre" id="name"><br>
	Apellido: <input type="text" name="apellido" id="apellido"><br>
	Cursos: <select name="idCurso">
				<%for(CursoDTO curso : cursos){ %>
				<option value="<%=curso.getIdCurso()%>">
					<%=curso.getDescripcion() %>
				</option>
				<%} %>
			</select><br>
			<input type="submit" value="enviar">
</form>
</body>
</html>