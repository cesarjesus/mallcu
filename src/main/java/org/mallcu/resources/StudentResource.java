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

import org.mallcu.api.Student;
import org.mallcu.core.ApplicationManager;
import org.mallcu.core.StudentsManager;

/**
 * Holds REST API operations with Students.
 * 
 * @author Cesar Flores
 */
@Path("api/v1/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
   
    // TODO: Needs to be managed, or injected.
    private StudentsManager studentsManager;
    
    public StudentResource() {
        studentsManager = ApplicationManager.getInstance().getStudentsManager();
    }
    
    @GET
    public List<Student> students() {
        return studentsManager.allStudents();
    }
    
    @GET
    @Path("{id}")
    public Response studentById(@PathParam("id") int id) {
        Response response;
        try {
            response = Response.ok(studentsManager.searchById(id)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return response;
    }
    
    @POST
    public Response add(Student student) {
        Response response = Response.status(Response.Status.CREATED).build();
        if (!studentsManager.add(student)) {
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }

        return response;
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Response response;
        try {
            studentsManager.delete(id);
            response = Response.ok().build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
    
    @GET
    @Path("{id}/class")
    public Response getClasses(@PathParam("id") int id) {
        Response response;
        try {
            response = Response.ok(studentsManager.getClasses(id)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
    
    @POST
    @Path("{id}/class/{code}")
    public Response addClass(@PathParam("id") int id,
            @PathParam("code") String classCode) {
        Response response;
        try {
            studentsManager.addClass(id, classCode);
            response = Response.ok().build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
    
    @DELETE
    @Path("{id}/class/{code}")
    public Response removeClass(@PathParam("id") int id,
            @PathParam("code") String classCode) {
        Response response;
        try {
            studentsManager.removeClass(id, classCode);
            response = Response.ok().build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id")int id, Student student) {
        Response response;
        try {
            response = Response.ok(studentsManager.update(id, student)).build();
        } catch (NoSuchElementException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
