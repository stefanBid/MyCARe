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
import model.Carrello;

import dao.ProductModelDM;


/**
 * Servlet implementation class CarrelloDelete
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce l'eliminazione di uno o più prodotti dal nostro carrello
 * Viene richiamata dalla JSP :(Carrello)
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */


@WebServlet("/CarrelloDelete")
public class CarrelloDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static ProductModelDM model = new ProductModelDM();   
    
    public CarrelloDelete() {
        super();
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /**
         * Ricavo le informazioni cruciali per identificare il prodotto da eliminare
         * 
         */
		int id = Integer.parseInt(request.getParameter("id"));
		String cod = request.getParameter("cod");
		
		ProductBean prodotto = null;
		
		try {
			prodotto = model.doRetrieveByKey(id, cod);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		/**
         * Una volta identificato il prodotto lo elimino da carrello
         * e aggiorno la sessione per avere modifiche in tempo reale
         */
		Carrello carrello = (Carrello)request.getSession().getAttribute("carrello");
				
				
		carrello.eliminaProdotto(prodotto);
		request.getSession().setAttribute("carrello", carrello);
		
		RequestDispatcher view = request.getRequestDispatcher("CarrelloControl");
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
