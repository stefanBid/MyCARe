
package dao;
import model.EstremiBean;

import model.UserBean;


/**
 * Interfaccia EstremiModel

 * 
 * Elenco di funzioni proncipali da eseguire sulle carte di credito del DB
 */

import java.sql.SQLException; //Gestisce le eccezioni che derivano dal linguaggio SQL
import java.util.Collection;

public interface EstremiModel {

	public void doSave(EstremiBean carta) throws SQLException;//Salva una nuova carta di credito associata ad un cliente
	public Collection<EstremiBean> doRetrieveByKey(UserBean utente) throws SQLException; //Restituisce tutte le carte di credito associate ad un determinato utente
	public boolean doDelete(String codiceCarta,UserBean utente) throws SQLException; //Elimina una carta associata ad un cliente
	public EstremiBean doRetrieveByKey(String username,String codiceCarta) throws SQLException; //Restituisce una determin ata carta di credito di un utente
	public void doUpdateSaldo(double prezzoDaScalare,String username,String codiceCarta) throws SQLException; //Sottrae dal saldo della carta il costo dell'ordine
	
	
}
