package bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DepositMoney {
	static int balance;
	public static void deposit(int accountnum,int amount) throws SQLException {
		try{
			String query = "select balance from Bank_System.bank_systems where Account_Number = ?";
			Connection con = Bank_Login.get_connection();
			PreparedStatement balance_check = con.prepareStatement(query);
			balance_check.setInt(1,accountnum);
			ResultSet rs =balance_check.executeQuery();
			while(rs.next()) {
				balance = rs.getInt("Balance");
			}
			balance = balance+amount;
			
			balance_check = con.prepareStatement("Update Bank_System.bank_systems SET Balance=? where Account_Number=?");
			balance_check.setInt(1, balance);
			balance_check.setInt(2, accountnum);
			balance_check.executeUpdate();
		}
		finally {
			
		}
		Bank_Login.balance = Bank_Login.balance+amount;
	}
}
