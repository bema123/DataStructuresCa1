/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructures.dynamicarrayca1;

import java.util.Scanner;

/**
 *
 * @author Bema Meite
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create an instance of DynamicArrayList class
        DynamicArrayList shoppingList = new DynamicArrayList();

        // Step 2: Ask the user how many entries they'd like to add
        System.out.print("How many entries would you like to add to your shopping list? ");
        int numEntries = scanner.nextInt();
        scanner.nextLine(); 

        // Step 3: Prompt the user to enter entries and add them to the list
        for (int i = 0; i < numEntries; i++) {
            System.out.print("Enter entry number" + (i + 1) + ": ");
            String entry = scanner.nextLine();
            shoppingList.add(entry);
        }

        // Step 4: Display the content of the shopping list
        System.out.println("Your shopping list:");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppingList.get(i));
        }

        // Step 5: Menu of actions for the shopping list
        while (true) {
            System.out.println("5. Exit");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the entry to add: ");
                    String newEntry = scanner.nextLine();
                    shoppingList.add(newEntry);
                    break;
                case 2:
                    System.out.print("Enter the entry to remove: ");
                    String entryToRemove = scanner.nextLine();
                    boolean removed = shoppingList.remove(entryToRemove, 0);
                    if (removed) {
                        System.out.println("Entry removed successfully.");
                    } else {
                        System.out.println("Entry not found.");
                    }
                    break;
                case 3:
                    System.out.println("Your shopping list:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println((i + 1) + ". " + shoppingList.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
}
    }
}