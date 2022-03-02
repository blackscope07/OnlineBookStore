package com.bookapp;

import java.sql.ResultSet;
import java.util.Scanner;


import com.book.dao.AdminOperation;
import com.book.dao.UserOperation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	boolean status=true;
    	try {
    		do {
        Scanner sc =new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("             WELCOME TO ONLINE BOOK STORE                   ");
        System.out.println("              WORLD CLASS BOOK STORE                        ");
        System.out.println("                    IS HERE TO                                ");
        System.out.println("             TO FILL UR LEARNING EXPERIENCES                                                      ");
        System.out.println("=========================================================");
        System.out.println("1-> ADMIN LOGIN");
        System.out.println("2-> CUSTOMER LOGIN");
        System.out.println("CLICK HERE TO EXPLORE UR BOOK STORE BY PRESSING THE 1 AND 2");
        int userin=sc.nextInt();
        if(userin==1) {
        	System.out.println("ENTER UR EMPOLYEE ID");
        	int empid=sc.nextInt();
        	System.out.println("ENTER UR EMPOLYEE PASSWORD");
        	String epassword=sc.next();
        	AdminOperation ao=new AdminOperation();
        	if(ao.login(empid, epassword)) {
        		System.out.println("=============================================================");
        		System.out.println("Login successfull!!");
                System.out.println("==============================================================");
        		System.out.println("1.ADD BOOK\r\n"
        				+ "2.REMOVE BOOK\r\n"
        				+ "3.SHOWBOOKS\r\n"
        				+ "4.Password Change\r\n"
        				+ "5.Logout\r\n");
        		int op=sc.nextInt();
        		
        		if(op==1) {
        			System.out.println("Enter Book Serial No:");
            		int bId=sc.nextInt();
            		System.out.println("Enter The BookName:");
            		String bname=sc.next();
            		System.out.println("Enter The Book AuthorName:");
            		String authorname=sc.next();
            		System.out.println("Enter Price of Book:");
            		double price=sc.nextDouble();
            		System.out.println("Enter Quantity of Book:");
            	    int qty=sc.nextInt();
            	    if(ao.AddBook(bId, bname, authorname, price, qty))
            		{
                        System.out.println("=======================================================================");
            			System.out.println("Bookes Added successfully To Sales!!");
                        System.out.println("=======================================================================");

            		}
            		else
            		{   System.out.println("=======================================================================");
            			System.out.println("Problem in Adding  creation!!");
                        System.out.println("=======================================================================");

            		}

    		}
        		else if(op==2)
            	{
            		System.out.println("Enter Book SerialNo to Delete:");
            		int bId=sc.nextInt();
            		if(ao.DeleteBook(bId))
            		{
            		System.out.println("=======================================================================");
            		System.out.println("Book Delete From BookList!!");
                    System.out.println("=======================================================================");
            		}
            		else {
            			System.out.println("=======================================================================");
            			System.out.println("Problem in Deleteing Operation!!");
                        System.out.println("=======================================================================");
            		}
            	}
        		
        		else if(op==3) {
        			ao.ShowBooks();
        			
        		}
            		
            		else if(op==4)
                	{
                		System.out.println("As Per Request Enter your Employee ID:");
                		long empId=sc.nextLong();
                		System.out.println("Enter your New Password(8 Character):");
                		String newPassword=sc.next();
                		if(ao.changePassword(empId, newPassword))
                		{
                			System.out.println("Password Changed Successfully!!");
                		}
                		else
                		{
                			System.out.println("Problem in password Changed!!");
                		}

            	}
            		else if(op==5) {
            			if(ao.logout()) {
            				status=false;
            				System.out.println("");
            			}
            		}
    		
    	}else
    	{
    		System.out.println("LOGIN SUCCESSFULL" +"LOGIN,PASSWORD IS WRONG");
    	}
        
    	}
        if(userin==2) {
        	System.out.println("=========================================================");
            System.out.println("             WELCOME TO ONLINE BOOK STORE                         ");
            System.out.println("                    IS HERE TO                                                   ");
            System.out.println("             TO FILL UR LEARNING EXPERIENCES                                                      ");
            System.out.println("=========================================================");
            System.out.println("**IF U R NEW TO OUR STORE PLZ PRESS NO.1 CLICK REGISTER BUTTON TO CREATE ACCOUNT IN OUR STORE ");
            System.out.println("**IF UR EXISTING CUSTOMER PLZ PRESS NO.2 TO MAKE LOGIN");
            
            System.out.println("  ");
         
       
            System.out.println("1-> REGISTRATION ``clickhere``");
            System.out.println("2-> CUSTOMER LOGIN");
            int login=sc.nextInt();
            
            UserOperation uo=new UserOperation();
            
            if(login==1) {
            	
             
        			System.out.println("Enter UR FRIST NAME:");
            		String Fn=sc.next();
            		System.out.println("Enter UR LAST NAME:");
            		String Ln=sc.next();
            		System.out.println("Enter UR address:");
            		String address=sc.next();
            		System.out.println("Enter  UR PHONE NUMBER:");
            		long phone=sc.nextLong();
            		System.out.println("Enter valid EMAIL id:");
            		String email=sc.next();
            		System.out.println("Enter UR USER NAME:");
            		String usern=sc.next();
            		System.out.println("Set PASSWORD FOR THE NEW USER (Min (8)character):");
            		String pass=sc.next();
            		
            		if(uo.Registration(Fn, Ln, address, phone, email, usern, pass))
            		{
                        System.out.println("=======================================================================");
            			System.out.println("Account created successfully!!");
                        System.out.println("=======================================================================");

            		}
            		else
            		{   System.out.println("=======================================================================");
            			System.out.println("Problem in account creation!!");
                        System.out.println("=======================================================================");

            		}
        		}
            else if(login==2) {
            	System.out.println("ENTER UR USERS NAME");
            	String username=sc.next();
            	System.out.println("ENTER UR USER PASSWORD");
            	String password=sc.next();
            	
            	if(uo.login(username, password)) {
                System.out.println("=======================================================================");
            	System.out.println("Login Successful");
                System.out.println("=======================================================================");
         		System.out.println("1.view Book\r\n"
         				+ "2.Add cart\r\n"
         				+ "3.View Cart\r\n"        				
         				+ "4.Change Password\r\n"
         				+ "5.Logout\r\n");
         				
         		int operation=sc.nextInt();
         		
         	   if(operation==1) {
        		uo.ShowBooks();
        			
        		}
         	   else if(operation==2) {
         		  uo.ShowBooks();
         		  
         		   System.out.println("ENTER THE BOOK ID AS SHOWN IN THE UPPER TABLE");
         		   int bid=sc.nextInt();
         		  
         		  if( uo.AddtoCart(bid )) {
         			  System.out.println("The Book Added to Successfully!!");
         		  }
         		  else {
         			  System.out.println("problem occured");
         		  }
         		   
         	   }
         	   
         	   
         	   else if(operation==3) {
         		  uo.ViewCart();
         		  
         		  System.out.println();
         		  System.out.println("Make the Order by Click option Bellow");
         		  System.out.println("Enter 1> TO PLACE THE ORDER ");
         		  System.out.println("ENTER 2> TO DELETE THE ITEM FROM THE CART");
         		  int so=sc.nextInt();
         		  if(so==1) {
         			  uo.ViewCart();
         			  System.out.println();
         			 System.out.println("Enter BookName:");
             		String bookName=sc.next();
             		System.out.println("Enter BookId:");
             		Long bookId=sc.nextLong();
             		System.out.println("Enter Quantity:");
             		Long bookqty=sc.nextLong();
             		System.out.println("Enter Addresss:");
             		String address=sc.next();
             		
             		if(uo.placeOrder(bookName, bookId, bookqty, address)) {
             			System.out.println("***ur Order where placed successfully***");
             		}
             		else {
             			System.out.println("***Problem Occured**");
             		}
         			  
         			  
         		  }
         		  if(so==2) {
         			 System.out.println("Enter the BOOKNAME TO DELETE FROM CART:");
             		String bkn=sc.next();
             		if(uo.deleteCart(bkn))
             		
             			System.out.println("Book deleted from cart successfully!!");
             		else
             			System.out.println("Problems OccurresCheck the Book Name Properly");

         		  }
         	   }
         		  
         		 
         		  
         	   
         	   
         	  else if(operation==4)
          	{
          		System.out.println("As Per Request Enter your Username:");
          		String usern=sc.next();
          		System.out.println("Enter your New Password(8 Character):");
          		String newPassword=sc.next();
          		if(uo.changePassword(username, newPassword))
          		{
          			System.out.println("Password Changed Successfully!!");
          		}
          		else
          		{
          			System.out.println("Problem in password Changed!!");
          		}

      	}
      		else if(operation==5) {
      			if(uo.logout()) {
      				status=false;
      				System.out.println("U WERE LOGOUT FROM THE APP THANK U USING APP");
      				System.out.println("RATE US UR EXPERIENCE USING THIS APP");
      				System.out.println("* * * * *");
      				System.out.println("see u soon ");
      			}
      		}
         		
            	}
            	else {
            		 System.out.println("=======================================================================");
            		System.out.println("Login UnSuccessful");
               	 System.out.println("=======================================================================");
            	}
            }
        
            
           
        	
        	
        
    		
    	}
    	}while(status);
    	
    	
    	}
    	

catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    


}
}
