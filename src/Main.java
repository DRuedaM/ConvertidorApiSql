import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main
{
	public static void main(String[] args)
	{
		try 
		{
			DatabseManager dManager = new DatabseManager();
			dManager.createConnection();
			
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://myanimelist.p.rapidapi.com/anime/52991"))
					.header("X-RapidAPI-Key", "8753c6cf24msh53b46ad39a8d287p1eb4f4jsn6e87232224ca")
					.header("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			Gson gson = new Gson();
			JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);
			
			AnimeContent animeContent = new AnimeContent(json.get("title_ov").getAsString(), json.get("synopsis").getAsString(), json.get("information").getAsJsonObject().get("episodes").getAsString(), 
					json.get("information").getAsJsonObject().get("status").getAsString(), json.get("information").getAsJsonObject().get("source").getAsString(), 
					json.get("information").getAsJsonObject().get("genre").getAsString(), json.get("information").getAsJsonObject().get("duration").getAsString(), json.get("picture_url").getAsString());
			
			animeContent.showAllAtributes();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
