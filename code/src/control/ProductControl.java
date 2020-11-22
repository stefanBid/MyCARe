package control;
import dao.*;

 //Gestione Entita Prodotto nel DB


import java.io.IOException;
import java.sql.SQLException;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductBean; //bean che gestisce un singolo prodotto

/**
 * Servlet implementation class ProductControl
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce le operazioni che possiamo svolgere sulla nostra lista prodotti (lato visitatore e lato amministratiìore)
 * Viene richiamata da due JSP :(ListaProdotti e ListaProdottiAdmin)
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */



@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ProductModelDM usa il DriverManager	
	static ProductModelDM model = new ProductModelDM();
	
	
    public ProductControl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sort = request.getParameter("sort");
		
		Collection<ProductBean> listaProdotti = null;
		

        //stringa che determinerà il comportamento della nostra Servlet in base all'azione che vogliamo svolgere
      	
		/**
         * Blocco di codice che ritorna la Lista prodotti e la rende visibile con modifiche apportate
         * 
         */
			try {
				listaProdotti =  model.doRetrieveAll(sort);
				
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			
		request.setAttribute("listaProdotti", listaProdotti);
        
        


		
		
         
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaProdotti.jsp");
		dispatcher.forward(request, response);
        
        /**
         * 
         * -----------FINE------------------
         */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}