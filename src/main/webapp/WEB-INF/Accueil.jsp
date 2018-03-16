<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
	<%@ include file="Menu.jsp"%>
	<p>Bienvenue sur le site ADVERTISEMENT BOARD !</p>

<p>
	<!-- <% out.print("azerty "+request.getRequestURI()); %> -->
	</p>
	
	<%
		String userName = request.getParameter("userName");
		if (userName == null) {
			userName = "default";
		}
		pageContext.setAttribute("userName", userName);
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		if (user != null) {
			pageContext.setAttribute("user", user);
	%>
	

	<p>

		Hello, ${fn:escapeXml(user.nickname)}! (You can <a
			
			
			href="<%=userService.createLogoutURL(request.getRequestURI().replace("WEB-INF/", ""))%>">sign
			out</a>.)
	</p>
	<%
		} else {
	%>
	<p>
		Hello! <a
			href="<%=userService.createLoginURL(request.getRequestURI().replace("WEB-INF/", ""))%>">Sign
			in</a> to include your name with greetings you post.
	</p>
	<%
		}
	%>
</body>
</html>