package controller;

import java.util.List;
import java.util.Scanner;



import model.Account;


public class AdminTransaction {
	
	public static void input(Scanner scanner ,List<Account> list) {
		System.out.println("nhap tên tài khảon");
		String nameAccount = scanner.nextLine();
		System.out.println("nhap mật khẩu");
	  String  mk = scanner.nextLine();
	  
		   menu(scanner);

	
	}
	   public static  Account getAcount(String nameAccount,List<Account> list) {  // check tài khoản
		   for(Account user : list) {
			   if(user.getAccountName().equals(nameAccount)) {
				   return user;
			   }
			 
			  
		   }
		   return null;
	   }
  public static void viewAccount(List<Account> list) {
	 System.out.println("danh sach account là :");
	 for(Account user : list) {
		 System.out.println(user.getAccountName()+","+user.getName()+","+user.getMoney()+","+"/n");
	 }
  }
  public static void save(List<Account> list, Scanner scanner ) {
	  System.out.println("nhap ten tai khoan");
	  String nameAccount = scanner.nextLine();
	  System.out.println("nhap ten chủ tài khoản");
	  String name = scanner.nextLine();
	  System.out.println("nhap mật khẩu");
	  String pass = scanner.nextLine();
	  System.out.println("nhap số tiền :");
	 int money = scanner.nextInt();

	Account account = new Account(name, nameAccount, pass, money);
	account.setActivated(false);
	account.setRole(false);
	list.add(account);
	System.out.println("thêm mới thành công");
	System.out.println("tài khoản bạn vừa thêm vào  là :" + account.getName());
  }
  public static void disableAccount(Scanner c ,List<Account> list) {
	  System.out.println("nhap tên tài khoản bạn muốn vô hiệu hóa");
	  String nameString = c.nextLine();
	  if(AtmMethod.checkAcount1(nameString, list)==true) {
		  Account account = getAcount(nameString, list);
		 account.setActivated(false);
		 System.out.println("bạn đã vô hiệu hóa tài kharon này!");
	  }
  }
  public static void viewableAccount(Scanner c ,List<Account> list) {
	  System.out.println("nhap tên tài khoản bạn muốn vô hiệu hóa");
	  String nameString = c.nextLine();
	  if(AtmMethod.checkAcount1(nameString, list)==true) {
		  Account account = getAcount(nameString, list);
		 account.setActivated(true);
		 System.out.println("bạn đã kiach hoạt tài khaorn này");
	  }
  }
 public static void menu(Scanner scanner) {
	 System.out.println("bạn muốn vào trang quản trị hay vào trang user ? nhập 1 nếu vào tragn user ? nhâp 2 nếu vào trang quản trị ? bạn chon ?");
	   int lc = scanner.nextInt();
	   if(lc==1) {
		   AtmMethod.menuService(scanner);
		   
	   }
	   else if(lc==2) {
			 List<Account> list = AtmMethod.addList();
			 StringBuffer menu = new StringBuffer();
				menu.append("Vui lòng chọn dịch vụ ! Bạn chọn ?").append("\n")
				.append("1.xem danh sach tài khoản").append("\n")
				.append("2.tạo account mơi").append("\n")
				.append("3.vô hiệu hóa account").append("4.kich hoạt tài khoản") ;
          System.out.println(menu);
			 
			  
				  System.out.println("nhap luac chon của bạn");
				  scanner.nextLine();
				 String  select = scanner.nextLine();
				 
					  switch(select) {
					    case "1" :{
					    	
					    viewAccount(list);
					    	break;
					    }
					    case "2" :{
					    	
					    	
						   save(list, scanner);
					    	break;
					    }
					    case "3" :{
					    	  disableAccount(scanner, list);
								break;
							
					    }
					    case "4" : {
					    	viewableAccount(scanner, list);
					    }
					  }
				  }
					  
				  else {
					  System.out.println("Dịch Vụ không tồn tại ! cám ơn quí khách");
				  }
					 
	   }
	 

		 
	 
	
	  

 }

