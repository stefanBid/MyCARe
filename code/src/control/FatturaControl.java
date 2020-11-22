package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import model.IvaBean;
import model.ProductBean;
import model.VoiceOrderBean;
import model.OrderBean;
/**
 * Servlet implementation class FatturaControl
 */
@WebServlet("/FatturaControl")
public class FatturaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static VoiceOrderModelDM model = new VoiceOrderModelDM();
	static IvaModelDM model2 = new IvaModelDM();
	static ProductModelDM model1   = new ProductModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FatturaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<VoiceOrderBean> vociOrdini = null;
		Collection<IvaBean> ivaProdotti=new LinkedList<IvaBean>();
		Collection<ProductBean> voceProdotti = new LinkedList<ProductBean>();
		
		OrderBean Ordine = new OrderBean();
		
		Ordine.setCodiceOrdine(request.getParameter("CodiceOrdine"));
		Ordine.setDataOrdine(request.getParameter("DataOrdine"));
		Ordine.setDescrizione(request.getParameter("DescrizioneOrdine"));
		Ordine.setUsername(request.getParameter("UsernameOrdine"));
		
		try {
			System.out.println("QUI");
			vociOrdini = model.doRetrieveAllByKey(Ordine);//VociOrdini è l'insieme delle voci di Ordine
			if(vociOrdini!=null) {
				System.out.println(vociOrdini.size());
			}
			Iterator<?> it = vociOrdini.iterator();
			  
	          while (it.hasNext()) {
	              VoiceOrderBean voce = (VoiceOrderBean) it.next();
	           
	              ProductBean prodotto = model1.doRetrieveByKey(voce.getIdProdotto(), voce.getCodiceProdotto());
	              System.out.println("Prodotto =" + prodotto.toStringProdotto());
	              IvaBean iva = model2.doRetrieveIvaByProduct(prodotto);
	             /*Test delal stampa funzionante*/ System.out.println("Iva =" + iva.getValore());
	              voceProdotti.add(prodotto);
	              ivaProdotti.add(iva);
	              }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		System.out.println("SONO IL NUMERO DI FATTURA FINALE" + request.getParameter("numeroFattura"));
		request.setAttribute("voceProdotti", voceProdotti);
		request.setAttribute("ivaProdotti", ivaProdotti);
		request.setAttribute("vociOrdini",vociOrdini);
		request.setAttribute("Ordine", Ordine);
		request.setAttribute("numeroFattura", request.getParameter("numeroFattura"));
		RequestDispatcher view = request.getRequestDispatcher("Fattura.jsp");
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
