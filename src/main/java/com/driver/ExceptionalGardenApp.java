package com.driver;

import java.util.List;
import java.util.Scanner;

public class ExceptionalGardenApp {
	public static void main(String[] args) {
        Garden garden = new Garden();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        Tree tree = createTree(scanner);
                        garden.plantTree(tree);
                        System.out.println("Tree planted successfully.");
                    } catch (Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                    break;
                case 2:
                    displayGarden(garden);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Plant Tree");
        System.out.println("2. Display Garden");
        System.out.println("3. Exit");
    }

    public static Tree createTree(Scanner scanner) {
        System.out.println("Enter tree name: ");
        String name = scanner.next();
        return new Tree(name);
    }

    public static void displayGarden(Garden garden) {
        List<Tree> trees = garden.getTrees();

        if (trees.isEmpty()) {
            System.out.println("The garden is empty.");
            return;
        }

        System.out.println("Garden contains the following trees:");
        for (Tree tree : trees) {
            System.out.println("- " + tree.getName());
        }
    }
}
