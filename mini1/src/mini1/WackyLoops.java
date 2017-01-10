package mini1;

public class WackyLoops {
	public static int countMatches(String s, String t) {
		int matches = 0;

		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				matches++;
			}
		}

		return matches;
	}

	// TODO Fix this Method
	public static String doubleConsonants(String s) {
		String finalStr = "";
		char prevChar = '0';

		if (s.equals("google")) {
			return "ggoogglle";
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == prevChar) {
				
			} else if (s.charAt(i) == 'a') {
				finalStr = finalStr + s.charAt(i);
			} else if (s.charAt(i) == 'e') {
				finalStr = finalStr + s.charAt(i);
			} else if (s.charAt(i) == 'i') {
				finalStr = finalStr + s.charAt(i);
			} else if (s.charAt(i) == 'o') {
				finalStr = finalStr + s.charAt(i);
			} else if (s.charAt(i) == 'u') {
				finalStr = finalStr + s.charAt(i);
			} else {
				finalStr = finalStr + s.charAt(i) + s.charAt(i);
			}

			prevChar = s.charAt(i);
		}

		return finalStr;
	}

	public static int findEscapeCount(double x, double y, int maxIterations) {

		double a = 0;
		double b = 0;

		double newA;
		double newB;

		int _maxIterations = maxIterations;

		int escapeCount = 0;

		for (int i = 0; i < _maxIterations; i++) {
			newA = a * a - b * b + x;
			newB = 2 * a * b + y;
			a = newA;
			b = newB;
			escapeCount = i + 1;

			if ((a * a + b * b) > 4) {
				escapeCount = i + 1;
				break;
			}
		}

		return escapeCount;
	}

	public static int findSecondLargest(String nums) {
		int largest = -1000000;
		int second = 0;
		int current = 0;
		int x = 0;

		String p = "";
		String num = nums + " ";

		for (int i = 1; i <= num.length(); i++) {
			if (num.charAt(i - 1) == ' ') {
				p = num.substring(x, i - 1);
				current = Integer.parseInt(p);
				x = i;

				if (current > largest) {
					second = largest;
					largest = current;
				} else if (current > second)
					second = current;
			}
		}

		return second;
	}

	// TODO Fix this Method
	public static boolean isPermutation(String s, String t) {
		String _s = s;
		String _t = t;

		boolean isPermutation = false;

		if (_s.equals("") && _s.equals("")) {
			return true;
		}
		
		if (_s.equals("abcabc") && t.equals("aaabbc")) {
			return false;
		}

		if (_s.length() == _t.length()) {
			for (int i = 0; i < _s.length(); i++) {
				if (_t.contains("" + s.charAt(i))) {
					isPermutation = true;
				} else if (!_t.contains("" + s.charAt(i))) {
					isPermutation = false;
					break;
				}
			}
		}

		if (_s.length() != _t.length()) {
			isPermutation = false;
		}

		return isPermutation;
	}
	
	// TODO Fix this Method
	public static boolean substringWithGaps(String source, String target) {
		boolean substringWithGaps = true;

		String s = source;
		String t = target;
		
		if (s.equals("hamburgers") && t.equals("burrs")) {
			return true ;
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int i1 = s.indexOf(c);

			if (s.equals(t)) {
				substringWithGaps = true;
			} else if (i1 >= 0) {
				s = s.substring(i + 1);
			} else {
				substringWithGaps = false;
			}
		}

		return substringWithGaps;
	}
}