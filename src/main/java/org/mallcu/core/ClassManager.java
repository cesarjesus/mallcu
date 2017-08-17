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

    /**
     * Returns all classes.
     * 
     * @return a List of classes.
     */
    public List<Class> allClasses() {
        return classes;
    }
    
    /**
     * Search a Class for the given code.
     * 
     * @param code of the class.
     * @return the Class for the code, throws NotSuchElementException if not found.
     */
    public Class searchByCode(String code) {
        // TODO: If the element is not present
        // it will throws NotSuchElementException
        return classes.stream()
                .filter(clasz -> clasz.getCode().equals(code))
                .findFirst()
                .get();
    }
    
    /**
     * Add a new Class, if a class with the same code already exists,
     * it will not be added.
     * 
     * @param clasz to be added.
     * @return true if the Class was added, false in other case.
     */
    public boolean add(Class clasz) {
        boolean codeAlreadyExists = classes.stream()
                .anyMatch(c -> c.getCode().equals(clasz.getCode()));
        if (codeAlreadyExists) {
            return false;
        }

        return classes.add(clasz);
    }
    
    /**
     * Delete a class for the given code. If a class with the given
     * code does not exists, it will throws NoSuchElementException.
     * 
     * @param code of the class to be deleted.
     * @return true if was deleted, false in other case.
     */
    public boolean delete(String code) {
        // TODO: Add control to verify if the element really exists
        // before try to remove it.
        return classes.remove(searchByCode(code));
    }
    
    /**
     * Add a student to the class. If a class with the given code
     * does not exists or a student with the given id does not exists,
     * it will throws NoSuchElementException. If a student is already
     * in the class, it will do nothing.
     * 
     * @param classCode the code of the Class.
     * @param studentId the id of the student.
     * @return true if the student was added, false in other case.
     */
    public boolean addStudent(String classCode, int studentId) {
        // TODO: It should be changed according searchByCode changes.
        Class clasz = searchByCode(classCode);
        StudentsManager studentManager = ApplicationManager
                .getInstance().getStudentsManager();
        
        if (clasz.getStudents().stream().anyMatch(s -> s.getId() == studentId)) {
            // NOTE: Student already in the class,
            // no need to add again, do nothing.
            return true;
        }
        
        // TODO: This cannot be a good way todo this.
        // TODO: Verify if the operation is success and then return true.
        clasz.addStudent(studentManager.searchById(studentId));
        studentManager.searchById(studentId).addClass(clasz);
        
        return true;
    }
    
    /**
     * Removes a student from a class. If the given class code does not exists
     * or the given student id does not exists, it will throws NoSuchElementException.
     * 
     * @param classCode the code of the class.
     * @param studentId the id of the student.
     * @return true if the student is removed.
     */
    public boolean removeStudent(String classCode, int studentId) {
        Class clasz = searchByCode(classCode);
        clasz.removeStudent(ApplicationManager.getInstance()
                .getStudentsManager().searchById(studentId));
        // FIXME: Does not have much sence return this.
        return true;
    }
    
    /**
     * Returns all student ids for this class. If the class
     * id does not exists, it will throws NoSuchElementException.
     * 
     * @param classCode the code of the class.
     * @return a list of integers that represents the ids of the students.
     */
    public List<Integer> getStudents(String classCode) {
        List<Integer> students = new ArrayList<>();
        Class clasz = searchByCode(classCode);
        clasz.getStudents().forEach((student) -> {
            students.add(student.getId());
        });
        
        return students;
    }
    
    /**
     * Update information of the class. It will throws a NoSuchElementException
     * if the class code does not exist.
     * 
     * @param classCode the code of the class.
     * @param clasz a class with new information.
     * @return the updated class.
     */
    public Class update(String classCode, Class clasz) {
        Class saved = searchByCode(classCode);
        // TODO: Again, ineficient way todo this.
        saved.setTitle(clasz.getTitle());
        saved.setDescription(clasz.getDescription());
        return saved;
    }
}
