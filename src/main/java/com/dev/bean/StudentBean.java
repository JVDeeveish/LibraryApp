package com.dev.bean;

public class StudentBean {
	private int rollNo;
	private String password;
	private String name;
	StudentBean()
	{
		
	}
	public StudentBean(int rno,String nme,String pwd)
	{
		rollNo=rno;
		password=pwdEncryption(pwd);
		name=nme;
	}
	
	public StudentBean(int rno,String pwd)
	{
		rollNo=rno;
		password=pwdEncryption(pwd);
	}
	private String pwdEncryption(String p)
	{
		String pwd="";
		for(int i=0;i<p.length();i++)
		{
			char c = p.charAt(i);
			if(c=='Z')
				pwd+='A';
			else if(c=='z')
				pwd+='a';
			else if(c=='9')
				pwd+='0';
			else
				pwd+=(char)(c+1);
		}
		return pwd;
	}
	public String getStudentName()
	{
		return name;
	}
	public String getStudentPassword()
	{
		return password;
	}
	public int getStudentRollNo() {
		return rollNo;
	}
	
}
