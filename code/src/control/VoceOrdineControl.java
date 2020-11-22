package control;

import java.io.IOException;
import java.sql.SQLException;

import dao.*;
import model.IvaBean;
import model.OrderBean;
import model.ProductBean;
import model.VoiceOrderBean;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoceOrdineControl
 * 
 * ------------------------------------------------------------
* 
* Questa servlet gestisce un ordine nel dettaglio (lato visitatore)
* Viene richiamata dalla JSP :(OrdiniUser)
* 
* -------------------------------------------------------------
* 
*
*  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 */


@WebServlet("/VoceOrdineControl")
public class VoceOrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static VoiceOrderModelDM model = new VoiceOrderModelDM();
	static IvaModelDM model2 = new IvaModelDM();
	static ProductModelDM model1   = new ProductModelDM();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	   public VoceOrdineControl() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<VoiceOrderBean> vociOrdini = null;
		Collection<ProductBean> voceProdotti = new LinkedList<ProductBean>();
		Collection<IvaBean> ivaProdotti=new LinkedList<IvaBean>();
		
		
		
	
		OrderBean ordine = new OrderBean();
		request.setAttribute("numeroFattura",request.getParameter("numeroFattura"));
		
		System.out.println("SONO IL NUMERO DI FATTURA" + request.getParameter("numeroFattura"));
		request.setAttribute("ordine", ordine);
		ordine.setCodiceOrdine(request.getParameter("codOrdine"));
		request.setAttribute("codiceOrdine", ordine.getCodiceOrdine());
		ordine.setUsername(request.getParameter("usern"));
		ordine.setDescrizione(request.getParameter("descrizione"));
		System.out.println("CIAO SONO LA DATA " + ordine.getDataOrdine());
		ordine.setDataOrdine(request.getParameter("data"));
		System.out.println("Sono il request da ta ordine" + request.getParameter("DataOrdine"));

	try {
		System.out.println("QUI");
		vociOrdini = model.doRetrieveAllByKey(ordine);//VociOrdini è l'insieme delle voci di Ordine
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
	
	request.setAttribute("voceProdotti", voceProdotti);
	request.setAttribute("ivaProdotti", ivaProdotti);
	request.setAttribute("vociOrdini",vociOrdini);


	RequestDispatcher view = request.getRequestDispatcher("VoceOrdine.jsp");
	view.forward(request, response);
	}

	
	
	
	
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
