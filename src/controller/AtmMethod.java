package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import model.User;


public class AtmMethod {
   public static List<User> addList(){ // lấy danh sách user
	   List<User> list = new ArrayList<User>(3);
	   User user1 = new User("lê thế hiếu", "lehieu", "123", 5000000);
		User user2 = new User("vũ mai lâm", "malams", "123", 600000);
		User user4 = new User("nguyễn văn trường", "truong", "123", 1000000);
		
		list.add(user1);
		list.add(user2);
		list.add(user4);
		return list;
   }
   public static  boolean checkAcount(String nameAccount, String password, List<User> list) {  // check tài khoản
	   for(User user : list) {
		   if(user.getAccountName().equals(nameAccount)&&user.getPassword().equals(password)) {
			   return true;
		   }
		 
		  
	   }
	   return false;
   }
   public static  boolean checkAcount1(String nameAccount,List<User> list) {  // check tài khoản
	   for(User user : list) {
		   if(user.getAccountName().equals(nameAccount)) {
			   return true;
		   }
		 
		  
	   }
	   return false;
   }
   public static User getUser(String nameAccount, String password, List<User> list) { // lấy userkhi đăng nhập thanafh công
	   User user = null;
	   for(User users : list) {
		   if(users.getAccountName().equals(nameAccount)&&users.getPassword().equals(password)) {
			  user = users;
			 
		   }
		  
		}
	   if(user!=null) return user;
	   
	   
	   return null;

	   }
	  
  public static User input(Scanner scanner) {  // nhập
	  int n = 0 ;
	  User user = new User();
	  System.out.println("vui lòng nhập tên tài khoản của bạn :");
	  String name = scanner.nextLine();
	  String ten = name.trim();
	  System.out.println("nhap mật khẩu của bạn");
	  String pasS = scanner.nextLine();
	  String pass = pasS.trim();
	  List<User> list = addList();
	 for(int i = 0 ; i<3 ;i++) {
		 if(checkAcount(ten,pass, list)) {
			  user = getUser(name, pasS, list);
			  System.out.println("Xin Chào"+user.getName());
			  break;
		  }
		  else {
			n++;
		}
	 }
	 if(n==3) {System.out.println("Tài khoản của bạn không đúng !") ;  System.exit(0);}
	 return user;
  }
  
  public static void checkMoney(User user) { //check money
	  System.out.println("Tài khoản hiện tại của bạn là : " + user.getMoney());
  }
  
  public static void putOutMoney(Scanner scanner ,User user) { // rut tiền
	  System.out.println("nhập số tiền bạn muốn rút :");
	  int m = 0;
	  try {
		 m = scanner.nextInt();
	} catch (Exception e) {
		System.out.println("vui long nhập chính xác số tiền bạn muốn rut /n số tiền phải là chữ số !");
		System.out.println("bạn muốn tiếp tục y/n?");
		if(action(scanner)== true)  m = scanner.nextInt();
		else {
			System.out.println("Giao dịch thất bại");
			
		}
	}
	  
	  System.out.println("Giao dịch thành công");
	  user.setMoney(user.getMoney()-m);
	  System.out.println("bạn muốn tiếp tục sử dụng dịch vụ  y/n?");
	  if(action(scanner)== true) {
		  menuService(scanner);
	  }
	  else {
		System.out.println("Cám ơn bạn đã sử dụng dịch vụ");
	}
  }
  
  public static boolean action(Scanner scanner) { // xac nhận hanh động
	  String action = scanner.nextLine();
	  if(action.equals("y")) return true;
	  return false;
  }
  
  public static void menuService(Scanner scanner) {  // menu lưa chọn
	  User user = input(scanner);
		  StringBuffer menu = new StringBuffer();
			menu.append("Vui lòng chọn dịch vụ ! Bạn chọn ?").append("\n")
			.append("1.Kiem tra so du").append("\n")
			.append("2.Rut tien").append("\n")
			.append("3.Chuyen tien").append("4.Thoát") ;
		System.out.println(menu);
	    inputMenu(scanner, user);
	
  }
  public static  boolean checkAcountToTransfer(String nameAccount, List<User> list,String account2) {  // check tài khoản
	   for(User user : list) {
		   if(user.getAccountName().equals(nameAccount)&& !user.getAccountName().equals(account2)) {
			   return true;
		   }
		 
	   }
	   return false;
  }
  
  public static  User AcountToTransfer(String nameAccount, List<User> list) {  // check tài khoản
	  User user = new User();
	   for(User users : list) {
		   if(users.getAccountName().equals(nameAccount)) {
			  user= users;
			  return user;
		   }
		   else {
			return null;
		}
	   }
	   return null;
 }
  
  
  public static void transferMoney(Scanner scanner , User user1) {
	  List<User> list = addList();
	  User user2 = new User();
	  int k = 0 ;
	  System.out.println("nhập Account bạn muốn chuyển");
	  String name = scanner.nextLine();
	 if(checkAcount1(name, list)) {  user2 = AcountToTransfer(name, list);
}		
		System.out.println("nhập số tiền bạn muốn chuyển :");
		
		try {
			 k = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Nhập đúng định dạng , số tiền phải là số !");
			if(action(scanner)== true) {
				k = scanner.nextInt();
			}
			else {
				System.out.println("Giao dịch kết thúc");
			}
		}
		
		if(user1.getMoney()< k) {
			 System.out.println("số tiền của bạn không đủ , cảm ơn quí khách đã sử dụng dịch vụ");
				
		}
		else {
			user1.setMoney(user1.getMoney()-k);
		}
	}
  
  
  public static void inputMenu(Scanner scanner ,User user) { // nhâp menu 

	  int n = 0 ;
	  String select = null;
	  for(int i = 0 ; i<3;i++) {
		  System.out.println("nhap luac chon của bạn");
		   select = scanner.nextLine();
		  if(select.equals("1")||select.equals("2")||select.equals("3")||select.equals("4")) break;
		  else {
			  System.out.println("Dịch Vụ không tồn tại");
			n++;
		}
	  }
	  if(n==3) System.out.println("Giao dịch kết thúc");
	  
	  switch(select) {
	    case "1" :{
	    	checkMoney(user);
	    	System.out.println("bạn của muốn tiếp tục sử dụng dịch vụ không ? Bạn chọn y/n ?");
	    	if(action(scanner)==true) inputMenu(scanner,user);
	    	else {
	    		System.out.println("Cám Ơn bạn đã sử dụng dịch vụ");
				break;
			}
	    	break;
	    }
	    case "2" :{
	    	putOutMoney(scanner,user);
	    	System.out.println("bạn của muốn tiếp tục sử dụng dịch vụ không ? Bạn chọn y/n ?");
	    	if(action(scanner)==true) inputMenu(scanner,user);
	    	else {
	    		System.out.println("Cám Ơn bạn đã sử dụng dịch vụ");
	    		
				break;
			}
	    	break;
	    }
	    case "3" :{
	    	transferMoney(scanner, user);
	    	System.out.println("Giao dich thanh công");
	    	if(action(scanner)==true) inputMenu(scanner,user);
	    	else {
	    		System.out.println("Cám Ơn bạn đã sử dụng dịch vụ");
	    		
				break;
			}
	    	break;
	    }
	    case "4" : {
	    	System.out.println("Cám Ơn bạn đã sử dụng dịch vụ");
	    }
	  }
  }
}
