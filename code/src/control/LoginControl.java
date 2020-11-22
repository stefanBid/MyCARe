package control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import dao.UserModelDM;


/**
 * Servlet implementation class LoginControl
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

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserModelDM model = new UserModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
	
		
		
		if(!utente.isEmpty()) {
			RequestDispatcher view= request.getRequestDispatcher("AreaUtente.jsp");
			view.forward(request, response);
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		try {
			utente = model.doRetrieveByKey(username, password);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	
		if(utente.isEmpty()) //Nel caso l'utente non è presente nel Database oppure username o password sono errati
		{  
			
			
			String errorMessage="Username o Password errati!";
			request.setAttribute("errorMessage",errorMessage);
			request.getSession().setAttribute("utente",utente);
			
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		
		
		
		if(utente.getRuoloUser().equals("Amministratore"))/*Quindi esiste ed � un admin*/
		{
			String errorMessage="";
			request.setAttribute("errorMessage",errorMessage);
			request.getSession().setAttribute("utente", utente);
			RequestDispatcher view = request.getRequestDispatcher("ProductControlAdmin");
			view.forward(request, response);
		}
		
		
		if (utente.getRuoloUser().equals("Guest"))/*Quindi esiste ed � un utente normale*/
		{
			
			String errorMessage="";
			request.setAttribute("errorMessage",errorMessage);
			request.getSession().setAttribute("utente", utente);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
		
		
		
		
		

	}
	
	
	
	
		
}
