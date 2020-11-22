<%@ page language="java" import="java.text.DecimalFormat , java.text.NumberFormat,model.IvaBean,model.VoiceOrderBean,model.OrderBean,java.util.Collection,java.util.Iterator,model.UserBean,model.ProductBean, javax.swing.JOptionPane" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% Collection<?> voceProdotti = (Collection<?>) request.getAttribute("voceProdotti");%>
 <% Collection<?> ivaProdotti = (Collection<?>) request.getAttribute("ivaProdotti");%>
<%	UserBean user = (UserBean) request.getSession().getAttribute("utente"); %>
<% Collection<?> vociOrdini = (Collection<?>) request.getAttribute("vociOrdini");%>
<%Double som =0.0; %>
<% %>
  <%
    UserBean utente= (UserBean) request.getSession().getAttribute("utente"); 
  OrderBean Ordine = (OrderBean) request.getAttribute("Ordine"); 
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
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <link rel="stylesheet" href="CSS/fattura.css">
    
   <title>Fattura</title>
</head>
<body >
<div style="Display : none"><%@ include file="Header.html" %></div>
<br><br>
<center><h1>Fattura Fiscale</h1></center>

<ul> 

<p>    
    <div id="container">
        <div class="split2">
           <div>
              <h1>Intestatario</h1>
        <h3>Nome:<%=utente.getNomeUser()%> </h3>
		<h3>Cognome:<%=utente.getCognomeUser()%> </h3>
		<h3>Email:<%=utente.getEmailUser()%></h3>
		<h3>C.F. :<%=utente.getCodFiscaleUser()%></h3>
		<h3>Indirizzo di Spedizione :<%=utente.getIndirizzoUser()%></h3>
              
           </div>
           <div>
              <h1>My CARe</h1>
              <p>P.iva:01546784320</p>
           </div>
       <br>
       <br>
         <br>
       <br>
         <br>
       <br>
         <br>
       <br>
</p><p>
</p><center><table border="" cols="2" width="90%">

<div><br><font size="+2">Dettagli Fattura</font></div>
        <tbody><tr>
            <td>Numero Fattura: <%=request.getAttribute("numeroFattura")%></td>
            
       </tr>

       <tr>
           <td>Data Contabile:  <%= Ordine.getDataOrdine() %></td>
               
                    
                
      </tr>
      </tbody></table>
</center>

<p>
<br>
<br>
<br>

	
<br>
<br>
<br>
<table id="tabellaCarrello" border= "4" align="center">
		<tr align = "CENTER">
		<th colspan= "2"> Prodotti Acquistati </th>
		<th> Descrizione</th>
		<th>Quantita Acquista</th>
		
		<th> Prezzo</th>
		<th>Iva</th> 
		
		<th>Prezzo Totale</th>
		</tr>
		
				<%
				NumberFormat nf = new DecimalFormat("0.00");
				if (vociOrdini != null && vociOrdini.size() != 0 && voceProdotti != null && voceProdotti.size() != 0){	
			Iterator<?> it = vociOrdini.iterator();
				Iterator<?> it1 = voceProdotti.iterator();
				Iterator<?> it2 = ivaProdotti.iterator();
				while (it.hasNext() && it1.hasNext()) {
					VoiceOrderBean bean = (VoiceOrderBean) it.next();
					ProductBean bean1 = (ProductBean) it1.next();
					IvaBean bean2 = (IvaBean) it2.next();
					som = som   + (bean.getPrezzoAcquisto() * (1 + (bean2.getValore() / 100)));
		%>
			<tr align="center">
		 <!--Per vedere L'iimagine del prodotto in fattura togliere il commento-->	
		<!-- <td><img src="<%= bean1.getPathNameFotoP()%>" weight = "100" height = "100"></td> -->
			
			
			<td> <%= bean1.getIdProdotto() %></td>
			<td> <%= bean1.getNomeProdotto() %></td>
			
			
			<td> <%= bean1.getDescrizione() %></td>
			<td> <%= bean.getQuantita() %></td>
			<td> <%= bean.getPrezzoAcquisto() %> €</td>
			<td> <%= bean2.getValore() %></td>
			<td> <%= nf.format(bean.getPrezzoAcquisto() * (1 + (bean2.getValore() / 100)))%> €</td>
		
		
			</tr>
	<%} %>
		<%} %>
		 
		
</table>
<h4>Totale Ordine: <%= nf.format(som) %> €</h4>

<button onclick="window.print()"class="buttStamp">Stampa Fattura PDF</button>	



</body>

</html>
</center>




