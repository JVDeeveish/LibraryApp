package com.dev.UserServlet;

import java.io.IOException;
import java.util.ArrayList;

import com.dev.service.StudentServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RenewBookServlet
 */
public class RenewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("StudentID") +"SUCCESSSSSS");
		int StudentID = (Integer)session.getAttribute("StudentID");
		System.out.println(StudentID);
		StudentServiceImpl st = new StudentServiceImpl();
		
		ArrayList<ArrayList<Object>> BooksRenewal=st.RenewBooksList(StudentID);
	      //System.out.println(FilterdBooks);
	      request.setAttribute("BooksRenewal",BooksRenewal);
	      RequestDispatcher rd=request.getRequestDispatcher("RenewBooksDisplay.jsp");
	      rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
