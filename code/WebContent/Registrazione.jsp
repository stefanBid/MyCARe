<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrati</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
<style>
</style>
</head>
<body>

<%@ include file="Header.html" %>
<section class="cover__registrazione">
<br>
<br>
<br>
<div class="pre_contenitore_r">
			<h1 style="font-size:3vw">Registrazione</h1>
		</div>
		<div class="contenitore_r">
		
			<form action="RegistrationControl" method="post"  name= "invio" onsubmit= "return validazioneRegistrazione()">
				<p class="pa">Inserisci i tuoi dati</p>
					<p>
						<label>Username</label><br>
							<input type="text" name="username" class="username" id="user" placeholder="Username" onfocusout="controlUsername()">
							<small id="euser" style="display:none">Errore</small>
					</p>
					<p>
						<label>Password</label><br>
							<input type="Password" name="password" class="password" id="pass" placeholder="Password">
							<small id="epass" style="display:none">Errore</small>
					</p>
						
						
					<p>
						<label>Nome</label><br>
							<input type="text" name="Nome" class="nome" id="nom" placeholder="Nome" >
							<small id="enom" style="display:none">Errore</small>
					</p>
						
						
					<p>
						<label>Cognome</label><br>
							<input type="text" name="Cognome" class="cognome" id="cog" placeholder="Cognome">
							<small id="ecog" style="display:none">Errore</small>
					</p>
						
						
				<p>
						<label>email</label><br>
							<input type="text" name="email" class="email" id="mail" placeholder="email" onfocusout="controlEmail()">
							<small id="ermail" style="display:none">Errore</small>
					</p>
						
						
					<p>
						<label>Data di nascita</label><br>
							<input type="date" name="data" class="data" id="dat">
							<small id="edata" style="display:none">Errore</small>
					</p>
					
							
					<p>
						<label>Indirizzo</label><br>
							<input type="text" name="indirizzo" class="indirizzo" id="ind" placeholder="indirizzo">
							<small id="eind" style="display:none">Errore</small>
					</p>
					
							
					<p>
						<label>Codice Friscale</label><br>
							<input type="text" name="codice" class="codf" id="codf" placeholder="Codice Fiscale">
							<small id="ecod" style="display:none">Errore</small>
					</p>
					
					
						<input type="submit" name="btn" value="Registrati">
						
									
			</form>
		</div>
		<br>
		<br>
</section>

<%@ include file="Footer.html" %>

<script src="JS/ValidazioneRegistrazione.js"></script>	
<script src="JS/AsyncronousLoginCheck.js"></script>		
			


</body>
</html>
