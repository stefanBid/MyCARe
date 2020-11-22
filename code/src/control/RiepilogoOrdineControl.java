package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstremiModelDM;

import dao.IvaModelDM;
import model.EstremiBean;
import model.IvaBean;
import model.ProductBean;
import model.UserBean;
import model.Carrello;


/**
 * Servlet implementation class RiepilogoOrdineControl
 */
@WebServlet("/RiepilogoOrdineControl")
public class RiepilogoOrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EstremiModelDM model1  = new EstremiModelDM();
	static IvaModelDM model2 = new IvaModelDM();
    
    public RiepilogoOrdineControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		Double totale = 0.0;
		IvaBean iva = null;
		
		for(ProductBean bean : cart.getCarrello()){ 
			try {
				iva = model2.doRetrieveIvaByProduct(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			totale = totale +(bean.getPrezzoProdotto()*(1+(iva.getValore()/100)));
			
		}
		NumberFormat nf = new DecimalFormat("0.00");
		String tot = nf.format(totale);
		
		request.getSession().setAttribute("totale", tot);
		
		
		
		Collection<EstremiBean>  listaCarte = null;
		if(utente.getUsernameUser()!=null) {
			try {
				listaCarte = model1.doRetrieveByKey(utente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	
		
		request.setAttribute("totale",totale );
		request.setAttribute("listaCarte", listaCarte);
		RequestDispatcher view = request.getRequestDispatcher("/RiepilogoOrdine.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
