package dao;
import control.DBConnectionPool;
import model.*;


import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Servlet implementation class IvaModelDM
 */

public class IvaModelDM implements IvaModel {
	private static final String TABLE_NAME = "iva";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IvaModelDM() {
        super();
        // TODO Auto-generated constructor stub
    }


		
	
	@Override
	public synchronized IvaBean doRetrieveIvaByProduct(ProductBean prodotto) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		String stato = prodotto.getStatoIva(); //Utente di appoggio
		IvaBean iva = new IvaBean();
		String selectSQL = "SELECT * FROM " + "iva" + " WHERE statoIva = ? ";
		
		
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			
			ps.setString(1, stato);
			 
			try {
				ResultSet rs = ps.executeQuery();

				if(rs.next()){
				
					
			

				 iva.setStatoIva(rs.getString("statoIva"));
						 iva.setValore(rs.getDouble("valore"));
				}
					System.out.println(iva.toString());
				}catch(SQLException e){
					
					System.out.println("VADO QUI");
					e.printStackTrace();
					return null;
				}
				
	finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
		return iva;
	}
	
	@Override
	public synchronized IvaBean doRetrieveIvaByString(String stato) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		
		IvaBean iva = new IvaBean();
		String selectSQL = "SELECT * FROM " + "iva" + " WHERE statoIva = ? ";
		
		
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			
			ps.setString(1, stato);
			 
			try {
				ResultSet rs = ps.executeQuery();

				if(rs.next()){
				
					
			

				 iva.setStatoIva(rs.getString("statoIva"));
						 iva.setValore(rs.getDouble("valore"));
				}
					System.out.println(iva.toString());
				}catch(SQLException e){
					
					System.out.println("VADO QUI");
					e.printStackTrace();
					return null;
				}
				
	finally {
		try {
			if(ps != null)
				ps.close();
		}finally {
			DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
		}
	}
		return iva;
	}
	
}
	
		
	

