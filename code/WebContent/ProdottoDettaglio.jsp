<%@ page language="java" import="model.ProductBean" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ProductBean prodotto = (ProductBean) request.getAttribute("prodotto"); 
    %>
<!DOCTYPE html>
<html>
<head>

 

<script>

 

 var val = 0;

 

 function cambiaOpacita(){

 

 var immagine = document.getElementById("im");

 

 immagine.style.opacity = val/100;

 

 immagine.style.filter = 'alpha(opacity = ' + val + ')';       

 

 }

 

 function aumentaOpacita()

 

{

 

 val += 2;  

 

 cambiaOpacita();

 

 if(val<100)

 

{  

 

 setTimeout("aumentaOpacita();", 50);

 

 } 

 

 }

 

</script>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js' type='text/javascript'></script>

 

<script src='https://sites.google.com/site/cercasoluzione3/pagina-di-caricamento-pro/ingrandimento-immagini_cs3.js' type='text/javascript'>

 

</script>

 

<script type='text/javascript'>

 

//<![CDATA[

 

jQuery(document).ready(function($){

 

 $('#im').addimagezoom({
  zoomrange: [5, 5],
  magnifiersize: [600,600],
  magnifierpos: 'right',
  cursorshade: true,
  cursorshadecolor: 'pink',
  cursorshadeopacity: 0.3,
  cursorshadeborder: '1px solid red',
  
 })

 

 

})
 
//]]>

 

</script>

 

</head>
<body>

    <%@ include file="Header.html" %>
    
    <div align="center">
    <div id="titolo">
    <h1 align ="center">Prodotto in dettaglio</h1>
    
    <br>
    <br>
    <br>
    

 

    <h1><%=prodotto.getNomeProdotto()%></h1>
    </div>
    <br>
    
    <div id="foto"> <img id="im" style="width:100%; max-width:400px" src="images/PhotoProdotti/<%=prodotto.getPathNameFotoP()%> " alt="Foto prodotto" onLoad="aumentaOpacita();"> 
    </div>
    
    
        <div id="info"><h3>Codice:        </h3><%=prodotto.getCodProdotto()%>  
        <h3>Categoria:     </h3><%=prodotto.getCategoria()%>  
        <h3>Descrizione:   </h3><%=prodotto.getDescrizione()%> 
        <h3>Prezzo:        </h3><%=prodotto.getPrezzoProdotto()%> €  (IVA esclusa)
        </div>
    
    <br>
    <br>
    
    <% if(prodotto.getQuantitaMagazzino()>0){%>
        <h2>Disponibilità Immediata</h2>
        <form action = "CarrelloControl" method = "GET">
        <div class="bottoni_vari">
            <input type = "number" name ="quantita" min="1" max = "<%= prodotto.getQuantitaMagazzino()%>">
            <input type="hidden" name = "id" value= <%=prodotto.getIdProdotto() %>> 
            <input type="hidden" name = "cod" value= <%=prodotto.getCodProdotto() %>> 
            
            <input type = "submit" class = "bottoni_vari"  value ="Aggiungi al Carrello">
            </div>
        </form>
        
    <%}else{%>
        <h2>Prodotto momentaneamente non disponibile</h2>
        <%} %>
<div class="ipertesti">

 
<br>
<br>
<a  href ="ProductReview?idPro=<%=prodotto.getIdProdotto() %>&codPro=<%=prodotto.getCodProdotto() %>">Lascia una recensione</a>

 

<br>

 

<br>

 

 

<a  href ="ReviewView?idPro=<%=prodotto.getIdProdotto()%>&codPro=<%=prodotto.getCodProdotto()%>">Guarda le recensioni</a>

 

</div>
<br>

 

<%@ include file = "Footer.html" %>
    
<script src="JS/zoom.js"></script>
</div>
</body>
</html>