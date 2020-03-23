package model;

public class User {
   private String name;
   private String accountName;
   private String password;
   private int money;
public User() {
	super();
}
public User(String name, String accountName, String password, int money) {
	super();
	this.name = name;
	this.accountName = accountName;
	this.password = password;
	this.money = money;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
   
}
