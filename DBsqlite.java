/* DBsqlite.java */
          
package com.my.sqliteDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.remote.TargetedNotification;

public class DBSqlite {

	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public PreparedStatement psmt = null;
	private String url ;
	
	public DBSqlite (String url) {
		this.url = url;
	}

	public void Select(String tableName) {
		
		
		
		try {
				Class.forName("org.sqlite.JDBC");
				System.out.println("class founded : ok!");
				
						try {
							System.out.println(tableName);
							//String query = "select * from users";
							Connection con = DriverManager.getConnection(url);
							PreparedStatement psmt = con.prepareStatement("select * from " + tableName);
							
							//psmt.setString(1, tableName);
							rs = psmt.executeQuery();
							
							//stmt = con.createStatement();
							//rs = stmt.executeQuery(query);
							while (rs.next()){
								
								String str = rs.getString(1);
								String str2 = rs.getString(2);
								//System.out.println(str2.hashCode());
								String str3 = rs.getString(3);
								System.out.println(str + ","+ str2.trim() +","+ str3);
								
								
							}
						
							} catch (SQLException e) {
								e.printStackTrace();
							}finally {
							
								try {
									if (con != null) con.close();
									if (psmt != null) psmt.close();
								
								}catch (SQLException e) {
									e.printStackTrace();
									
								}
						}
				
			
			
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		
	}
	
	public void insert(String id,String pw) throws SQLException {
		
		int num = lastNum();
			if (num != -1) {
					
					String sql = "insert into users values(?,?,?)";
					Connection con = DriverManager.getConnection(url);
					PreparedStatement psmt = con.prepareStatement(sql);
					psmt.setInt(1, num);
					psmt.setString(2, id);
					psmt.setString(3, pw);
					
					int result = psmt.executeUpdate();
					if (result == 1) { 
						 System.out.println("successfully updated!");
						} else {
							
							 System.out.println("update Failed!");	
						}
			 		if (con !=null) con.close();
			 		if (psmt != null ) psmt.close();
			}
	}
	
	public int lastNum() throws SQLException {
		String sql = "select u_number from users order by u_number desc";
		int result;
		
		
		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		if (rs.next()){
			
			result = rs.getInt(1)+1;
			
			
			if (con !=null) con.close();
	 		if (psmt != null ) psmt.close();
			
			return result;
		}else {
			return -1;
		}
		
		
 		
	}

}


