package bankingapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;

public class Bank_Login {
	 String CustomerName;
	 int CustomerAccNumber=1234000000;
	 String CustomerAddress;
	 String CustomerGender;
	 int TotalAccounts;
	 static int balance;
	Scanner sc = new Scanner(System.in);
	public static Connection get_connection() {
		//get connection
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_System?useTimezone =true&serverTimezone=PST", "root", "Pilli@123");
	//		System.out.println("connected");
			return con;
		}
		catch(Exception e) {
			System.out.println("Not connected");
			e.printStackTrace();
		}
		return null;
	}
	//previous transaction
	public void PreviousTransaction() {
		
	}
	//check if want to continue
	public void ifWantContinue() throws SQLException {
		System.out.println("**********************************************************");
		System.out.println("If you want to continue enter Y or enter N");
		System.out.println("**********************************************************");
		char op = sc.next().charAt(0);
		if( op == 'Y') {
			operations();
		}
		if(sc.next().charAt(0) == 'N') {
			System.out.println("Thank you");
		}
		else {
			System.out.println("PLEASE ENTER A VALID OPTION");
		}
	}
	//selecting operations
	public void operations() throws SQLException {
		System.out.println("Please select an option: ");
		char option = sc.next().charAt(0);
		switch (option) {
		case 'A':
			System.out.println("Please enter your details for creating account");
			System.out.println("Enter Gender:");
			String gender = sc.next();
			System.out.println("Enter Address:");
			String address = sc.next();
			System.out.println("Enter Last Name:");
			String t = sc.next();
			System.out.println("Enter First Name:");
			String u = sc.next();
			
			int accountno= (int) (Math.random()*55.234);
			String prevTrans = null;
			AccountCreating.create_account(accountno,t,u,prevTrans,0,gender,address);
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'B': 
			System.out.println("Please enter your account number:");
			Balance.checkBalance(sc.nextInt());
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'C':
			System.out.println("Enter your Account number: ");
			int acnum = sc.nextInt();
			System.out.println("Enter the amount you want to withdraw: ");
			int withdrawlAmount = sc.nextInt();
			Withdrawing.withdrawl(acnum,withdrawlAmount);
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'D':
			System.out.println("Enter your Account number: ");
			int acnum1 = sc.nextInt();
			System.out.println("Enter the amount you want to deposit");
			int depositAmount = sc.nextInt();
			DepositMoney.deposit(acnum1, depositAmount);
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'E':
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		default:
			System.out.println("PLEASE ENTER A VALID OPTION");
			ifWantContinue();
			break;
		}
	}
	public static void main(String[] args) throws SQLException {
		int accnumber = (int) Math.random()+ 49*3; 
		System.out.println("**********************************************************");
		System.out.println("Welcome to ABC bank. Your AccountNo. is: "+ accnumber);
		System.out.println("**********************************************************");
		System.out.println("A. Create Account");
		System.out.println("B. Check Balance");
		System.out.println("C. Withdrawl");
		System.out.println("D. Deposit");
		System.out.println("E. Previous Transacation");
		Bank_Login bl = new Bank_Login();
		bl.get_connection();
		bl.operations();
	}
}
