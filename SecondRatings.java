
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmovies", "ratings.csv");
    }

	public SecondRatings(String moviefile, String ratingsfile) {
		//Create a FirstRatings Object
		System.out.println("I am in Second rating");
		FirstRatings fr = new FirstRatings();
		myMovies=fr.loadMovies(moviefile);
		myRaters=fr.loadRaters(ratingsfile);
	}
	
	public int getMovieSize(){
		
		return myMovies.size();
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
		
		ArrayList<Rating> rating = new ArrayList<Rating>();
		for (Movie movie:myMovies){
			String movie_Id= movie.getID();
			if (getAveragebyId(movie_Id,minimalRaters)!=0.0){
				Rating rat = new Rating(movie_Id,getAveragebyId(movie_Id,minimalRaters));
				rating.add(rat);
			}
			
		}
		Collections.sort(rating);
		return rating;
	}
	
	public String getTitle(String movie_Id){
		
		for (Movie movie:myMovies){
			if (movie.getID().equals(movie_Id)){
				return movie.getTitle();
			}
			
		}
		return "Movie not Found";
	}
	
	public String getId(String movieTitle){
		
		for (Movie movie:myMovies){
			if (movie.getTitle().equals(movieTitle)){
				return movie.getID();
			}
			
		}
		return "No Such Title";
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
	
}

