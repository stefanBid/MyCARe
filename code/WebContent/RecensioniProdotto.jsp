
<%@ page language="java" import = "java.util.Collection, java.util.Iterator,model.ProductBean,model.RecensioniBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> listaRecensioni = (Collection<?>) request.getAttribute("listaRecensioni");
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
<h2>Catalogo</h2><h2></h2>
<br>
<br>





<table id ="prodotti" border="8" align="Center">
<h2 align="center"><%=prodotto.getNomeProdotto()%></h2>
		<tr>
		<br>	
		</tr>
		<%
			if (listaRecensioni != null && listaRecensioni.size() != 0) {
				Iterator<?> it = listaRecensioni.iterator();
				while (it.hasNext()) {
					RecensioniBean review = (RecensioniBean) it.next();
		%>
		
	
		<tr align = "CENTER">
			<td><%=review.getFeedback()%></td>
			<td><%=review.getUser() %></td>
			
			
				
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











 
 
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</script>
 <p id="Test"></p>
</body>
</html>
