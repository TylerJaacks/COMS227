package lab4;

public class PostageUtil2 {
	public static double computePostage(double weight) {
		double cost = 0;
		if (weight <= 2) {
			cost = 0.47;
		} else {
			if (weight > 1) {
				cost = (0.47 + Math.ceil(weight - 1) * 0.21);
			} else {
				if (weight > 3.5) {
					cost = 0.94 + Math.ceil(weight - 1) * 0.21;
				} else {
					cost = 0.47 + Math.ceil(weight - 1) * 0.21;
				}
			}
		}
		
		return cost;
	}
}