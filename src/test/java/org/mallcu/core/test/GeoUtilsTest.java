package org.mallcu.core.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mallcu.api.Student;
import org.mallcu.core.GeoUtils;

/**
 * Tests for GeoUtils class.
 * 
 * @author Cesar Flores
 */
public class GeoUtilsTest {
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void studentInClassRoomTest() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Wilson");
        student.setLatitude(34.069149);
        student.setLongitude(-118.442639 );
        
        org.mallcu.api.Class clasz = new org.mallcu.api.Class();
        clasz.setTitle("Principles of computational geo-location analysis");
        clasz.setLatitude(34.069140);
        clasz.setLongitude(-118.442689);
        
        assertTrue(GeoUtils.isStudentInClassRoom(student, clasz));
    }
}
