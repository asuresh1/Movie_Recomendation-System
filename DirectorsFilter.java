import java.util.ArrayList;
import java.util.Arrays;

public class DirectorsFilter implements Filter{
	private ArrayList<String> myDirectors;
	private String directorName;
	
	public DirectorsFilter(String director) {
		directorName = director;
		
	}
	@Override
	public boolean satisfies(String id) {
		String movieDirector = MovieDatabase.getDirector(id);
		
		ArrayList<String> directorsList = new ArrayList<String>(Arrays.asList(movieDirector.split(", ")));
		ArrayList<String> myDirectors = new ArrayList<String>(Arrays.asList(directorName.split(", ")));
		System.out.println(directorsList +" "+myDirectors );
		
		for (String name:myDirectors){
			if (directorsList.contains(name)){return true;}
			
		}
		return false;
		
	}

}
