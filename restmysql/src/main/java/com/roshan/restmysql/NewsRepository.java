 package com.roshan.restmysql;

 import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.roshan.restmysql.News;

 public class NewsRepository {

Connection con = null;
  
 	public NewsRepository() {
 		
 	  String url = "jdbc:mysql://localhost:8383/restmysql";
 	  String username = "root";
 	  String password = " ";
 	  try {
 		  
 		  Class.forName("com.mysql.jdbc.Driver");
 	  con= (Connection) DriverManager.getConnection(url,username,password);
 	  }
 	  catch(Exception e) {
 		  System.out.println(e);
 	  }
 	 
 	}
 public ArrayList<News> getNews()

 {
 ArrayList<News> news= new ArrayList<>();
 String sql ="select * from news";
 
 try {
 Statement st = con.createStatement();
 ResultSet rs = st.executeQuery(sql);
 	while(rs.next())
 	 {
 		News n = new News();
 		n.setDate(rs.getString(1));
 		n.setTime(rs.getString(2));
 		n.setStatus(rs.getString(3));

 		news.add(n);
 	 }
 }
 catch(Exception e)
 {
	 
	System.out.println(e); 
 }
 
 return news;
 }
 
 public ArrayList<News> getNews(String st1)	
 {
		
	 ArrayList<News> news= new ArrayList<>();
	 String sql ="select * from news where status="+st1;
	 
	 try {
	 Statement st = con.createStatement();
	 ResultSet rs = st.executeQuery(sql);
	 	while(rs.next())
	 	 {
	 		News n = new News();
	 		n.setDate(rs.getString(1));
	 		n.setTime(rs.getString(2));
	 		n.setStatus(rs.getString(3));

	 		news.add(n);
	 	 }
	 }
	 catch(Exception e)
	 {
		 
		System.out.println(e); 
	 }
	 
	 return news;
	 
 }
 public void create(News n1) {
	 
	 String sql ="insert into news values(?,?,?)";
	 
	 try {
	 PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
	 st.setString(1,n1.getDate());
	 st.setString(2, n1.getTime());
	 st.setString(3, n1.getStatus());
	 
	 st.executeUpdate();
	 	
	 }
	 catch(Exception e)
	 {
		 
		System.out.println(e); 
	 }

	 

 	
 }


 	
 	
 }
