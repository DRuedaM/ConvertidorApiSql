import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabseManager 
{

	private String user = "root";
	private String password = "admin";
	private String url = "jdbc:mysql://localhost:3306/";
	private String databaseName = "animelist";
	private String table = "USE animelist;"
			+ "CREATE TABLE IF NOT EXISTS animecontent"
			+ "("
			+ "title_ov VARCHAR(45) NOT NULL,"
			+ "synopsis VARCHAR(200) NOT NULL,"
			+ "episodes VARCHAR(45) NOT NULL,"
			+ "status VARCHAR(45) NOT NULL,"
			+ "source VARCHAR(45) NOT NULL,"
			+ "genre VARCHAR(45) NOT NULL,"
			+ "duration VARCHAR(45) NOT NULL,"
			+ "picture_url VARCHAR(100) NOT NULL"
			+ ");";
			
	private Connection connection;
	
	
	public DatabseManager(){}
	
	public DatabseManager(String user, String password, String url, String databaseName)
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
						
			int tableStatus = statement.executeUpdate(table);
			if(tableStatus > 0) System.out.println("Tabla de contenido creada!");
		} 
		catch (Exception e) 
		{
			System.out.println(table);
			e.printStackTrace();
		}
	}
	
	

}
