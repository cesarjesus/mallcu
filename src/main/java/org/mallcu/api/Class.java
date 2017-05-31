package org.mallcu.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a Class.
 * 
 * @author Cesar Flores
 */
public class Class {
    
    private String code;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonSerialize(using = ListStudentsSerializer.class)
    private List<Student> students;
    
    public Class() {
        students = new ArrayList<>();
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    @JsonProperty
    public String getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(String code) {
        this.code = code;
    }

     /**
     * Get the value of students
     *
     * @return the value of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Add a new student to the Class.
     * 
     * @param student to be added.
     */
    public void addStudent(Student student) {
        // TODO: Initialize students in some place first.
        students.add(student);
    }
    
    /**
     * Removes a student from the class.
     * 
     * @param student to be removed.
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }
}
