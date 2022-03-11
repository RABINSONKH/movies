package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class movies {
	
	public static void main(String[] args) {
	
		String jdbcUrl = "jdbc:sqlite:/C:\\sqlite3\\SQLiteStudio\\movies.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM movies";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Integer Id = result.getInt("Id");
				String Name = result.getString("Name");
				String LeadActor = result.getString("LeadActor");
				String Actress = result.getString("Actress");
				Integer YearOfRelease = result.getInt("YearOfRelease");
				String DirectorName = result.getString("DirectorName");
				
				System.out.println(Id + " | "+ Name + LeadActor + " | "+ Actress + YearOfRelease + " | "+ DirectorName);
			}
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
		
		
	}
}