/*
 * Author: Alexander Anderson
 * Summer 2014
 */
package linkedList;

import java.util.Scanner;

/*
 * Example usage of the LinkedList
 */
public class LinkedListApp {
	private static Scanner input;
	private static LinkedList<String> cars;
	
	public static void main(String[] args) {
		cars = new LinkedList<>();
		input = new Scanner(System.in);
		cars.append("Elantra".toUpperCase());
		cars.append("Civic".toUpperCase());
		cars.append("Lancer".toUpperCase());
		cars.append("Sonata".toUpperCase());
		cars.append("Jetta".toUpperCase());
		
		boolean loopControl = true;
		while (loopControl) {
			System.out.println("Please select from one of the following choices:");
			System.out.println();
			System.out.println("a) Size of LinkedList");
			System.out.println("b) Insert before");
			System.out.println("c) Insert after");
			System.out.println("d) Remove");
			System.out.println("e) Display all items");
			System.out.println("f) Clear");
			System.out.println("g) Quit");
			
			System.out.print("Selction: ");
			String choice = input.nextLine();
			System.out.println();
			
			switch (choice) {
			case "a"	: 	System.out.println("The size of the list is: " + cars.getSize());
							System.out.println();
							break;
							
			case "b"	:	insertCase(false);
							System.out.println();
							break;
							
			case "c"	: 	insertCase(true);
							System.out.println();
							break;
			
			case "d"	: 	System.out.print("Please specify the data you wish to remove: ");
							String dataToRemove = input.nextLine().toUpperCase();
							try {
								cars.remove(dataToRemove);
								System.out.println(dataToRemove + " was successfully removed from the list");
							} catch (RuntimeException e) {
								System.out.println("Could not remove " + dataToRemove);
								System.out.println(dataToRemove +" was not in the list");
							}
							System.out.println();
							break;
			
			case "e"	: 	System.out.println(cars.toString());
							System.out.println();
							break;
			
			case "f"	: 	removeCase();
							break;
			
			case "g"	: 	System.out.println("Good Bye");
							loopControl = false;
							break;
			}
		}
	}

	private static void removeCase() {
		System.out.println("Are you sure you want to remove all list elements? [Y/N]");
		String yesOrNo = input.nextLine();
		if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("y")) {
			cars.clear();
			System.out.println("The list has been cleared.");
			System.out.println();
		}
		else if (yesOrNo.equalsIgnoreCase("no") || yesOrNo.equalsIgnoreCase("n")) {
			System.out.println("List WAS NOT cleared");
			System.out.println();
		}
		else {
			System.out.println("Choice not recognized");
		}
	}

	/**
	 * Used to run the insertCase. both the beforeInsert and afterInsert
	 * @param isAfterInsertion
	 * Use this parameter to distinguish between insertAfter() and insertBefore()
	 */
	private static void insertCase(boolean isAfterInsertion) {
		
		System.out.print("Please specify the data you wish to insert: ");
		String data = input.nextLine().toUpperCase();
		System.out.println();
		System.out.print("Please specify where to insert the data: ");
		String insertionKey = input.nextLine().toUpperCase();
		try {
			if (isAfterInsertion)
				cars.insertAfter(insertionKey, data);
			else
				cars.insertBefore(insertionKey, data);
			
			System.out.println("Insertion successful");
		} catch (RuntimeException e) {
			System.out.println("Invalid insert location: " + insertionKey);
			System.out.println("Insertion not made");
		}
	}
}
