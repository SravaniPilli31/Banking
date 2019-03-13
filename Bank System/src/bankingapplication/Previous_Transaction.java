package bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Previous_Transaction {
	public static void whichTransaction(int accountnum) throws SQLException {
		String query = "Select Previous_Transaction from Bank_System.bank_systems where Account_Number=?";
		Connection con = Bank_Login.get_connection();
		PreparedStatement balance_check = con.prepareStatement(query);
		balance_check.setInt(1,accountnum);
		ResultSet rs = balance_check.executeQuery();
		while(rs.next()) {
			System.out.println("Previous transaction on this account is : " +rs.getString("Previous_Transaction"));
		}
	}
	public static void prev_transaction(int accountnum, String transaction) throws SQLException {
		try{
			String query = "Update Bank_System.bank_systems SET Previous_Transaction=? where Account_Number=?";
			Connection con = Bank_Login.get_connection();
			PreparedStatement balance_check = con.prepareStatement(query);
			balance_check.setString(1, transaction);
			balance_check.setInt(2, accountnum);
			balance_check.executeUpdate();
		}
		finally {
			
		}
	}
}
