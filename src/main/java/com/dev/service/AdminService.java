package com.dev.service;

import java.util.ArrayList;

import com.dev.DAO.AdminDAO;

public class AdminService {
	AdminDAO stu = new AdminDAO();

	public int adminCheck(String username,String password)
	{
		return stu.adminCheck(username,password);
	}
	public void AddNewBook(String bookName,String authorName,int count) {
		stu.AddNewBook(bookName,authorName,count);
	}
	public void AddExistingBook(int bookID,int count){
		stu.AddExistingBook(bookID,count);
	}
	public void removeExistingBook(int bookID,int count){
		stu.removeExistingBook(bookID,count);
	}
	public ArrayList<ArrayList<Object>> getDueBooks(int StudentID){
		return stu.getDueBooks(StudentID);
	}
	
	public void returnBook(int StudentID,int BookID)
	{
		stu.returnBook(StudentID,BookID);
	}
	public void issueBook(int StudentID,int BookID)
	{
		stu.issueBook(StudentID,BookID);
	}
}
