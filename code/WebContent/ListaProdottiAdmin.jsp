
<%@ page language="java" import = "java.util.Collection, java.util.Iterator,model.ProductBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> listaProdotti = (Collection<?>) request.getAttribute("listaProdotti");
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}
 
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #f2f2f2;
  whidth:auto;
}
 
tr:hover {background-color:#ffaf06;}
</style>
<meta charset="UTF-8">
<title>Storage ADMIN</title>
</head>
<body >
	<%@ include  file ="HeaderAdmin.html" %>
	
<br>
<br>
<br>
<h2>Catalogo (VISTA ADMIN)</h2>
<br>
<br>
<table id ="prodotti" class="tabella" border="4">

		<tr>
			<th>ID <a href="ProductControlAdmin?sort=idProdotto">Ordina</a></th>
			<th>Foto prodotto</th>
			<th>Codice <a href="ProductControlAdmin?sort=codProdotto">Ordina</a></th>
			<th>Nome Prodotto <a href="ProductControlAdmin?sort=nomeProdotto">Ordina</a></th>
			<th>Descrizione</th>
			<th>Categoria <a href ="ProductControlAdmin?sort=categoria">Ordina</a></th>
			<th>Prezzo <a href ="ProductControlAdmin?sort=prezzoProdotto">Ordina</a></th>
			<th>Cosa vuoi fare:</th>
		</tr>
		<%
			if (listaProdotti != null && listaProdotti.size() != 0) {
				Iterator<?> it = listaProdotti.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		<tr align = "CENTER">
			<td><%=bean.getIdProdotto()%></td>
			<td> <img alt="Foto prodotto" src="images/PhotoProdotti/<%=bean.getPathNameFotoP()%>" weight ="100" height ="100"></td>
			<td><%=bean.getCodProdotto()%></td>
			<td><%=bean.getNomeProdotto()%></td>
			<td><%=bean.getDescrizione()%></td>
			<td><%=bean.getCategoria()%></td>
			<td><%=bean.getPrezzoProdotto()%> € </td>
			<td><a href="DeleteControl?id=<%=bean.getIdProdotto()%>&cod=<%=bean.getCodProdotto()%>">Elimina</a></td>
				
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
<br>
<br>
<br>
<div class="pre_contenitore_prodotto">
	<p>Aggiungi un nuovo prodotto</p>
</div>
	<div class="contenitore_prodotto">
	<div class="spaceL"></div>
	<div class="spaceR">
		<img src="images/new.png" height="300" widht="300">
	</div>
<form action="ProductControlAdmin" method ="POST" enctype="multipart/form-data" onsubmit="return validazioneProdotto()" >
			
	
		
			<input type="file" name="foto" >Modifica Immagine 
			<input type="hidden" name = "action" value= "aggiungi">
			
			<p>
			<label>ID</label><br>
			<input type = "text" name  ="idProdotto" placeholder="ID del prodotto" id="idp">
			<small id="iderr" style="display:none">Errore</small>
			</p>
			
			<p>
			<label>CodProdotto</label><br>
			<input type = "text" name  ="codProdotto" placeholder="Codice del Prodotto" id="codp">
			<small id="coderr" style="display:none">Errore</small>
			</p>
			
			
			<p>
			<label>Stato IVA</label><br>
			<select name = "stato" id="iva">
				<option value="Italia">ITA</option>
				<option value="Cina">CHI</option>
				<option value="Germania">GER</option>
				<option value="Francia">FRA</option>
			</select>
			<small id="ivaerr" style="display:none">Errore</small>
			</p>
			
			<p>
			<label>Nome</label><br>
			<input type = "text" name  ="nomeProdotto" placeholder="Nome del Prodotto" id="nomp">
			<small id="nomPerr" style="display:none">Errore</small>
			</p>
			
			<p>
			<label>Descrizione</label><br>
			<input type = "textarea" name="descrizione" placeholder="Breve descrizione del Prodotto" id="desc">
			<small id="descerr" style="display:none">Errore</small>
			</p>
			
			<p>
			<label>Prezzo</label><br>
			<input type="text" name="prezzoProdotto" placeholder="Prezzo del prodotto €" id="prezzo">
			<small id="prezerr" style="display:none">Errore</small>
            </p>
            
            <p>
            <label>Categoria</label><br>	
			<select name = "categoria" id="cat">
				<option value="Cura e Pulizia">Cura e Pulizia</option>
				<option value="Elettronica per Auto">Elettronica per Auto</option>
				<option value="Interni ed Esterni">Interni ed Esterni</option>
		
			</select>
			<small id="caterr" style="display:none">Errore</small>
			<p>
			
			<p>
			<label>Quantita</label><br>
			<input type = "text" name="quantitaMagazzino" placeholder="Quantità presente in magazzino" id="quant">	
			</p>
			<small id="quanterr" style="display:none">Errore</small>
			<br>
			<input type="submit" value ="AGGIUNGI NUOVO PRODOTTO">	
		</form>
		
	
	
		
	
	</div>
	<div class="down"></div>
	<br>
	<br>

<%@ include file = "Footer.html" %>

<script src = "JS/ValidazioneProdotto.js"></script>
</body>
</html>
