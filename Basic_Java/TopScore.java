//By Justin Pope

import java.util.*;

public class TopScore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter the number of students
		System.out.println("Enter the numbers of students: ");
		int numOfStudents = input.nextInt();
		
		System.out.println("Enter a student name: ");
		String student1 = input.next();
		System.out.println("Enter a student score: ");
		double score1 = input.nextDouble();
		
		for (int i = 0; i < numOfStudents - 1; i++) {
			System.out.println("Enter a student name: ");
			String student = input.next();
			
			System.out.println("Enter a student score: ");
			double score = input.nextDouble();
			input.close();
			
			if (score > score1) {
				student1 = student;
				score1 = score;
			}
		}
		
		System.out.println("Top student " + student1 + "'s score is " + score1);
	}

}
