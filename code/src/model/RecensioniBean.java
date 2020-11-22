package model;

import java.io.Serializable; //per mantenere l'oggetto persistente nel tempo

/**
* Been per gestire il feedback di un utente su un prodotto
* 
* @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
*
*/

public class RecensioniBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore del Bean
	 * al suo interno inizializziamo i vari parametri
	 */
	
	public RecensioniBean() {
		this.codiceFeedback = 0;
		this.valutazione = -1;
		this.dataFeedback = null;
		this.feedback = null;
		this.user = null;
		this.idProdottoFeedback = -1;
		this.codiceProdottoFeedback = null;
		
	}
	
	/**
	 * Reastituisce il codice della recensione
	 * @return codiceFeedback
	 */
	public int getCodiceFeedback() {
		return codiceFeedback;
	}
	
	/**
	 * Modifica il codice della recensione
	 * @param i
	 */
	public void setCodiceFeedback(int i) {
		this.codiceFeedback = i;
	}
	
	/**
	 * Restituisce la valutazione del prodotto (scala 1-5)
	 * @return valutazione
	 */
	public int getValutazione() {
		return valutazione;
	}
	
	
	/**
	 * Modifica la valutazione del prodotto
	 * @param valutazione
	 */
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	
	
	/**
	 * Restituisce la data della recensione
	 * @return dataFeedback
	 */
	public String getDataFeedback() {
		return dataFeedback;
	}
	
	
	/**
	 * Modifica la data della recensione
	 * @param dataFeedback
	 */
	public void setDataFeedback(String dataFeedback) {
		this.dataFeedback = dataFeedback;
	}
	
	/**
	 * Restituisce la recensione (il testo sul commento del prodotto)
	 * @param string 
	 * @return feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	
	
	/**
	 * Modifica la recensione ( il testo sul commento del prodotto)
	 * @param feedback
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	/**
	 * restituisce l'utente che ha rilasciato la recensione
	 * @return user
	 */
	public String getUser() {
		return user;
	}
	
	
	/**
	 * modifica l'utente che ha rilasciato la recensione
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	
	/**
	 * Restituisce l'id del prodotto su cui è stata fatta la recensione
	 * @return idProdottoFeedback
	 */
	public int getIdProdottoFeedback() {
		return idProdottoFeedback;
	}
	
	
	/**
	 * Modifica l'id del prodotto sul quale è stata rilasciatag la recensione
	 * @param idProdottoFeedback
	 */
	public void setIdProdottoFeedback(int idProdottoFeedback) {
		this.idProdottoFeedback = idProdottoFeedback;
	}
	
	
	/**
	 * Restituisce  il codice prodotto sul quale è stata rilasciata una recensione
	 * @returnbcodiceProdottoFeedback
	 */
	public String getCodiceProdottoFeedback() {
		return codiceProdottoFeedback;
	}
	
	/**
	 * Modifica il codice prodotto sul quale è stata rilascita la recensione
	 * @param codiceProdottoFeedback
	 */
	public void setCodiceProdottoFeedback(String codiceProdottoFeedback) {
		this.codiceProdottoFeedback = codiceProdottoFeedback;
	}
	
	
	
	
	/**
	 * Produce una stinga contenente tutti i campi del bean
	 */
	public String toString() {
		return "RecensioniBean [codiceFeedback=" + codiceFeedback + ", valutazione=" + valutazione + ", dataFeedback="
				+ dataFeedback + ", feedback=" + feedback + ", user=" + user + ", idProdottoFeedback="
				+ idProdottoFeedback + ", codiceProdottoFeedback=" + codiceProdottoFeedback + "]";
	}




	//Variabili d'Istanza
	private int codiceFeedback;
	private int valutazione;
	private String dataFeedback;
	private String feedback;
	private String user;
	private int idProdottoFeedback;
	private String codiceProdottoFeedback;


	
	
	

}
