import java.io.*;
import java.util.*;

public class StudentService {

    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentService() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
        System.out.println("Student added.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                "ID: " + s.id +
                " Name: " + s.name +
                " Marks: " + s.marks +
                " Grade: " + s.getGrade()
            );
        }
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id)
                return s;
        }
        return null;
    }

    public void updateMarks(int id, int marks) {
        for (Student s : students) {
            if (s.id == id) {
                s.marks = marks;
                saveToFile();
                System.out.println("Marks updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void showTopper() {
        if (students.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        Student top = students.get(0);
        for (Student s : students) {
            if (s.marks > top.marks)
                top = s;
        }

        System.out.println("Top Performer:");
        System.out.println(top.name + " - " + top.marks);
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
        }
    }
}
