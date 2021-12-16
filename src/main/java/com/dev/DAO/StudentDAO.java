package com.dev.DAO;

import java.util.ArrayList;

import com.dev.bean.StudentBean;

public interface StudentDAO {
	public void addUser(StudentBean s);
	public int usercheck(StudentBean s);
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByBookName(String s);
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByAuthor(String s);
	public ArrayList<ArrayList<Object>>  RenewBooksList(int rno);
	public ArrayList<ArrayList<Object>> BookHistory(int rno);
	public int  RenewBooks(int rno);
	public ArrayList<ArrayList<Object>>DueBooksList(int rno);
}
