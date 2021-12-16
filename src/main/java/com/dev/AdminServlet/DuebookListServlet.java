package com.dev.AdminServlet;

import java.io.IOException;
import java.util.ArrayList;

import com.dev.service.AdminService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DuebookListServlet
 */
@WebServlet("/DuebookList")
public class DuebookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DuebookListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		AdminService as = new AdminService();
		ArrayList<ArrayList<Object>> DueBooksList= as.getDueBooks(StudentID);
		int totalPenalty=0;
		for(ArrayList bookdetail : DueBooksList ){
			
			totalPenalty+=(int)bookdetail.get(5);
		}
		 request.setAttribute("DueBooksList",DueBooksList);
		 request.setAttribute("totalPenalty",totalPenalty);
		 
	      RequestDispatcher rd=request.getRequestDispatcher("AdminDueBooksDisplay.jsp");
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
