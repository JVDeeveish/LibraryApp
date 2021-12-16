package com.dev.AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dev.service.AdminService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddNewBookServlet
 */
@WebServlet("/AddNewBook")
public class AddNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddNewBookServlet() {
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
		AdminService as = new AdminService();
		String bookname=request.getParameter("bookName");
		String AuthorName = request.getParameter("authorName");
		int count=Integer.parseInt(request.getParameter("Count"));
		as.AddNewBook(bookname,AuthorName,count);
		PrintWriter out = response.getWriter();
		out.println("Succesfully Added");
		
	}

}
