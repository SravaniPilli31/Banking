package bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Balance {
	public static void checkBalance(int accountnum) throws SQLException {
		//select balance from Bank_System.bank_systems where Account_Number = ?;
		String query = "select balance from Bank_System.bank_systems where Account_Number = ?";
		try{
			Connection con = Bank_Login.get_connection();
			PreparedStatement balance_check = con.prepareStatement(query);
			balance_check.setInt(1,accountnum);
			ResultSet rs =balance_check.executeQuery();
			while(rs.next()) {
				System.out.println("Your account balance is : " +rs.getInt("Balance"));
			}
		}
		finally {
			
		}
	}
}
