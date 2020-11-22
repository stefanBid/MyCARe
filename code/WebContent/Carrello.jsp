<%@ page language="java" import="java.util.Iterator,java.util.Collection,java.util.ArrayList,model.ProductBean,model.Carrello,model.UserBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% Carrello cart = (Carrello) request.getAttribute("carrello");%>
    <%
    UserBean utente= (UserBean) request.getSession().getAttribute("utente"); 
    %>
    
 
    
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Carrello</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
</head>
<body >
 <%@ include file="Header.html" %>
 <br>
 <br>
 <br>

 
 
	<% if(cart.getCarrello().size()<1){ %>
		
		<div class = "carrello clearfix">
		<h1 >Il Carrello è vuoto</h1>
		<div class="carrello_item">
		<a href = "ProductControl"><img src ="images/compra.png"></a></div>

		</div>
		
	<% }else{ %>
	
	<table id="tabellaCarrello" border= "4" align="center">
		<tr align="center">
			<th>Foto prodotto</th>
			<th>Nome Prodotto</th>
			<th>Quantita da acquistare</th>	
			<th>Elimina Prodotto</th>
		</tr>
		<tr align="center">
		<%int i=0; %>
		<% for(ProductBean bean : cart.getCarrello()){ %>
			<tr align="center">
			<%System.out.println(bean.getPathNameFotoP()); %>
			<td> <img alt="Foto prodotto" src="images/PhotoProdotti/<%=bean.getPathNameFotoP()%>" weight ="100" height ="100"></td>
			<td><%=bean.getNomeProdotto()%></td>
			<td><%=cart.getQuantita().get(i)%></td>
			<td class="lista__prodotti"><a href="CarrelloDelete?id=<%=bean.getIdProdotto()%>&cod=<%=bean.getCodProdotto()%>">Elimina</a></td>
			</tr>
		<%i++; 
		
		} 
		}%>	
		
	</table>
	<br>
	<br>
	<%System.out.println(cart.getCarrello().size()); %>
	
 <% if((cart.getCarrello().size()>0) && (utente.getUsernameUser()==null)){ %>
		<form action="UserControl" method ="get" class ="voce_menu">
	 <div class="bottoni_vari" align="center">
	<input type="submit" value ="PROCEDI ALL'ACQUISTO">
	</div>
	</form>
	<%}%>
 <br><br>
 <% if(cart.getCarrello().size()>0 && utente.getUsernameUser()!=null){ %>
	<form action="RiepilogoOrdineControl" method ="get" class ="voce_menu">	
	 <div class="bottoni_vari" align="center">
	<input type="submit" value ="PROCEDI ALL'ACQUISTO">
	</div>
	</form>
<%} %>	
	

	

</body>
</html>