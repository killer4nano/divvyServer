package com.divvy.webService;

 
import java.sql.*;
import java.util.ArrayList;
 
public class SqlCommunication {
 
 
	
	public static Connection sqlConnection() {
		
		Connection connect = null;
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connect =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/divvy?autoreconnect=true&useSSL=false","root","humberdeployost");
	       
	       return connect;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}



               
	public static int login(String name, String password){
	    Connection connect = sqlConnection();
	    String queryString = "";
	    try{
	        Statement statement = connect.createStatement();
	        queryString = "select * from users where username = \"" +name + "\" and password = PASSWORD(\"" + password + "\") ";
	        
	        ResultSet result = statement.executeQuery(queryString);
	   
	    if   (result.next()){             
	    	return (result).getInt("id");                                                
	    }
	       
	    }
	   
	    catch(Exception e){
	        System.out.println(e);
	        return 0;
	    }
	   
	   
		return 0;
	}
	
	public static int register(String name, String password){
	    Connection connect = sqlConnection();
	    String queryString = "";
	    try{
	        Statement statement = connect.createStatement();
	        queryString = "insert into users (username,password) values (\""+name+"\",PASSWORD(\""+password+"\"))";
	        int result = statement.executeUpdate(queryString,Statement.RETURN_GENERATED_KEYS);
      
	    	return result;                                                        
	    }
	   
	    catch(Exception e){
	        System.out.println(e);
	        return 0;
	    }
	   
	   
	}
   
               
   
               
               
}


