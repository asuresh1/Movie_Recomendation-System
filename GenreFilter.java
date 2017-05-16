import java.util.ArrayList;
import java.util.Arrays;

public class GenreFilter implements Filter{
	private String myGenre;
	
	public GenreFilter(String genre){
		myGenre = genre;
	}
	
	@Override
	public boolean satisfies(String id){
		
		
		String genreList = MovieDatabase.getGenres(id);
		
		ArrayList<String> allList = new ArrayList<String>(Arrays.asList(genreList.split(", ")));
		
		if (allList.contains(myGenre)){
			
			return true;
		}
		else{
			return false;
		}
		
	}

}


