package fileSortingWords;

import java.io.*;
import java.util.*;

public class ReadingFromAFile {

	public static void main(String[] args) {
		
		/*
		 * I am resubmitting because I did not allow the user to enter in a file
		 * and I also did not allow duplicates because I used a set.
		 */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a filename: ");
		String filename = sc.next();
		sc.close();

		try {
			Scanner input = new Scanner(new File(filename));
			System.out.print("\nHere are your words unsorted:\n");
			
			while(input.hasNextLine())
				System.out.println(input.nextLine() + " ");
			
			input.close();
			
			// Creating a PriorityQueue and adding the words from file
			PriorityQueue<String> queue = new PriorityQueue<String>();
			Scanner input2 = new Scanner(new File(filename));
			while(input2.hasNextLine())
				queue.offer(input2.nextLine());
			
			System.out.print("\nHere are your words sorted in alphabetical order:\n");
			while (queue.size()> 0)
				System.out.println(queue.remove() + " ");
			
			input.close();
			input2.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}

	}

}
