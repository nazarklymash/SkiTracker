package util;

import java.util.Scanner;

public class Helpers {

    public static int readInt(Scanner scanner) throws NumberFormatException{
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static int readChoice(int id, Scanner scanner){
        try {
                System.out.println("Info: Enter the ID: ");
                int choice = readInt(scanner);

                if (choice == 0){
                    System.out.println("Info: Exiting menu...");
                    return -1;
                }

                if (choice < 1 || choice > id){
                    System.out.println("Error: Incorrect ID (1 <= ID <= " + id + ")");
                    return -1;
                }
            return choice;
        } catch (NumberFormatException e){
            System.out.println("Error: Enter valid number" + e.getMessage());
            return -1;
        }
    }
}
