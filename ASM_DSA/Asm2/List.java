/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asm2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author ADMIN
 */
public class List {
     private ArrayList<Node> students;

    public List() {
        students = new ArrayList<>();
    }

    // Thêm sinh viên mới vào danh sách
    public void addStudent(int id, String name, double marks) {
        Node student = new Node(id, name, marks);
        students.add(student);
    }

    // Sửa thông tin sinh viên theo ID
    public boolean editStudent(int id, String newName, double newMarks) {
        for (Node student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setMarks(newMarks);
                return true;
            }
        }
        return false;
    }
    // Xóa sinh viên theo ID
    public boolean deleteStudent(int id) {
        for (Node student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    // Tìm kiếm sinh viên theo ID (Sử dụng Binary Search)
    public Node searchStudentById(int id) {
        // Sort the list by ID before performing binary search
        sortStudentsById();

        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Node midStudent = students.get(middle);

            if (midStudent.getId() == id) {
                return midStudent; // Found the student
            } else if (midStudent.getId() < id) {
                left = middle + 1; // Search in the right half
            } else {
                right = middle - 1; // Search in the left half
            }
        }

        return null; // Student not found
    }
    // Sắp xếp danh sách sinh viên theo ID (Required for Binary Search)
    private void sortStudentsById() {
        students.sort(Comparator.comparingInt(Node::getId));
    }

    // Hiển thị tất cả sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Node student : students) {
            System.out.println(student);
        }
    }
    // Sắp xếp danh sách sinh viên theo điểm số (Bubble Sort)
    public void sortStudentsByMarks() {
        int n = students.size();
         for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Node temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
}
