package dao;
import model.UserBean;




/**
 * Interfaccia ProductModel 
 * 
 * Elenco di funzioni proncipali da eseguire sui prodotti del DB
 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL
import java.util.Collection;




public interface UserModel {

	
	
	
	
	public void doSave(UserBean utente) throws SQLException; // Salva un prodotto  nel DB
	
	
	public UserBean doRetrieveByKey(String username,String password) throws SQLException; //Mi restituisce un determinato prodotto nel DB
	
	public UserBean doRetrieveByAdmin(String username) throws SQLException; //Mi restituisce un determinato prodotto nel DB

	public Collection<UserBean> RetrieveAll() throws SQLException;
	
	public void changePath(String percorso ,String username) throws SQLException; //Mi restituisce un determinato prodotto nel DB

	public int checkUsername(String username) throws SQLException; //Mi restituisce un determinato prodotto nel DB

	public int checkEmail(String email) throws SQLException; //Mi restituisce un determinato prodotto nel DB
}