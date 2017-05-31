package org.mallcu.core.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
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
        
        // TODO: Not sure to understand well if this should be true or false.
        assertTrue(GeoUtils.isStudentInClassRoom(student, clasz));
    }
    
    @Test
    public void studentNotInClassRoomTest() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Graham");
        student.setLatitude(34.069901);
        student.setLongitude(-118.441562);
        
        org.mallcu.api.Class clasz = new org.mallcu.api.Class();
        clasz.setTitle("Sedimentary Petrology");
        clasz.setLatitude(34.069585);
        clasz.setLongitude(-118.441878);
        
        // TODO: Not sure to understand well if this should be true or false.
        assertFalse(GeoUtils.isStudentInClassRoom(student, clasz));
    }
}
