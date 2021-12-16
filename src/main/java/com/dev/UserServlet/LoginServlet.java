package com.dev.UserServlet;

import java.io.IOException;

import com.dev.bean.StudentBean;
import com.dev.service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(request.getParameter("rollNo"));
		int rollNo = Integer.parseInt(request.getParameter("RollNo"));
		String pwd=request.getParameter("pass");
		StudentBean s = new StudentBean(rollNo,pwd);
		StudentServiceImpl st = new StudentServiceImpl();
		 //System.out.println(s.getStudentName());
		HttpSession session = request.getSession();
		session.setAttribute("StudentID",rollNo);
		
		 if(st.usercheck(s) == 1)
			 response.sendRedirect("Welcome.jsp");
		 else
			 response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
