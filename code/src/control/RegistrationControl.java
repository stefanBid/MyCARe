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
 * Servlet implementation class RegistrationControl
 */
@WebServlet("/RegistrationControl")
public class RegistrationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UserModelDM model=new UserModelDM();
       
    
    public RegistrationControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
    
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String email = request.getParameter("email");
		String data= request.getParameter("data");
		String indirizzo = request.getParameter("indirizzo");
		String codice = request.getParameter("codice");
		String ruolo="Guest";
		
		UserBean utente= new UserBean();
		
		utente.setUsernameUser(username);
		utente.setPasswordUser(password);
		utente.setNomeUser(nome);
		utente.setCognomeUser(cognome);
		utente.setEmailUser(email);
		utente.setDatanascitaUser(data);
		utente.setIndirizzoUser(indirizzo);
		utente.setCodFiscaleUser(codice);
		utente.setRuoloUser(ruolo);
		
		
		try {
			if(model.doRetrieveByKey(username,password).isEmpty()==false) {

				response.sendRedirect(request.getContextPath()+"/UtentePresente.jsp");
				
				
				}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			model.doSave(utente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("UserControl");
		view.forward(request, response);
		
		
		
		
	}

	
	
	
	
	
}
