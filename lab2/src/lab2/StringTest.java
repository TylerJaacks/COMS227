package lab2;

public class StringTest {
	public static void main(String[] args) {
		String message;
		
		message = "Hello, world!";
		
		System.out.println(message);
		
		int theLength = message.length();
		
		System.out.println(theLength);
		
		String uppercaseMessage = message.toUpperCase();
		
		System.out.println(uppercaseMessage);
		
		String hello = message.substring(0, 5);
		
		System.out.println(hello);
		
		String replaced = message.replace('o', '*');
		
		System.out.print(replaced);
	}
}