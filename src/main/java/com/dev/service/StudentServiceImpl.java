package com.dev.service;

import java.util.ArrayList;

import com.dev.DAO.StudentDAO;
import com.dev.DAO.StudentDAOImpl;
import com.dev.bean.StudentBean;

public class StudentServiceImpl implements StudentService {
	StudentDAOImpl stu = new StudentDAOImpl();
	@Override
	public void addUser(StudentBean s) {
		// TODO Auto-generated method stub
		System.out.println("serviceImpl");
		System.out.println(s.getStudentName());
		System.out.println(s.getStudentPassword());
		System.out.println(s.getStudentRollNo());
		stu.addUser(s);
		
	}

	@Override
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByBookName( String s) {
		// TODO Auto-generated method stub
		System.out.println("calling DAO LAyer");
		return stu.SearchAvailableBooksByBookName(s);
	}

	@Override
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByAuthor(String s) {
		// TODO Auto-generated method stub
		return stu.SearchAvailableBooksByAuthor(s);
		
	}

	@Override
	public ArrayList<ArrayList<Object>>  RenewBooksList(int rno) {
		// TODO Auto-generated method stub
		return stu.RenewBooksList(rno);
		
	}

	@Override
	public ArrayList<ArrayList<Object>> BookHistory(int rno) {
		// TODO Auto-generated method stub
		return stu.BookHistory(rno);
		
	}

	@Override
	public int usercheck(StudentBean s) {
		// TODO Auto-generated method stub
		System.out.println("serviceImpl");
		//System.out.println(s.getStudentName());
		System.out.println(s.getStudentPassword());
		System.out.println(s.getStudentRollNo());
		return stu.usercheck(s);
		
	}

	@Override
	public int RenewBooks(int rno) {
		// TODO Auto-generated method stub
		return stu.RenewBooks(rno);
	}

	@Override
	public ArrayList<ArrayList<Object>> DueBooksList(int rno) {
		// TODO Auto-generated method stub
		return stu.DueBooksList(rno);
	}

}
