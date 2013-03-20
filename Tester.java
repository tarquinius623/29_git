import java.io.*;
import java.util.*;
import java.math.*;

public class Tester {
	
	private ArrayList<Song> songs;
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> artist = new ArrayList<String>();
	private ArrayList<String> album = new ArrayList<String>();
	private ArrayList<String> genre = new ArrayList<String>();

	
	public static void main(String[] args) {
		Tester t = new Tester();
		SongQuickSort q = new SongQuickSort();

		t.setSongs(q.quickSort(t.getSongs(), "name"));
		for (int i = 0; i < t.getSongs().size(); i++){
			//System.out.println(t.getSongs().get(i));
		}
		
		SongBinarySearch b = new SongBinarySearch();
		System.out.println("");
		System.out.println(b.binarySearch(t.getSongs(), "name", "Fixing A Hole", 0, t.getSongs().size()));
		System.out.println(b.binarySearch(t.getSongs(), "name", "Ziggy Stardust", 0, t.getSongs().size()));
	}
	
	public Tester(){
		construct();
		//System.out.println(name.get(5000));
		System.out.println("");
		//System.out.println(artist.get(5000));
		System.out.println("");
		//System.out.println(genre.get(5000));
		System.out.println("");
		int counter = 0;
		for (int i=0; i < 5100; i++) {
			if (name.get(i) != null && artist.get(i) != null && album.get(i) != null && genre.get(i) != null) {
				Song s = new Song(name.get(i), artist.get(i), album.get(i), genre.get(i));
				songs.add(s);
				//System.out.println(s);
			} else {
				break;
			}
		}
	}
	
	public void construct()  {
		songs = new ArrayList<Song>();
		try {
			BufferedReader CSVFile = new BufferedReader(new FileReader("bens_library.csv"));
		
			String dataRow = CSVFile.readLine(); // Read first line.
			// The while checks to see if the data is null. If 
			// it is, we've hit the end of the file. If not, 
			// process the data.
		
			while (dataRow != null){
				int count = 0;
			
				String[] dataArray = dataRow.split(",");
				for (String item:dataArray) { 
					//System.out.print(item + "\t"); 
					count++;
					if (count == 1) {
						name.add(item);
					} else if (count == 2) {
						artist.add(item);
					} else if (count == 3) {
						album.add(item);
					} else if (count == 4) {
						genre.add(item);
					}
				}
			
				//System.out.println(); // Print the data line.
				dataRow = CSVFile.readLine(); // Read next line of data.

			}
			// Close the file once all data has been read.
			CSVFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(genre);
	}
	
	
	public ArrayList<Song> getSongs(){
		return songs;
	}
	
	public void setSongs(ArrayList<Song> newSongs) {
		songs = newSongs;
	}
}