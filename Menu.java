import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<Student> students;
    private final Scanner scanner;

    public Menu(ArrayList<Student> students, Scanner scanner){
        this.students = students;
        this.scanner = scanner;
    }

    public void run(){
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                
                case "2":
                    showStudents();
                    break;

                case "3":
                    removeStudent();
                    break;

                case "0":
                    isRunning = false;
                    System.out.println("Exiting from menu...");
                    break;

                default:
                    System.out.println("Incorrect choice (1, 2, 3 or 0)");
                    break;
            }
        }
    }

    private void addStudent(){
        try {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter level: ");
        int level = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter objective level: ");
        int objLevel = 0;
        boolean isCorrect = false;
        while (!isCorrect){
            objLevel = Integer.parseInt(scanner.nextLine().trim());
            if (objLevel <= level){
                System.out.println("Objective level has to be > than current level");
                continue;
            } else {
                isCorrect = true;
            }
        }
        
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setLevel(level);
        student.setObjLevel(objLevel);

        students.add(student);
        System.out.println("Student was successfully added");
        } catch (NumberFormatException e){
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (IllegalArgumentException e ){
            System.out.println("Input error: " + e.getMessage());
        }
    }
    
    private void showStudents(){

        if (!students.isEmpty()){        
            System.out.println("List of students: ");

            for (Student student : students){
            String name = student.getName();
            int age = student.getAge();
            int level = student.getLevel();
            int objLevel = student.getObjLevel();
            System.out.println("Name: " + name + ", Age: " + age + ", Level: " + level + ", objective level: " + objLevel);
            }
        } else {
            System.out.println("There is no students to show");
        }
    }

    private void removeStudent(){

    }

    private void printMenu(){
        System.out.println("\n SkiTracker Menu");
        System.out.println("Type 1 to add the student");
        System.out.println("Type 2 to show the students");
        System.out.println("Type 3 to remove the student");
        System.out.println("Type 0 to exit");
    }
}
