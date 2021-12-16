package com.dev.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.dev.service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class RenewServiceServlet
 */
public class RenewServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath())
		HttpSession session = request.getSession();
		int StudentID = (Integer)session.getAttribute("StudentID");
		System.out.println(StudentID);
		StudentServiceImpl st = new StudentServiceImpl();
		
		int BooksRenewalstatus=st.RenewBooks(StudentID);
		System.out.println(BooksRenewalstatus);
		PrintWriter out =response.getWriter();
		out.println("Renewed Succesfully");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
