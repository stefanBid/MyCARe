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
import dao.RecensioniModelDM;
import model.ProductBean;
import model.RecensioniBean;
import model.UserBean;
/**
 * Servlet implementation class RecensioniControl
 */
@WebServlet("/RecensioniControl")
public class RecensioniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RecensioniModelDM model = new RecensioniModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecensioniControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recensione = request.getParameter("recensione");
		RecensioniBean review = new RecensioniBean();
		review.setFeedback(recensione);
		
		int id = Integer.parseInt(request.getParameter("idProdotto"));
		String cod = request.getParameter("codProdotto");
		review.setCodiceProdottoFeedback(cod);
		review.setIdProdottoFeedback(id);
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		String nomeUtente = utente.getUsernameUser();
		
		review.setUser(nomeUtente);
		try {
			model.doSave(review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("RecensioneEffettuata.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
