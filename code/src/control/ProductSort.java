package control;
import com.google.gson.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson; //Gson  per le risposte dinamiche

import dao.ProductModelDM;
import model.ProductBean;

/**
 * Servlet implementation class ProductSort
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce le operazioni che possiamo svolgere sulla nostra lista prodotti (lato visitatore)
 * Operazioni di filtro per i prodotti 
 * Viene richiamata da due JSP :(ListaProdotti )
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */

@WebServlet("/ProductSort")
public class ProductSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ProductModelDM usa il DriverManager	
		static ProductModelDM model = new ProductModelDM();  
    
    public ProductSort() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		Collection<ProductBean> listaProdotti = null;
		

        //stringa che determinerà il comportamento della nostra Servlet in base all'azione che vogliamo svolgere
      	
		/**
         * Blocco di codice che ritorna la Lista prodotti e la rende visibile con modifiche apportate
         * 
         */
		String sort = request.getParameter("sort");
		System.out.println("Sono il parametro passato" + sort);
		
		
			try {
				listaProdotti =  model.doRetrieveAll(sort);
				
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
				System.out.println("Genero questa eccezione");
			}
			System.out.println("ci sono1");
			//request.setAttribute("listaProdotti", listaProdotti);
			System.out.println("ci sono2");
			 String json = new Gson().toJson("JSON");
			//request.setAttribute("test", "testdelcod");
			if (listaProdotti != null && listaProdotti.size() != 0) {
				Iterator<?> it = listaProdotti.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
					System.out.println(bean.getNomeProdotto());
					
					
					
				}}
		
			
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaProdotti.jsp");
			dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
