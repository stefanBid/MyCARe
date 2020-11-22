package model;
import java.util.ArrayList;
/**
 * Gestisce il carrello del nostro sito
 * 
 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */


public class Carrello {
	
	/**
	 * Costruttore che inizializza il nostro carrello
	 */
	public Carrello() {
		carrello = new ArrayList<ProductBean>();
		quantita = new ArrayList<Integer>();
	}
	
	/**
	 * Aggiunge un prodotto al carrello
	 * @param prodotto da aggiungere al carrello
	 */
	public void aggiungiProdotto(ProductBean prodotto,int tot) {
		int i =0;
		boolean trovato = false;
		
		//ciclo per vedere se il prodotto che vogliamo aggiungere è già presente
		for(ProductBean bean : carrello) {
			
			if(bean.getIdProdotto()==prodotto.getIdProdotto()) {
				int totquantita = quantita.get(i) +tot;
				quantita.set(i,totquantita);
				trovato =true;
			}
			i++;
		}
		//se il prodotto che vogliamo inserire non è mai stato messo nel carrello
		if(trovato==false) {
			carrello.add(prodotto);
			quantita.add(tot);
		}
		
	}
	
	
	/**
	 * Elimina un prodotto dal carrello
	 * @param prodotto da leimina dal carrello
	 */
	
	public void eliminaProdotto(ProductBean prodotto) {
		int i =0;
		for(ProductBean bean : carrello) {
			
			if(bean.getIdProdotto()==prodotto.getIdProdotto()) {
				carrello.remove(bean);
				quantita.remove(i);
				break;
			}
			i++;
		}
	}
	
	/**
	 * Ritorna l'intero carrello
	 * @return carrello
	 */
	public ArrayList<ProductBean> getCarrello(){
		return carrello;
	}
	
	/**
	 * Ritorna le quantita per ogni prodotto
	 * @return lista quantita
	 */
	public ArrayList<Integer> getQuantita(){
		return quantita;
	}
	
	//Variabili d'istanza
	private ArrayList<ProductBean> carrello;
	private ArrayList<Integer> quantita;
}
