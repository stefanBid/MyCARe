
package model;

import java.io.Serializable; //per mantenere l'oggetto persistente nel tempo

	/**
	 * Been per gestire l'entità Utente
	 * 
	 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
	 *
	 */


	public class UserBean implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * Costruttore del Been
		 * al suo interno inizializziamo i vari parametri
		 */
		public UserBean() {
			
			this.codFiscaleUser=null;
			this.indirizzoUser=null;
			this.nomeUser=null;
			this.cognomeUser=null;
			this.datanascitaUser=null;
			this.usernameUser=null;
			this.emailUser=null;
			this.passwordUser=null;
			this.ruoloUser=null;
			this.pathNameFotoP=null;
		}
		
		//METODI
		
		


		
	




		//variabili d'istanza
		
	
		@Override
		public String toString() {
			return "UserBean [indirizzoUser=" + indirizzoUser + ", nomeUser=" + nomeUser + ", cognomeUser="
					+ cognomeUser + ", datanascitaUser=" + datanascitaUser + ", codFiscaleUser=" + codFiscaleUser
					+ ", usernameUser=" + usernameUser + ", emailUser=" + emailUser + ", passwordUser=" + passwordUser
					+ ", RuoloUser=" + ", pathNameFotoP=" + pathNameFotoP + "]";
		}
		public String getIndirizzoUser() {
			return indirizzoUser;
		}
		public void setIndirizzoUser(String indirizzoUser) {
			this.indirizzoUser = indirizzoUser;
		}
		public String getNomeUser() {
			return nomeUser;
		}
		public void setNomeUser(String nomeUser) {
			this.nomeUser = nomeUser;
		}
		public String getCognomeUser() {
			return cognomeUser;
		}
		public void setCognomeUser(String cognomeUser) {
			this.cognomeUser = cognomeUser;
		}
		public String getDatanascitaUser() {
			return datanascitaUser;
		}
		public void setDatanascitaUser(String datanascitaUser) {
			this.datanascitaUser = datanascitaUser;
		}
		public String getCodFiscaleUser() {
			return codFiscaleUser;
		}
		public void setCodFiscaleUser(String codFiscaleUser) {
			this.codFiscaleUser = codFiscaleUser;
		}
		public String getUsernameUser() {
			return usernameUser;
		}
		public void setUsernameUser(String usernameUser) {
			this.usernameUser = usernameUser;
		}
		public String getEmailUser() {
			return emailUser;
		}
		public void setEmailUser(String emailUser) {
			this.emailUser = emailUser;
		}
		public String getPasswordUser() {
			return passwordUser;
		}
		public void setPasswordUser(String passwordUser) {
			this.passwordUser = passwordUser;
		}
		public String getRuoloUser() {
			return ruoloUser;
		}
		public void setRuoloUser(String ruoloUser) {
			this.ruoloUser  = ruoloUser;
		}
		public String getPathNameFotoP() {
			return pathNameFotoP;
		}
		public void setPathNameFotoP(String pathNameFotoP) {
			this.pathNameFotoP = pathNameFotoP;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		public boolean isEmpty(){
			if(usernameUser==null || usernameUser=="") {
				return true;
			}
			return false;
		}
		private String indirizzoUser;
		private String nomeUser;
		private String cognomeUser;
		private String datanascitaUser;
		private String codFiscaleUser;
		private String usernameUser;
		private String emailUser;
		private String passwordUser;
		private String ruoloUser;
		private String pathNameFotoP;
		
		
	    
	   
	

	}



