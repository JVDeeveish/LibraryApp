package com.dev.UserServlet;

import java.io.IOException;
import java.util.ArrayList;

import com.dev.service.StudentServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBooksBybookNameSerlvet
 */
@WebServlet("/SearchBooksByBookName")
public class SearchBooksBybookNameSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      String bookNameSearchKey= request.getParameter("bookNameSearchKey");
	      StudentServiceImpl st = new StudentServiceImpl();
	      System.out.println("Calling service layer  "+bookNameSearchKey);
	      ArrayList<ArrayList<Object>> FilterdBooks= st.SearchAvailableBooksByBookName(bookNameSearchKey);
	      //System.out.println(FilterdBooks);
	      request.setAttribute("FilterdBooks", FilterdBooks);
	      RequestDispatcher rd=request.getRequestDispatcher("FilterdBooksDisplay.jsp");
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
