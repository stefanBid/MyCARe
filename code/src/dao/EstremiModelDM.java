package dao;

/**
* Gestiamo le carte di credito nel nostro DB

* @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
*
*/
import control.DBConnectionPool;
import model.EstremiBean;

import model.UserBean;


import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class EstremiModelDM implements EstremiModel{
	
	private static final String TABLE_NAME = "estremi"; //Tabella del DB dove andiamo ad operare
	
	@Override
	public synchronized void doSave(EstremiBean carta) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		String insertSQL = "INSERT INTO " + EstremiModelDM.TABLE_NAME + " (codiceCarta,usern,Intestatario,scadenza,cvv,saldo) "
				+ " VALUES(?,?,?,?,?,?)";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			ps.setString(1,carta.getCodiceCarta());
			ps.setString(2,carta.getUserCarta());
			ps.setString(3,carta.getIntestatario());
			ps.setString(4,carta.getScadenza());
			ps.setInt(5,carta.getCvv());
			ps.setDouble(6,carta.getSaldo());
			
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
	public synchronized boolean doDelete(String codiceCarta,UserBean utente) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		
		int result = 0; //Flag di controllo
		String user = utente.getUsernameUser();
		String deleteSQL = "DELETE FROM " + EstremiModelDM.TABLE_NAME + " WHERE codiceCarta = ? AND usern = ?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(deleteSQL); //Passiamo la query SQL
			ps.setString(1, codiceCarta);
			ps.setString(2, user);
			
			result = ps.executeUpdate();
		}finally {
			
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		
		return (result != 0);
	}
	
	

	@Override
	public synchronized Collection<EstremiBean> doRetrieveByKey(UserBean utente) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		String user  = utente.getUsernameUser();
		
		Collection<EstremiBean> listaCarte = new LinkedList<EstremiBean>();
		
		String selectSQL = " SELECT * FROM " + EstremiModelDM.TABLE_NAME +" WHERE usern = ?";
		
		
		try {
			
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EstremiBean carta = new EstremiBean();
				
				carta.setCodiceCarta(rs.getString("codiceCarta"));
				carta.setUserCarta(rs.getString("usern"));
				carta.setIntestatario(rs.getString("Intestatario"));
				carta.setScadenza(rs.getString("scadenza"));
				carta.setCvv(rs.getInt("cvv"));
				carta.setSaldo(rs.getDouble("saldo"));
				listaCarte.add(carta);
			}
			
		}finally {
			
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		
		return listaCarte;
	}
	
	
	public synchronized EstremiBean doRetrieveByKey(String username,String codiceCarta) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		EstremiBean carta = new EstremiBean();
		String selectSQL = " SELECT * FROM " + EstremiModelDM.TABLE_NAME +" WHERE usern = ? AND codiceCarta = ?";
		try {
			
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			ps.setString(1, username);
			ps.setString(2, codiceCarta);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				carta.setCodiceCarta(rs.getString("codiceCarta"));
				carta.setUserCarta(rs.getString("usern"));
				carta.setIntestatario(rs.getString("Intestatario"));
				carta.setScadenza(rs.getString("scadenza"));
				carta.setCvv(rs.getInt("cvv"));
				carta.setSaldo(rs.getDouble("saldo"));
			}
			
		}finally {
			
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		
		return carta;
	}
	
	
	
	@Override
	public  synchronized void doUpdateSaldo(double prezzoDaScalare,String codiceCarta,String username) throws SQLException{
		Connection connection = null;
	 	PreparedStatement ps = null;
		EstremiBean carta = doRetrieveByKey(username,codiceCarta);
		System.out.println(carta.toString());
		double newSaldo  = (carta.getSaldo() - prezzoDaScalare);
		System.out.println(prezzoDaScalare +"/"+ newSaldo);
		
		String updateSQL = "UPDATE "+ EstremiModelDM.TABLE_NAME +" SET saldo= ? WHERE codiceCarta= ? AND usern= ?"; 
		System.out.println(updateSQL);
		try {
			
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(updateSQL); //Passiamo la query SQL
			ps.setDouble(1, newSaldo);
			ps.setString(2, codiceCarta);
			ps.setString(3, username);
			ps.executeUpdate();
			System.out.print(ps);
		
		}finally {
			try {
				if(ps!=null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection);//Rilascio la connessione al Database
			}
		}
	}
	

}
