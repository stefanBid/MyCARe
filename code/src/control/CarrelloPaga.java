package control;

import java.io.IOException;


import java.sql.SQLException;
import java.util.*;
import java.text.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.Carrello;
import model.OrderBean;
import model.ProductBean;
import model.UserBean;
import model.VoiceOrderBean;

/**
 * Servlet implementation class CarrelloPaga
 * 
 * ------------------------------------------------------------
 * 
 * Questa servlet gestisce un cech che simula il pagamento di un ordine 
 * Viene richiamata dalla JSP :(Carrello)
 * 
 * -------------------------------------------------------------
 * 
 *
 *  @author MyCARe group (Alfonso D'Amiano, Antonio Cappabianca, Stefano Biddau)
 *  
 */


@WebServlet("/CarrelloPaga")
public class CarrelloPaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModelDM model = new ProductModelDM();
	static OrderModelDM model1 = new OrderModelDM();
	static VoiceOrderModelDM model2 = new VoiceOrderModelDM();
	static EstremiModelDM model3 = new EstremiModelDM();
       
    
    public CarrelloPaga() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				doPost(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /**
         * Recupero il mio carrello dalla sessione e per ogni prodotto presente in esso
         * vado ad eseguire un opportuna Query sql che aggiorni le quantità in magazzino del prodotto
         */
		Carrello carrello = (Carrello)request.getSession().getAttribute("carrello");
		
		int i = 0;
		
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data  = (String) sdf.format(d);
		
		OrderBean ordine = new OrderBean();
		ordine.setCodiceOrdine(utente.getCodFiscaleUser()+d.getTime());
		
		ordine.setUsername(utente.getUsernameUser());
		ordine.setDescrizione("ARTICOLI ACQUISTATI");
		ordine.setDataOrdine(data);
		
		try {
			model1.doSave(ordine);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(ProductBean prodotto : carrello.getCarrello()) {
			
			try {
				model.doUpdateQuantity(prodotto.getIdProdotto(), prodotto.getCodProdotto(), carrello.getQuantita().get(i));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			VoiceOrderBean voceOrdine = new VoiceOrderBean();
			
			voceOrdine.setQuantita(carrello.getQuantita().get(i));
			voceOrdine.setPrezzoAcquisto(prodotto.getPrezzoProdotto());
			voceOrdine.setIdProdotto(prodotto.getIdProdotto());
			voceOrdine.setCodiceProdotto(prodotto.getCodProdotto());
			voceOrdine.setCodiceOrdine(ordine.getCodiceOrdine());
			
			try {
				model2.doSave(voceOrdine);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
		}
        
		
        /**
         * Una volta svuotato il carrello aggiorniamo la sessione
         */
		String tot = (String) request.getSession().getAttribute("totale");
		tot = tot.replace(",", ".");
		double totale = Double.parseDouble(tot);
		
	
		String codiceCarta= request.getParameter("carta");
		try {
			
			model3.doUpdateSaldo(totale, codiceCarta, utente.getUsernameUser());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		Carrello newCarrello = new Carrello();
		request.getSession().setAttribute("carrello", newCarrello);
		RequestDispatcher view = request.getRequestDispatcher("CarrelloControl");
		view.forward(request, response);
	}

}