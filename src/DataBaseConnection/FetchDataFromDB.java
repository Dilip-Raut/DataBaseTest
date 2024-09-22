package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDataFromDB {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Connection con=null;
		String dbUrl="jdbc:mysql://localhost:3306/automationTesting?useSSL=true";
		String driver="com.mysql.cj.jdbc.Driver";
		String userName ="root";
		String password="root";
		
		Class.forName(driver);
		con=DriverManager.getConnection(dbUrl,userName,password);
		
		System.out.println("Connection Establish Successfully");
		
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from credentials");
		
		while(rs.next()) {
			
			System.out.println("UserName : "+rs.getString("UserName")+"  "
					+"Password : "+rs.getString("Password")+"	"
					+"DateCreated : "+rs.getString("DateCreated")+"  "
					+"NoOfAttempts : "+rs.getString("NoOfAttempts")+"  "
					+"Results : "+rs.getString("Results")
					);
		}
		
		rs.close();
		

	}

}
