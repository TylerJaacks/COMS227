package lab4;

public class PostageUtil3 {
	public static double computePostage(double weight) {
		double cost = 0.47;
		
		if (weight > 1) {
			cost = (cost + Math.ceil(weight - 1) * 0.21);
		} else if (weight > 3.5) {
			cost = cost + 0.47;
		}
		
		return cost;
	}
}