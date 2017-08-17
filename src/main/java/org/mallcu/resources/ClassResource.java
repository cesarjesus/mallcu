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
            response = Response.ok(classManager.searchByCode(code)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @POST
    public Response add(Class clasz) {
        Response response = Response.ok().status(Response.Status.CREATED).build();
        if (!classManager.add(clasz)) {
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }

        return response;
    }

    @DELETE
    @Path("{code}")
    public Response delete(@PathParam("code") String code) {
        Response response;
        try {
            boolean deleted = classManager.delete(code);
            if (deleted) {
                response = Response.ok().build();
            } else {
                response = Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @POST
    @Path("{code}/students/{id}")
    public Response addStudent(@PathParam("code") String classCode,
            @PathParam("id") int studentId) {
        Response response;
        try {
            classManager.addStudent(classCode, studentId);
            response = Response.ok().build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }

    @DELETE
    @Path("{code}/students/{id}")
    public Response removeStudent(@PathParam("code") String classCode,
            @PathParam("id") int studentId) {
        Response response;
        try {
            classManager.removeStudent(classCode, studentId);
            response = Response.ok().build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }

    @GET
    @Path("{code}/students")
    public Response getStudents(@PathParam("code") String classCode) {
        Response response;
        try {
            response = Response.ok(classManager.getStudents(classCode)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }

    @PUT
    @Path("{code}")
    public Response update(@PathParam("code") String classCode, Class clasz) {
        Response response;
        try {
            response = Response.ok(classManager.update(classCode, clasz)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }
}
