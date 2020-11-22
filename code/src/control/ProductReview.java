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
import model.ProductBean;

/**
 * Servlet implementation class ProductReview
 */
@WebServlet("/ProductReview")
public class ProductReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModelDM model = new ProductModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod_Prodotto = request.getParameter("codPro");
		int id_Prodotto = Integer.parseInt(request.getParameter("idPro"));
		System.out.println("codice" + cod_Prodotto);
		System.out.println("id" + id_Prodotto);
		ProductBean prodotto =  new ProductBean();
		try {
			 prodotto = model.doRetrieveByKey(id_Prodotto, cod_Prodotto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prodotto", prodotto);
		
		RequestDispatcher view = request.getRequestDispatcher("stelle.jsp");
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
