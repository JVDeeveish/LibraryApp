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
 * Servlet implementation class IssueBooksServlet
 */
@WebServlet("/IssueBooks")
public class IssueBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IssueBooksServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AdminService as = new AdminService();
		int BookID=Integer.parseInt(request.getParameter("BookID"));
		int StudentID=Integer.parseInt(request.getParameter("StudentID"));
		as.issueBook(StudentID,BookID);
		PrintWriter out = response.getWriter();
		out.println("Succesfully Issued");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
