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
 * Servlet implementation class DueBooksSevlet
 */
public class DueBooksSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   

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
		
		ArrayList<ArrayList<Object>> DueBooksList=st.DueBooksList(StudentID);
	      //System.out.println(FilterdBooks);
	      request.setAttribute("DueBooksList",DueBooksList);
	      RequestDispatcher rd=request.getRequestDispatcher("DueBooksDisplay.jsp");
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
