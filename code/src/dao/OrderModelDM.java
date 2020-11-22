package dao;
import control.DBConnectionPool;


import model.OrderBean;

import model.UserBean;

import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Servlet implementation class UserModelDM
 */

public class OrderModelDM implements OrderModel {
	private static final String TABLE_NAME = "ordine"; //Tabella del DB dove andiamo ad operare

	/**
     * @see HttpServlet#HttpServlet()
     */
	public OrderModelDM() {
		super();
	}
	
@Override   
public synchronized void doSave(OrderBean Ordine) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		String insertSQL = "INSERT INTO " + OrderModelDM.TABLE_NAME + " (codiceOrdine,usern,descrizione,dataOrdine) "
				+ " VALUES(?,?,?,?)";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			ps.setString(1,Ordine.getCodiceOrdine());
			ps.setString(2,Ordine.getUsername());
			ps.setString(3,Ordine.getDescrizione());
			ps.setString(4,Ordine.getDataOrdine());
			
			
			ps.executeUpdate(); //esegue la Query di aggiornamento
			
			connection.commit();
				
		}finally {
		
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
	}

@Override
public synchronized Collection<OrderBean> doRetrieveByKey(UserBean utente) throws SQLException{
	
	Connection connection = null;
	
	PreparedStatement ps = null;
	
	Collection<OrderBean> listaOrdini = new LinkedList<OrderBean>();
	
	String username= utente.getUsernameUser();
	
	String selectSQL = " SELECT * " + "FROM " + OrderModelDM.TABLE_NAME + " WHERE usern = ? ";
	
	
	try {
		
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			OrderBean Ordine = new OrderBean();
			
			Ordine.setCodiceOrdine(rs.getString("codiceOrdine"));
			Ordine.setUsername(rs.getString("usern"));
			Ordine.setDescrizione(rs.getString("descrizione"));
			Ordine.setDataOrdine(rs.getString("dataOrdine"));
			
			listaOrdini.add(Ordine);
			
			
		}
		
	}finally {
		
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	
	return listaOrdini;
}
	
	



}













