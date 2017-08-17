package org.mallcu.core;

/**
 * Manage references to the services.
 * FIXME: Have to be a better way to do this.
 * 
 * @author Cesar Flores
 */
public class ApplicationManager {
    
    private static ApplicationManager instance;
    
    private StudentsManager studentsManager;
    private ClassManager classManager;
    
    private ApplicationManager(){
        studentsManager = new StudentsManager();
        classManager = new ClassManager();
    }
    
    public StudentsManager getStudentsManager() {
        return studentsManager;
    }
    
    public ClassManager getClassManager() {
        return classManager;
    }
    
    public static ApplicationManager getInstance() {
        if (instance == null) {
            instance = new ApplicationManager();
        }
        
        return instance;
    }
}
