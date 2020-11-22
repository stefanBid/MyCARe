<%@ page language="java" import="model.UserBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%UserBean utente = (UserBean) request.getSession().getAttribute("utente"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%if(utente.isEmpty()){ %>
		<h1>CHI SEI?</h1>
	
	<%}%>
		
	<%if(!utente.isEmpty() && utente.getRuoloUser().equals("Amministratore")){ %>
		<h1>Sei un admin</h1>
	<%} %>
	
	<%if(!utente.isEmpty() && utente.getRuoloUser().equals("Guest")){ %>
		<h1>E sopratutto non sei un Guest</h1>
	<%}%>

</body>
</html>