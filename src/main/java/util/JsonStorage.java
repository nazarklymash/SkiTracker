package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import model.Student;

import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonStorage {

    public static void writeFileJson(ArrayList<Student> students, String outputFile){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(outputFile)) {

            gson.toJson(students, writer);
            System.out.println("Info: Content in JSON was successfully saved to file");

        } catch (IOException e){

            System.err.println("Error: can't open or write into the file: " + e.getMessage());

        }
    }

    public static ArrayList<Student> readFileJson(String inputFile){

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(inputFile)){

            Type studentListType = new TypeToken<ArrayList<Student>>(){}.getType();
            ArrayList<Student> students = gson.fromJson(reader, studentListType);

            if (students == null){

                return new ArrayList<>();

            }

            return students;

        } catch (IOException e){

            System.err.println("Error: failed to read the file: " + e.getMessage());
            return new ArrayList<>();

        }
    }
}
