package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



public class Helpers {

    public static int readInt(Scanner scanner) throws NumberFormatException{
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static int readChoice(ArrayList<Student> students, Scanner scanner){
        try {
                int id = students.size();
                System.out.println("Info: Enter the ID of student: ");
                int choice = readInt(scanner);

                if (choice == 0){
                    System.out.println("Info: Exiting menu...");
                    return -1;
                }

                if (choice < 1 || choice > id){
                    System.out.println("Error: Incorrect ID of student (1 <= ID <= " + id + ")");
                    return -1;
                }
            return choice;
        } catch (NumberFormatException e){
            System.out.println("Error: Enter valid number" + e.getMessage());
            return -1;
        }
    }

    public static void writeFileJson(Student student, String outputFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(outputFile)) {
            gson.toJson(student, writer);
            System.out.println("Info: Content was successfully saved to file");
        } catch (IOException e){
            System.err.println("Error: can't open or write into the file: " + e.getMessage());
        }
    }
}
