import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseManager 
{
	
	private Connection connection;
	private String user = "root";
	private String password = "66GgD1d5EhcB6g6AfCGa4aeBFBBhbABg";
	private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:26355/animelist";
	private String databaseName = "animelist";
	private String table = "CREATE TABLE IF NOT EXISTS animecontent"
			+ "("
			+ "title_ov VARCHAR(45) NOT NULL, "
			+ "synopsis VARCHAR(10000) NOT NULL, "
			+ "episodes VARCHAR(45) NOT NULL, "
			+ "status VARCHAR(45) NOT NULL, "
			+ "source VARCHAR(45) NOT NULL, "
			+ "genre VARCHAR(45) NOT NULL, "
			+ "duration VARCHAR(45) NOT NULL, "
			+ "picture_url VARCHAR(100) NOT NULL " 
			+ ")";
	
	
	public DatabaseManager(){}
	
	public DatabaseManager(String user, String password, String url, String databaseName)
	{
		this.user = user;
		this.password = password;
		this.url = url;
		this.databaseName = databaseName;
	}
	
	public void createConnection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			
			int dbStatus = statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
			if(dbStatus > 0) System.out.println("Base de datos creada!");
						
			statement.executeUpdate("USE animelist;");
			
			int tableStatus = statement.executeUpdate(table);
			if(tableStatus == 0) System.out.println("Tabla de contenido creada!");
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void insertData(AnimeContent animeContent)
	{
		createConnection();
		try 
		{
			String query = "INSERT INTO animecontent (title_ov, synopsis, episodes, status, source, genre, duration, picture_url) "
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, animeContent.getTitle_ov());
			preparedStatement.setString(2, animeContent.getSynopsis());
			preparedStatement.setString(3, animeContent.getEpisodes());
			preparedStatement.setString(4, animeContent.getStatus());
			preparedStatement.setString(5, animeContent.getSource());
			preparedStatement.setString(6, animeContent.getGenre());
			preparedStatement.setString(7, animeContent.getDuration());
			preparedStatement.setString(8, animeContent.getPicture_url());
			
			preparedStatement.execute();
			connection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	

}
