package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    @Inject
    SubjectService subjectService;

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {
        return Response.ok(subjectService.createSubject(subject)).build();
    }

    @Path("getall")
    @GET
    public List<Subject> getallSubjects() {
        return subjectService.getAllSubjects();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        return Response.ok(subjectService.updateTodo(subject)).build();
    }
    @Path("searchById/{id}")
    @GET
    public Subject getStudent(@PathParam("id") Long id) {
        return subjectService.findSubjectById(id);
    }
}
