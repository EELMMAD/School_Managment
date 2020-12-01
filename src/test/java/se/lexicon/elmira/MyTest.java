package se.lexicon.elmira;

import org.junit.Test;
import static org.junit.Assert.*;

import se.lexicon.elmira.bl.Course;
import se.lexicon.elmira.bl.Student;
import se.lexicon.elmira.da.CourseDaoList;
import se.lexicon.elmira.da.StudentDaoList;
import java.time.*;
import java.util.*;

public class MyTest {
    protected CourseDaoList coursesList = new CourseDaoList();
    protected StudentDaoList studentsList = new StudentDaoList();
    @Test
    public void test1() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        int allCourses = coursesList.findAll().size();
        int expectedAllCourses  = 3;
        int allStudents = studentsList.findAll().size();
        int expectedAllStudents  = 4;
        assertEquals(expectedAllCourses, allCourses);
        assertEquals(expectedAllStudents, allStudents);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test2() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        Course course1 = coursesList.findById(1);
        Course course2 = coursesList.findById(11);
        Course expectedCourse2 = null;
        assertNotNull(course1);
        assertEquals(expectedCourse2, course2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test3() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        Student student1 = studentsList.findById(1);
        Student student2 = studentsList.findById(11);
        Student expectedStudent2 = null;
        assertNotNull(student1);
        assertEquals(expectedStudent2, student2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test4() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        Course course1 = coursesList.findById(1);
        Student student1 = studentsList.findById(1);
        Student student2 = studentsList.findById(2);
        student1.register(course1);
        student2.register(course1);
        int number1 = student1.getCourses().size();
        int expectedNumber1 = 1;
        int number2 = course1.getStudents().size();
        int expectedNumber2 = 2;
        student1.unregister(course1);
        int number3 = student1.getCourses().size();
        int expectedNumber3 = 0;
        student1.unregister(course1);
        int number4 = course1.getStudents().size();
        int expectedNumber4 = 1;
        student2.unregister(course1);
        int number5 = course1.getStudents().size();
        int expectedNumber5 = 0;
        assertEquals(expectedNumber1, number1);
        assertEquals(expectedNumber2, number2);
        assertEquals(expectedNumber3, number3);
        assertEquals(expectedNumber4, number4);
        assertEquals(expectedNumber5, number5);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test5() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        List<Course> courses1 = coursesList.findByName("course1");
        int number1 = courses1.size();
        int expectedNumber1 = 2;
        List<Course> courses2 = coursesList.findByName("course4");
        int number2 = courses2.size();
        int expectedNumber2 = 0;
        assertEquals(expectedNumber1, number1);
        assertEquals(expectedNumber2, number2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test6() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        List<Course> courses1 = coursesList.findByDate(LocalDate.parse("2018-01-10"));
        int number1 = courses1.size();
        int expectedNumber1 = 2;
        List<Course> courses2 = coursesList.findByDate(LocalDate.parse("2019-05-13"));
        int number2 = courses2.size();
        int expectedNumber2 = 0;
        assertEquals(expectedNumber1, number1);
        assertEquals(expectedNumber2, number2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test7() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        List<Student> students1 = studentsList.findByName("student1");
        int number1 = students1.size();
        int expectedNumber1 = 2;
        List<Student> students2 = studentsList.findByName("student12");
        int number2 = students2.size();
        int expectedNumber2 = 0;
        assertEquals(expectedNumber1, number1);
        assertEquals(expectedNumber2, number2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
    @Test
    public void test8() {
        coursesList.saveCourse(new Course(1, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(2, "course1", LocalDate.parse("2018-01-10"), 20));
        coursesList.saveCourse(new Course(3, "course2", LocalDate.parse("2018-02-10"), 10));
        studentsList.saveStudent(new Student(1, "student1", "email1", "address1"));
        studentsList.saveStudent(new Student(2, "student1", "email2", "address2"));
        studentsList.saveStudent(new Student(3, "student2", "email3", "address3"));
        studentsList.saveStudent(new Student(4, "student3", "email4", "address4"));
        Student student1 = studentsList.findByEmail("email3");
        Student student2 = studentsList.findByEmail("email13");
        Student expectedStudent = null;
        assertNotNull(student1);
        assertEquals(expectedStudent, student2);
        coursesList.removeAll();
        studentsList.removeAll();
    }
}
