
<%@ page language="java" import = "java.util.Collection, java.util.Iterator,model.ProductBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> listaProdotti = (Collection<?>) request.getAttribute("listaProdotti");
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Storage</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
</head>
<body >
	<%@ include  file ="Header.html" %>
	
<br>
<br>
<br>
<h2>Catalogo</h2>
<br>
<br>

<table id ="prodotti" border="4">
		<tr>
			<th>Foto prodotto</th>
			<th class="lista__prodotti">Nome Prodotto <a href="ProductControl?sort=nomeProdotto">Ordina</a></th>
			<th class="lista__prodotti">Prezzo <a href ="ProductControl?sort=prezzoProdotto">Ordina</a></th>
			<th>Cosa vuoi fare:</th>
		</tr>
		<%
			if (listaProdotti != null && listaProdotti.size() != 0) {
				Iterator<?> it = listaProdotti.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		<tr align = "CENTER">
			<td> <img alt="Foto prodotto" src="images/PhotoProdotti/<%=bean.getPathNameFotoP()%>" weight ="100" height ="100"></td>
			<td><%=bean.getNomeProdotto()%></td>
			<td><%=bean.getPrezzoProdotto()%> € </td>
			<td class = "lista__prodotti"><a href="CarrelloControl?id=<%=bean.getIdProdotto()%>&cod=<%=bean.getCodProdotto()%>&quantita=1&b1=si">Aggiungi al Carrello</a><br>
				<a href="DetailsControl?action=visualizza&id=<%=bean.getIdProdotto()%>&cod=<%=bean.getCodProdotto()%>&b1=si">Dettagli</a></td>
				
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="7">No products available</td>
		</tr>
		<%
			}
		%>
	</table>


<br>
<br>
<br>





<%@ include file = "Footer.html" %>
</body>
</html>
