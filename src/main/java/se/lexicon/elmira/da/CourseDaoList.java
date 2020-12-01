package se.lexicon.elmira.da;

import se.lexicon.elmira.bl.Course;
import se.lexicon.elmira.bl.Student;

import java.util.*;
import java.time.*;

public class CourseDaoList implements CourseDao {
    private static List<Course> courses = new ArrayList<Course>();

    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course findById(int id) {
        Course output = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                output = courses.get(i);
                break;
            }
        }
        return output;
    }

    public List<Course> findByName(String name) {
        List<Course> output = new ArrayList<Course>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(name)) {
                output.add(courses.get(i));
            }
        }
        return output;
    }

    public List<Course> findByDate(LocalDate date) {
        List<Course> output = new ArrayList<Course>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getDate().equals(date)) {
                output.add(courses.get(i));
            }
        }
        return output;
    }

    public List<Course> findAll() {
        return courses;
    }

    public boolean removeCourse(Course course) {
        List<Student> unreg = course.getStudents();
        for (int i = 0; i < unreg.size(); i++) {
            unreg.get(i).unregister(course);
        }
        boolean output = courses.remove(course);
        return output;
    }

    public void removeAll() {
        courses = new ArrayList<Course>();
    }
}

