package model;


import java.io.Serializable;//per mantenere l'oggetto persistente nel tempo

/**
 * Been per gestire l'entità Ordine
 * 
 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */

public class OrderBean implements Serializable{
	
	private static final long serialVersionUID =  1L;
	
	/**
	 * Costruttore del Bean
	 * al suo interno inizializziamo i vari parametri
	 */
	public OrderBean(){
		
		this.codiceOrdine = null;
		this.username = null;
		this.descrizione = null;
		this.dataOrdine = null;
		
	}
	
	
	//METODI
	
	/**
	 * Restituisce il codice dell'Ordine
	 * @return codiceOrdine
	 */
	public String getCodiceOrdine() {
		return codiceOrdine;
	}
	
	/**
	 * Setta un nuovo codice dell'Ordine
	 * @param codiceOrdine
	 */
	public void setCodiceOrdine(String codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}
	
	/**
	 * Restituisce l'Username dell'utente al quale è legato quest'ordine
	 * @return username (Username di UserBean)
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Setta un nuovo username dell'utente al quale è legato l'ordine
	 * @param username (Username di UserBean)
	 */
	public void setUsername(String utenteUsername) {
		
		this.username = utenteUsername;
	}
	
	/**
	 * Restituisce la Descrizione dell'ordine
	 * @return descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Modifica la descrizione dell'Ordine
	 * 
	 * @param descrizione ordine
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Restituisce la data dell'Ordine
	 * @return data dell'Ordine
	 */
	public String getDataOrdine() {
		return dataOrdine;
	}
	
	/**
	 * Modifica la data dell'ordine effettuato da un utente
	 * @param dataOrdine
	 */
	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	
	
	
	
	
	/**
	 * Stampa la stringa contenete i dati di un prodotto
	 */
	public String toStringOrdine() {
		return "OrderBean [codiceOrdine=" + codiceOrdine + ", username=" + username + ", descrizione=" + descrizione
				+ ", dataOrdine=" + dataOrdine + "]";
	}






	//Variabili d'Istanza
	private String codiceOrdine;
	private String username;
	private String descrizione;
	private String dataOrdine;
	
	
	

}
