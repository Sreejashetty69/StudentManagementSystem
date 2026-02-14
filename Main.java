import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\nStudent Performance Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Show Topper");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Marks: ");
                    int marks = sc.nextInt();

                    service.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = service.searchStudent(sc.nextInt());
                    if (s != null)
                        System.out.println(s.name + " - Grade: " + s.getGrade());
                    else
                        System.out.println("Not found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Marks: ");
                    int newMarks = sc.nextInt();
                    service.updateMarks(uid, newMarks);
                    break;

                case 5:
                    service.showTopper();
                    break;

                case 6:
                    return;
            }
        }
    }
}
