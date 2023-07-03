// Justin Pope

public class Recursion {

	public static void main(String[] args) {
		
		// This will test the method for i = 1, 2, 3, 4, 5, 6, 7, 8, 9, and 10, and print the result of the series.
		for (int i = 1; i <= 10; i++) {
			System.out.println("m(i) for i = " + i + " is: " + m(i));
		}
		
	}
	
	public static double m(double i) {
		
		// 0 is the base case so it will return 0.
		if (i == 0) return 0;
		
		// Creating a variable to store the sum, it must be a double so the quotients will not be 0.
		double sum = 0;
		
		// This if-else statement makes sure the number is higher than the base case and not negative.
		if (i > 0) {
			// The sum is initialized to be equal to the formula for the series using the value of the initial i.
			sum = i/((2 * i) + 1);
			/* The method will call itself again to get the result of the previous number in the series
			 * The sum will be added with those numbers using the += operator.
			 * The method will keep calling itself until it reaches 0, then it will return 0. 
			 */
			sum += m(i - 1);
		}
		// The method will return 0 if i is negative.
		else return 0;
		
		// The sum is returned so that the sum variable can directly use addition on the method itself.
		return sum;
		
	}

}
