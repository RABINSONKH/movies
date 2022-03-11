package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MoviesFilterByActorName {

	public static void main(String[] args) {
			System.out.println("Enter the actor Name: ");
		 	Scanner in = new Scanner(System.in);
	        String actorName = in.nextLine();
	        
	 
		String jdbcUrl = "jdbc:sqlite:/C:\\sqlite3\\SQLiteStudio\\movies.db";	
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "select * from movies where LeadActor = " + "'"+ actorName+"'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			int rowCount = 0;
			
			while(result.next()) {
				rowCount++;
				Integer Id = result.getInt("Id");
				String Name = result.getString("Name");
				String LeadActor = result.getString("LeadActor");
				String Actress = result.getString("Actress");
				Integer YearOfRelease = result.getInt("YearOfRelease");
				String DirectorName = result.getString("DirectorName");
				
				System.out.println(Id + " | "+ Name + LeadActor + " | "+ Actress + YearOfRelease + " | "+ DirectorName);
			}
			if( rowCount == 0) {
				System.out.println("There are no movies of this Actor : "+ actorName);
			}
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}

	}

}
