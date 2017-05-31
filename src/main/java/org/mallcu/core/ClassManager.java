package org.mallcu.core;

import java.util.ArrayList;
import java.util.List;

import org.mallcu.api.Class;

/**
 * Logic to handle Class.
 * 
 * @author Cesar Flores
 */
public class ClassManager {
    // TODO: It can be retrieve from DB or wherever.
    private List<Class> classes;

    public ClassManager() {
        classes = new ArrayList<>();
    }
    
    public ClassManager(List<Class> clasz) {
        this.classes = clasz;
    }

    public List<Class> allClasses() {
        return classes;
    }
    
    public Class searchByCode(String code) {
        // TODO: If the element is not present
        // it will throws NotSuchElementException
        return classes.stream()
                .filter(clasz -> clasz.getCode().equals(code))
                .findFirst()
                .get();
    }
    
    public boolean add(Class clasz) {
        return classes.add(clasz);
    }
    
    public boolean delete(String code) {
        // TODO: Add control to verify if the element really exists
        // before try to remove it.
        return classes.remove(searchByCode(code));
    }
    
    public boolean addStudent(String classCode, int studentId) {
        // TODO: It should be changed according searchByCode changes.
        Class clasz = searchByCode(classCode);
        StudentsManager studentManager = ApplicationManager
                .getInstance().getStudentsManager();
        // TODO: This cannot be a good way todo this.
        // TODO: Verify if the operation is success and then return true.
        clasz.addStudent(studentManager.searchById(studentId));
        studentManager.searchById(studentId).addClass(clasz);
        return true;
    }
    
    public boolean removeStudent(String classCode, int studentId) {
        Class clasz = searchByCode(classCode);
        clasz.removeStudent(ApplicationManager.getInstance()
                .getStudentsManager().searchById(studentId));
        return true;
    }
    
    public List<Integer> getStudents(String classCode) {
        List<Integer> students = new ArrayList<>();
        Class clasz = searchByCode(classCode);
        clasz.getStudents().forEach((student) -> {
            students.add(student.getId());
        });
        
        return students;
    }
    
    public Class update(String classCode, Class clasz) {
        Class saved = searchByCode(classCode);
        // TODO: Again, ineficient way todo this.
        saved.setTitle(clasz.getTitle());
        saved.setDescription(clasz.getDescription());
        return saved;
    }
}
