package com.my.sqliteDB;

import java.sql.SQLException;



public class MainExe {
	
	
	public static void main(String[] args) throws SQLException {
		MenuList m = new MenuList();
		DBSqlite db = new DBSqlite("jdbc:sqlite:G:\\sqlite3\\databases\\users.db");
	
		while (true) {
				m.printList();
		
				if (m.getCmd() ==1 ) {
					db.Select("users");
					
				}else if (m.getCmd() == 2) {
					System.out.print("id :");
					String id = m.input();
					System.out.println(id);
					System.out.print("pw :");
					String pw = m.input();
					System.out.println(pw);
					
					db.insert(id,pw);
					
				}else if (m.getCmd() == 3) {
					
					
				}else if (m.getCmd() == 4) {
					
				}else {
					
				}
		}
		
	}

}
