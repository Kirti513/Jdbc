package com.robomq.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;

public class Customer {
	Connection con;
	PreparedStatement pre;
	Statement stat;
	ResultSet res;
	int id;
	String fName;
	String lName;
	String address;
	String email;
	Scanner sc;
	
	public void insert()

	{
		try
		{
			 sc=new Scanner(System.in);
			System.out.println("Enter Customer ID:");
			id=sc.nextInt();
			System.out.println("Enter Customer First Name:");
			fName=sc.next();
			System.out.println("Enter Customer Last Name:");
			lName=sc.next();
			System.out.println("Enter Your Address:");
			address=sc.next();
			System.out.println("Enter Your Email:");
			email=sc.next();
			
			pre=(PreparedStatement) con.prepareStatement("insert into Customer values(?,?,?,?,?)");
			pre.setInt(1, id);
			pre.setString(2,fName);
			pre.setString(3,lName);
			pre.setString(4,address);
			pre.setString(5,email);
			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Customer Details Successfully inserted..");
			else
				System.out.println("Customer Details not inserted..");
			pre.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void printCustomerDetails()
	{
		try
		{
			stat=(Statement) con.createStatement();
			res=stat.executeQuery("select * from Customer");
			while(res.next())
			{
				System.out.println("Customer_Id : "+res.getInt("id"));
				System.out.println("FirstName : "+res.getString("fName"));
				System.out.println("LastName : "+res.getString("lName"));
				System.out.println("Address : "+res.getString("address"));
				System.out.println("Email : "+res.getString("email"));
				
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateCustomerDetails()
	{
		try
		{
			System.out.println("Enter Customer Id:");
			id = sc.nextInt();
			System.out.println("Enter First Name:");
			fName = sc.next();
			System.out.println("Enter Last Name:");
			lName = sc.next();
			System.out.println("Enter Address:");
			address = sc.next();
			System.out.println("Enter Email:");
			email = sc.next();
			pre = (PreparedStatement) con.prepareStatement("Update customers set fname=?,lname=?,address=?,email=?  where id=?");
			
			pre.setString(1, fName); 
			pre.setString(2, lName);
			pre.setString(3, address); 
			pre.setString(4, email); 
			pre.setInt(5, id);
//			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Information Updated..");
			else
				System.out.println("Information is not updated..");
			pre.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteStudentDetails()
	{
		try
		{
			System.out.println("Enter Customer Id to delete:");
			id = sc.nextInt();
			pre = (PreparedStatement) con.prepareStatement("delete from customers where customerid=?");
			pre.setInt(1, id);
			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Record Deleted...");
			else
				System.out.println("Record has not Deleted...");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
