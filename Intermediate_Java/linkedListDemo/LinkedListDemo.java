package linkedListDemo;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		MyLinkedListOrig<Object> list = new MyLinkedListOrig<>();
		list.addFirst("America");
		list.add("Mexico");
		list.add("Japan");
		list.add("France");
		list.add("Germany");
		list.addLast("Norway");
		
		System.out.println("Elements in the list:\n" + list);
		
		System.out.println("\nThe list contains Mexico: " + list.contains("Mexico"));
		
		System.out.println("The element at index 3 is: " + list.get(3));
		
		System.out.println("The index of Japan is: " + list.indexOf("Japan"));
		
		System.out.println("The last index of \"Norway\" on the list is: " + list.lastIndexOf("Norway"));
		
		System.out.println("America will be replaced with " + list.set(0, "China") + " in the list.");
		
		System.out.println("New List:\n" + list);

	}

}
