package org.mallcu.core;

import org.mallcu.api.Student;

/**
 * Utilities to work with geo location.
 * 
 * @author Cesar Flores
 */
public class GeoUtils {
   
    /**
     * Calculates if a student are in class room, class room has 20x20 meters.
     * 
     * @param student to be check if is in class room.
     * @param clasz if the student is there.
     * @return true if student is in class room, false in otherwise.
     */
    public static boolean isStudentInClassRoom(Student student,
            org.mallcu.api.Class clasz) {
        // FIXME: The formula still is not working correctly, need to be reviewed.
        double classNewLat = clasz.getLatitude() + (10 / 6378) * 180 / Math.PI;
        double classNewLon = clasz.getLongitude() 
                + (10 / 6378) * (180 / Math.PI) / Math.cos(clasz.getLatitude() * Math.PI / 180);
        boolean lat = (student.getLatitude() < clasz.getLatitude() + classNewLat)
                        && (student.getLatitude() > clasz.getLatitude() - classNewLat);
        boolean lon = (student.getLongitude() < clasz.getLongitude() + classNewLon)
                        && (student.getLongitude() > clasz.getLongitude() - classNewLon);
        return lat && lon;
    }
}
