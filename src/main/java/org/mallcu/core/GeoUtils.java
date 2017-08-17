package org.mallcu.core;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.spatial4j.shape.Rectangle;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.ShapeFactory;
import org.locationtech.spatial4j.shape.SpatialRelation;
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
        
        SpatialContext context = SpatialContext.GEO;
        ShapeFactory shapeFactory = context.getShapeFactory();
        //Point studentPoint = shapeFactory.pointXY(student.getLatitude(), student.getLongitude());
        Shape shape = SpatialContext.GEO.makePoint(student.getLongitude(), student.getLatitude());
        double distTenMeters = DistanceUtils.dist2Degrees(10 / 1000, DistanceUtils.EARTH_MEAN_RADIUS_KM);
        Point p1 = SpatialContext.GEO.makePoint(clasz.getLongitude() - distTenMeters, clasz.getLatitude() - distTenMeters);
        Point p2 = SpatialContext.GEO.makePoint(clasz.getLongitude() + distTenMeters, clasz.getLatitude() + distTenMeters);
        Rectangle rectangle = shapeFactory.rect(p1, p2);
        if (shape.relate(rectangle) == SpatialRelation.WITHIN) {
            return true;
        }
        return false;
        // FIXME: The formula still is not working correctly, need to be reviewed.
        /*double classNewLon = clasz.getLatitude() + (10 / 6378) * 180 / Math.PI;
        double classNewLat = clasz.getLongitude() 
                + (10 / 6378) * (180 / Math.PI) / Math.cos(clasz.getLatitude() * Math.PI / 180);
        boolean lat = (student.getLatitude() < clasz.getLatitude() + classNewLat)
                        && (student.getLatitude() > clasz.getLatitude() - classNewLat);
        boolean lon = (student.getLongitude() < clasz.getLongitude() + classNewLon)
                        && (student.getLongitude() > clasz.getLongitude() - classNewLon);
        return lat && lon;*/
    }
}
