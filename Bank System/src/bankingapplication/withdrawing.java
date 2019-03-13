package bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Withdrawing {
	static int balance;
	//withdraw
		public static void withdrawl(int accountnum, int amount) throws SQLException {
			try{
				String query = "select balance from Bank_System.bank_systems where Account_Number = ?";
				Connection con = Bank_Login.get_connection();
				PreparedStatement balance_check = con.prepareStatement(query);
				balance_check.setInt(1,accountnum);
				ResultSet rs =balance_check.executeQuery();
				while(rs.next()) {
					balance = rs.getInt("Balance");
				}
				if(balance ==0 || balance < amount) {
					System.out.println("Not enough balance in your account");
				}
				else {
					balance = balance - amount;
					System.out.println("Please collect cash");
				}
				balance_check = con.prepareStatement("Update Bank_System.bank_systems SET Balance=? where Account_Number=?");
				balance_check.setInt(1, balance);
				balance_check.setInt(2, accountnum);
				balance_check.executeUpdate();
			}
			finally {
				//update prevoius transaction
				Previous_Transaction.prev_transaction(accountnum, "Balance Check");
			}
			
		}
}
