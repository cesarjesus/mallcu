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

import org.mallcu.api.Class;
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
        classManager = new ClassManager();
    }

    @GET
    public List<Class> classes() {
        return classManager.allClasses();
    }

    @GET
    @Path("{code}")
    public Class classByCode(@PathParam("code") String code) {
        return classManager.searchByCode(code);
    }

    @POST
    public Response add(Class clasz) {
        // TODO: Verify if the student was added correctly
        // and then return a OK response.
        classManager.add(clasz);
        return Response.ok().build();
    }

    @DELETE
    @Path("{code}")
    public Response delete(@PathParam("code") String code) {
        classManager.delete(code);
        // TODO: Verify if the student was deleted correctly
        // and then return a OK response.
        return Response.ok().build();
    }

    @Path("{code}/addStudent/{id}")
    public Response addStudent(@PathParam("code") String classCode,
            @PathParam("id") int studentId) {
        classManager.addStudent(classCode, studentId);
        return Response.ok().build();
    }
}
