package model;

import java.io.Serializable; //per mantenere l'oggetto persistente nel tempo

/**
 * Been per gestire l'entità prodotto
 * 
 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */

public class VoiceOrderBean implements Serializable {

		private static final long serialVersionUID = 1L;
		
		/**
		 * Costruttore del Bean
		 * al suo interno inizializziamo i vari parametri
		 */
		
		public VoiceOrderBean() {
			this.codiceVoce = -1;
			this.quantita = -1;
			this.prezzoAcquisto = 0.00;
			this.idProdotto = -1;
			this.codiceProdotto = null;
			this.codiceOrdine = null;
			this.valoreIva=0.0;
			
		}
		
		//METODI
		
		/**
		 * Restituisce la Voce del singolo prodotto
		 * 
		 * @return voceOrdine (singolo Prodotto)
		 */
		public int getCodiceVoce() {
			return codiceVoce;
		}
		/**
		 * Modifica la voce Ordine del singolo prodotto
		 * @param codiceVoce (singolo Prodotto)
		 */
		public void setCodiceVoce(int codiceVoce) {
			this.codiceVoce = codiceVoce;
		}
		
		/**
		 * Restituisce la quantità acquistata di un singolo prodotto
		 * @return quantità acquistata
		 */
		public int getQuantita() {
			return quantita;
		}
		
		/**
		 * Modifica la quantità acquistata di un singolo prodotto
		 * @param quantita acquistata
		 */
		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}
		
		/**
		 * Restituisce il prezzo con cui abbiamo acquistato quel prodotto
		 * @return prezzo di Acquisto
		 */
		public double getPrezzoAcquisto() {
			return prezzoAcquisto;
		}
		
		/**
		 * Modifica il prezzo di acquisto di un prodotto
		 * @param prezzoAcquisto
		 */
		public void setPrezzoAcquisto(double prezzoAcquisto) {
			this.prezzoAcquisto = prezzoAcquisto;
		}
		
		/**
		 * Restituisce l'ID del singolo prodotto
		 * @return ID Prodotto
		 */
		public int getIdProdotto() {
			return idProdotto;
		}
		
		/**
		 * Modifica l'ID del singolo prdotto
		 * @param idProdotto
		 */
		public void setIdProdotto(int idProdotto) {
			this.idProdotto = idProdotto;
		}
		
		/**
		 * Restituisce il codice del singolo prodotto
		 * @return codice Prodotto
		 */
		public String getCodiceProdotto() {
			return codiceProdotto;
		}
		
		/**
		 * Modifica il codice del singolo prodotto
		 * @param codiceProdotto
		 */
		public void setCodiceProdotto(String codiceProdotto) {
			this.codiceProdotto = codiceProdotto;
		}
		
		/**
		 * Restituisce il codice dell'Ordine associato a quella singola voce
		 * @return codice Ordine
		 */
		public String getCodiceOrdine() {
			return codiceOrdine;
		}
		
		/**
		 * Modifica il codice Ordine al quale è associata la singola voce
		 * @param codiceOrdine
		 */
		public void setCodiceOrdine(String codiceOrdine) {
			this.codiceOrdine = codiceOrdine ;
		}
		

		public double getValoreIva() {
			return valoreIva;
		}
		
		
		

		public void setValoreIva(double valoreIva) {
			this.valoreIva = valoreIva;
		}
		
		
		
		
		
		
		/**
		 * Stampa la stringa contenente i dati di una voce Ordine
		 *
		 */
		
		public String toStringVoceOrdine() {
			return "VoiceOrderBean [codiceVoce=" + codiceVoce + ", quantita=" + quantita + ", prezzoAcquisto="
					+ prezzoAcquisto + ", idProdotto=" + idProdotto + ", codiceProdotto=" + codiceProdotto
					+ ", codiceOrdine=" + codiceOrdine + "]";
		}





		// variabili d'istanza
		private int codiceVoce;
		private int quantita;
		private double prezzoAcquisto;
		private int idProdotto;
		private String codiceProdotto;
		private String codiceOrdine;
		private double valoreIva;

		
}
