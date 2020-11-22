package dao;
import model.UserBean;
import model.OrderBean;


/**
 * Interfaccia ProductModel 
 * 
 * Elenco di funzioni proncipali da eseguire sui prodotti del DB
 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL
import java.util.Collection;

public interface OrderModel {

	public void doSave(OrderBean ordine) throws SQLException; // Salva un prodotto  nel DB
	
	public Collection<OrderBean> doRetrieveByKey(UserBean utente) throws SQLException; //Mi restituisce un determinato prodotto nel DB
	
	
}
