package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyJDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/quancafe";
			String usr = "root";
			String password = "";
			conn = DriverManager.getConnection(url, usr, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
