package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class DateControl
 */
@WebServlet("/DateControl")
public class DateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro nella servlet di control data");
		String data_inizio = request.getParameter("data_inizio");
		String data_fine = request.getParameter("data_fine");
		
		//Trasformo la Stringa data di inizio in un Oggetto "DATE"
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data_Inizio = null;
		try {
			data_Inizio = sdf.parse(data_inizio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trasformo la Stringa data fine in un Oggetto "DATE"
		
		Date data_Fine = null;
		try {
			data_Fine = sdf.parse(data_fine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Per Debug mi stampo le date
		
		

		
		
		request.getSession().setAttribute("dataInizio", data_Inizio);
		request.getSession().setAttribute("dataFine", data_Fine);
		
		
		System.out.println("Sono la stringa trasformata in data iniziale In Sessione di date" + request.getSession().getAttribute("dataInizio"));
		System.out.println("Sono la stringa trasformata in data finale In Sessione di Date" + request.getSession().getAttribute("dataFine"));
		
		
		RequestDispatcher view = request.getRequestDispatcher("OrdineControl");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public Date stringToDate(String dataString)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		try {
			data = sdf.parse(dataString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}


}
