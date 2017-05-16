import edu.duke.*;
import java.util.*;
public class MovieRunnerAverage {
	public void printAverageRatings(){
		System.out.println("I am in MovieRunner Average");
		
		SecondRatings sr = new SecondRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmoviesfull.csv", "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
		//SecondRatings sr = new SecondRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmovies_short.csv", "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings_short.csv");
		int numOfMovies = sr.getMovieSize();
		int numOfRaters = sr.getRaterSize();
		System.out.println("No of Movies:"+ numOfMovies);
		System.out.println("No of Raters:"+ numOfRaters);
		ArrayList<Rating> aveRating = sr.getAverageRatings(12);
		System.out.println(aveRating);
		String movieTitle = "Maze Runner";
		System.out.println("Size above 20 "+aveRating.size());
		for (Rating rater:aveRating){
			
			System.out.println(rater.getValue()+" "+ sr .getTitle(rater.getItem()));
		}
		
	}
	
	public void getAverageRatingOneMovie(){
		SecondRatings sr = new SecondRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmoviesfull.csv", "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
		//SecondRatings sr = new SecondRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmovies_short.csv", "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings_short.csv");
		String id =sr.getId("The Maze Runner");
		double ave = sr.averageRatingMovie(id);
		System.out.println(ave);
	
		
		
	}
	
	
}
