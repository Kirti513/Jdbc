package com.robomq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

//import com.mysql.cj.jdbc.CallableStatement;


public class CreateCustomerTable {
	

	public static void main(String[] args) {
		
		int ch;
		Scanner sc=new Scanner(System.in);
		Customer customers =new Customer();
		
		while(true) {
			System.out.println(
					"Enter your choice(1-5):\n1.Insert Customer information\n2.Update Customer information\n3.Delete Customer information\n4.Print Customer information\n5.Exit Application");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				customers.insert();
				break;
			case 2:
				customers.updateCustomerDetails();
				break;
			case 3:
				customers.deleteStudentDetails();
				break;
			case 4:
				customers.printCustomerDetails();
				break;
			case 5:
				System.out.println("Thank you for Using");
				System.exit(0);
				break;
			default :
				System.out.println("Invalid choice!!");
				
			}
		
		
		
			
			  try 
			  { 
				  Class.forName("com.mysql.cj.jdbc.Driver"); 
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","Sgvu@12345"); 
				  System.out.println("Database Connected....");
			  
			  
			  /*CallableStatement stat=(CallableStatement) con.
			  prepareCall("create table Customer (Customer_Id int, FirstName varchar(50), LastName varchar(50),"
			  + "Address varchar(200),Email varchar(20))");
			  
			  boolean result=stat.execute(); if(!result)
			  System.out.println("Table Created...."); else
			  System.out.println("Table Not Created...."); }
			   catch(Exception e) {
		  e.printStackTrace(); }*/
			  
			  }
			  catch(Exception e) {
				  e.printStackTrace();
				  }
		 
			  
	}
	}
}



