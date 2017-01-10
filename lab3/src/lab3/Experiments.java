package lab3;

import java.util.Random;

public class Experiments {

	public static void main(String[] args) {
		/** Experiment 1 **/
		System.out.println(1000000 % 7);
		
		/** Experiment 2 **/
		Person person = new Person("Tyler Jaacks", 19);
		
		System.out.println(person.getName() + " " + person.getAge());
		
		/** Experiment 3 **/
		int x = 42;
	    String s = "" + x;
	    
	    s = "42";
	    x = Integer.parseInt(s);
	    
	    //String hello = "Hello";
	    //int hello1 = Integer.parseInt(hello);
	    
	    /** Experiment 4 **/
	    int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		System.out.println(min);
		System.out.println(max);
		
		min = min - 2;
		max = max + 2;
		
		System.out.println(min);
		System.out.println(max);
		
		/** Experiment 5 **/
		Random rand1 = new Random();
		
		System.out.println(rand1.nextInt(6));
		System.out.println(rand1.nextInt(6));
		System.out.println(rand1.nextInt(6));
		System.out.println(rand1.nextInt(6));
		
		Random rand2 = new Random(137);
		
		System.out.println(rand2.nextInt());
		System.out.println(rand2.nextInt());
		System.out.println(rand2.nextInt());
		System.out.println(rand2.nextInt());
	}
}