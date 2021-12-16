package com.dev.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.dev.utility.DBConnection;
import com.dev.bean.StudentBean;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void addUser(StudentBean s) {
		// TODO Auto-generated method stub
		try {
			 Connection con=DBConnection.getConnection();
			 
			PreparedStatement ps=con.prepareStatement("INSERT INTO public.student(\r\n"
					+ "	studentid, studentname, pass)\r\n"
					+ "	VALUES (?, ?, ?);");
			
			ps.setString(2, s.getStudentName());
			ps.setInt(1, s.getStudentRollNo());
			ps.setString(3, s.getStudentPassword());
			int k=0;
			System.out.println(ps);
			ps.executeUpdate();
			System.out.println("daoImpl");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByBookName(String searchkey) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> FilteredBooks = new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			System.out.println("select bk.BookName,bd.authorname,bd.AvailableCount from Book bk join BookDetails bd on bk.bookid=bd.bookid where bk.bookname like '%"+searchkey+"%'");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select BookName,authorname,AvailableCount from Book where upper(bookname) like '%"+searchkey.toUpperCase()+"%'");
			
			
			while(r.next())
			{	
				ArrayList<Object> BookDetail = new ArrayList<>();
				BookDetail.add(r.getString("BookName"));
				BookDetail.add(r.getString("authorname"));
				BookDetail.add(r.getString("AvailableCount"));
				FilteredBooks.add(BookDetail);
					//System.out.println(r.getString("BookName"));
			}
			//System.out.println(FilteredBooks);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return FilteredBooks;
		
	}

	@Override
	public ArrayList<ArrayList<Object>> SearchAvailableBooksByAuthor(String searchkey) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> FilteredBooks = new ArrayList<>();
		try {
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		
		//System.out.println("select a.BookName,b.authorname,b.AvailableCount from Book a join BookDetails b on a.bookid=b.bookid where a.authorname like '%"+searchkey"%'");
		ResultSet r=st.executeQuery("select BookName,authorname,AvailableCount from Book where upper(authorname) like '%"+searchkey.toUpperCase()+"%'");
		while(r.next())
		{
			ArrayList<Object> BookDetail = new ArrayList<>();
			BookDetail.add(r.getString("BookName"));
			BookDetail.add(r.getString("authorname"));
			BookDetail.add(r.getString("AvailableCount"));
			FilteredBooks.add(BookDetail);
			
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return FilteredBooks;
		
	}

	@Override
	public ArrayList<ArrayList<Object>>  RenewBooksList(int rno) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> BooksRenewal = new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r = st.executeQuery("select b.bookname,b.authorname,bh.issueddate,bh.duedate from borrowHistory bh join book b on bh.bookid=b.bookid where bh.duedate between Date(CURRENT_DATE) and Date(CURRENT_DATE + INTERVAL '5 day') and bh.studentid="+rno+"and status=false");
			while(r.next())
			{
				ArrayList<Object> BookDetail = new ArrayList<>();
				BookDetail.add(r.getString("BookName"));
				BookDetail.add(r.getString("AuthorName"));
				BookDetail.add(r.getString("issueddate"));
				BookDetail.add(r.getString("duedate"));
				BooksRenewal.add(BookDetail);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return BooksRenewal;
		
	}

	@Override
	public ArrayList<ArrayList<Object>> BookHistory(int rno) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> StudentBookHistory = new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select bk.bookname,bh.issueddate,bh.duedate from borrowhistory bh join book bk on bh.bookid = bk.bookid where studentid="+rno);
			while(r.next())
			{
				ArrayList<Object> BookDetail = new ArrayList<>();
				BookDetail.add(r.getString("BookName"));
				BookDetail.add(r.getString("issueddate"));
				BookDetail.add(r.getString("duedate"));
				StudentBookHistory.add(BookDetail);
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return StudentBookHistory;
	}

	@Override
	public int usercheck(StudentBean s) {
		// TODO Auto-generated method stub
		String entered_pwd=s.getStudentPassword();
		String rollno=Integer.toString(s.getStudentRollNo());
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select pass from student where studentid="+rollno);
			r.next();
			String password = r.getString("pass");
			if(password.equals(entered_pwd))
				return 1;
			else
				return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int RenewBooks(int rno) {
		// TODO Auto-generated method stub
		int k=0;
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE BORROWHISTORY SET ISSUEDDATE = CURRENT_DATE , DUEDATE=Date(CURRENT_DATE + INTERVAL '1 month') where borrowID in (Select BorrowID from borrowhistory where duedate between Date(CURRENT_DATE) and Date(CURRENT_DATE + INTERVAL '5 day') and studentid="+rno+" and status = false)");
			return ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<ArrayList<Object>> DueBooksList(int rno) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> DueBookList = new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r = st.executeQuery("select b.bookname,b.authorname,bh.issueddate,bh.duedate,date(current_date)-bh.duedate as DueDays from borrowHistory bh join book b on bh.bookid=b.bookid where bh.duedate < Date(CURRENT_DATE)  and bh.studentid="+rno+"and status=false");
			while(r.next())
			{
				ArrayList<Object> BookDetail = new ArrayList<>();
				BookDetail.add(r.getString("BookName"));
				BookDetail.add(r.getString("AuthorName"));
				BookDetail.add(r.getString("issueddate"));
				BookDetail.add(r.getString("duedate"));
				BookDetail.add(r.getString("DueDays"));
				DueBookList.add(BookDetail);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return DueBookList;

	}

}
