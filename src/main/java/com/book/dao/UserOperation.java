package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserOperation {
DataConnectivity db= new DataConnectivity();
	
	Connection conn=db.dbconnection();
	
public boolean Registration(String Fn,String Ln,String address,long phone,String email,String usern,String pass) throws SQLException {
		
		PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		ps.setString(1, Fn);
		ps.setString(2, Ln);
		ps.setString(3, address);
		ps.setLong(4, phone);
		ps.setString(5,email);
		ps.setString(6,usern);
		ps.setString(7, pass);
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false; 
	}

public boolean login(String username,String password) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("select * from users where username=? && password=?");
	ps.setString(1, username);
	ps.setString(2, password);
	ResultSet result=ps.executeQuery(); 
	
	if(result.next())
	{
		return true; 
	}
	else
	{
		return false;
	}
}

public void ShowBooks() throws SQLException {
	PreparedStatement ps=conn.prepareStatement("select * from book");
	ResultSet result=ps.executeQuery();
	System.out.println("BookID"+" "+"BookName"+"        "+"BookAuthorName"+"      "+"Price"+"      "+"Qty");	
	while(result.next())
	
	System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getInt(4)+" "+result.getInt(5));
	
}

public boolean AddtoCart(int bid)  throws SQLException{
	
	PreparedStatement ps=conn.prepareStatement("insert into viewcart(bookId,bookname,author,price) select bookId,bookname,author,price from book where bookId=? ");
	ps.setInt(1, bid);
	int affectedRows=ps.executeUpdate();


 if(affectedRows>0) {
	 return true;
 }
	 else {
		 return false;
 }
}
	

	


public void ViewCart() throws SQLException {
	PreparedStatement ps=conn.prepareStatement("select * from viewcart");
	ResultSet rs=ps.executeQuery();
	System.out.println("BookName"+"  "+"BookAuthorName"+"  "+"BookPrice"+ "Qty");
	
	while(rs.next())
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
}

public boolean changePassword(String username,String newPassword) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("update user set password=? where username=? ");
	ps.setString(1, newPassword);
	ps.setString(2, username);
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}
public boolean logout() throws SQLException
{
	conn.close();
	return true;
}

public boolean deleteCart(String bkn) throws SQLException {
	PreparedStatement ps=conn.prepareStatement("delete from viewcart where bookname=?");
	ps.setString(1, bkn);
int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}

public boolean placeOrder(String bookName,long bookId,long bookqty,String address) throws SQLException {
	PreparedStatement ps=conn.prepareStatement("insert into ordertable values(?,?,?,?)");
	ps.setString(1, bookName);
	ps.setLong(2, bookId);
	ps.setLong(3, bookqty);
	ps.setString(4, address);
int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
	
}
}


