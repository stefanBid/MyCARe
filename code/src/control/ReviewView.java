package control;

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

import dao.ProductModelDM;
import dao.RecensioniModelDM;
import model.ProductBean;
import model.RecensioniBean;

/**
 * Servlet implementation class ReviewView
 */
@WebServlet("/ReviewView")
public class ReviewView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModelDM model = new ProductModelDM();
	static RecensioniModelDM model2 = new RecensioniModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<RecensioniBean> listaRecensioni = null;
		int idProdotto = Integer.parseInt(request.getParameter("idPro"));
		String codProdotto = request.getParameter("codPro");
		
		System.out.println("IDPRO " + idProdotto);
		System.out.println("CODPRO " + codProdotto);
		ProductBean prodotto = new ProductBean();
		try {
			
			prodotto = model.doRetrieveByKey(idProdotto, codProdotto);
			System.out.println(prodotto.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(prodotto.toString());
			listaRecensioni = model2.doRetrieveAll(prodotto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (listaRecensioni != null && listaRecensioni.size() != 0) {
			Iterator<?> it = listaRecensioni.iterator();
			while (it.hasNext()) {
				RecensioniBean bean = (RecensioniBean) it.next();
				System.out.println("Prodotto" + bean.toString());
			}
			}
		request.setAttribute("listaRecensioni", listaRecensioni);
		request.setAttribute("prodotto", prodotto);
		RequestDispatcher view = request.getRequestDispatcher("RecensioniProdotto.jsp");
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
