package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductModelDM;
import model.ProductBean;
import model.UserBean;

/**
 * Servlet implementation class DeleteControl
 */
@WebServlet("/DeleteControl")
public class DeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModelDM model = new ProductModelDM(); 
       
   
    public DeleteControl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//stringa che determinerà il comportamento della nostra Servlet in base all'azione che vogliamo svolgere
        Collection<ProductBean> listaProdotti = null;
        /**
         * Rimozione di un prodotto al DB (OPERAZIONE lato AMMINISTRATORE)
         * ------------INIZIO-------------------
         */
 		
 			int id = Integer.parseInt(request.getParameter("id"));
 			String cod = request.getParameter("cod");
 	
             try {
 				model.doDelete(id,cod);
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
  
         
         /**
          * ----------FINE----------------
          */
 		
 		/**
         * Blocco di codice che ritorna la Lista prodotti e la rende visibile con modifiche apportate
         * 
         */
			try {
				listaProdotti =  model.doRetrieveAll(null);
				
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			
		request.setAttribute("listaProdotti", listaProdotti);
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		

	    
	    
	    
	    
	    
	    
		if(utente.getRuoloUser().equals("Amministratore")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaProdottiAdmin.jsp");
			dispatcher.forward(request, response);
            }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
