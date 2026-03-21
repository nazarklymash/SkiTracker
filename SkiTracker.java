import java.util.ArrayList;
import java.util.Scanner;

public class SkiTracker {
    public static void main (String[] args){
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        Menu menu = new Menu(students, scanner);
        menu.run();

        scanner.close();
    }
}