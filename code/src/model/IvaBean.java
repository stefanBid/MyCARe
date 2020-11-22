package model;


import java.io.Serializable;//per mantenere l'oggetto persistente nel tempo

/**
 * Been per gestire l'entità Ordine
 * 
 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */

public class IvaBean implements Serializable{
	
	private static final long serialVersionUID =  1L;
	
	/**
	 * Costruttore del Bean
	 * al suo interno inizializziamo i vari parametri
	 */
	public IvaBean(){
		
		this.statoIva = null;
		this.valore= 0.0;
	
		
	}
	
	
	//METODI
	
	public String getStatoIva() {
		return statoIva;
	}
	
	
	public void setStatoIva(String statoIva) {
		this.statoIva = statoIva;
	}
	
	
	public double getValore() {
		return valore;
	}
	
	
	
	public void setValore(double valore) {
		this.valore = valore;
	}
	
	
	
	@Override
	public String toString() {
		return "IvaBean [statoIva=" + statoIva + ", valore=" + valore + "]";
	}



	//Variabili d'Istanza
	private String statoIva;
	private double valore;

	
	

}
