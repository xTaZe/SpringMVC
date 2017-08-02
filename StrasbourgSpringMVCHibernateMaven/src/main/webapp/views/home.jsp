<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1
		style="background-color: #e74c3c; color: #34495e; text-align: center;">
		${name}</h1>

	<h1
		style="background-color: #bdc3c7; color: #34495e; font-size: 16pt; text-align: center;">
		${salutation}</h1>


	<table align="center" cellspacing="10">

		<tr style="color: blue; font-style: italic; font-size: 14pt">

			<td align="right" bgcolor="#3498db"><a href="listemployes"><button>Liste des employes</button></a></td>
		</tr>
	</table>
</body>
</html>