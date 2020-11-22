
/**
 * Gestiamo i prodotti nel nostro DB
 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */

package dao;
import control.DBConnectionPool;
import model.ProductBean;


import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class ProductModelDM implements ProductModel {
	
	private static final String TABLE_NAME = "prodotto"; //Tabella del DB dove andiamo ad operare
	
	@Override
	public synchronized void doSave(ProductBean prodotto) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME + " (idProdotto,codProdotto,stato,nomeProdotto,descrizione,prezzoProdotto,categoria,pathNameFotoP,quantitaMagazzino) "
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			ps.setInt(1,prodotto.getIdProdotto());
			ps.setString(2, prodotto.getCodProdotto());
			ps.setString(3,prodotto.getStatoIva());
			ps.setString(4,prodotto.getNomeProdotto());
			ps.setString(5,prodotto.getDescrizione());
			ps.setDouble(6, prodotto.getPrezzoProdotto());
			ps.setString(7, prodotto.getCategoria());
			ps.setString(8, prodotto.getPathNameFotoP());
			ps.setInt(9, prodotto.getQuantitaMagazzino());
			
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
	public synchronized boolean doDelete(int id,String codProdotto) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		
		int result = 0; //Flag di controllo 
		String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE idProdotto = ? AND codProdotto = ?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(deleteSQL); //Passiamo la query SQL
			ps.setInt(1, id);
			ps.setString(2, codProdotto);
			
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
	public synchronized ProductBean doRetrieveByKey(int id, String codProdotto) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		
		ProductBean prodotto = new ProductBean(); //Prodotto di appoggio
		
		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE idProdotto = ? AND codProdotto = ?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			ps.setInt(1, id);
			ps.setString(2, codProdotto);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto.setIdProdotto(rs.getInt("idProdotto"));
				prodotto.setCodProdotto(rs.getString("codProdotto"));
				prodotto.setStatoIva(rs.getString("stato"));
				prodotto.setNomeProdotto(rs.getString("nomeProdotto"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setPrezzo(rs.getDouble("prezzoProdotto"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setPathNameFotoP(rs.getString("pathNameFotoP"));
				prodotto.setQuantitaMagazzino(rs.getInt("quantitaMagazzino"));
				
			}
			
		}finally {
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		return prodotto;
	}
	
	@Override
	public synchronized Collection<ProductBean> doRetrieveAll(String order) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		Collection<ProductBean> listaProdotti = new LinkedList<ProductBean>();
		
		String selectSQL = " SELECT * FROM " + ProductModelDM.TABLE_NAME;
		
		if (order != null && !order.contentEquals("")) {
			selectSQL += " ORDER BY " + "("+order+")";
		}
		
		try {
			
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductBean prodotto = new ProductBean();
				
				prodotto.setIdProdotto(rs.getInt("idProdotto"));
				prodotto.setCodProdotto(rs.getString("codProdotto"));
				prodotto.setStatoIva(rs.getString("stato"));
				prodotto.setNomeProdotto(rs.getString("nomeProdotto"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setPrezzo(rs.getDouble("prezzoProdotto"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setPathNameFotoP(rs.getString("pathNameFotoP"));
				prodotto.setQuantitaMagazzino(rs.getInt("quantitaMagazzino"));
				
				listaProdotti.add(prodotto);
				
				
			}
			
		}finally {
			
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		
		return listaProdotti;
	}
	
	
	@Override
	public synchronized void doUpdateQuantity(int idProdotto,String codProdotto,int newQuantity) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		ProductBean prodotto = doRetrieveByKey(idProdotto,codProdotto);
		int quantita = (prodotto.getQuantitaMagazzino()-newQuantity);
		
		
		String updateSQL = "UPDATE "+ ProductModelDM.TABLE_NAME+" SET quantitaMagazzino= ? WHERE idProdotto = ? AND codProdotto = ?"; 
		
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(updateSQL); //Passiamo la query SQL
			ps.setInt(1,quantita);
			ps.setInt(2,idProdotto );
			ps.setString(3, codProdotto);
			
			ps.executeUpdate();
			
		}finally {
			
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		
		
	}
	public void addPhoto(String codProdotto ,int idProdotto,String nomeFoto) throws SQLException
	{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
	
		String insertSQL = "UPDATE prodotto SET pathNameFotoP = ?  WHERE codProdotto = ? AND idProdotto = ?";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			ps.setString(1,nomeFoto);
			ps.setString(2,codProdotto);
			ps.setInt(3,idProdotto);
			
		

			
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
	
}
