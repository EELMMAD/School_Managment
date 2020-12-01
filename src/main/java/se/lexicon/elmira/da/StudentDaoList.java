package se.lexicon.elmira.da;

import se.lexicon.elmira.bl.Course;
import se.lexicon.elmira.bl.Student;

import java.util.*;

public class StudentDaoList implements StudentDao {
    private static List<Student> students = new ArrayList<Student>();

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student findById(int id) {
        Student output = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                output = students.get(i);
                break;
            }
        }
        return output;
    }

    public List<Student> findByName(String name) {
        List<Student> output = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                output.add(students.get(i));
            }
        }
        return output;
    }

    public Student findByEmail(String email) {
        Student output = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEmail().equals(email)) {
                output = students.get(i);
                break;
            }
        }
        return output;
    }

    public List<Student> findAll() {
        return students;
    }

    public boolean deleteStudent(Student student) {
        List<Course> unreg = student.getCourses();
        for (int i = 0; i < unreg.size(); i++) {
            student.unregister(unreg.get(i));
        }
        boolean output = students.remove(student);
        return output;
    }

    public void removeAll() {
        students = new ArrayList<Student>();
    }
}

