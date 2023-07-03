package fileSortingWords;

import java.io.*;
import java.util.*;

public class WritingToAFile {

	public static void main(String[] args) {
		
		int wordcount = 5;
		System.out.println("Enter " + wordcount + " words, they must start with a letter.\n");
		
		Scanner sc=new Scanner(System.in);
		
		try {
		DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("input.txt")));
			
		// Writing the words to the file
		for (int i=0; i < wordcount; i++) {
		System.out.println("Enter a word");
		output.writeUTF(sc.nextLine());
		}
		
		output.close();
		sc.close();
		
		System.out.print("\nHere are your words unsorted: [");
		
		// Reading the words from the file and printing them unsorted
		DataInputStream input = new DataInputStream(new FileInputStream("input.txt"));
		for (int i=0; i < wordcount; i++) {
			if(i < wordcount - 1)
				System.out.print(input.readUTF() + ", ");
			else
				System.out.print(input.readUTF());
		}
		System.out.print("]\n");
		
		input.close();
		
		// Creating a Hash Set and adding the words from file
		Set<String> set = new HashSet<String>();
		DataInputStream input2 = new DataInputStream(new FileInputStream("input.txt"));
		for (int i=0; i < wordcount; i++) {
		set.add(input2.readUTF());
		}
		
		input2.close();
		
		// Creating a TreeSet and sorting the words alphabetically
		TreeSet<String> treeSet = new TreeSet<String>(set);
		System.out.println("Here are your words sorted in alphabetical order: " + treeSet);
			
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
