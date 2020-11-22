package control;

/**
 * In questa classe gestiamo la connessione al Database tramite Connection Pool

 * @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBConnectionPool {
	
	/**
	 * Lista di connessioni al DataBase
	 * 
	 * 		###INIZIO###
	 */
	
	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	
	
	
	
	
	/**
	 * Genera una connessione al nostro Database
	 * @return nuova connessione da ggiungere al pool
	 * @throws SQLException se la connessione non si genera
	 */
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "127.0.0.1";
		String port = "3306";
		String db = "MyCare"; //nel caso sostituire con storage se non si connette
		String username = "root";
		String password = "Berau99!";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);

		newConnection.setAutoCommit(false);
		return newConnection;
	}
	
	
	/**
	 * Preleva la connessione dalla lista se è presente, altrimenti la crea
	 * @return la connessione
	 * @throws SQLException se non riesce a prelevarla
	 */
	
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}
	
	
	/**
	 * Aggiunge la connessione  al pool delle connesioni libere
	 * @param connection
	 * @throws SQLException se non riesco ad eseguire l'operazione
	 */
	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}
	
	
	
}
