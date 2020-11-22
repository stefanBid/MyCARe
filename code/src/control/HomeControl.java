package control;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeControl
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce il Menù navigazionale del nostro sito
 * Viene richiamata dall'Header del sito: Header.html
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */


@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeControl() {
        super();
    }
        

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bott1 = request.getParameter("bott1");
		String bott2 = request.getParameter("bott2");
		String bott3 = request.getParameter("bott3");
		
		if(bott1!=null) {
			request.setAttribute("b1", bott1);
			RequestDispatcher view = request.getRequestDispatcher("ProductControl?b1=si");
			view.forward(request, response);
		}
		
		if(bott2!=null) {
			request.setAttribute("b2", bott2);
			RequestDispatcher view = request.getRequestDispatcher("ProductControl?b2=si");
			view.forward(request, response);
		}
		
		if(bott3!=null) {
			request.setAttribute("b3", bott3);
			RequestDispatcher view = request.getRequestDispatcher("CarrelloControl");
			view.forward(request, response);
		}
		
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
