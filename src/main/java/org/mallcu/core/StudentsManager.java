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
    
    public List<String> getClasses(int id) {
        Student student = searchById(id);
        List<String> classes = new ArrayList<>();
        student.getClasses().stream().forEach(s -> classes.add(s.getCode()));
        return classes;
    }
    
    public boolean addClass(int id, String classCode) {
        Student student = searchById(id);
        ClassManager classManager = ApplicationManager
                .getInstance().getClassManager();
        student.addClass(classManager.searchByCode(classCode));
        classManager.searchByCode(classCode).addStudent(student);
        // TODO: Verify and validate that it was added correctly
        return true;
    }
    
    public boolean removeClass(int id, String classCode) {
        Student student = searchById(id);
        student.removeClass(ApplicationManager.getInstance()
                .getClassManager().searchByCode(classCode));
        return true;
    }
    
    public Student update(int id, Student student) {
        Student saved = searchById(id);
        // TODO: This is ineficient, have to be a better way to do this.
        saved.setFirstName(student.getFirstName());
        saved.setLastName(student.getLastName());
        
        return saved;
    }
}
