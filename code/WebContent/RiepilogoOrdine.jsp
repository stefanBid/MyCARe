<%@ page language="java" import="java.util.Iterator,java.util.Collection,java.util.ArrayList,model.ProductBean,model.Carrello,model.UserBean,model.EstremiBean ,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% Carrello cart = (Carrello) request.getSession().getAttribute("carrello");%>
    <%
    UserBean utente= (UserBean) request.getSession().getAttribute("utente"); 
    %>
    
    <%Collection<?> listaCarte = (Collection<?>) request.getAttribute("listaCarte"); %>
    <% String totale = (String) request.getSession().getAttribute("totale"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Riepilogo Ordine</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
</head>
<body>
	<%@ include file="Header.html" %>
	

	<h1 align="center">Riepilogo Ordine</h1>
	<table id="tabellaCarrello" border= "4" align="center">
		<tr align="center">
			<th>Foto prodotto</th>
			<th>Codice</th>
			<th>Nome Prodotto</th>
			<th>Quantita da acquistare</th>	
		</tr>
		<tr align="center">
		<%int i=0; %>
		<% for(ProductBean bean : cart.getCarrello()){ %>
			<tr align="center">
			<td> <img alt="Foto prodotto" src="images/PhotoProdotti/<%=bean.getPathNameFotoP()%>" weight ="100" height ="100"></td>
			<td><%=bean.getCodProdotto()%></td>
			<td><%=bean.getNomeProdotto()%></td>
			<td><%=cart.getQuantita().get(i)%></td>
			</tr>
		<%i++; 
		
		} 
		%>	
		
</table>

<div class="menu__paga">
	<form method="post" action="CarrelloPaga">
	<%if (listaCarte != null && listaCarte.size() != 0) {%>	
		<h1>Seleziona Metodo di pagamento</h1>
		<br>
				<% Iterator<?> it = listaCarte.iterator();
				while (it.hasNext()) {
					EstremiBean carta = (EstremiBean) it.next();%>
				   <input type="radio" name="carta" value="<%=carta.getCodiceCarta()%>"> <%=carta.getIntestatario() %> (<%= carta.getCodiceCarta()%>)
					<br>
				<%} %>
				<h1>Totale: <%= totale %> €</h1>
				<br>
				<br>
				 <div class="bottoni_vari" align="center">
				<input type="submit" class=".carrello__bar" value ="ACQUISTA">	
				</div>
		<%} else{%>
		
			<h1><a href="estremi.html">Aggiungi una Carta per completare l'acquisto</a></h1>
		<%}%>	
	</form>
	</div>
</body>
</html>