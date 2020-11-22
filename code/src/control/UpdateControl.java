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

/**
 * Servlet implementation class UpdateControl
 */
@WebServlet("/UpdateControl")
public class UpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// ProductModelDM usa il DriverManager	
		static ProductModelDM model = new ProductModelDM();
    
	
    public UpdateControl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String cod = request.getParameter("cod");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		try {
			model.doUpdateQuantity(id, cod, quantita);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("NewFile.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
