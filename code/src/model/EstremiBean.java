package model;

import java.io.Serializable; //per mantenere l'oggetto persistente nel tempo

/**
* Been per gestire gli estremi di pagamento
* 
* @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
*
*/

public class EstremiBean implements Serializable {

		private static final long serialVersionUID = 1L;
		

		/**
		 * Costruttore del Bean
		 * al suo interno inizializziamo i vari parametri
		 */
		
		public EstremiBean() {
			this.codiceCarta = null;
			this.intestatario = null;
			this.scadenza = null;
			this.cvv = -1;
			this.userCarta = null;
			this.saldo = 600;
		}
		
		
		//METODI
		/**
		 * Restituisce il codice della carta
		 * @return codiceCarta
		 */
		public String getCodiceCarta() {
			return codiceCarta;
		}
		
		/**
		 * Modifica il codice della carta
		 * @param codiceCarta
		 */
		public void setCodiceCarta(String codiceCarta) {
			this.codiceCarta = codiceCarta;
		}
		
		/**
		 * Restituisce l'intestatario della carta (non necessariamente deve essere il propietario dell'account)
		 * la carta però deve essere asoociato ad un account
		 * @return intestatario
		 */
		public String getIntestatario() {
			return intestatario;
		}
		
		/**
		 * Modifica l'intestatario della carta di 
		 * @param intestatario
		 */
		public void setIntestatario(String intestatario) {
			this.intestatario = intestatario;
		}
		
		/**
		 * Restituisce la scadenza della carta
		 * @return scadenza
		 */
		public String getScadenza() {
			return scadenza;
		}
		
		
		/**
		 * Modifica la data di scadenza della carta
		 * @param scadenza
		 */
		public void setScadenza(String scadenza) {
			this.scadenza = scadenza;
		}
		
		/**
		 * restituisce il cvv (Codice di Verifica) della carta
		 * @return cvv
		 */
		public int getCvv() {
			return cvv;
		}
		
		
		/**
		 * Modifica il cvv (Codice di Verifica) della carta
		 * @param cvv
		 */
		public void setCvv(int cvv) {
			this.cvv = cvv;
		}
		
		/**
		 * Restituisc e l'utente del sito al quale è associata tale carta
		 * @return user
		 */
		public String getUserCarta() {
			return userCarta;
		}
		
		/**
		 * Modifica l'utente del sito al quale è associata la carta
		 * @param user
		 */
		public void setUserCarta(String userCarta) {
			this.userCarta = userCarta;
		}
		
		
		/**
		 * Restituisce il saldo attivo della carta
		 * @return saldo
		 */
		public double getSaldo() {
			return saldo;
		}
		
		
		
		/**
		 * Modifica il saldo attivo sulla carta
		 * @param saldo
		 */
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		
		
		
		

		/**
		 * Stampa la STRINGA CONTENETE I DATI DEKKA CARTA
		 */
		public String toString() {
			return "EstremiBean [codiceCarta=" + codiceCarta + ", intestatario=" + intestatario + ", scadenza="
					+ scadenza + ", cvv=" + cvv + ", userCarta=" + userCarta + ", saldo=" + saldo + "]";
		}










		//variabili d'istanza
		private String codiceCarta;
		private String intestatario;
		private String scadenza;
		private int cvv;
		private String userCarta;
		private double saldo;
}
