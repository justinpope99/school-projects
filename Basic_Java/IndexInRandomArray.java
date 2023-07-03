// Justin Pope

import java.util.*;

public class IndexInRandomArray {
	public static void main(String[] args) {
		int[] data = new int[100];
		
		// Initialize array
		for (int i = 0; i < 100; i++)
			data[i] = (int)(Math.random() * 10000);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an index: ");
		int index = input.nextInt();
		input.close();
		
		try {
			System.out.println("The element is " + data[index]);
		}
		catch (Exception ex) {
			System.out.println("Index out of bound");
		}
	}
}
