package com.robomq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;

public class FirstJdbc {

	Connection con;
	PreparedStatement pre;
	Statement stat;
	ResultSet res;
	int rollno;
	String fname;
	String lname;
	public FirstJdbc()

	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root", "Sgvu@12345");
			System.out.println("Database Connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insert()

	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Student RollNo.");
			rollno=sc.nextInt();
			System.out.println("Enter Student FirstName.");
			fname=sc.next();
			System.out.println("Enter Student LastName.");
			lname=sc.next();
			
			pre=(PreparedStatement) con.prepareStatement("insert into Student values(?,?,?)");
			pre.setInt(1, rollno);
			pre.setString(2,fname);
			pre.setString(3,lname);
			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Student Details Committed..");
			else
				System.out.println("Student Details are Not Committed..");
			pre.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
		
		FirstJdbc stud=new FirstJdbc();
		stud.insert();
//	public static void main(String[] args) {
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root", "Sgvu@12345");
//			System.out.println("Connected....");
//			} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
}
	}

