import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLDBConnector {
	public static Connection getDbConnection() {
		Connection connection = null;
		final String HOST_NAME = System.getProperty("DB_IP_ADDRESS");
		final String PORT = System.getProperty("DB_PORT");
		final String DATABASE = System.getProperty("DB_DATABASE");
		final String USERNAME = System.getProperty("DB_USERNAME");
		final String PASSWORD = System.getProperty("DB_PASSWORD");

		System.out.println(HOST_NAME);
		System.out.println(PORT);
		System.out.println(DATABASE);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DATABASE;
			System.out.println(url);
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
