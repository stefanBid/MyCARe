package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductModelDM;
import dao.UserModelDM;
import model.UserBean;

@WebServlet("/PhotoControl")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class PhotoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String SAVE_DIR ="images" + File.separator + "PhotoUser";
	static UserModelDM model = new UserModelDM();
       
    public PhotoControl() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.write("Error: GET method is used but POST method is required");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ci sono nella servlet");

		
	    String appPath = request.getServletContext().getRealPath("");
	    String savePath = appPath + SAVE_DIR;
	    
	    System.out.println("Sono l'appPath" + appPath);
	    System.out.println("Sono il savePath" + savePath);
	    
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
System.out.println("Sono il fileSaveDir" + fileSaveDir);
		Part foto = request.getPart("foto");
		String fileName = foto.getSubmittedFileName();
			
		UserBean utente = (UserBean) request.getSession().getAttribute("utente");
		utente.setPathNameFotoP(fileName);
		request.getSession().setAttribute("utente",utente);
		
		
		 
		    System.out.println("Sono il nome della foto : " + fileName);
		    System.out.println("Vengo salvata qui  : " + savePath + File.separator + fileName);
		
			if (fileName != null && !fileName.equals("")) {
				foto.write(savePath + File.separator + fileName);
			}
					try {
					
					
					//Fare una funzione nel DAO (UserModelDM) (ModelUtente.funzione(percorsoFoto , Username);
						
						
						model.changePath(fileName, utente.getUsernameUser());
					} catch (SQLException sqlException) {
					System.out.println(sqlException);
				}
			
		

		RequestDispatcher view = request.getRequestDispatcher("/AreaUtente.jsp");
		view.forward(request, response);
	}
	
}
