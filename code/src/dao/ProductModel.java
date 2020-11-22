package dao;
import model.ProductBean;


/**
 * Interfaccia ProductModel 
 * 
 * Elenco di funzioni proncipali da eseguire sui prodotti del DB
 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL
import java.util.Collection;

public interface ProductModel {

	public void doSave(ProductBean prodotto) throws SQLException; // Salva un prodotto  nel DB
	
	public boolean doDelete(int id, String codProdotto) throws SQLException; //Elimina un prodotto dal DB
	
	public ProductBean doRetrieveByKey(int id,String codProdotto) throws SQLException; //Mi restituisce un determinato prodotto nel DB
	
	public Collection<ProductBean> doRetrieveAll(String order) throws SQLException; //Restituisce tutti i prodotti del DB
	
	public void doUpdateQuantity(int idProdotto,String codProdotto,int newQuantity) throws SQLException; //aggiorna la quantità del prodotto presente in magazzino
	
	public void addPhoto(String codProdotto ,int idProdotto,String nomeFoto) throws SQLException;
}
