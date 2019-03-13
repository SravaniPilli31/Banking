package bankingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AccountCreating {
	Bank_Login bl = new Bank_Login();
public static void create_account(int accnum,String lastname, String firstname, String prevT, int balance, String gender, String address) throws SQLException {
		
		try{
			String query = "insert into Bank_System.bank_systems(Account_Number,Last_Name,First_Name,Previous_Transaction,Balance,Gender,Address)values(?,?,?,?,?,?,?)";
			Connection con = Bank_Login.get_connection();
			PreparedStatement creation_Status = con.prepareStatement(query);
			creation_Status.setInt(1,accnum);
			creation_Status.setString(2,lastname);
			creation_Status.setString(3,firstname);
			creation_Status.setString(4,prevT);
			creation_Status.setInt(5,balance);
			creation_Status.setString(6,gender);
			creation_Status.setString(7,address);
			creation_Status.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Details updated");
		}
	}

}
