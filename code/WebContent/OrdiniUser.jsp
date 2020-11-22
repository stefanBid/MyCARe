<%@ page language="java" import="model.OrderBean,model.VoiceOrderBean,java.util.Collection,java.util.Iterator,model.UserBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");%>
<%	UserBean user = (UserBean) request.getSession().getAttribute("utente"); %>
<%int numero = 0; %>
 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>I tuoi ordini</title>
</head>
<body>


<%@ include file="Header.html" %> 
<br>
<br>
<br>

<% if(ordini.size() == 0 || ordini == null){ %>
	<h1 align ="CENTER">Nessun Ordine Effettuato</h1>
<%}else{ %>

<h1>Lista Ordini ( <%=user.getNomeUser()%> <%=user.getCognomeUser()%>)</h1>
<br>
<br>
<br>
<table id="tabellaCarrello" border= "4" align="center">
		<tr align="center">
		<th style="Display : none">
			<th>Codice Ordine</th>
			<th>Descrizione</th>
			<th>Data Ordine</th>
			<th>Dettagli</th>
		
		</tr>
		<%
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				while (it.hasNext()) {
					OrderBean bean = (OrderBean) it.next();
					numero++;
		%>
			<tr align="center">
			
		<td style="Display : none"><%=numero %></td>
			<td><%=bean.getCodiceOrdine()%></td>
		
			<td><%=bean.getDescrizione()%></td>
			<td><%=bean.getDataOrdine()%></td>
			
			<td class="lista__prodotti"><a target ="_blank" href="VoceOrdineControl?numeroFattura=<%=numero%>&codOrdine=<%= bean.getCodiceOrdine()%>&usern= <%= bean.getUsername()%>&descrizione= <%= bean.getDescrizione()%>&data= <%=bean.getDataOrdine()%>">Dettagli Ordine</a></td>
			</tr>
		
	<%} %>
		<%} %>
</table>
<%} %>
	



</body>
</html>