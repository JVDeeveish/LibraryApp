package com.dev.backendtest;

import com.dev.bean.StudentBean;
import com.dev.service.AdminService;
import com.dev.service.StudentService;
import com.dev.service.StudentServiceImpl;

public class backendtest {

	static public void main(String args[])
	{
		
		AdminService as = new AdminService();
		int BookID=106;
		int StudentID=1002;
		as.issueBook(StudentID,BookID);
		
		
	}
}
