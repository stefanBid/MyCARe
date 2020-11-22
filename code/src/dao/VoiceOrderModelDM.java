

package dao;
import control.DBConnectionPool;


import model.OrderBean;
import model.VoiceOrderBean;


import java.sql.Connection; //Connection gestita nel connnectionPool
import java.sql.PreparedStatement; // possono essere usati per creare query SQL parametriche e precompilate 
import java.sql.ResultSet;// L’oggetto ResultSet è il risultato di una query di selezione (SELECT)
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class VoiceOrderModelDM implements VoiceOrderModel {
	
	private static final String TABLE_NAME = "voceOrdine";//Tabella del DB dove andiamo ad operare
	
	
	@Override
	public synchronized void doSave(VoiceOrderBean VoceOrdine) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		String insertSQL = "INSERT INTO " + VoiceOrderModelDM.TABLE_NAME + " (quantita,prezzoAcquisto,codiceOrd,idPro,codPro) "
				+ " VALUES(?,?,?,?,?)";
		try {
			connection = DBConnectionPool.getConnection(); 
			ps = connection.prepareStatement(insertSQL); //Passiamo la query SQL
			
			
			ps.setInt(1,VoceOrdine.getQuantita());
			ps.setDouble(2,VoceOrdine.getPrezzoAcquisto());
			ps.setString(3,VoceOrdine.getCodiceOrdine());
			ps.setInt(4,VoceOrdine.getIdProdotto());
			ps.setString(5,VoceOrdine.getCodiceProdotto());

			
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
	public synchronized Collection<VoiceOrderBean> doRetrieveAllByKey(OrderBean Ordine) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		Collection<VoiceOrderBean> Voci = new LinkedList<VoiceOrderBean>(); //Prodotto di appoggio
		
		String selectSQL = "SELECT * FROM " + VoiceOrderModelDM.TABLE_NAME + " WHERE codiceOrd = ?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
	
			ps = connection.prepareStatement(selectSQL); //Passiamo la query SQL
			ps.setString(1, Ordine.getCodiceOrdine());		
			
			ResultSet rs = ps.executeQuery();
			
		
			
			while(rs.next()) {
				VoiceOrderBean VoceOrdine = new VoiceOrderBean();
				
				VoceOrdine.setCodiceVoce(rs.getInt("codiceVoce"));
				VoceOrdine.setQuantita(rs.getInt("quantita"));
				VoceOrdine.setPrezzoAcquisto(rs.getDouble("prezzoAcquisto"));
				VoceOrdine.setCodiceOrdine(rs.getString("codiceOrd"));
				VoceOrdine.setCodiceProdotto(rs.getString("codPro"));
				VoceOrdine.setIdProdotto(rs.getInt("idPro"));
				
				
				
				Voci.add(VoceOrdine);
				
			}
			
		}finally {
			try {
				if(ps != null)
					ps.close();
			}finally {
				DBConnectionPool.releaseConnection(connection); //Rilascio la connessione dal pool
			}
		}
		return Voci;
	}
}
