package genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {
	public String fetchDataFromDatabase(Connection connection, String query) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(query);
		if (result.next())
			return result.getString(1);
		return "";
	}

	public void insertDataIntoDatabase(Connection connection, String query) throws SQLException {
		int result = connection.createStatement().executeUpdate(query);
		if (result == 1)
			System.out.println("Database updated");
		else
			System.out.println("Database not updated");
	}
}
