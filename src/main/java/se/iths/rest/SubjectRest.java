package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.rest.verifiers.SubjectVerifier;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    @Inject
    SubjectService subjectService;
    @Inject
    SubjectVerifier verifier;

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {
        verifier.verifySubject(subject);
        return Response.ok(subjectService.createSubject(subject)).build();
    }

    @Path("getall")
    @GET
    public List<Subject> getallSubjects() {
        return verifier.list_subjectsCheck(subjectService.getAllSubjects(),"No subjects registered");
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        verifier.verifySubject(subject);
        return Response.ok(subjectService.updateTodo(subject)).build();
    }
    @Path("searchById/{id}")
    @GET
    public Subject getSubject(@PathParam("id") Long id) {
        return verifier.SubjectExist(subjectService.findSubjectById(id),id);
    }

    @Path("getStudentsBySubjectName/{name}")
    @GET
    public Set<Student> getStudentsPerSubject(@PathParam("name") String name){
        try{
        return subjectService.findStudentsBySubject(name);}
        catch(NoResultException e){
            throw new StudentNotFoundException("Not found matches to given subject. Make sure you spell subject's name right and that subject is registered");
        }
    }
    @Path("deleteById/{id}")
    @DELETE
    public Response deleteSSubject(@PathParam("id") Long id) {
        return verifier.SubjectExist(subjectService.findSubjectById(id), subjectService);
    }

}
