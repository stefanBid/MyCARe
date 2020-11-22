
package model;

import java.io.Serializable; //per mantenere l'oggetto persistente nel tempo

	/**
	 * Been per gestire l'entità prodotto
	 * 
	 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
	 *
	 */


	public class ProductBean implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * Costruttore del Been
		 * al suo interno inizializziamo i vari parametri
		 */
		public ProductBean() {
			
			this.idProdotto =-1;
			this.quantitaMagazzino = -1;
			this.codProdotto = null;
			this.nomeProdotto = null;
			this.statoIva = null;
			this.categoria = null;
			this.descrizione  =null;
			this.prezzoProdotto = 0.00;
			this.pathNameFotoP = null;
		}
		
		//METODI
		
		
		/**
		 * Restituisce l'ID del prodotto
		 * @return idProdotto
		 */
		public int getIdProdotto() {
			return idProdotto;
		}
		
		
		
		/**
		 * Modifica l'ID del prodotto
		 * @param idProdotto
		 */
		public void setIdProdotto(int idProdotto) {
			this.idProdotto = idProdotto;
		}
		
		
		
		/**
		 * Restituisce il numero di pezzi presenti nel magazzino
		 * @return quantitaMagazzino
		 */
		public int getQuantitaMagazzino() {
			return quantitaMagazzino;
		}
		
		
		
		/**
		 * Modifica il numero di pezzi presenti in magazzino
		 * @param idProdotto
		 */
		public void setQuantitaMagazzino(int quantitaMagazzino) {
			this.quantitaMagazzino = quantitaMagazzino;
		}
		
		
		
		/**
		 * Restituisce il codice del Prodotto
		 * @return codProdotto
		 */
		public String getCodProdotto() {
			return codProdotto;
		}
		
		
		
		/**
		 * Modifica il codice del prodotto
		 * @param codProdotto
		 */
		public void setCodProdotto(String codProdotto) {
			this.codProdotto = codProdotto;
		}
		
		
		
		/**
		 * Restituisce lo stato d'IVA al quale il prodotto è soggetto
		 * @return statoIva
		 */
		public String getStatoIva() {
			return statoIva;
		}
		
		
		
		/**
		 * Modifica lo stato d'IVA al quale il prodotto deve essere sottoposto
		 * @param statoIva
		 */
		public void setStatoIva(String statoIva) {
			this.statoIva = statoIva;
		}
		
		
		
		/**
		 * Restituisce il nome del prodotto
		 * @return nomeProdotto
		 */
		public String getNomeProdotto() {
			return nomeProdotto;
		}
		
		
		
		/**
		 * Modifica il nome del prodotto
		 * @param nomeProdotto
		 */
		public void setNomeProdotto(String nomeProdotto) {
			this.nomeProdotto = nomeProdotto;
		}
		
		
		
		/**
		 * Restituisce la descrizione del prodotto
		 * @return descrizione
		 */
		public String getDescrizione() {
			return descrizione;
		}
		
		
		
		/**
		 * Modifica la descrizione del Prodotto
		 * @param descrizione
		 */
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		
		
		
		/**
		 * Restituisce il Prezzo del Prodotto
		 * @return prezzoProdotto
		 */
		public double getPrezzoProdotto() {
			return prezzoProdotto;
		}
		
		
		
		/**
		 * Modifica il prezzo di un Prodotto
		 * @param prezzoProdotto
		 */
		public void setPrezzo(double prezzoProdotto) {
			this.prezzoProdotto = prezzoProdotto;
		}
		
		
		
		/**
		 * Restituisce la categoria del prodotto
		 * @return categoria
		 */
		public String getCategoria() {
			return categoria;
		}
		
		
		
		/**
		 * Modifica la categoria di un prodotto
		 * @param categoria
		 */
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
		
		
		/**
		 * Restituisce il pathname della foto asoociata al prodotto
		 * @return
		 */
		public String getPathNameFotoP() {
			return pathNameFotoP;
		}
		
		
		
		/**
		 * Modifica il pathname della foto associata al prodotto
		 * @param pathNameFotoP
		 */
		public void setPathNameFotoP(String pathNameFotoP) {
			this.pathNameFotoP = pathNameFotoP;
		}


		
		


		
		/**
		 * Stampa la stringa contenente i dati di un prodotto 
		 */
		public String toStringProdotto() {
			return nomeProdotto + " (" + idProdotto+ "  " + codProdotto + "), " + prezzoProdotto + " " +quantitaMagazzino + " "+ statoIva+ ". " + descrizione;
		}





		//variabili d'istanza
		private int idProdotto;
		private int quantitaMagazzino;
		private String codProdotto;
		private String statoIva;
		private String nomeProdotto;
		private String descrizione;
		private double prezzoProdotto;
		private String categoria;
		private String pathNameFotoP;
		
		
	    
	   
		

	}



