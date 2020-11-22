package dao;

import model.OrderBean;


import model.VoiceOrderBean;



/**

 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL
import java.util.Collection;

public interface VoiceOrderModel {

	public void doSave(VoiceOrderBean VoceOrdine) throws SQLException; // Salva un prodotto  nel DB
	
	public Collection<VoiceOrderBean> doRetrieveAllByKey(OrderBean Ordine) throws SQLException; //Mi restituisce un determinato prodotto nel DB
	
	
	
}
