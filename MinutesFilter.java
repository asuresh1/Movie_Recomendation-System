
public class MinutesFilter implements Filter{
	private int myMinTime;
	private int myMaxTime;
	
	public MinutesFilter(int minTime, int maxTime) {
		myMinTime = minTime;
		myMaxTime = maxTime;
	}
	@Override
	public boolean satisfies(String id) {
		return (MovieDatabase.getMinutes(id)>=myMinTime && (MovieDatabase.getMinutes(id)<=myMaxTime));
	}

}
