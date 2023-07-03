package arrayListDemo;

import java.util.*;

public class OccurencesOfIntegersInAnArrayList {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number of integers. Enter the number 0 to stop the input.");
		
		// Adding the numbers to an ArrayList
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int number;
		do {
			number = input.nextInt();
			
			if (number != 0);
			numbers.add(number);
		} while (number != 0);
		input.close();
		
		// Converting the numbers to Strings and inserting them into a String Array
		String[] numbersText = new String[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			numbersText[i] = String.valueOf(numbers.get(i));
		}
		
		// Creating a TreeMap to hold the numbers as a key and the count as a value
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(int i = 0; i < numbersText.length; i++) {
			String key = numbersText[i];
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		// Inserting the entries into a set and using an integer to count the number of occurrences
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		int max = 0;
		for (Map.Entry<String, Integer> entry: set) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		
		// Displaying the integer(s) that occurred the most
		System.out.println("\nMost Common Integer(s): ");
		for (Map.Entry<String, Integer> entry: set) {
			if (entry.getValue() == max) {
				System.out.println("Integer: " + entry.getKey() + "\tOccurrences: " + max);
			}
		}

	}

}
