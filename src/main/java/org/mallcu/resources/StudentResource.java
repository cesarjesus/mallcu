package org.mallcu.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mallcu.api.Student;
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
        studentsManager = new StudentsManager();
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
}
