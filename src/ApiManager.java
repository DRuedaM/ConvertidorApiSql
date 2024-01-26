import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiManager 
{
	
	public static String makeRequest()
	{
		try 
		{
			//Se realiza una request a la api de myanimelist
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://myanimelist.p.rapidapi.com/anime/1535"))
					.header("X-RapidAPI-Key", "84b2974b8dmsh0aae20c5eaeb6f8p156e46jsn9031e1ec01e3")
					.header("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String makeRequest(String animeName)
	{
		try 
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://myanimelist.p.rapidapi.com/v2/anime/search?q=" + animeName + "&n=1&score=8"))
					.header("X-RapidAPI-Key", "84b2974b8dmsh0aae20c5eaeb6f8p156e46jsn9031e1ec01e3")
					.header("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getAnime(String animeId)
	{
		try 
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://myanimelist.p.rapidapi.com/anime/" + animeId))
					.header("X-RapidAPI-Key", "84b2974b8dmsh0aae20c5eaeb6f8p156e46jsn9031e1ec01e3")
					.header("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}

}
