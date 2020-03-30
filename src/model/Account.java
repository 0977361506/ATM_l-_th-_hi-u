package model;

public class Account {
   private String name;
   private String accountName;
   private String password;
   private int money;
   private boolean  role;
   private boolean activated;
public boolean isActivated() {
	return activated;
}
public void setActivated(boolean activated) {
	this.activated = activated;
}
public Account(String name, String accountName, String password, int money, boolean role, boolean activated) {
	super();
	this.name = name;
	this.accountName = accountName;
	this.password = password;
	this.money = money;
	this.role = role;
	this.activated = activated;
}
public Account(String name, String accountName, String password, int money, boolean role) {
	super();
	this.name = name;
	this.accountName = accountName;
	this.password = password;
	this.money = money;
	this.role = role;
}
public boolean isRole() {
	return role;
}
public void setRole(boolean role) {
	this.role = role;
}
public Account() {
	super();
}
public Account(String name, String accountName, String password, int money) {
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
