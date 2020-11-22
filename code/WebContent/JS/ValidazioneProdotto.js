//Validazione aggiunta prodotto

function validazioneProdotto(){
	
	//variabili che contengono gli elementi del form
	
	var id = document.getElementById("idp").value;
	var codP = document.getElementById("codp").value;
	var iva = document.getElementById("iva").value;
	var nomp = document.getElementById("nomp").value;
	var desc = document.getElementById("desc").value;
	var prezzo = document.getElementById("prezzo").value;
	var categoria = document.getElementById("cat").value;
	var quant = document.getElementById("quant").value;
	
	
	
	//Espressioni regolari
	
	function regularId(campo){
		var id_reg_exp =/^[0-9]+$/;
		return id_reg_exp.test(campo);
	}
	
	function regularCodice(campo){
		var cod_reg_exp =/^[0-9]+$/;
		return cod_reg_exp.test(campo);
	}
	
	function regularPrezzo(campo){
		var prezzo_reg_exp = /^[1-9]\d{0,2}(\.\d{3})*(,\d+)?$/;
		return prezzo_reg_exp.test(campo);
	}
	
	function regularQuantita(campo){
		var quantita_reg_exp = /^[0-9]+$/;
		return quantita_reg_exp.test(campo);
	}
	
	
	
	
	//Settiamo tutti gli small con display: none in modo tale da avere l'effetto dinamico quzndo risolviamo il problema
	document.getElementById("iderr").style.display="none";
	document.getElementById("coderr").style.display="none";
	document.getElementById("ivaerr").style.display="none";
	document.getElementById("nomPerr").style.display="none";
	document.getElementById("descerr").style.display="none";
	document.getElementById("prezerr").style.display="none";
	document.getElementById("caterr").style.display="none";
	document.getElementById("quanterr").style.display="none";
	
	
	
	
	//controllo campi
	
	var validate = true;
	
	if(( id == "") || ( id =="undefined")){//controllo Id non inserito
		
		var erroreId = document.getElementById("iderr");
		erroreId.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreId.style.display = "block";
		erroreId.style.color = "red";
		erroreId.style.fontStyle = "oblique";
		validate =  false;
		
		}else if(!regularId(id)){ // controllo Id non valido come formato
			
			var erroreId = document.getElementById("iderr");
			erroreId.innerHTML = "Formato non valido (numeri: 0-9)";
			erroreId.style.display = "block";
			erroreId.style.color = "red";
			erroreId.style.fontStyle = "oblique";
			validate =  false;
		
	}else if(( codP == "") || ( codP == "undefined")){//controllo Codice prodotto non inserito
		
		var erroreCod = document.getElementById("coderr");
		erroreCod.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreCod.style.display = "block";
		erroreCod.style.color = "red";
		erroreCod.style.fontStyle = "oblique";
		validate =  false;
		
		}else if(!regularCodice(codP)){ // controllo Codice Prodotto non valido come formato
			
			var erroreCod = document.getElementById("coderr");
			erroreCod.innerHTML = "Formato non valido (numeri: 0-9)";
			erroreCod.style.display = "block";
			erroreCod.style.color = "red";
			erroreCod.style.fontStyle = "oblique";
			validate =  false;
			
			}else if((codP.length <= 12) || (codP.length >= 14)){//controllo codice Prodotto troppo lungo o troppo corto
				
				var erroreCod = document.getElementById("coderr");
				erroreCod.innerHTML = "Il Codice deve essere composto necessariamente da 13 cifre";
				erroreCod.style.display = "block";
				erroreCod.style.color = "red";
				erroreCod.style.fontStyle = "oblique";
				validate = false;
				
	}else if(( iva == "") || ( iva =="undefined")){//controllo IVA non inserita
		
		var erroreIva = document.getElementById("ivaerr");
		erroreIva.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreIva.style.display = "block";
		erroreIva.style.color = "red";
		erroreIva.style.fontStyle = "oblique";
		validate =  false;
		
	}else if(( nomp == "") || ( nomp =="undefined")){//controllo Nome prodotto non inserito
		
		var erroreNomeP = document.getElementById("nomPerr");
		erroreNomeP.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreNomeP.style.display = "block";
		erroreNomeP.style.color = "red";
		erroreNomeP.style.fontStyle = "oblique";
		validate =  false;
		
	}else if ((desc == "") || (desc=="undefined")){
		
		var erroreDescrizione = document.getElementById("descerr");
		erroreDescrizione.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreDescrizione.style.display = "block";
		erroreDescrizione.style.color = "red";
		erroreDescrizione.style.fontStyle = "oblique";
		validate =  false;
		
	}else if(( prezzo == "") || ( prezzo =="undefined")){//controllo prezzo non inserito
		
		var errorePrezzo = document.getElementById("prezerr");
		errorePrezzo.innerHTML = "Questo campo non pu&oacute essere vuoto";
		errorePrezzo.style.display = "block";
		errorePrezzo.style.color = "red";
		errorePrezzo.style.fontStyle = "oblique";
		validate =  false;
		
			
	}else if(( categoria == "") || ( categoria =="undefined")){//controllo categoria non inserita
		
		var erroreCategoria = document.getElementById("caterr");
		erroreCategoria.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreCategoria.style.display = "block";
		erroreCategoria.style.color = "red";
		erroreCategoria.style.fontStyle = "oblique";
		validate =  false;
		
	}else if(( quant == "") || ( quant =="undefined")){//controllo quantità non inserito
		
		var erroreQuantita = document.getElementById("quanterr");
		erroreQuantita.innerHTML = "Questo campo non pu&oacute essere vuoto";
		erroreQuantita.style.display = "block";
		erroreQuantita.style.color = "red";
		erroreQuantita.style.fontStyle = "oblique";
		validate =  false;
		
		}else if(!regularQuantita(quant)){ // controllo quantit° non valido come formato
			
			var erroreQuantita = document.getElementById("quanterr");
			erroreQuantita.innerHTML = "Formato non valido (numeri: 0-9)";
			erroreQuantita.style.display = "block";
			erroreQuantita.style.color = "red";
			erroreQuantita.style.fontStyle = "oblique";
			validate =  false;
	}

	return validate;
}