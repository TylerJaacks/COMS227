package lab5;
import java.util.Scanner;

public class Loops {
	public static void main(String[] args) {
		System.out.println(Initials("Tyler del Jaacks"));
		System.out.println(firstVowel("wrtyE"));
	}
	
	public static String Initials(String name) {
		char _firstLetter = '0';
		String _name = "";
		Scanner _scanner = new Scanner(name);
		
		while(_scanner.hasNext()) {
			_firstLetter = _scanner.next().charAt(0);
			
			_name = _name + "" + _firstLetter;
		}
		
		return _name;
	}
	
	public static int firstVowel(String s) {
		for (int i = 0; i < s.length(); i++)
			switch (s.charAt(i)) {
				case 'a':
					return i;
				case 'e':
					return i;
				case 'i':
					return i;
				case 'o':
					return i;
				case 'u':
					return i;
				case 'A':
					return i;
				case 'E':
					return i;
				case 'I':
					return i;
				case 'O':
					return i;
				case 'U':
					return i;
			}
		
		return -1;
	}
}