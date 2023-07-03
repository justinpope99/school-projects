// Justin Pope

package inheritanceDemoAdvanced;
import java.util.Scanner;
public class FinalExamDemo {
	
	public static void main(String[] args) {
		Scanner scores = new Scanner(System.in);
		System.out.print("Enter the total number of questions: ");
		int questions = scores.nextInt();
		System.out.print("Enter the number of questions you got incorrect: ");
		int questionsMissed = scores.nextInt();
		scores.close();
		FinalExam finalExam = new FinalExam(questions, questionsMissed);
		System.out.println("Your score is: " + finalExam.getScore());
	}

}
