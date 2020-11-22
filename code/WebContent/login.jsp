<%@ page language="java"  import="model.UserBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src = "JS/loginValidate.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login form</title>
<link rel= "icon" href= "images/icon.png" type ="image/png" />
<style>
</style>
</head>
<body>

<%@ include file="Header.html" %>
<section class="cover__login">
<br>
<br>
<br>
<div class="pre_contenitore">
			<p>Login</p>
		</div>
		<div class="contenitore">
			<form action="LoginControl" method="post">
				<p class="par">Inserisci le tue credenziali</p>
					<p>
						<label>Username</label><br>
							<input type="text" name="username" class="username" id ="UsernameLogin" placeholder="Username" >
							<small id = "userEr"style="display:none;">Errore</small>
					</p>
					<p>
						<label>Password</label><br>
							<input type="Password" name="password" class="password" id ="PasswordLogin" placeholder="Password" >
							<small  id = "passEr" style="display:none;">Errore</small>
					</p>
					
					<p style="color:red"><i><%=request.getAttribute("errorMessage")%></i></p>

					
					
						<input type="submit" name="btn" value="Accedi" >
			</form>
			
			<p class="par">Non sei ancora registrato<br> ( <a href="Registrazione.jsp">Registrati qui</a> )</p>
			
		</div>
		<br>
		<br>
</section>

<%@ include file="Footer.html" %>	
			
	</body>

</html>
