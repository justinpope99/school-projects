//By Justin Pope

public class ReverseAnInteger2 {

	public static void main(String[] args) {
		
	System.out.println("Enter an integer: ");
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	//Another way to make a Scanner without import
	int number = input.nextInt();
	input.close();
	reverse(number);
	}

	public static void reverse(int number) {
		while (number !=0) {
			int remainder = number % 10;
			System.out.print(remainder);
			number = number / 10;
		}
		System.out.println();
	}
}
