package se.lexicon.elmira.da;

import se.lexicon.elmira.bl.Course;
import java.util.*;
import java.time.*;

public interface CourseDao {
    public Course saveCourse(Course course);
    public Course findById(int id);
    public List<Course> findByName(String name);
    public List<Course> findByDate(LocalDate date);
    public List<Course> findAll();
    public boolean removeCourse(Course course);
}