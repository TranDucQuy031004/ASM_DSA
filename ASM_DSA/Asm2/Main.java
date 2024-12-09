package Asm2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List studentList = new List();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addStudent(scanner, studentList);
                        break;
                    case 2:
                        editStudent(scanner, studentList);
                        break;
                    case 3:
                        deleteStudent(scanner, studentList);
                        break;
                    case 4:
                        searchStudent(scanner, studentList);
                        break;
                    case 5:
                        studentList.displayStudents();
                        break;
                    case 6:
                        studentList.sortStudentsByMarks();
                        System.out.println("Students sorted by marks.");
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addStudent(Scanner scanner, List studentList) {
        try {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();

            studentList.addStudent(id, name, marks);
            System.out.println("Student added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. ID should be an integer, and Marks should be a decimal number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void editStudent(Scanner scanner, List studentList) {
        try {
            System.out.print("Enter ID of student to edit: ");
            int editId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new Marks: ");
            double newMarks = scanner.nextDouble();

            if (studentList.editStudent(editId, newName, newMarks)) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. ID should be an integer, and Marks should be a decimal number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void deleteStudent(Scanner scanner, List studentList) {
        try {
            System.out.print("Enter ID of student to delete: ");
            int deleteId = scanner.nextInt();

            if (studentList.deleteStudent(deleteId)) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. ID should be an integer.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void searchStudent(Scanner scanner, List studentList) {
        try {
            System.out.print("Enter ID of student to search: ");
            int searchId = scanner.nextInt();

            Node student = studentList.searchStudentById(searchId);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. ID should be an integer.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}
