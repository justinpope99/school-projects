//Justin Pope

import java.util.Scanner;

/**
 * This program gets a set of test scores and
 * uses the Grader class to calculate the average
 *with the lowest score dropped.
 */

public class CalculateAverage
{
	public static void main(String[] args) 
	{
		int numScores;
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Get the number of test scores.
		System.out.print("How many test scores do you have? ");
		numScores = keyboard.nextInt();
		
		// Create an array to hold the test scores.
		double[] scores = new double[numScores];
		
		// Get the test scores and store them
		// in the scores array.
		for (int index = 0; index < numScores; index++)
		{
			System.out.print("Enter score #" +
							   (index + 1) + ": ");
			scores[index] = keyboard.nextDouble();
		}
		keyboard.close();
		
		// Create a Grader object, passing the
		// scores array as an argument to the
		// constructor.
		Grader myGrader = new Grader(scores);
		
		// Display the adjusted average.
		System.out.println("Your adjusted average is " +
						   myGrader.getAverage());
		
		//Display the lowest score
		System.out.println("Your lowest test score was " +
						   myGrader.getLowestScore());
	}
}
