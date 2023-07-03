// Justin Pope

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This program allows the user to order a pizza.
 */

public class OrderingPizza {
	
	public static void main(String[] args) {
		
		/** Setting the properties for the pizza */
		int size = 12;
		String crust = "Thin-crust";
		double cost = 12.99;
		
		// Create a Scanner object to read input.
		Scanner input = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to Mike and Diane's Pizza");
		
		// User's first name
		System.out.print("Enter your first name: ");
		String name = input.next();
		
		// Flag for discount
		boolean discount = false;
		
		// If the user has the same name as one of the owners, they will get a discount.
		if (name.toUpperCase().equals("MIKE") || name.toUpperCase().equals("DIANE"))
			discount = true;
		
		// Size of the pizza
		System.out.println("Pizza Size (inches)" + "\tCost");
		
		// Pizza Options: Size and Cost
		System.out.println("\t" + "10" + "\t\t" + "$10.99");
		System.out.println("\t" + "12" + "\t\t" + "$12.99");
		System.out.println("\t" + "14" + "\t\t" + "$14.99");
		System.out.println("\t" + "16" + "\t\t" + "$16.99");
		
		System.out.print("What size pizza would you like?"
				+ "\n10, 12, 14, or 16 (enter the number only): ");
		
		// User input for size
		size = input.nextInt();
		
		// Setting the cost based on the size
		switch(size) {
		case 10: cost = 10.99;
			break;
		case 12: cost = 12.99;
			break;
		case 14: cost = 14.99;
			break;
		case 16: cost = 16.99;
			break;
		default: System.out.println("Invalid pizza size");
			break;
		}
		
		// Options for Pizza Crust
		System.out.print("What type of crust do you want?" +
		"\n(H)Hand-tossed, (T) Thin-crust, or (D) Deep-dish (enter H, T, or D): ");
		
		// User input for crust
		// Converting the input to Upper Case and into a char type.
		char crustChoice = input.next().toUpperCase().charAt(0);
		
		// Setting the pizza crust
		switch(crustChoice) {
		case 'H': crust = "Hand-tossed";
			break;
		case 'T': crust = "Thin-crust";
			break;
		case 'D': crust = "Deep-dish";
			break;
		default: System.out.println("Invalid crust choice");
			break;
		}
		
		System.out.println("All pizzas come with cheese." +
		"\nAdditional toppings are $1.25 each, choose from:" +
				"\nPepperoni, Sausage, Onion, Mushroom");
		
		// Asking the user if they want additional toppings.
		System.out.print("Do you want Pepperoni? (Y/N): ");
		char pepperoniChoice = input.next().toUpperCase().charAt(0);
		System.out.print("Do you want Sausage? (Y/N): ");
		char sausageChoice = input.next().toUpperCase().charAt(0);
		System.out.print("Do you want Onion? (Y/N): ");
		char onionChoice = input.next().toUpperCase().charAt(0);
		System.out.print("Do you want Mushroom? (Y/N): ");
		char mushroomChoice = input.next().toUpperCase().charAt(0);
		
		input.close();
		
		// Adding toppings into an array.
		char[] toppingChoice = {pepperoniChoice, sausageChoice, onionChoice, mushroomChoice};
		
		// Creating an additional array so that the topping can be printed if the user selected it.
		ArrayList<String> toppings = new ArrayList<>();
		toppings.add("Pepperoni");
		toppings.add("Sausage");
		toppings.add("Onion");
		toppings.add("Mushroom");
		
		// Determining if the user is eligible for a discount.
		if(discount)
			cost -= (cost * 0.05); // The discount is 5%.
		
		// Tell the user they have received a discount.
		if(discount)
			System.out.print("\nCongratulations! You have received a 5% discount"
					+ " for having the same name as one of the owners.");
		
		/** Displaying the order */
		
		System.out.println("\nYour order is as follows:");
		
		// Display Pizza size
		System.out.println(size + " inch pizza");
		
		// Display Pizza crust
		if (crust.equals("Thin-crust"))
			System.out.println(crust);
		else
			System.out.println(crust + " crust");
		
		// Print the toppings if the user has selected them.
		System.out.print("Cheese ");
		for(int i = 0; i < toppings.size(); i++) {
			if(toppingChoice[i] == 'Y') { // If the user has selected Y...
				cost += 1.25; // Adding the topping to the cost
				System.out.print(toppings.get(i) + " "); // If the user selected 'Y', the topping will be printed.
			}
		}

		// Display the cost of the order
		System.out.printf("\nThe cost of your order is: " + "$%4.2f", cost);
		
		// Display Tax
		double tax = cost * 0.08875; // New York City Sales Tax is 8.875%
		System.out.printf("\nThe tax is: " + "$%4.2f", tax);
		
		// Display Total
		System.out.printf("\nThe total due is: " + "$%4.2f", cost + tax);
		
		System.out.println("\nYour order will be ready for pickup in 30 minutes.");
		
	}

}

