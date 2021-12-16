package com.dev.AdminServlet;

import java.io.IOException;


import com.dev.service.AdminService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAccessServlet
 */
@WebServlet("/AdminAccess")
public class AdminAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminAccessServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username=request.getParameter("AdminuserName" );
		String Adminpassword=request.getParameter("AdminPassword");
		AdminService as = new AdminService();
		if(as.adminCheck(username, Adminpassword)==1)
		{
			response.sendRedirect("AdminWelcomePage.jsp");
		}
		else
			response.sendRedirect("AdminLogin.html");
			
	}

}
