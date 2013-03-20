import java.util.*;

public class SongQuickSort{
	
	public SongQuickSort(){
		
	}
	
	public ArrayList<Song> quickSort(ArrayList<Song> a, String tag){
		if (a.size() <= 1) {
			return a;
		}
		Song pivot = a.remove(0);
		//System.out.println("Pivot is "+pivot);
		ArrayList<Song> less = new ArrayList<Song>();
		ArrayList<Song> greater = new ArrayList<Song>();
		for (Song x : a){
			if (x.getSomething(tag).compareTo(pivot.getSomething(tag)) <= 0) {
				less.add(x);
				//System.out.println(x+" is less than "+pivot);
			} else {
				greater.add(x);
				//System.out.println(x+" is greater than "+pivot);
			}
		}
		//System.out.println(less);
		//System.out.println(greater);
		ArrayList<Song> a1 = new ArrayList<Song>();
		ArrayList<Song> a2 = new ArrayList<Song>();
		a1 = quickSort(less, tag);
		//System.out.println("A1 is "+a1+" when a is "+a);
		a1.add(pivot);
		//System.out.println("A1 is "+a1);
		a2 = quickSort(greater, tag);
		for (Song y : a2){
			a1.add(y);
		}		
		//System.out.println(a2.typeOf());
		//System.out.println("A1 is "+a1+" when a is "+a);
		
		return a1;
	}
	
}