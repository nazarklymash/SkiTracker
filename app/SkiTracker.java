package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Student;
import ui.Menu;
import util.JsonStorage;

public class SkiTracker {
    public static void main (String[] args){
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String storage = "data/students.json";
        students = JsonStorage.readFileJson(storage);
        
        Menu menu = new Menu(students, scanner);
        menu.run();

        JsonStorage.writeFileJson(students, storage);

        scanner.close();
    }
}