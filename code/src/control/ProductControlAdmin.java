package control;
//Gestione Entita Prodotto nel DB


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductModelDM;
import model.ProductBean; //bean che gestisce un singolo prodotto
import model.UserBean;

/**
 * Servlet implementation class ProductControlAdmin
 */
@WebServlet("/ProductControlAdmin")

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB


public class ProductControlAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String SAVE_DIR ="images" + File.separator + "PhotoProdotti";
	static ProductModelDM model = new ProductModelDM(); 
    
    public ProductControlAdmin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String sort = request.getParameter("sort");
		
		Collection<ProductBean> listaProdotti = null;
		

        //stringa che determinerà il comportamento della nostra Servlet in base all'azione che vogliamo svolgere
        String action = request.getParameter("action"); 
        


        /**
         * Aggiunta di un prodotto al DB (OPERAZIONE lato AMMINISTRATORE)
         * ------------INIZIO-------------------
         */

		if((action!=null) && (action.equals("aggiungi"))) {
			
            ProductBean bean = new ProductBean();
            bean.setIdProdotto(Integer.parseInt(request.getParameter("idProdotto")));
            bean.setCodProdotto(request.getParameter("codProdotto"));
            bean.setStatoIva(request.getParameter("stato"));
            bean.setNomeProdotto(request.getParameter("nomeProdotto"));
            bean.setDescrizione(request.getParameter("descrizione"));
            bean.setPrezzo(Double.parseDouble(request.getParameter("prezzoProdotto")));
            bean.setCategoria(request.getParameter("categoria"));
            bean.setQuantitaMagazzino(Integer.parseInt(request.getParameter("quantitaMagazzino")));
            bean.setPathNameFotoP("");
            try {
				model.doSave(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    		/**************************************************************************************/
    		
    		System.out.println("ci sono nella servlet");

    		
    	    String appPath = request.getServletContext().getRealPath("");
    	    String savePath = appPath + SAVE_DIR;
    	    
    	    System.out.println("Sono l'appPath del prodotto" + appPath);
    	    System.out.println("Sono il savePath del prodotto" + savePath);
    	    
    		File fileSaveDir = new File(savePath);
    		if (!fileSaveDir.exists()) {
    			fileSaveDir.mkdir();
    		}
    System.out.println("Sono il fileSaveDir del prodotto" + fileSaveDir);
    		Part foto = request.getPart("foto");
    		
    		
    		String fileName = foto.getSubmittedFileName();
    		
    			
    		
    			
    			System.out.println("Sono il nome della foto : " + fileName);
    		    System.out.println("Vengo salvata qui  : " + savePath + File.separator + fileName);
    		
    			if (fileName != null && !fileName.equals("")) {
    				foto.write(savePath + File.separator + fileName);
    			}
    					try {
    					
    					
    					//Fare una funzione nel DAO (UserModelDM) (ModelUtente.funzione(percorsoFoto , Username);
    						
    						
    						model.addPhoto(request.getParameter("codProdotto"),Integer.parseInt(request.getParameter("idProdotto")),fileName);
    					} catch (SQLException sqlException) {
    					System.out.println(sqlException);
    				}
    			
    		
    		
    		/**************************************************************************************/
        }
        
	
        /**
         * ----------FINE----------------
         */
        
         



       
		
		
			
		/**
         * Blocco di codice che ritorna la Lista prodotti e la rende visibile con modifiche apportate
         * 
         */
			try {
				listaProdotti =  model.doRetrieveAll(sort);
				
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			
		request.setAttribute("listaProdotti", listaProdotti);
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		

	    
	    
	    
	    
	    
	    
		if(utente.getRuoloUser().equals("Amministratore")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaProdottiAdmin.jsp");
			dispatcher.forward(request, response);
            }
	}

}
