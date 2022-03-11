package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateMoviesTable {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:sqlite:/C:\\sqlite3\\SQLiteStudio\\movies.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			
			String sql = "INSERT INTO movies (Name,LeadActor,Actress,YearOfRelease,DirectorName) VALUES ('The Shawshank Redemption ','Morgan Freeman','Renee Blaine',1994,'Frank Darabont'),('The Godfather ','Al Pacino','Renee Blaine',1972,'Francis Ford'),('The Dark knight ','Christain Bale','Renee Blaine',2008,'Christopher Nolan'),('Wolf of Wallstreet ','Leonardo DiCaprio','Renee Blaine',2013,'Martin Scorsese'),('Inception ','Leonardo DiCaprio','Renee Blaine',2010,'Christopher Nolan')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
		
		
	}

	}
