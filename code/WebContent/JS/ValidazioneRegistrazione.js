//Validazione Registrazione

function validazioneRegistrazione(){
	
	//Variabili che contengono gli input del form
	
	var user = document.getElementById("user").value;
	var pass = document.getElementById("pass").value;
	var nom = document.getElementById("nom").value;
	var cog = document.getElementById("cog").value;
	var ind = document.getElementById("ind").value;
	var mail = document.getElementById("mail").value;
	var cod = document.getElementById("codf").value;
	var dat = document.getElementById("dat").value;
	
	
	
	
	//Espressioni Regolari
	
	function regularUser(campo){
		var user_reg_exp = /^[0-9a-zA-Z]+$/;
		return user_reg_exp.test(campo)
	}
	
	function regularPassword(campo){
		var pass_reg_exp = /^[0-9a-zA-Z]+$/;
		return pass_reg_exp.test(campo);
	}
	
	function regularNomeCognome(campo){
		var nomCog_reg_exp = /^[A-Za-z]+$/;
		return nomCog_reg_exp.test(campo);
	}
	
	function regularIndirizzo(campo){
		var ind_reg_exp =/^[0-9a-zA-Z]+$/;
		return ind_reg_exp.test(campo);
	}
	
	function regularMail(campo){
		var mail_reg_exp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		return mail_reg_exp.test(campo);
	}
	
	function regularCodiceFiscale(campo){
		var cod_reg_exp = /[a-z]{6}\d{2}[abcdehlmprst]\d{2}[a-z]\d{3}[a-z]/i;
		return cod_reg_exp.test(campo);
	}
	
	
	
	

	
	
	
	//Settiamo tutti gli small con display: none in modo tale da avere l'effetto dinamico quzndo risolviamo il problema
	document.getElementById("euser").style.display="none";
	document.getElementById("epass").style.display="none";
	document.getElementById("enom").style.display="none";
	document.getElementById("ecog").style.display="none";
	document.getElementById("eind").style.display="none";
	document.getElementById("edata").style.display="none";
	document.getElementById("ermail").style.display="none";
	document.getElementById("ecod").style.display="none";
	
	
	//controllo campi
	
	var validate = true;
	
	if ((user == "") || (user == "undefined")) { //controlllo Username non inserito
		var erroreUser = document.getElementById("euser");
		erroreUser.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreUser.style.display = "block";
		erroreUser.style.color = "red";
		erroreUser.style.fontStyle = "oblique";
		validate =  false;
		
		}else if(!regularUser(user)){ //controllo Username non valido come formato
			
			var erroreUser = document.getElementById("euser");
			erroreUser.innerHTML = "Formato non valido (lettere:A-Z/a-z numeri: 0-9)";
			erroreUser.style.display = "block";
			erroreUser.style.color = "red";
			erroreUser.style.fontStyle = "oblique";
			validate = false;
			
	}else if ((pass == "") || (pass == "undefined")) {//controllo Password non inserita
		
		var errorePassword = document.getElementById("epass");
		errorePassword.innerHTML = "Questo campo non pu&oacute essere vuoto";
		errorePassword.style.display = "block";
		errorePassword.style.color = "red";
		errorePassword.style.fontStyle = "oblique";
		validate = false;
		
		}else if(!regularPassword(pass)){//controllo Password non valida come formato
			
			var errorePassword = document.getElementById("epass");
			errorePassword.innerHTML = "Formato non valido (lettere:A-Z/a-z  numeri: 0-9)";
			errorePassword.style.display = "block";
			errorePassword.style.color = "red";
			errorePassword.style.fontStyle = "oblique";
			validate = false;
			
	}else if ((nom == "") || (nom == "undefined")) {//controllo Nome non inserito
			
		var erroreNome = document.getElementById("enom");
		erroreNome.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreNome.style.display = "block";
		erroreNome.style.color = "red";
		erroreNome.style.fontStyle = "oblique";
		validate = false;
		
		}else if(!regularNomeCognome(nom)){//controllo Nome non valido come formato
			
			var erroreNome = document.getElementById("enom");
			erroreNome.innerHTML = "Formato non valido (lettere:A-Z/a-z)";
			erroreNome.style.display = "block";
			erroreNome.style.color = "red";
			erroreNome.style.fontStyle = "oblique";
			validate = false;
			
	}else if ((cog == "") || (cog == "undefined")) {//controllo Cognome non inserito
			
		var erroreCognome = document.getElementById("ecog");
		erroreCognome.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreCognome.style.display = "block";
		erroreCognome.style.color = "red";
		erroreCognome.style.fontStyle = "oblique";
		validate = false;
		
		}else if(!regularNomeCognome(cog)){//controllo Cognome non valido come formato
		
			var erroreNome = document.getElementById("ecog");
			erroreNome.innerHTML = "Formato non valido (lettere:A-Z/a-z)";
			erroreNome.style.display = "block";
			erroreNome.style.color = "red";
			erroreNome.style.fontStyle = "oblique";
			validate = false;
			
	}else if ((mail == "") || (mail == "undefined")) {//controllo e-mail non inserita
			
		var erroreMail = document.getElementById("ermail");
		erroreMail.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreMail.style.display = "block";
		erroreMail.style.color = "red";
		erroreMail.style.fontStyle = "oblique";
		validate = false;
		
		}else if(!regularMail(mail)){
			var erroreMail = document.getElementById("ermail");
			erroreMail.innerHTML = "Formato e-mail non corretto";
			erroreMail.style.display = "block";
			erroreMail.style.color = "red";
			erroreMail.style.fontStyle = "oblique";
			validate = false;
		
	}else if ((dat == "") || (dat == "undefined")) {//controllo data di Nascita non inserita
			
		var erroreData = document.getElementById("edata");
		erroreData.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreData.style.display = "block";
		erroreData.style.color = "red";
		erroreData.style.fontStyle = "oblique";
		validate = false;
		
	}else if ((ind == "") || (ind == "undefined")) {//controllo indirizzo non inserito
			
		var erroreIndirizzo = document.getElementById("eind");
		erroreIndirizzo.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreIndirizzo.style.display = "block";
		erroreIndirizzo.style.color = "red";
		validate = false;
		
	}else if ((cod == "") || (cod == "undefined")) { //controllo Codice Fiscale non Inserito
			
		var erroreCodice = document.getElementById("ecod");
		erroreCodice.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreCodice.style.display = "block";
		erroreCodice.style.color = "red";
		erroreCodice.style.fontStyle = "oblique";
		validate = false;
		
		}else if(!regularCodiceFiscale(cod)){
			var erroreCodice = document.getElementById("ecod");
			erroreCodice.innerHTML = "Il Codice Fiscale inesistente o non rispetta il formato";
			erroreCodice.style.display = "block";
			erroreCodice.style.color = "red";
			erroreCodice.style.fontStyle = "oblique";
			validate = false;
	}
	
	return validate;
		
	
}