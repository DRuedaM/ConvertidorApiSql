import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Main
{
	public static void main(String[] args)
	{
		try 
		{
			String animeName;
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduzca el nombre del anime a buscar");
			animeName = teclado.nextLine();
			animeName = animeName.replace(" ", "%20");
			//Se hace primero una busqueda del anime introducido por el usuario
			JsonArray jsonBusqueda = new Gson().fromJson(ApiManager.makeRequest(animeName), JsonArray.class);
			String resultadoBusqueda = jsonBusqueda.get(0).getAsJsonObject().get("myanimelist_id").getAsString();
						
			JsonObject jsonResultado= new Gson().fromJson(ApiManager.getAnime(resultadoBusqueda), JsonObject.class);
			//Se crea el objeto AnimeContent para enviar los datos a la base de datos
			AnimeContent animeContent = generateClass(jsonResultado);
			
			//Se crea una instancia de la clase DatabaseManager
			DatabaseManager dManager = new DatabaseManager();
			//Abrimos la conexion con la base de datos
			dManager.insertData(animeContent);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	public static AnimeContent generateClass(JsonObject json) 
	{
		AnimeContent animeContent = new AnimeContent(json.get("title_ov").getAsString(), json.get("synopsis").getAsString(), json.get("information").getAsJsonObject().get("episodes").getAsString(), 
				json.get("information").getAsJsonObject().get("status").getAsString(), json.get("information").getAsJsonObject().get("source").getAsString(), 
				json.get("information").getAsJsonObject().get("genre").getAsString(), json.get("information").getAsJsonObject().get("duration").getAsString(), json.get("picture_url").getAsString());
		
		return animeContent;
	}
}
