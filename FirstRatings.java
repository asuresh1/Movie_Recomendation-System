import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;


public class FirstRatings {

	
	public ArrayList<Movie> loadMovies(String fileName){
		System.out.println(fileName);
		FileResource fr = new FileResource(fileName);
		CSVParser parser = fr.getCSVParser();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		for (CSVRecord currRow: parser){
			Movie currMovie = new Movie(currRow.get("id"), currRow.get("title"), currRow.get("year"), currRow.get("genre"), 
					currRow.get("director"),currRow.get("country"),currRow.get("poster"),Integer.parseInt(currRow.get("minutes")));
				    
			movies.add(currMovie);
			
		}
		return movies;
		
	}
	
	
	public void moviesComedyGenre(ArrayList<Movie> movies){
		int numComedy =0;
		for (Movie currMovie:movies){
			if (currMovie.getGenres().contains("Comedy") || currMovie.getGenres().contains("comedy")){
				numComedy++;
				//System.out.println(currMovie.getMinutes());
			}
		}
		System.out.println("Comedy Genre Movies "+numComedy);
	}
	
	public void moviesLength(ArrayList<Movie> movies){
		int numLength =0;
		for (Movie currMovie:movies){
			if (currMovie.getMinutes()>150){
				numLength++;
				//System.out.println(currMovie.getMinutes());
			}
		}
		System.out.println("Movies Greater Than 150 minutes "+numLength);
	}
	
	public HashMap<String,Integer> maximumNumMoviesDirector(ArrayList<Movie> movies){
		HashMap<String,Integer> directorNumMovies = new HashMap<String,Integer>();
		for (Movie movie:movies){
   		 String directorName = movie.getDirector();
   		 if(!directorNumMovies.containsKey(directorName)){
   			directorNumMovies.put(directorName, 1);
   		 }
   		 else{
   			directorNumMovies.put(directorName,directorNumMovies.get(directorName)+1);
   		 }
   	 }	 
   	 
   	 return directorNumMovies;
    }
		
	public void testLoadMovies(){
		
		String fileName = "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratedmovies_short.csv";
		//FileResource fr = new FileResource(fileName);
		
		ArrayList<Movie> movies = loadMovies(fileName);
		
		/*for (Movie currMovie:movies){
		System.out.println(currMovie.getTitle());
		}*/
		
		System.out.println(movies.size());
		
		moviesComedyGenre(movies);
		moviesLength(movies);
		//Build a directory of the Directors and the number of movies the director has directed
		HashMap<String,Integer> directorNames = maximumNumMoviesDirector(movies);
		System.out.println("Maximum Number of movies by Director");
		
		Set entrySet = directorNames.entrySet();
		Iterator it = entrySet.iterator();
		int maxNumMovies =0;
		String directorName="";
		while(it.hasNext()){
			Map.Entry me = (Map.Entry)it.next();
			int movieNum = (int) me.getValue();
			if (movieNum>=maxNumMovies){
				maxNumMovies = (int) movieNum;
				directorName = (String) me.getKey();
				
			}
		}
		System.out.println(directorNames.get(directorName));
		System.out.println("Max Number of Movies by a director "+directorName);
		System.out.println(directorNames);
	}	 
	

	public void getNumRaters(ArrayList<Rater> raters,String id){
		int numOfRatings =0;
		
		for (Rater rater:raters){
			//System.out.println(rater.getID());
			if (rater.getID().equals(id)){
				//System.out.println("I am inside "+rater.numRatings());
				numOfRatings= rater.numRatings();
			}
		}
		System.out.println("No of Ratings by one   "+numOfRatings);
	}
	
	   
	public ArrayList<Rater> loadRaters(String fileName){
		FileResource fr = new FileResource(fileName);
		CSVParser parser = fr.getCSVParser();
		ArrayList<Rater> raters = new ArrayList<Rater>();
		
		String tempId ="";
		Rater rater = new EfficientRater("");
		//PlainRater rater = new PlainRater("");
		 
		
		for (CSVRecord currRec: parser){
			String myId = currRec.get("rater_id");
	        String movId = currRec.get("movie_id");
			
			if(currRec.get("rater_id").equals(rater.getID()) ){
				
				rater.addRating(movId, Double.parseDouble(currRec.get("rating")));
				//raters.add(rater);
			}
			
			else{
				rater = new EfficientRater(myId);
				rater.addRating(currRec.get("movie_id"), Double.parseDouble(currRec.get("rating")));
				raters.add(rater);
			}		
		}
	//System.out.println("This is of the raters "+raters.size());		
	/*for (Rater currRater:raters){
		System.out.println("This is the number of rating by rater "+currRater.getID() +" "+currRater.numRatings());
	}*/
	return raters;	
	}
    
    public void getRaterWithNumOfMovies(ArrayList<Rater> raters,HashMap<String,Integer> raterWithNumOfMovies){
        for(Rater rater:raters){
            if(!raterWithNumOfMovies.containsKey(rater.getID())){
                raterWithNumOfMovies.put(rater.getID(),1);
            }else{
                int num=raterWithNumOfMovies.get(rater.getID());
                num+=1;
                
                raterWithNumOfMovies.put(rater.getID(),num);
            }
        }
    } 
    
    public void getRaterWithMaxNumOfMovies(HashMap<String,Integer> raterWithNumOfMovies,Integer maxValue){
        String maxKey="";
        for(String s:raterWithNumOfMovies.keySet()){
            if(raterWithNumOfMovies.get(s)==maxValue){
                maxKey=s;
            }
        }
        System.out.println("maxKey "+maxKey);
    }

    public int getSumOfRatingsPerMovie(ArrayList<Rater> raters,String movie_id){
        int sum=0;
        for(Rater rater:raters){
            if(rater.hasRating(movie_id)){
                sum+=rater.getRating(movie_id);
            }
        }
        return sum;
    }
    
    public void maximunNumOfRatings(int raterId, ArrayList<Rater> raters){
    	int count=0;
    	for (Rater currRater:raters){
    		if(Integer.parseInt(currRater.getID())==(raterId)){
    			count++;
    		}
    		
    	}
    	System.out.println("Number of Ratings by: "+raterId+" is "+count);
    	
    }
    
    public void maximunNumOfRatingsMovie(int movieId, ArrayList<Rater> raters){
    	int count=0;
    	
    	for (Rater currRater:raters){
    		
    		  		
    			if(currRater.hasRating(Integer.toString(movieId))){
    				//System.out.println("This is the Rater Id:"+currRater.getID());
    			count++;
    			}
    		
    		
    	}
    	System.out.println("Number of Ratings by: "+movieId+" is "+count);
    	
    }
    
       
	public void testLoadRaters(){
		String fileName = "C:/Users/aw634c/newJava/workspace/MovieRecommender/src/data/ratings_short.csv";
		//FileResource fr = new FileResource(fileName);
		
		ArrayList<Rater> raters = loadRaters(fileName);
		
		ArrayList<String> numOfDiffMoviesTotal = new ArrayList<String>();
		
		System.out.println("This is the size of raters class "+ raters.size());
		int raterId=193;
		maximunNumOfRatings(raterId,raters);
		int movieId = 1798709;
		maximunNumOfRatingsMovie(movieId,raters);
		
		for (Rater currRater:raters){
			HashMap<String, Rating> rating =  currRater.getMyRatings();
			for(String str:rating.keySet()){
				if (!numOfDiffMoviesTotal.contains(str)){
					numOfDiffMoviesTotal.add(str);
				}
			}
		}
		
		System.out.println("Num of Movies Rated by the Raters:"+numOfDiffMoviesTotal.size() );
		
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FirstRatings mr = new FirstRatings();
		//mr.testLoadMovies();
		//FirstRatings fr = new FirstRatings();
		//fr.testLoadRaters();
		//MovieRunnerAverage mr1 = new MovieRunnerAverage();
		//mr1.printAverageRatings();
		//mr1.getAverageRatingOneMovie();
		MovieRunnerWithFilters mr1 = new MovieRunnerWithFilters();
		mr1.printAverageRatings();
		
		//mr1.printAverageRatingsByYear();
		//mr1.printAverageRatingsByGenre();
		//mr1.printAverageRatingsByMinutes();
		//mr1.printAverageRatingsByDirector();
		
		//mr1.printAverageRatingsByYearAfterAndGenre();
		//mr1.printAverageRatingsByDirectorsAndMinutes();
		
	}

}
