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
	<h1>Effectuer une recherche</h1>
	<form action = "/rechercher_step2" method = "POST">
         <label for="mots_cles">Mots-clés: </label><input type = "text" id = "mots_cles" name = "mots_cles">
         <br />
         <label for="prix_min">Prix min</label><input type = "text" id = "prix_min" name = "prix_min" />
         <br />
         <label for="prix_max">Prix min</label><input type = "text" id = "prix_max" name = "prix_max" />
         <br />
         <label for="entre_le">Entre le</label><input type = "text" id = "entre_le" name = "entre_le" />
         <br />
         <label for="et_le">Entre le</label><input type = "text" id = "et_le" name = "et_le" />
         <br />
         <input type = "submit" value = "Rechercher !" />
  	</form>
</body>
</html>