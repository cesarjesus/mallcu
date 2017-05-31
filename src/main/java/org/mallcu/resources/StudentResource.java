package org.mallcu.resources;

import java.util.List;

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
    public Student studentById(@PathParam("id") int id) {
        return studentsManager.searchById(id);
    }
    
    @POST
    public Response add(Student student) {
        // TODO: Verify if the student was added correctly
        // and then return a OK response.
        studentsManager.add(student);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        studentsManager.delete(id);
        // TODO: Verify if the student was deleted correctly
        // and then return a OK response.
        return Response.ok().build();
    }
    
    @GET
    @Path("{id}/class")
    public List<String> getClasses(@PathParam("id") int id) {
        return studentsManager.getClasses(id);
    }
    
    @POST
    @Path("{id}/class/{code}")
    public Response addClass(@PathParam("id") int id,
            @PathParam("code") String classCode) {
        studentsManager.addClass(id, classCode);
        // TODO: Verify if the class was added correctly
        // and then return OK response.
        return Response.ok().build();
    }
    
    @DELETE
    @Path("{id}/class/{code}")
    public Response removeClass(@PathParam("id") int id,
            @PathParam("code") String classCode) {
        studentsManager.removeClass(id, classCode);
        // TODO: Verify that remove was success and then return OK.
        return Response.ok().build();
    }
    
    @PUT
    @Path("{id}")
    public Student update(@PathParam("id")int id, Student student) {
        return studentsManager.update(id, student);
    }
}
