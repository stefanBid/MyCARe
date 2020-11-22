package control;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;




/**
 * Servlet implementation class UserControl
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce l'accesso al nostro sito da parte degli utenti e da parte dell'amministratore
 * Viene richiamata da due JSP :()
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */

@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");

		if(utente == null) {
			
			String errorMessage="";
			request.setAttribute("errorMessage", errorMessage);
			utente = new UserBean();
			request.getSession().setAttribute("utente", utente);
			RequestDispatcher view= request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		
		
		if(!utente.isEmpty()) {
			RequestDispatcher view= request.getRequestDispatcher("AreaUtente.jsp");
			view.forward(request, response);
		}
		
		
		
	
		if(utente.isEmpty()) //Nel caso l'utente non è presente nel Database oppure username o password sono errati
		{  
			
			
			String errorMessage="";
			request.setAttribute("errorMessage",errorMessage);
			request.getSession().setAttribute("utente",utente);
			
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		

	}
	
	
	
	
		
}
