package se.lexicon.elmira.app;

import se.lexicon.elmira.bl.Course;
import se.lexicon.elmira.bl.Student;
import se.lexicon.elmira.da.CourseDaoList;
import se.lexicon.elmira.da.StudentDaoList;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseDaoList coursesList = new CourseDaoList();
        StudentDaoList studentsList = new StudentDaoList();
        System.out.println("Press a to create new courses.");
        System.out.println("Press b to create new students.");
        System.out.println("Press c to register.");
        System.out.println("Press d to unregister.");
        System.out.println("Press e to find course by id.");
        System.out.println("Press f to find course by name.");
        System.out.println("Press g to find course by date.");
        System.out.println("Press h to find all courses.");
        System.out.println("Press i to find student by id.");
        System.out.println("Press j to find student by name.");
        System.out.println("Press k to find student by email.");
        System.out.println("Press l to find all students.");
        System.out.println("Press m to edit courses.");
        System.out.println("Press n to edit students.");
        System.out.println("Press o to finish the program.");
        String item = "";
        while (!item.equals("o")) {
            System.out.print("***** Enter item: ");
            item = scanner.nextLine();
            /* create course */
            if (item.equals("a")) {
                System.out.print("----- Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter name: ");
                String name = scanner.nextLine();
                System.out.print("----- Enter date (like 2020-02-15): ");
                String date = scanner.nextLine();
                System.out.print("----- Enter duration: ");
                int duration = Integer.parseInt(scanner.nextLine());
                Course course = new Course(id, name, LocalDate.parse(date), duration);
                coursesList.saveCourse(course);
            }
            /* create student */
            else if (item.equals("b")) {
                System.out.print("----- Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter name: ");
                String name = scanner.nextLine();
                System.out.print("----- Enter email: ");
                String email = scanner.nextLine();
                System.out.print("----- Enter address: ");
                String address = scanner.nextLine();
                Student student = new Student(id, name, email, address);
                studentsList.saveStudent(student);
            }
            /* register */
            else if (item.equals("c")) {
                System.out.print("----- Enter student id: ");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter course id: ");
                int courseId = Integer.parseInt(scanner.nextLine());
                Student student = studentsList.findById(studentId);
                Course course = coursesList.findById(courseId);
                if (student != null) {
                    student.register(course);
                }
            }
            /* unregister */
            else if (item.equals("d")) {
                System.out.print("----- Enter student id: ");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter course id: ");
                int courseId = Integer.parseInt(scanner.nextLine());
                Student student = studentsList.findById(studentId);
                Course course = coursesList.findById(courseId);
                if (student != null) {
                    student.unregister(course);
                }
            }
            /* find course by id */
            else if (item.equals("e")) {
                System.out.print("----- Enter course id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Course course = coursesList.findById(id);
                if (course != null) {
                    System.out.println(course.toString());
                }
            }
            /* find course by name */
            else if (item.equals("f")) {
                System.out.print("----- Enter course name: ");
                String name = scanner.nextLine();
                List<Course> courses = coursesList.findByName(name);
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println(courses.get(i).toString());
                }
            }
            /* find course by date */
            else if (item.equals("g")) {
                System.out.print("----- Enter course date (like 2020-02-15): ");
                String date = scanner.nextLine();
                List<Course> courses = coursesList.findByDate(LocalDate.parse(date));
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println(courses.get(i).toString());
                }
            }
            /* find all the courses */
            else if (item.equals("h")) {
                List<Course> courses = coursesList.findAll();
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println(courses.get(i).toString());
                }
            }
            /* find student by id */
            else if (item.equals("i")) {
                System.out.print("----- Enter student id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Student student = studentsList.findById(id);
                if (student != null) {
                    System.out.println(student.toString());
                }
            }
            /* find student by name */
            else if (item.equals("j")) {
                System.out.print("----- Enter student name: ");
                String name = scanner.nextLine();
                List<Student> students = studentsList.findByName(name);
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(students.get(i).toString());
                }
            }
            /* find student by email */
            else if (item.equals("k")) {
                System.out.print("----- Enter student email: ");
                String email = scanner.nextLine();
                Student student = studentsList.findByEmail(email);
                if (student != null) {
                    System.out.println(student.toString());
                }
            }
            /* find all the students */
            else if (item.equals("l")) {
                List<Student> students = studentsList.findAll();
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(students.get(i).toString());
                }
            }
            /* edit courses */
            else if (item.equals("m")) {
                System.out.print("----- Enter course id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter name: ");
                String name = scanner.nextLine();
                System.out.print("----- Enter date (like 2020-02-15): ");
                String date = scanner.nextLine();
                System.out.print("----- Enter duration: ");
                int duration = Integer.parseInt(scanner.nextLine());
                Course course = coursesList.findById(id);
                if (course != null) {
                    course.setName(name);
                    course.setDate(LocalDate.parse(date));
                    course.setDuration(duration);
                }
            }
            /* edit students */
            else if (item.equals("n")) {
                System.out.print("----- Enter student id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("----- Enter name: ");
                String name = scanner.nextLine();
                System.out.print("----- Enter email: ");
                String email = scanner.nextLine();
                System.out.print("----- Enter address: ");
                String address = scanner.nextLine();
                Student student = studentsList.findById(id);
                if (student != null) {
                    student.setName(name);
                    student.setEmail(email);
                    student.setAddress(address);
                }
            }
            /* finish */
            else if (item.equals("o")) {
                return;
            }
        }
    }
}

