function controlUsername()
{
	var username = document.getElementById("user");
	var valueUsername = username.value;
	
	
	var erroreUser = document.getElementById("euser");

	 
	 
	var url ="ControlLogin?user=" + valueUsername;
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 && xhr.status == 200)
			{
			var check = String(xhr.responseText);
			
			if(check == 1)
				{
				
				username.style.borderColor ="C02230";
				
					
					
				erroreUser.innerHTML = "Questo Username &#233 gia presente";

				 erroreUser.style.display = "block";

				 erroreUser.style.color = "red";

				 erroreUser.style.fontStyle = "oblique";
				 
				}
			else
				{
				erroreUser.style.display = "none";
				erroreUser.innerHTML = "";
				}
			}
	}
	xhr.open("GET" , url , true);
	xhr.send(null);
	}




function controlEmail()
{
	
	var email = document.getElementById("email");
	
	var valueEmail = email.value;
	var erroreEmail = document.getElementById("ermail");
	

var url ="ControlLogin?email=" + valueEmail;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		
		
		if(xhr.readyState == 4 && xhr.status == 200)
			{
			var check = String(xhr.responseText);
			
			if(check == 3)
				{
		
				
				
					
				erroreEmail.innerHTML = "Questo Email &#233 gia presente";

				 erroreEmail.style.display = "block";

				 erroreEmail.style.color = "red";

				 erroreEmail.style.fontStyle = "oblique";
				 
				}
			else
				{
				erroreEmail.style.display = "none";
				erroreEmail.innerHTML = "";
				}
			}
	}
	xhr.open("GET" , url , true);
	xhr.send(null);
	
}

