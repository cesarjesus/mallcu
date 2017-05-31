package org.mallcu.core;

import org.mallcu.api.Student;

/**
 * Utilities to work with geo location.
 * 
 * @author Cesar Flores
 */
public class GeoUtils {
   
    public static boolean isStudentInClassRoom(Student student,
            org.mallcu.api.Class clasz) {
        boolean lat = (student.getLatitude() < clasz.getLatitude() + 10)
                        && (student.getLatitude() > clasz.getLatitude() - 10);
        boolean lon = (student.getLongitude() < clasz.getLongitude() + 10)
                        && (student.getLongitude() > clasz.getLongitude() - 10);
        return lat && lon;
    }
}
