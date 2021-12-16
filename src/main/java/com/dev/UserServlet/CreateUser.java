package com.dev.UserServlet;

import com.dev.bean.StudentBean;
import com.dev.service.StudentServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateUser extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		int rollNo = Integer.parseInt(req.getParameter("rollNo"));
		 String name= req.getParameter("username");
		 String pwd=req.getParameter("password");
		 StudentBean s = new StudentBean(rollNo,name,pwd);
		 StudentServiceImpl st = new StudentServiceImpl();
		 System.out.println(s.getStudentName());
		 st.addUser(s);	
	}
}
