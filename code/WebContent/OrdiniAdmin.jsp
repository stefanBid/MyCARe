<%@ page language="java" import="model.OrderBean,model.VoiceOrderBean,java.util.*,java.util.Date,model.UserBean,control.DateControl,java.io.IOException,java.text.*,control.VoceOrdineControl" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");%>
  <% Collection<?> costoOrdini = (Collection<?>) request.getAttribute("costoOrdini");%>
 <% Collection<?> utenti = (Collection<?>) request.getAttribute("utenti");%>
<%	UserBean user = (UserBean) request.getSession().getAttribute("utente"); %>
 
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
<title>I tuoi ordini</title>

<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
	<script src='jquery.zoom.js'></script>
	<script>
		$(document).ready(function(){
			$('#ex1').zoom();
			$('#ex2').zoom({ on:'grab' });
			$('#ex3').zoom({ on:'click' });			 
			$('#ex4').zoom({ on:'toggle' });
		});
	</script>
</head>
<body style="background-color:orange;">



<%
if(user.getRuoloUser().equals("Guest")){%>
<%@ include file="Header.html" %>
<%}else {%>
<%@ include file="HeaderAdmin.html"%>
<%} %>


<br>
<br>
<br>

<h1>Amministratore :  <%=user.getNomeUser()%> <%=user.getCognomeUser()%> <%=user.getIndirizzoUser()%></h1>
<br>
<form action="DateControl" method="get"><h3>Ricerca per data</h3>
Da 
<input type="date" name="data_inizio">
a
<input type="date" name="data_fine">

<select name = "search_utente">

<%UserBean bean1 = null; 
if (utenti != null && utenti.size() != 0) {
				Iterator<?> it1 = utenti.iterator();
				while (it1.hasNext()) {
					bean1 = (UserBean) it1.next();%>
				<option value="<%=bean1.getUsernameUser()%>"><%= bean1.getUsernameUser()%></option>

<%}			} %>
</select>
<input type="submit" name="btn" value="Invia">
</form>
<% if(ordini.size() == 0 || ordini == null){ %>
	<h1 align ="CENTER">Nessun Utente Selezionato</h1>
<%}else{ %>


<br>




<table id="tabellaCarrello" border= "4" align="center">

<h3 align="left"> Tabella di: <%=bean1.getNomeUser()%> <%= bean1.getCognomeUser()%> </h3>	
		<tr align="center">
		
			<th>Codice Ordine</th>
			<th>Descrizione</th>
			<th>Data Ordine</th>
			<th>Dettagli</th>
			<th>Prezzo totale ordine</th>
		
		</tr>
		<%
		Date InizioDataSessione = (Date)request.getSession().getAttribute("dataInizio");
		Date   FineDataSessione = (Date)request.getSession().getAttribute("dataFine");
		
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				Iterator<?> it1 = costoOrdini.iterator();
				while (it.hasNext() && it.hasNext()) {
					OrderBean bean = (OrderBean) it.next();
					Double prezzo = (Double) it1.next();
					String temp = bean.getDataOrdine();
					
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date data = null;
						try {
							data = sdf.parse(temp);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					if((InizioDataSessione==null || FineDataSessione==null) || (data.compareTo(InizioDataSessione)>= 0 && data.compareTo(FineDataSessione)<= 0)){
		%>
		
			<tr align="center">
			
			<td><%=bean.getCodiceOrdine()%></td>
			<td><%=bean.getDescrizione()%></td>
			<td><%=bean.getDataOrdine()%></td>
			<td><a href="VoceOrdineControl?codOrdine=<%= bean.getCodiceOrdine()%>&usern= <%= bean.getUsername()%>&descrizione= <%= bean.getDescrizione()%>&data= <%=bean.getDataOrdine()%>">Dettagli Ordine</a></td>
			<td><%=prezzo%></td>
			</tr>
		
	<%}		} %>
		<%} %>
</table>
<%} %>



</body>
</html>


	
	