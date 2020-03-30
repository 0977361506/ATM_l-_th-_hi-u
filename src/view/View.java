package view;

import java.util.Scanner;

import controller.AdminTransaction;
import controller.AtmMethod;

public class View {
	public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
    AdminTransaction.input(scanner, AtmMethod.addList());
  }

	
	

	
}
