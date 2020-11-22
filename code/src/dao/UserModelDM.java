
package dao;
import control.DBConnectionPool;

import model.UserBean;


import java.util.*;
import java.io.File;
import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;

/**
 * Servlet implementation class UserModelDM
 */

public class UserModelDM implements UserModel {
	private static final String TABLE_NAME = "utente"; //Tabella del DB dove andiamo ad operare
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModelDM() {
        super();
        // TODO Auto-generated constructor stub
    }

@Override   
public synchronized void doSave(UserBean utente) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		String insertSQL = "INSERT INTO " + UserModelDM.TABLE_NAME + " (codiceFiscale,username,email,pass,nomeUtente,cognomeUtente,dataNascita,indirizzo,ruolo,pathNameFotoU) "
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			ps.setString(1,utente.getCodFiscaleUser());
			ps.setString(2,utente.getUsernameUser());
			ps.setString(3,utente.getEmailUser());
			ps.setString(4,utente.getPasswordUser());
			ps.setString(5,utente.getNomeUser());
			ps.setString(6,utente.getCognomeUser());
			ps.setString(7,utente.getDatanascitaUser());
			ps.setString(8,utente.getIndirizzoUser());
			ps.setString(9,utente.getRuoloUser());
			ps.setString(10,utente.getPathNameFotoP());
			
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
public synchronized UserBean doRetrieveByKey(String username,String password) throws SQLException{
	Connection connection = null;
	PreparedStatement ps = null;
	
	UserBean utente = new UserBean(); //Utente di appoggio
	
	String selectSQL = "SELECT * FROM " + UserModelDM.TABLE_NAME + " WHERE Username = ? AND pass = ?";
	
	try {
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		
		ps.setString(1, username);
		ps.setString(2, password);
		try {
		ResultSet rs = ps.executeQuery();
		
		
		
		while(rs.next()) {
			
			utente.setCodFiscaleUser(rs.getString("codiceFiscale"));
			utente.setUsernameUser(rs.getString("username"));
			utente.setEmailUser(rs.getString("email"));
			utente.setPasswordUser(rs.getString("pass"));
			utente.setNomeUser(rs.getString("nomeUtente"));
			utente.setCognomeUser(rs.getString("cognomeUtente"));
			utente.setDatanascitaUser(rs.getString("dataNascita"));
			utente.setIndirizzoUser(rs.getString("indirizzo"));
			utente.setRuoloUser(rs.getString("ruolo"));
			utente.setPathNameFotoP(rs.getString("pathnameFotoU"));
			}
		}catch(SQLException e){
			return null;
		}
		
	}finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	return utente;
}
@Override
public UserBean doRetrieveByAdmin(String username) throws SQLException
{
	Connection connection = null;
	PreparedStatement ps = null;
	
	UserBean utente = new UserBean(); //Utente di appoggio
	
	String selectSQL = "SELECT * FROM " + UserModelDM.TABLE_NAME + " WHERE Username = ?";
	
	try {
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		
		ps.setString(1, username);
	
		try {
		ResultSet rs = ps.executeQuery();
		
		
		
		while(rs.next()) {
			
			utente.setCodFiscaleUser(rs.getString("codiceFiscale"));
			utente.setUsernameUser(rs.getString("username"));
			utente.setEmailUser(rs.getString("email"));
			utente.setPasswordUser(rs.getString("pass"));
			utente.setNomeUser(rs.getString("nomeUtente"));
			utente.setCognomeUser(rs.getString("cognomeUtente"));
			utente.setDatanascitaUser(rs.getString("dataNascita"));
			utente.setIndirizzoUser(rs.getString("indirizzo"));
			utente.setRuoloUser(rs.getString("ruolo"));
			utente.setPathNameFotoP(rs.getString("pathnameFotoU"));
			}
		}catch(SQLException e){
			return null;
		}
		
	}finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	return utente;
}
@Override
public Collection<UserBean> RetrieveAll() throws SQLException
{
	
	Connection connection = null;
	PreparedStatement ps = null;
	Collection<UserBean> utenti = new LinkedList<UserBean>(); //Prodotto di appoggio
	
	String selectSQL = "SELECT * FROM " + UserModelDM.TABLE_NAME ;
	
	try {
		connection = DBConnectionPool.getConnection(); 

		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		
		
		ResultSet rs = ps.executeQuery();
		
	
		
		while(rs.next()) {
			UserBean utente = new UserBean();
			
			utente.setCodFiscaleUser(rs.getString("codiceFiscale"));
			utente.setUsernameUser(rs.getString("username"));
			utente.setEmailUser(rs.getString("email"));
			utente.setPasswordUser(rs.getString("pass"));
			utente.setNomeUser(rs.getString("nomeUtente"));
			utente.setCognomeUser(rs.getString("cognomeUtente"));
			utente.setDatanascitaUser(rs.getString("dataNascita"));
			utente.setIndirizzoUser(rs.getString("indirizzo"));
			utente.setRuoloUser(rs.getString("ruolo"));
			utente.setPathNameFotoP(rs.getString("pathnameFotoU"));
			
			
			
			utenti.add(utente);
			
		}
		
	}finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	return utenti;
}



public void changePath (String percorso ,String username) throws SQLException
{
	
Connection connection = null;
PreparedStatement ps = null;

String insertSQL = "UPDATE utente SET pathNameFotoU = ?  WHERE username = ?";


try {
	connection = DBConnectionPool.getConnection(); 
	ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
	
	
	System.out.println("PRIMA Stringa SQL : " + insertSQL);
	
	ps.setString(1,percorso);
	ps.setString(2,username);
	
	ps.executeUpdate(); //esegue la Query di aggiornamento
	
	
	System.out.println("DOPO Stringa SQL : " + insertSQL);
	connection.commit();
		
}finally {

	try
		{
		if(ps != null)
		ps.close();
		}
	finally {
		DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
	}
}
}



public int checkUsername(String username) throws SQLException
{
	Connection connection = null;
	PreparedStatement ps = null;

	UserBean utente = new UserBean(); //Utente di appoggio
	String user = "";

	

	
	String selectSQL = "SELECT * FROM " + UserModelDM.TABLE_NAME + " WHERE Username = ?";
	
	try {
	
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		
		ps.setString(1, username);
		
		try {
		ResultSet rs = ps.executeQuery();
		
		
		
		while(rs.next()) {
			
			utente.setCodFiscaleUser(rs.getString("codiceFiscale"));
			utente.setUsernameUser(rs.getString("username"));
			utente.setEmailUser(rs.getString("email"));
			utente.setPasswordUser(rs.getString("pass"));
			utente.setNomeUser(rs.getString("nomeUtente"));
			utente.setCognomeUser(rs.getString("cognomeUtente"));
			utente.setDatanascitaUser(rs.getString("dataNascita"));
			utente.setIndirizzoUser(rs.getString("indirizzo"));
			utente.setRuoloUser(rs.getString("ruolo"));
			utente.setPathNameFotoP(rs.getString("pathnameFotoU"));
			}
		
	
		}catch(SQLException e){
			return -1;
		}
		
		user = utente.getUsernameUser();
		
		if( user == null)
		{
		
			return 0;
		}
		
	}finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	
	return 1;
}


public int checkEmail(String email) throws SQLException
{ 
	
	Connection connection = null;
	PreparedStatement ps = null;
	
	UserBean utente = new UserBean(); //Utente di appoggio


	

	
	String selectSQL = "SELECT * FROM " + UserModelDM.TABLE_NAME + " WHERE email = ?";
	
	try {
	
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		
		ps.setString(1, email);
		
		try {
		ResultSet rs = ps.executeQuery();
		
		
		
		while(rs.next()) {
			
			utente.setCodFiscaleUser(rs.getString("codiceFiscale"));
			utente.setUsernameUser(rs.getString("username"));
			utente.setEmailUser(rs.getString("email"));
			utente.setPasswordUser(rs.getString("pass"));
			utente.setNomeUser(rs.getString("nomeUtente"));
			utente.setCognomeUser(rs.getString("cognomeUtente"));
			utente.setDatanascitaUser(rs.getString("dataNascita"));
			utente.setIndirizzoUser(rs.getString("indirizzo"));
			utente.setRuoloUser(rs.getString("ruolo"));
			utente.setPathNameFotoP(rs.getString("pathnameFotoU"));
			}
		
		;
		}catch(SQLException e){
			return -1;
		}
		
		email = utente.getEmailUser();
		
		if( email == null)
		{
			
			return 2;
		}
		
	}finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	
	return 3;
}
}











