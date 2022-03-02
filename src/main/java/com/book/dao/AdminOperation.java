package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminOperation {
DataConnectivity db= new DataConnectivity();
	
	Connection conn=db.dbconnection();
	public boolean login(int eid,String password) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("select * from admin where emp_id=? && password=?");
		ps.setInt(1, eid);
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
	public boolean AddBook(int bId,String bname,String authorname,double price,int qty)throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("insert into book values(?,?,?,?,?)");
		ps.setInt(1, bId);
		ps.setString(2, bname);
		ps.setString(3, authorname);
		ps.setDouble(4, price);
		ps.setInt(5,qty);
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}

	public boolean DeleteBook(int bId) throws SQLException 
	{
		PreparedStatement ps=conn.prepareStatement("delete from book where bookId=?");
		ps.setLong(1, bId);
int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public boolean changePassword(long empId,String newPassword) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update admin set password=? where emp_id=? ");
		ps.setString(1, newPassword);
		ps.setLong(2, empId);
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
	public void ShowBooks() throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from book");
		ResultSet rs=ps.executeQuery();
		System.out.println("BookId"+"  "+"BookName"+"  "+"BookAuthorName"+" "+"BookPrice"+" "+"BookQty");
		
		while(rs.next())
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
	}
}
