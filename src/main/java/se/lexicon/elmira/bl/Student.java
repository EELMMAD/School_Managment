package se.lexicon.elmira.bl;

import java.util.*;

public class Student {
    private int id;
    private String name, email, address;
    private List<Course> courses;
    public Student(int studentId, String studentName, String studentEmail, String studentAddress) {
        courses = new ArrayList<Course>();
        id = studentId;
        name = studentName;
        email = studentEmail;
        address = studentAddress;
    }

    public void register(Course course) {
        if (course != null) {
            course.register(this);
            courses.remove(course);
            courses.add(course);
        }
    }
    public void unregister(Course course) {
        if (course != null) {
            course.unregister(this);
            courses.remove(course);
        }
    }

    public String toString() {
        return "id=<" + Integer.toString(id) + "> name=<" + name + "> email=<" + email + "> address=<" + address + ">";
    }

    public int getId() {
        return id;
    }
    public void setId(int studentId) {
        id = studentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String studentName) {
        name = studentName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String studentEmail) {
        email = studentEmail;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String studentAddress) {
        address = studentAddress;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

