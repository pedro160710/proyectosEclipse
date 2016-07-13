<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="subirArchivo.jsp" enctype="multipart/mixed stream" method="post">
		<tr>
			<td><input type="file" name="campoArchivo" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="hidden" name="subir" value="upload" /> <input
				type="submit" value="agregar" /></td>
		</tr>


	</form>
</body>
</html>