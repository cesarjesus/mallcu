package org.mallcu.core;

import java.util.ArrayList;
import java.util.List;

import org.mallcu.api.Student;

/**
 * Logic to handle students.
 * 
 * @author Cesar Flores
 */
public class StudentsManager {
    
    // TODO: It can be retrieve from DB or wherever.
    private List<Student> students;

    public StudentsManager() {
        students = new ArrayList<>();
    }
    
    public StudentsManager(List<Student> students) {
        this.students = students;
    }

    public List<Student> allStudents() {
        return students;
    }
    
    public Student searchById(int id) {
        // TODO: If the element is not present
        // it will throws NotSuchElementException
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }
    
    public boolean add(Student student) {
        return students.add(student);
    }
    
    public boolean delete(int id) {
        // TODO: Add control to verify if the element really exists
        // before try to remove it.
        return students.remove(searchById(id));
    }
}
