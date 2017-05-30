package org.mallcu.core;

import java.util.ArrayList;
import java.util.List;

import org.mallcu.api.Class;

/**
 * Logic to handle Class.
 * 
 * @author cesar_flores
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
        return true;
    }
}
