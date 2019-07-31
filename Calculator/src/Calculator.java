import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Thommu
 *
 */
public class Calculator {

	/**
	 * @param args
	 */
	public static double sum(double a, double b) {
		return a+b;
	}
	public static double difference(double a, double b) {
		return a-b;
	}
	public static double product(double a, double b) {
		return a*b;
	}
	public static double divide(double a, double b) {
		return a/b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Calculator initialized!");
		System.out.println("Input 2 numbers");
		try {
			Double a = scanner.nextDouble();
			Double b = scanner.nextDouble();
			
		System.out.println("Select choice :\n"
				+ "1. Division\n"
				+ "2. Multiply\n"
				+ "3. Add\n"
				+ "4. Subtract\n");
		int choice = scanner.nextInt();
		double result=0;
		switch(choice) {
			case 1: result=divide(a,b); break;
			case 2: result=product(a,b); break;
			case 3: result=sum(a,b); break;
			case 4: result=difference(a,b); break;
			default:System.out.println("Invalid choice input. select only 1-4");
		}
		System.out.println("Result is : "+result);
		
		}catch(InputMismatchException e) {
			System.out.println("Number expected");
		}
		
	}

}
