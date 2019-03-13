package bankingapplication;

class Withdrawing {
	//withdraw
		public static void withdrawl(int amount) {
			
			if(Bank_Login.balance ==0 || Bank_Login.balance < amount) {
				System.out.println("Not enough balance in your account");
			}
			else {
				Bank_Login.balance = Bank_Login.balance - amount;
				System.out.println("Please collect cash");
			}
		}
}
