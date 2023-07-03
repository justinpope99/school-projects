package arrayListDemo;

import java.util.ArrayList;

public class ArrayListRemoveDuplicates {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		ArrayList<String> listStr = new ArrayList<String>();
		listStr.add("New York");
		listStr.add("Boston");
		listStr.add("Miami");
		listStr.add("Boston");
		
		System.out.println("Integer List\n" + list);
		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.println(newList + "\n");

		System.out.println("String List\n" + listStr);
		ArrayList<String> newList2 = removeDuplicates(listStr);
		System.out.println(newList2);

	}
	
	public static<E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		
		ArrayList<E> result = new ArrayList<E>();
		
		for (E e: list) {
			if (!result.contains(e))
				result.add(e);
		}
		
		return result;
	}
	
}
