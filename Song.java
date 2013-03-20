public class Song {
	
	private String name;
	private String artist;
	private String album;
	private String genre;
	
	public Song(String namenew, String artistnew, String albumnew, String genrenew){
		name = namenew;
		artist = artistnew;
		album = albumnew;
		genre = genrenew;
		//System.out.println(name+artist+album);
	}
	
	public String getSomething(String tag){
		if (tag == "name"){
			return name;
		} else if (tag == "artist") {
			return artist;
		} else if (tag == "album") {
			return album;
		} else if (tag == "genre") {
			return genre;
		} else {
			return "false";
		}
	}
	
	public String toString(){
		return name+" by "+artist+" on "+album;
	}
}