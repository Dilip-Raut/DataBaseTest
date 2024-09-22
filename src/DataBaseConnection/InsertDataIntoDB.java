package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertDataIntoDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;
		String dbUrl = "jdbc:mysql://localhost:3306/automationTesting?useSSL=true";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "root";

		Class.forName(driver);
		con = DriverManager.getConnection(dbUrl, userName, password);

		System.out.println("Connection Establish Successfully");
		
		PreparedStatement ps=con.prepareStatement("INSERT into credentials(UserName,Password,DateCreated,NoOfAttempts,Results)values('Dilip','Dilip@01','2024-09-20',13,'Pass')");
		
		System.out.println("Data Inserted Successfully");
		
		ps.executeUpdate();
		
		con.close();

	}
}
