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
import java.util.*;
import dao.*;


/**
* Servlet implementation class OrdineControl
* 
* ------------------------------------------------------------
* 
* Questa servlet gestisce la lista degli ordini di un utente (lato visitatore)
* Viene richiamata dalla JSP :(AreaUtente)
* 
* -------------------------------------------------------------
* 
*
*  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
*  
*/




@WebServlet("/OrdineControl")
public class OrdineControl extends HttpServlet {
	
	// ProductModelDM usa il DriverManager	
		static OrderModelDM model = new OrderModelDM();
		
	private static final long serialVersionUID = 1L;
	static UserModelDM model1 = new UserModelDM();
	static VoiceOrderModelDM model2 = new VoiceOrderModelDM();
	static ProductModelDM model3 = new ProductModelDM();
	static IvaModelDM model4 = new IvaModelDM();
    public OrdineControl() {
        super();
        
    }

    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<OrderBean> ordini =null;
		Collection<Double> costoOrdini = new LinkedList<Double>();
		UserBean ruoloUser = (UserBean) request.getSession().getAttribute("utente");
		System.out.println("Sono l'utente" + ruoloUser.toString());
		Collection<UserBean> utenti = new LinkedList<UserBean>();
		try {
			utenti = model1.RetrieveAll();
			request.setAttribute("utenti", utenti);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
 		String ruolo = ruoloUser.getRuoloUser(); 
		//Controllo Amministratore
		if(ruolo.equals("Amministratore"))
		{
			System.out.println("Sono Un ADMIN");
			String username = request.getParameter("search_utente");
			try {
				UserBean utenteTrovato = model1.doRetrieveByAdmin(username);
				ordini =  model.doRetrieveByKey(utenteTrovato);
				System.out.println("Sono l'utente cercato" + utenteTrovato.toString());
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			costoOrdini = OrderToPrice(ordini);
			
			request.setAttribute("ordini", ordini);
			request.setAttribute("costoOrdini", costoOrdini);
			RequestDispatcher view = request.getRequestDispatcher("/OrdiniAdmin.jsp");
			view.forward(request, response);
		}
		
		
		//Fine Controllo Amministratore
		try {
			UserBean utente = (UserBean) request.getSession().getAttribute("utente");
			ordini =  model.doRetrieveByKey(utente);
			}
		
		 catch(SQLException e){
			 System.out.println("Error:" + e.getMessage());
		 }
		costoOrdini = OrderToPrice(ordini);
		request.setAttribute("ordini", ordini);
		request.setAttribute("costoOrdini", costoOrdini);
		
		RequestDispatcher view = request.getRequestDispatcher("/OrdiniUser.jsp");
		view.forward(request, response);
		
		
		
		
		
	}
	
	
	
	
	







	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public double totaleOrdine(OrderBean ordine)
	{
		double risultato = 0.0;
		try {
			Collection<VoiceOrderBean> voceOrdini = model2.doRetrieveAllByKey(ordine);
			 Iterator<?> it = voceOrdini.iterator();
			  
	          while (it.hasNext()) {
	              VoiceOrderBean voce = (VoiceOrderBean) it.next();
	              
	              ProductBean prodotto = model3.doRetrieveByKey(voce.getIdProdotto(),voce.getCodiceProdotto());
	              IvaBean ivaProdotto = model4.doRetrieveIvaByProduct(prodotto);
	              double iva = ivaProdotto.getValore();
	              
	              risultato = risultato + voce.getPrezzoAcquisto() * (1+iva/100);
	          }
	          
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return risultato;
	}
	
	public Collection <Double> OrderToPrice(Collection<OrderBean> ordini)
	{
		Collection<Double> costoOrdini = new LinkedList<Double>();
		if (ordini != null && ordini.size() != 0) {
			Iterator<?> it = ordini.iterator();
			Iterator<?> it1 = costoOrdini.iterator();
			while (it.hasNext()) {
				OrderBean bean = (OrderBean) it.next();
				
				Double prezzo = totaleOrdine(bean);
				costoOrdini.add(prezzo);
			}	}
		return costoOrdini;
	}
	
	
	

}
