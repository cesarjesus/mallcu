package org.mallcu.resources;

import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mallcu.api.Class;
import org.mallcu.core.ApplicationManager;
import org.mallcu.core.ClassManager;

/**
 * Holds REST API operations with classes.
 *
 * @author cesar_flores
 */
@Path("api/v1/class")
@Produces(MediaType.APPLICATION_JSON)
public class ClassResource {

    // TODO: Needs to be managed, or injected.
    private ClassManager classManager;

    public ClassResource() {
        classManager = ApplicationManager.getInstance().getClassManager();
    }

    @GET
    public List<Class> classes() {
        return classManager.allClasses();
    }

    @GET
    @Path("{code}")
    public Response classByCode(@PathParam("code") String code) {
        Response response;
        try {
            Class clasz = classManager.searchByCode(code);
            response = Response.ok(clasz).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }

    @POST
    public Response add(Class clasz) {
        // TODO: Verify if the student was added correctly
        // and then return a OK response.
        Response response;
        boolean added = classManager.add(clasz);
        if (added) {
            response = Response.ok().status(Response.Status.CREATED).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        return response;
    }

    @DELETE
    @Path("{code}")
    public Response delete(@PathParam("code") String code) {
        classManager.delete(code);
        // TODO: Verify if the student was deleted correctly
        // and then return a OK response.
        return Response.ok().build();
    }

    @POST
    @Path("{code}/students/{id}")
    public Response addStudent(@PathParam("code") String classCode,
            @PathParam("id") int studentId) {
        classManager.addStudent(classCode, studentId);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("{code}/students/{id}")
    public Response removeStudent(@PathParam("code") String classCode,
            @PathParam("id") int studentId) {
        classManager.removeStudent(classCode, studentId);
        return Response.ok().build();
    }
    
    @GET
    @Path("{code}/students")
    public List<Integer> getStudents(@PathParam("code") String classCode) {
        return classManager.getStudents(classCode);
    }
    
    @PUT
    @Path("{code}")
    public Class update(@PathParam("code") String classCode, Class clasz) {
        return classManager.update(classCode, clasz);
    }
}
