import java.util.Scanner;

class Bank_Login {
	 String CustomerName;
	 int CustomerAccNumber=1234000000;
	 String CustomerAddress;
	 String CustomerGender;
	 int TotalAccounts;
	 int balance;
	Scanner sc = new Scanner(System.in);
	public void create_account(String name, int age, String address, String gender) {
		CustomerName = name;
		CustomerAccNumber = CustomerAccNumber+1;
		CustomerAddress = address;
		CustomerGender = gender;
	}
	public int checkBalance(int accountnum) {
		return balance;
	}
	public void withdrawl(int amount) {
		if(balance ==0 || balance < amount) {
			System.out.println("Not enough balance in your account");
		}
		else {
			balance = balance - amount;
			System.out.println("Please collect cash");
		}
	}
	public void deposit(int amount) {
		balance = balance+amount;
	}
	public void PreviousTransaction() {
		
	}
	public void ifWantContinue() {
		System.out.println("**********************************************************");
		System.out.println("If you want to continue enter Y or enter N");
		System.out.println("**********************************************************");
		if(sc.next().charAt(0) == 'Y') {
			operations();
		}
		if(sc.next().charAt(0) == 'N') {
			System.out.println("Thank you");
		}
		else {
			System.out.println("PLEASE ENTER A VALID OPTION");
		}
	}
	public void operations() {
		System.out.println("Please select an option: ");
		char option = sc.next().charAt(0);
		switch (option) {
		case 'A': 
			System.out.println("Your account balance is: "+ balance);
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'B':
			System.out.println("Enter the amount you want to withdraw: ");
			int withdrawlAmount = sc.nextInt();
			withdrawl(withdrawlAmount);
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'C':
			System.out.println("Enter the amount you want to deposit");
			int depositAmount = sc.nextInt();
			balance = balance + depositAmount;
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		case 'D':
//			System.out.println();
			ifWantContinue();
			System.out.println("**********************************************************");
			break;
		default:
			System.out.println("PLEASE ENTER A VALID OPTION");
			ifWantContinue();
			break;
	}
	}

}
public class Bank_System{
	public static void main(String[] args) {
		int accnumber = (int) Math.random()+ 49*3; 
		System.out.println("**********************************************************");
		System.out.println("Welcome to ABC bank. Your AccountNo. is: "+ accnumber);
		System.out.println("**********************************************************");
		System.out.println("A. Check Balance");
		System.out.println("B. Withdrawl");
		System.out.println("C. Deposit");
		System.out.println("D. Previous Transacation");
		Bank_Login bl = new Bank_Login();
		bl.operations();
		
			
	}
}
