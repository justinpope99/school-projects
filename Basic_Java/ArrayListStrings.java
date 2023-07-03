// Justin Pope

import java.util.ArrayList;

public class ArrayListStrings {

	public static void main(String[] args) {
		
		// Create a program for a list of people: Mary, Tony, Joe, Liz, Kim, Arnold, Steven, Cathy, Carmen.
		ArrayList<String> names = new ArrayList<>();
		names.add("Mary");
		names.add("Tony");
		names.add("Joe");
		names.add("Liz");
		names.add("Kim");
		names.add("Arnold");
		names.add("Steven");
		names.add("Cathy");
		names.add("Carmen");
		
		// Show the size of the arrayList
		System.out.println("The size of the ArrayList is: " + names.size());
		
		// Show the arrayList after you replace Arnold with Tommy.
		int arnold = names.indexOf("Arnold");
		names.remove("Arnold");
		names.add(arnold, "Tommy");
		
		System.out.println("\nHere are the elements of the ArrayList:");
		names.forEach(System.out::println);
		
	}

}
