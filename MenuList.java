package com.my.sqliteDB;

import java.util.Scanner;

public class MenuList {
	Scanner sc;
	int cmd ;
	
	public MenuList () {
		this.cmd = 0;
	}

	public void printList() {
		int sel = 0;
		sc = new Scanner(System.in);
		boolean isGoing = true;
		while (isGoing) {
			System.out.println("1.select 2.insert 3.delete 4.update");
			sel = sc.nextInt();
			
				switch (sel) {
				case 1:
					System.out.println("select");
					setCmd(1);
					isGoing = false;
					break;
				case 2:
					isGoing = false;
					setCmd(2);
					System.out.println("insert");
					break;
				case 3:
					isGoing = false;
					setCmd(3);
					System.out.println("delete");
					break;
				case 4:
					isGoing = false;
					setCmd(4);
					System.out.println("update");
					break;
				default :
					System.out.println("not available");
										
					}
				
				}
	}
	
	public String input() {
		String input;
		input = sc.next();
	
		return input;
	}
	
	public void setCmd(int i) {
		
		this.cmd = i;
	}
	
	public int getCmd() {
		
		return this.cmd;
	}
}
