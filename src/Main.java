import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main
{
	public static void main(String[] args)
	{
		try 
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://myanimelist.p.rapidapi.com/anime/52991"))
					.header("X-RapidAPI-Key", "8753c6cf24msh53b46ad39a8d287p1eb4f4jsn6e87232224ca")
					.header("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
