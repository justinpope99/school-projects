// Justin Pope 

import java.util.Scanner;

public class FactorialDemo
{
	public static void main(String[] args)
	{
		int number;	// To hold a number
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Get a number from the user.
		System.out.println("Enter a nonnegative integer: ");
		number = keyboard.nextInt();
		keyboard.close();
		
		// Display the factorial.
		System.out.println(number + "! is " + factorial(number));
	}
	
	/**
	 * Recursive factorial method. This method returns the
	 * factorial of its argument, which is assumed to be a
	 * nonnegative number.
	 */
	
	private static int factorial(int n)
	{
		if (n == 0)
			return 1;	// Base case
		else
			return n * factorial(n-1);
	}
}
