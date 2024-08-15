import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String email;
    String phone;
    String code;
    int gender;
    float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }
}

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter student information");
            System.out.println("2. Print student list");
            System.out.println("3. Delete student by code");
            System.out.println("4. Sort students by score in descending order");
            System.out.println("5. Search for students by code or name");
            System.out.println("6. Search for students with scores >= x");
            System.out.println("7. Exit");
            System.out.print("Select function: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    printStudents();
                    break;
                case 3:
                    deleteStudentByCode();
                    break;
                case 4:
                    sortStudentsByGrade();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    searchStudentByGrade();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter student code: ");
        String code = scanner.nextLine();
        System.out.print("Enter gender (0: Female, 1: Male): ");
        int gender = scanner.nextInt();
        System.out.print("Enter mark: ");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        students.add(new Student(name, age, email, phone, code, gender, grade));
        System.out.println("More students successfully added!");
    }

    private static void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void deleteStudentByCode() {
        System.out.print("Enter the student code to delete: ");
        String code = scanner.nextLine();
        students.removeIf(student -> student.code.equals(code));
        System.out.println("Delete student successfully!");
    }

    private static void sortStudentsByGrade() {
        students.sort(Comparator.comparingDouble(student -> -student.grade));
        System.out.println("Sort students by success score in descending order!");
    }

    private static void searchStudent() {
        System.out.print("Enter the student code or name you want to find: ");
        String keyword = scanner.nextLine();
        for (Student student : students) {
            if (student.code.equals(keyword) || student.name.equalsIgnoreCase(keyword)) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudentByGrade() {
        System.out.print("Enter minimum score: ");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        for (Student student : students) {
            if (student.grade >= grade) {
                System.out.println(student);
            }
        }
    }
}
