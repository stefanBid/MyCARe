<%@ page language="java" import="model.VoiceOrderBean,java.util.Collection,java.util.Iterator,model.UserBean,model.ProductBean,model.OrderBean,model.IvaBean,java.text.DecimalFormat , java.text.NumberFormat" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% Collection<?> voceProdotti = (Collection<?>) request.getAttribute("voceProdotti");%>
 <% Collection<?> ivaProdotti = (Collection<?>) request.getAttribute("ivaProdotti");%>
<%	UserBean user = (UserBean) request.getSession().getAttribute("utente"); %>
<% Collection<?> vociOrdini = (Collection<?>) request.getAttribute("vociOrdini");%>
<% OrderBean ordine = (OrderBean) request.getAttribute("ordine");%>
<%Double som =0.0; %>
 
<!DOCTYPE html>
<html>
<head>

<body>

<%@ include file="Header.html" %>
<br>
<br>
<br>



<h1> ORDINE: <%=request.getAttribute("codiceOrdine")%> ( <%=user.getNomeUser()%> <%=user.getCognomeUser()%>)</h1>
<br>
<br>
<br>
<table id="tabellaCarrello" border= "4" align="center">
		<tr align = "CENTER">
		<th colspan= "4"> Prodotti Acquistati </th>
		<th colspan = "4"> Riepilogo Acquisto</th>
		</tr>
		
		<% double prezzoTotale;
		 NumberFormat nf = new DecimalFormat("0.00");
		if (vociOrdini != null && vociOrdini.size() != 0 && voceProdotti != null && voceProdotti.size() != 0){	
			Iterator<?> it = vociOrdini.iterator();
				Iterator<?> it1 = voceProdotti.iterator();
				Iterator<?> it2 = ivaProdotti.iterator();
				while (it.hasNext() && it1.hasNext()) {
					VoiceOrderBean bean = (VoiceOrderBean) it.next();
					ProductBean bean1 = (ProductBean) it1.next();
					IvaBean bean2 = (IvaBean) it2.next();
					som =  som + bean.getPrezzoAcquisto();
					 prezzoTotale =  bean.getPrezzoAcquisto() * (1 + (bean2.getValore() / 100));
			
					
				       
		%>
			<tr align="center">
			<td><img src="images/PhotoProdotti/<%= bean1.getPathNameFotoP()%>" weight = "100" height = "100"></td>
			<td> <%= bean1.getIdProdotto() %></td>
			<td> <%= bean1.getNomeProdotto() %></td>
			<td> <%= bean1.getDescrizione() %></td>
			
			
			
			<td> <%= bean.getQuantita() %></td>
			<td> <%= bean.getPrezzoAcquisto() %> €</td>
			<td> <%= bean2.getValore() %></td>
			<td> <%= nf.format(prezzoTotale)%></td>
			</tr>
	<%} %>
		<%} %>
		
</table>
<h4>Totale Ordine: <%= nf.format(som) %> €</h4>
<div class="ipertesti"><a href ="FatturaControl?numeroFattura=<%=request.getAttribute("numeroFattura")%>&CodiceOrdine=<%=ordine.getCodiceOrdine()%>&UsernameOrdine=<%=ordine.getUsername()%>&DescrizioneOrdine=<%=ordine.getDescrizione()%>&DataOrdine=<%=ordine.getDataOrdine()%>">Visualizza fattura</a>
</div>	



</body>
</html>