package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstremiModelDM;
import model.EstremiBean;
import model.UserBean;

/**
 * Servlet implementation class EstremiControl
 * Gestisce il salvataggio di dati sensibili quali quelli di una carta di credito
 */
@WebServlet("/EstremiControl")
public class EstremiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      //EstremiModelDM usa il DriverManager
	static EstremiModelDM model = new EstremiModelDM();
   
    public EstremiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		String user = utente.getUsernameUser();		
		String intestatario = request.getParameter("intestatario");
		String numeroCarta = request.getParameter("numeroCarta");
		
		String scadenza = request.getParameter("scadenza");
		
		int cvv = 0;
		if(request.getParameter("cvv")=="") {
			cvv =0;
		}else{
			cvv = Integer.parseInt(request.getParameter("cvv"));
		}
		EstremiBean carta = new EstremiBean();
		carta.setUserCarta(user);
		carta.setCodiceCarta(numeroCarta);
		carta.setIntestatario(intestatario);
		carta.setScadenza(scadenza);
		carta.setCvv(cvv);
		
		try {
			model.doSave(carta);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		RequestDispatcher view = request.getRequestDispatcher("AreaUtente.jsp");
		view.forward(request, response);
		 
		
	}

}
