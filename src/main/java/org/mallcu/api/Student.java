package org.mallcu.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a Student.
 * 
 * @author Cesar Flores
 */
public class Student {
    
    private Integer id;
    
    @JsonProperty
    private String firstName;
    
    @JsonProperty
    private String lastName;

    @JsonSerialize(using = ListClassSerializer.class)
    private List<Class> classes;

    public Student() {
        classes = new ArrayList<>();
    }
    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    @JsonProperty
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the value of classes
     *
     * @return the value of classes
     */
    public List<Class> getClasses() {
        return classes;
    }
    
    /**
     * Add an Class to existing list of classes.
     * 
     * @param clazz to be added.
     */
    public void addClass(Class clazz) {
        // TODO: Initialize classes in some place first.
        classes.add(clazz);
    }
}
