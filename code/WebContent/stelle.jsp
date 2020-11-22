<!DOCTYPE html>
<html>
<head>
<!DOCTYPE html>
<html lang="en"><head>
<meta charset="utf-8">
<link rel="stylesheet" href="CSS/commento.css">
<title>Commento</title>
<%@ page language="java" import = "java.util.Collection, java.util.Iterator,model.ProductBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
	
%>
</head>
<body >
    
    <form action="RecensioniControl" method="get">
        <div id="form">
        <h1>Compila il form sottostante per lasciare una recensione</h1>
        <%=prodotto.getNomeProdotto() %>
        <label for="messaggio">Recensione</label>
        <textarea name="recensione" id="messaggio" cols="30" rows="10"></textarea>
        

<input type="hidden" name = "idProdotto" value= "<%=prodotto.getIdProdotto()%>">
<input type="hidden" name = "codProdotto" value= "<%=prodotto.getCodProdotto()%>">

        <input type="submit" id="submit" name="submit" value="Invia" />
        </div>
        </form>


</body>
</html>


</body>
</html>