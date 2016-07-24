<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Registrar Libro

	<form method="post"
		action="http://localhost:8080/CrudRestWeb1/rest/crudLibroRest/registrarLibro">

		<label for="name" >Autor <input id ="name" type="text" name="txtAutor"></label>
		
		 <label >Titulo<input type="text" name="txtTitulo"></label>
		 <label >stock <input type="text" name="txtStock"></label>
		<input type="submit" name="enviar" value="registrar">

	</form>
</body>
</html>