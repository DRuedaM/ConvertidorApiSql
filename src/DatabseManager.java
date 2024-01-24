
public class DatabseManager 
{

	private String user = "root";
	private String password = "admin";
	private String url = "jdbc:mysql://localhost:3306/AnimeList";
	
	public DatabseManager(){}
	
	public DatabseManager(String user, String password, String url)
	{
		this.user = user;
		this.password = password;
		this.url = url;
	}
	
	public void createConnection()
	{
		
	}

}
