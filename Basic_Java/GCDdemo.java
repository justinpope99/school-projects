// Justin Pope

import java.util.Scanner;

public class GCDdemo
{
	/**
	 * main method
	 */
	
	public static void main(String[] args)
	{
		int num1, num2;// Two numbers
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Get two numbers from the user.
		System.out.println("Get an integer: ");
		num1 = keyboard.nextInt();
		System.out.println("Enter another integer: ");
		num2 = keyboard.nextInt();
		keyboard.close();
		
		// Display the GCD
		System.out.println("The greatest common divisor " +
						   "of these two numbers is " +
						   gcd(num1, num2));
	}
	
	/**
	 * The gcd method returns the greatest common divisor
	 * of the arguments passed into x and y.
	 */
	
	public static int gcd(int x, int y)
	{
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}
}
