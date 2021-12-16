package com.dev.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.text.DateFormat;
import java.util.Calendar;

import com.dev.utility.DBConnection;

public class AdminDAO {
	int BookID=107;

	public int adminCheck(String username,String password)
	{
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select pass from admintable where username = '"+username+"'");
			
			r.next();
			String pass = r.getString("pass");
			if(pass!=null && pass.equals(password))
				return 1;
			else
				return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void AddNewBook(String bookName,String authorName,int count){
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select max(bookID)+1 as NextBookId from book");
			r.next();
			int id=r.getInt("nextbookid");
			PreparedStatement ps=con.prepareStatement("Insert into Book values(?,?,?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2, bookName);
			ps.setString(3, authorName);
			ps.setInt(4,count);
			ps.setInt(5,count);
			ps.executeUpdate();
			System.out.println(ps);
			//Insert into Book values(107,'Computer programming in C','Rajaraman V',5,?)
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AddExistingBook(int BookID,int count)
	{
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE BOOK SET availablecount =  availablecount + " + count + ", totalcount = totalcount +" + count +" where bookid="+BookID);
			ps.executeUpdate();
			System.out.println(ps);
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void removeExistingBook(int BookID,int count)
	{
		
			try {
				Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("UPDATE BOOK SET availablecount =  availablecount - " + count + ", totalcount = totalcount -" + count +" where bookid="+BookID);
				ps.executeUpdate();
				System.out.println(ps);
			
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	public ArrayList<ArrayList<Object>> getDueBooks(int StudentID){
		ArrayList<ArrayList<Object>> DueBookList = new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet r = st.executeQuery("select b.bookname,b.authorname,bh.issueddate,bh.duedate,date(current_date)-bh.duedate as DueDays from borrowHistory bh join book b on bh.bookid=b.bookid where bh.duedate < Date(CURRENT_DATE)  and bh.studentid="+StudentID + "and status=false");
			while(r.next())
			{
				ArrayList<Object> BookDetail = new ArrayList<>();
				BookDetail.add(r.getString("BookName"));
				BookDetail.add(r.getString("AuthorName"));
				BookDetail.add(r.getString("issueddate"));
				BookDetail.add(r.getString("duedate"));
				BookDetail.add(r.getString("DueDays"));
				BookDetail.add(Integer.parseInt(r.getString("DueDays"))*2);
				DueBookList.add(BookDetail);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return DueBookList;
		
	}
	public void returnBook(int StudentID,int BookID) {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE BORROWHISTORY SET status=true  where bookid="+BookID+"and studentid = "+StudentID);
			ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("UPDATE BOOK SET availablecount = availablecount + 1  where bookid="+BookID);
			ps2.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void issueBook(int StudentID,int BookID) {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Insert Into Borrowhistory (bookid,studentid,issueddate,duedate,status) values(?,?,?,?,?)");
			ps.setInt(1,BookID);
			ps.setInt(2,StudentID);
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			//Date date = new Date();
			//Calendar cobj = Calendar.getInstance();
			
			ps.setDate(3,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now().plusMonths(1)));
			ps.setBoolean(5, false);
			ps.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("UPDATE BOOK SET availablecount = availablecount - 1  where bookid="+BookID);
			ps2.executeUpdate();
			System.out.println(ps2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
