package lab4;

import java.util.Scanner;

public class PostageTest {

	public static void main(String[] args) {
		PostageUtil postage = new PostageUtil();
		PostageUtil2 postage2 = new PostageUtil2();
		PostageUtil3 postage3 = new PostageUtil3();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the postage: ");
		double in = scanner.nextDouble();
		System.out.printf("%.2f%n", postage.computePostage(in));
		
		System.out.print("Enter the postage: ");
		double in2 = scanner.nextDouble();
		System.out.printf("%.2f%n", postage2.computePostage(in));
		
		System.out.print("Enter the postage: ");
		double in3 = scanner.nextDouble();
		System.out.printf("%.2f%n", postage3.computePostage(in3));
	}
}