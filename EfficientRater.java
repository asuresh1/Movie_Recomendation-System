
import java.util.*;
public class EfficientRater implements Rater {

	private String myID;
    private HashMap<String, Rating> myRatings;

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }

    public void addRating(String item, double rating) {
    	Rating rate = new Rating(item, rating);
        myRatings.put(item,rate);
    }

    public boolean hasRating(String item) {
    	if (myRatings.containsKey(item)){
    		return true;
    	}
    	else{
    		return false;
    	}
        
    }

    public String getID() {
        return myID;
    }

    public HashMap<String,Rating> getMyRatings(){
        return myRatings;
    }
    
    public double getRating(String item) {
        for (String movie_id:myRatings.keySet()){
        	if(myRatings.get(movie_id).getItem().equals(item)){
        		return myRatings.get(movie_id).getValue();
        	}
        	
        }
    	        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }
}
