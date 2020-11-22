package control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductModelDM;
import model.ProductBean;


/**
 * Servlet implementation class DetailsControl
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce la visualizzazione del nostro prodotto nel dettaglio
 * Viene richiamata da una JSP :(ListaProdotti)
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */


@WebServlet("/DetailsControl")
public class DetailsControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ProductModelDM usa il DriverManager	
		static ProductModelDM model = new ProductModelDM();
		
    public DetailsControl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int id = Integer.parseInt(request.getParameter("id"));
		String cod = request.getParameter("cod");
		ProductBean bean = null;
		
		
		/**
         * Preleva i dati dal database dello specifico prodotto selezionato
         */

		try {
			bean = model.doRetrieveByKey(id, cod);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("prodotto", bean);
		
		RequestDispatcher view = request.getRequestDispatcher("ProdottoDettaglio.jsp");
		view.forward(request, response);
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
