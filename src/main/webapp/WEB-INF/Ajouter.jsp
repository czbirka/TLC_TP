<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Menu.jsp"%>
	<h1>Ajouter une annonce</h1>
	<form action = "/Ajouter_step2" method = "POST">
         Titre: <input type = "text" name = "titre">
         <br />
         Prix: <input type = "text" name = "prix" />
         <br />
         Date <input type = "text" name = "date" />
         <input type = "submit" value = "Submit" />
      </form>
</body>
</html>