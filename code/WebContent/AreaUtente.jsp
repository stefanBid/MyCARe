<%@ page language="java" import=" model.UserBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    UserBean utente= (UserBean) request.getSession().getAttribute("utente"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area Utente</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
</head>
<body >
<% if(utente.getRuoloUser().equals("Amministratore")){ %>
<%@ include file="HeaderAdmin.html" %>
<%}else{ %>
<%@ include file="Header.html" %>
<%} %>
<section class="cover_AreaUtente">
<div class="contenitore_Utente">

		<% if(utente.getRuoloUser().equals("Amministratore")){%>

<h1 align="center"> Amministratore</h1>

 <%}else{%>

<h1 align="center"> Area Utente</h1>

<%} %>
		<form action="PhotoControl" enctype="multipart/form-data" method="post">
		<input type="file" name="foto">Modifica Immagine profilo
		<input type ="submit" value ="invia">
		</form>
	
	<form action="LogoutControl" method="GET"> 
		
		
	
		
	<!-- Qui dobbiamo mettere l'immagine presa dal DB -->	
	<p>Nome della foto <%=utente.getPathNameFotoP()%></p>
	<h3><img src="images/PhotoUser/<%=utente.getPathNameFotoP()%>" class="avatar" alt="avatar"></h3>
		<h3>Nome:        </h3><%=utente.getNomeUser()%>  
		<h3>Cognome:     </h3><%=utente.getCognomeUser()%>  
		<h3>Email:       </h3><%=utente.getEmailUser()%> 
		<h3>Username:    </h3><%=utente.getUsernameUser()%>
		<h4> <a href="OrdineControl"> Visualizza i tuoi ordini</a></h4>
		<h4> <a href="estremi.html"> Aggiungi Metodo di Pagamento</a></h4>
		<input type="submit"  value="LOGOUT">
		<br>
		<br>
	
	
		
		
		
	</form>

	</div>

	</section>
<%@ include file = "Footer.html" %>	



</body>
	
</html>