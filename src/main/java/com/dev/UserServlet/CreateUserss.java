package com.dev.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dev.bean.StudentBean;
import com.dev.service.StudentServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreateUserss
 */
@WebServlet("/CreateUser")
public class CreateUserss extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		 String name= request.getParameter("username");
		 String pwd=request.getParameter("password");
		 StudentBean s = new StudentBean(rollNo,name,pwd);
		 StudentServiceImpl st = new StudentServiceImpl();
		 System.out.println(s.getStudentName());
		 st.addUser(s);	
		 PrintWriter out =response.getWriter();
		out.println("Äccount Created Succesfully");
		 response.sendRedirect("login.jsp");
	}

	
}
