import java.util.ArrayList;

public class MovieRunnerWithFilters {

	public void printAverageRatings(){
		System.out.println("I am in MovieRunner With Filters");
		FourthRatings sr = new FourthRatings();
		//ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
		//SecondRatings sr = new SecondRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmovies_short.csv", "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings_short.csv");
		//int numOfMovies = sr.getMovieSize();
		//int numOfRaters = sr.getRaterSize();
		int numOfRaters = 0;
		//System.out.println("No of Movies:"+ numOfMovies);
		System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
		MovieDatabase.initialize("ratedmoviesfull.csv");
		int movieSize = MovieDatabase.size();
		System.out.println("No of Movies Found from Fourth Ratings:"+ movieSize);
		ArrayList<Rating> aveRating = sr.getAverageRatings(35);
		System.out.println("Found Average Ratings "+aveRating.size()+" movies");
		//String movieTitle = "Maze Runner";
		//System.out.println("Size above 20 "+aveRating.size());
		/*for (Rating rater:aveRating){
			
			//System.out.println(rater.getItem());
			System.out.println(rater.getValue()+" "+MovieDatabase.getTitle(rater.getItem()));
		}*/
		
		
	}
		
	public void printAverageRatingsByYear() {
		
		//Create a Third Rating Object
		ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
		//Get the Number of raters
		int numOfRaters = sr.getRaterSize();
		System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
		MovieDatabase.initialize("ratedmoviesfull.csv");
		int movieSize = MovieDatabase.size();
		System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
		ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter(20, new YearAfterFilter(2000));
		System.out.println("Found by year "+aveRating.size()+" movies");
		//String movieTitle = "Maze Runner";
		//System.out.println("Size above 20 "+aveRating.size());
		/*for (Rating rater:aveRating){
			
			//System.out.println(rater.getItem());
			System.out.println(rater.getValue()+" "+MovieDatabase.getTitle(rater.getItem()));
		}*/
		// TODO Auto-generated method stub
		
	}
	
	public void printAverageRatingsByGenre() {
		
		//Create a Third Rating Object
		ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
		//Get the Number of raters
		int numOfRaters = sr.getRaterSize();
		System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
		MovieDatabase.initialize("ratedmoviesfull.csv");
		int movieSize = MovieDatabase.size();
		System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
		String genre = "Comedy";
        GenreFilter genrefiler = new GenreFilter(genre);
        int miniRatings = 20;
        ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter (miniRatings, genrefiler);
        //System.out.println("Total movie have above " + miniRatings + " ratings: " + aveRating.size());
		
		System.out.println("Found By Genre "+aveRating.size()+" movies");
		//String movieTitle = "Maze Runner";
		//System.out.println("Size above 20 "+aveRating.size());
		/*for (Rating rater:aveRating){
			
			//System.out.println(rater.getItem());
			System.out.println(rater.getValue()+" "+MovieDatabase.getTitle(rater.getItem()));
			System.out.println("       "+MovieDatabase.getGenres(rater.getItem()));
		}*/
	}
		
		public void printAverageRatingsByMinutes() {
			
			//Create a Third Rating Object
			ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
			//Get the Number of raters
			int numOfRaters = sr.getRaterSize();
			System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
			MovieDatabase.initialize("ratedmoviesfull.csv");
			int movieSize = MovieDatabase.size();
			System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
			int minTime = 105;
			int maxTime= 135;
	       
	        MinutesFilter minMaxFilter = new MinutesFilter(minTime,maxTime);
	        int miniRatings = 5;
	        ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter (miniRatings, minMaxFilter);
	        //System.out.println("Total movie have above " + miniRatings + " ratings: " + aveRating.size());
			
			System.out.println("Found with Minutes "+aveRating.size()+" movies");
			//String movieTitle = "Maze Runner";
			//System.out.println("Size above 20 "+aveRating.size());
			/*for (Rating rater:aveRating){
				
				//System.out.println(rater.getItem());
				System.out.println(rater.getValue()+" Time: "+MovieDatabase.getMinutes(rater.getItem())+" "+MovieDatabase.getTitle(rater.getItem()));
				//System.out.println("       "+MovieDatabase.getMinutes(rater.getItem()));
			}*/
	}
		
		public void printAverageRatingsByDirector() {
			
			//Create a Third Rating Object
			ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
			//Get the Number of raters
			int numOfRaters = sr.getRaterSize();
			System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
			MovieDatabase.initialize("ratedmoviesfull.csv");
			int movieSize = MovieDatabase.size();
			System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
			String director = "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
			
	       
	        DirectorsFilter directorFilter = new DirectorsFilter(director);
	        int miniRatings = 4;
	        ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter (miniRatings, directorFilter);
	        //System.out.println("Total movie have above " + miniRatings + " ratings: " + aveRating.size());
			
			System.out.println("Found By Director "+aveRating.size()+" movies");
			//String movieTitle = "Maze Runner";
			//System.out.println("Size above 20 "+aveRating.size());
			/*for (Rating rater:aveRating){
				
				//System.out.println(rater.getItem());
				System.out.println(rater.getValue()+" "+MovieDatabase.getTitle(rater.getItem()));
				System.out.println("       "+MovieDatabase.getDirector(rater.getItem()));
			}*/
	}
		
		public void printAverageRatingsByDirectorsAndMinutes(){
			
			ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
			//Get the Number of raters
			int numOfRaters = sr.getRaterSize();
			System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
			MovieDatabase.initialize("ratedmoviesfull.csv");
			int movieSize = MovieDatabase.size();
			System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
			AllFilters allfilter= new AllFilters();
			String director = "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
			allfilter.addFilter(new DirectorsFilter(director));
			int minTime = 90;
			int maxTime= 180;
			allfilter.addFilter(new MinutesFilter(minTime,maxTime));
			int miniRatings = 3;
	        ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter (miniRatings, allfilter);
	        System.out.println("Found by Director and Minutes "+aveRating.size()+" movies");
			//String movieTitle = "Maze Runner";
			//System.out.println("Size above 20 "+aveRating.size());
			/*for (Rating rater:aveRating){
				
				//System.out.println(rater.getItem());
				System.out.println(rater.getValue()+" "+MovieDatabase.getMinutes(rater.getItem()) +" "+MovieDatabase.getTitle(rater.getItem()));
				System.out.println("       "+MovieDatabase.getDirector(rater.getItem()));
			}*/
			
			
		}
		
		public void printAverageRatingsByYearAfterAndGenre(){
			ThirdRatings sr = new ThirdRatings("C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings.csv");
			//Get the Number of raters
			int numOfRaters = sr.getRaterSize();
			System.out.println("No of Raters from Third Ratings:"+ numOfRaters);
			MovieDatabase.initialize("ratedmoviesfull.csv");
			int movieSize = MovieDatabase.size();
			System.out.println("No of Movies Found from Third Ratings:"+ movieSize);
			AllFilters allfilter= new AllFilters();
			
			allfilter.addFilter(new YearAfterFilter(1990));
			allfilter.addFilter(new GenreFilter("Drama"));
			int miniRatings = 8;
	        ArrayList<Rating> aveRating = sr.getAverateRatingsByFilter (miniRatings, allfilter);
	        System.out.println("Found year and Genre "+aveRating.size()+" movies");
			//String movieTitle = "Maze Runner";
			//System.out.println("Size above 20 "+aveRating.size());
			/*for (Rating rater:aveRating){
				
				//System.out.println(rater.getItem());
				System.out.println(rater.getValue()+" "+MovieDatabase.getYear(rater.getItem()) +" "+MovieDatabase.getTitle(rater.getItem()));
				System.out.println("       "+MovieDatabase.getGenres(rater.getItem()));
			}*/
			
			
		}
}
