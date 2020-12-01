package se.lexicon.elmira.da;

import se.lexicon.elmira.bl.Student;
import java.util.*;

public interface StudentDao {
    public Student findById(int id);
    public Student saveStudent(Student student);
    public List<Student> findByName(String name);
    public Student findByEmail(String email);
    public List<Student> findAll();
    public boolean deleteStudent(Student student);
}
