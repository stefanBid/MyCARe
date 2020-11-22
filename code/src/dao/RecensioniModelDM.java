package dao;
import control.DBConnectionPool;
import model.IvaBean;
import model.ProductBean;
import model.RecensioniBean;


import java.util.*;

import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;



/**
 * Servlet implementation class UserModelDM
 */

public class RecensioniModelDM implements RecensioniModel {
private static final String TABLE_NAME = "feedback"; //Tabella del DB dove andiamo ad operare
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecensioniModelDM() {
        super();
        // TODO Auto-generated constructor stub
    }

@Override   
public synchronized void doSave(RecensioniBean recensione) throws SQLException{
		System.out.println("SONO L'UTENTE DELLA RECENSIONE" + recensione.getUser());
		Connection connection = null;
		PreparedStatement ps = null;
		System.out.println("SONO IL SEOCNDO OGGETTO");
		System.out.println(recensione.toString());
		String insertSQL = "INSERT INTO " + RecensioniModelDM.TABLE_NAME + " (codiceFeedback,stelle,dataFeedback,testo, usern,idPro,codPro) "
				+"VALUES(?,?,?,?,?,?,?)";
		
		System.out.println("SOno la query");
		System.out.println(insertSQL);
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			
			ps.setInt(1,recensione.getCodiceFeedback());
			ps.setInt(2,recensione.getValutazione());
			ps.setString(3,null);
			ps.setString(4,recensione.getFeedback());
			ps.setString(5,recensione.getUser());
			ps.setInt(6,recensione.getIdProdottoFeedback());
			ps.setString(7,recensione.getCodiceProdottoFeedback());
			
			
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




public synchronized RecensioniBean doRetrieveFeedByProduct(ProductBean prodotto) throws SQLException{
	System.out.println("sono entrato nella funzione");
	
	Connection connection = null;
	PreparedStatement ps = null;
	RecensioniBean recensione=new RecensioniBean();
	
	
	String selectSQL = "SELECT * FROM mycare." + RecensioniModelDM.TABLE_NAME + " WHERE  idProdotto = ? AND codProdotto=? ";
	
	try {
		connection = DBConnectionPool.getConnection(); 
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
		ps.setInt(1,prodotto.getIdProdotto());
		ps.setString(2,prodotto.getCodProdotto());
		try {
		
		ResultSet rs = ps.executeQuery();
		
	
		recensione.setCodiceFeedback(rs.getInt("codiceFeedback"));
		recensione.setValutazione(rs.getInt("stelle"));
		recensione.setDataFeedback(rs.getString(" dataFeedback"));
		recensione.setFeedback(rs.getString("testo"));
		recensione.setUser(rs.getString("usern"));
		recensione.setIdProdottoFeedback(rs.getInt("idPro"));
		recensione.setCodiceProdottoFeedback(rs.getString("codPro"));
		
		
		}
		
		catch (SQLException e) {
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
	
	
	return recensione;
}

public Collection<RecensioniBean> doRetrieveAll(ProductBean prodotto) throws SQLException
{
	Connection connection = null;
	PreparedStatement ps = null;
	
	Collection<RecensioniBean> listaRecensioni = new LinkedList<RecensioniBean>();
	System.out.println("Sono il codice del rpdotto passato " + prodotto.getCodProdotto());
	
	String selectSQL = " SELECT * FROM " + RecensioniModelDM.TABLE_NAME +" WHERE codPro = ?";
	System.out.println("Sono la select " + selectSQL);
	
	
	
	try {
		
		connection = DBConnectionPool.getConnection(); 
		
		ps = connection.prepareStatement(selectSQL); //Passiamo la query SQLs
		ps.setString(1,prodotto.getCodProdotto());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			RecensioniBean recensione = new RecensioniBean();
			
			recensione.setCodiceFeedback(rs.getInt("codiceFeedback"));
			recensione.setValutazione(rs.getInt("stelle"));
			recensione.setDataFeedback(rs.getString("dataFeedback"));
			recensione.setFeedback(rs.getString("testo"));
			recensione.setUser(rs.getString("usern"));
			recensione.setIdProdottoFeedback(rs.getInt("idPro"));
			recensione.setCodiceProdottoFeedback(rs.getString("codPro"));
			
	
			
			listaRecensioni.add(recensione);
			
			
		}
		
	}finally {
		
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
	
	return listaRecensioni;
}
}