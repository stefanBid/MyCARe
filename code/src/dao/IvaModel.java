package dao;
import model.ProductBean;
import model.IvaBean;
/**
 * Interfaccia ProductModel 
 * 
 * Elenco di funzioni proncipali da eseguire sui prodotti del DB
 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL



public interface IvaModel {
/*
	public void doSave(ProductBean prodotto) throws SQLException; // Salva un prodotto  nel DB
	*/
	
	
public IvaBean doRetrieveIvaByProduct(ProductBean prodotto) throws SQLException; //Mi restituisce un iva del  prodeotto che gli passiamo nel DB
	
public IvaBean doRetrieveIvaByString(String Stato) throws SQLException; //Mi restituisce un iva del  prodeotto che gli passiamo nel DB	
	
}
