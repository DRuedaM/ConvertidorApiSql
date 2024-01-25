import com.google.gson.annotations.Expose;

public class AnimeContent 
{
	@Expose private String title_ov;
	@Expose private String synopsis;
	@Expose private String episodes;
	@Expose private String status;
	@Expose private String source;
	@Expose private String genre;
	@Expose private String duration;
	@Expose private String picture_url;
	
	
	
	
	
	public AnimeContent(String title_ov, String synopsis, String episodes, String status, String source, String genre,
			String duration, String picture_url) 
	{
		this.title_ov = title_ov;
		this.synopsis = synopsis;
		this.episodes = episodes;
		this.status = status;
		this.source = source;
		this.genre = genre;
		this.duration = duration;
		this.picture_url = picture_url;
	}
	
	
	public void showAllAtributes()
	{
		System.out.println(title_ov);
		System.out.println(synopsis);
		System.out.println(episodes);
		System.out.println(status);
		System.out.println(source);
		System.out.println(genre);
		System.out.println(duration);
		System.out.println(picture_url);
	}
	
	public String getTitle_ov() {
		return title_ov;
	}
	public void setTitle_ov(String title_ov) {
		this.title_ov = title_ov;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getEpisodes() {
		return episodes;
	}
	public void setEpisodes(String episodes) {
		this.episodes = episodes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	
	

}
