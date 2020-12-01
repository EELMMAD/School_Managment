package se.lexicon.elmira.bl;

import java.util.*;
import java.time.*;

public class Course {
    private int id, duration;
    private String name;
    private LocalDate date;
    private List<Student> students;
    public Course(int coursetId, String courseName, LocalDate courseDate, int courseDuration) {
        students = new ArrayList<Student>();
        id = coursetId;
        name = courseName;
        date = courseDate;
        duration = courseDuration;
    }

    public void register(Student student) {
        if (student != null) {
            students.remove(student);
            students.add(student);
        }
    }
    public void unregister(Student student) {
        if (student != null) {
            students.remove(student);
        }
    }

    public String toString() {
        return "id=<" + Integer.toString(id) + "> name=<" + name + "> date=<" + date.toString() + "> duration=<" + Integer.toString(duration) + ">";
    }

    public int getId() {
        return id;
    }
    public void setId(int courseId) {
        id = courseId;
    }

    public String getName() {
        return name;
    }
    public void setName(String courseName) {
        name = courseName;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate courseDate) {
        date = courseDate;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int courseDuration) {
        duration = courseDuration;
    }

    public List<Student> getStudents() {
        return students;
    }
}

