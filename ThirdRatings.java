
import edu.duke.*;
import java.util.*;
public class ThirdRatings {
	//private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings_short.csv");
    }

	public ThirdRatings(String ratingsfile) {
		//Create a ThirdRatings Object
		
		FirstRatings fr = new FirstRatings();
		
		myRaters=fr.loadRaters(ratingsfile);
	}
	
	
	
	public int getRaterSize(){
		
		return myRaters.size();
	}
    
	
	private double getAveragebyId(String movieId,int minimalRaters){
		
		int numOfRaters=0;
		double sum =0.0;
		
		for (Rater rater:myRaters){
			if(rater.hasRating(movieId)){
				numOfRaters++;
			}
		}
			if (numOfRaters>=minimalRaters){
				for (Rater rater1:myRaters){
					if(rater1.hasRating(movieId)){
						sum+=rater1.getRating(movieId);
					}
				}
				double ave= sum/numOfRaters;
				return ave;
			}
			
			else{
				return 0.0;
				}	
	}
	
	public ArrayList<Rating> getAverageRatings (int minimalRaters){
		
		ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
		ArrayList<Rating> rating = new ArrayList<Rating>();
		//Rating rat = new Rating("",0.0);
		for (String movie_id:myMovies){
			//String movie_Id= movie.getID();
			if (getAveragebyId(movie_id,minimalRaters)!=0.0){
				Rating rat = new Rating(movie_id,getAveragebyId(movie_id,minimalRaters));
				//rat = new Rating(movie_id,getAveragebyId(movie_id,minimalRaters));
				rating.add(rat);
			}
			
		}
		Collections.sort(rating);
		return rating;
	}
	

	public double averageRatingMovie(String movie_id){
		double numOfRaters=0.0;
		double sum =0.0;
		
		for (Rater rater:myRaters){
			if(rater.hasRating(movie_id)){
				numOfRaters++;
				sum+= rater.getRating(movie_id);
			}
			
		
		}
		
		double ave= sum/numOfRaters;
		
		return ave;
	}
	
	public ArrayList<Rating> getAverateRatingsByFilter(int minimalRaters,Filter filterCriteria){
		ArrayList<Rating> filterRating = new ArrayList<Rating>();
		ArrayList<String> movie_ids = MovieDatabase.filterBy(filterCriteria);
		//System.out.println("I am in averege filer "+movie_ids);
		for (String movie_id:movie_ids){
			//System.out.println(movie_id);
			//String movie_Id= movie.getID();
			//System.out.println(getAveragebyId(movie_id,minimalRaters));
			if (getAveragebyId(movie_id,minimalRaters)!=0.0){
				Rating rat = new Rating(movie_id,getAveragebyId(movie_id,minimalRaters));
				//System.out.println("I am here "+rat.getItem());
				//rat = new Rating(movie_id,getAveragebyId(movie_id,minimalRaters));
				filterRating.add(rat);
			}
			
		}
		Collections.sort(filterRating);
		return filterRating;
	}
}
