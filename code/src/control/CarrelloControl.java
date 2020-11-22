package control;

import java.io.IOException;



import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductBean;
import model.UserBean;
import model.Carrello;


import dao.ProductModelDM;


/**
 * Servlet implementation class CarrelloControl
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce la visualizzazione del nostro carrello in tutti i suoi possibili Stati
 * Viene richiamata dalle JSP :(Listaprodotti,ProdottoDettaglio)
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */


@WebServlet("/CarrelloControl")
public class CarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDM usa il DriverManager	
	static ProductModelDM model = new ProductModelDM();
	
	
    public CarrelloControl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductBean prodotto = null;
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		if(utente==null) {
			utente = new UserBean();
			request.getSession().setAttribute("utente",utente);
			
		}
		
		/**
         * Il carrello viene aggiunto alla sessione,
         * e creato all'occorrenza se non esiste
         */

		Carrello carrello = (Carrello)request.getSession().getAttribute("carrello");
		if(carrello ==null) {
			carrello = new Carrello();
			request.getSession().setAttribute("carrello", carrello);
		}
        


        /**
         * Questo blocco di codice viene eseguito soltanto quando eliminiamo un prodotto dal nostro carrello
         * in questo modo le eliminazioni sono visibili in tempo reale e senza aggiornare la pagina
         * -------INIZIO--------
         */

		if(request.getParameter("id")==null || request.getParameter("cod")==null ||request.getParameter("quantita")==null ) {
			
			request.getSession().setAttribute("carrello", carrello);
			request.setAttribute("carrello", carrello);
			RequestDispatcher view = request.getRequestDispatcher("/Carrello.jsp");
			view.forward(request, response);
		}
        

        /**
         * --------FINE---------
         */
        
        
         

        /**
         * Sezione di codice dove si gestiosce l'aggiunta di un nuovo prodotto al carrello
         * Aggiornamento del carrello presente nella nostra sessione in modo tale da vedere 
         * le modifiche apportate
         * 
         * ---------INIZIO---------
         */
		if(request.getParameter("id")!=null || request.getParameter("cod")!=null ||request.getParameter("quantita")!=null ) {
		int id = Integer.parseInt(request.getParameter("id").trim());
		String cod = request.getParameter("cod");
		int quantita = Integer.parseInt(request.getParameter("quantita").trim());
		
		
		try {
			prodotto = model.doRetrieveByKey(id, cod);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		carrello.aggiungiProdotto(prodotto, quantita);
		request.getSession().setAttribute("carrello", carrello);
		request.setAttribute("carrello", carrello);
		}
        /**
         * ----------FINE----------
         */
		
	
		RequestDispatcher view = request.getRequestDispatcher("/Carrello.jsp");
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
