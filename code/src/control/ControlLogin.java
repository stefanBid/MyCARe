package control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


import dao.UserModelDM;
import com.google.gson.*;
/**
 * Servlet implementation class ControlLogin
 */
@WebServlet("/ControlLogin")
public class ControlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserModelDM model = new UserModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
	String username = request.getParameter("user");
	String email = request.getParameter("email");

	if(username != null || email != null)
		{

			try
			{
				
			int rs = model.checkUsername(username);
			int check = 0;
			int re = model.checkEmail(email);	
	
			
			String oggetto = null;
			
		
			
			if(rs == 0)
			{
				 check = 0;
			}
			
			if(re == 2)
			{
				 check = 2;
			}
				
		
			
			if(rs == 1)
			{
				 check = 1;
			}
			
			if(re == 3)
			{
				 check = 3;
			}
			
			
			oggetto = new Gson().toJson(check);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(oggetto);
		
			
			
				
			}catch(SQLException e)
			{
		
			e.printStackTrace();
			}
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
