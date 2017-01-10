package hw2;

public class ParkingRateUtil {
	/**
	 * This is the time limit for exit.
	 */
	public static final int EXIT_TIME_LIMIT = 15;
	private static double cost;
	
	/**
	 * Initializes the cost variable for later use.
	 */
	private ParkingRateUtil() {
		cost = 0.0;
	}
	
	/**
	 * Calculates the cost for a given time frame (In minutes).
	 * @param minutes
	 * @return Returns the cost based on the time in minutes given.
	 */
	public static double calculateCost(int minutes) {		
		if(minutes <= 30){
			cost = 1.00;
		}else if(minutes <=60){
			
			cost = 2.00;
		}else if(minutes <= 120){
			cost = 3.25;
		}else if(minutes <= 180){
			cost = 4.50;
		}else if(minutes <= 240){
			cost = 5.75;
		}else if(minutes <= 300){
			cost = 7.00;
		}else if(minutes <= 360){
			cost = 8.25;
		}else if(minutes <= 420){
			cost = 9.50;
		}else if(minutes <= 480){
			cost = 10.25;
		}else if(minutes <= 540){
			cost = 11.00;
		}else if( minutes > 1440){
		
			cost= (minutes/1440) * 11.50 + calculateCost(minutes%1440);
			}else{
				cost = 11.50;
				}

		
		return cost;
	}
}