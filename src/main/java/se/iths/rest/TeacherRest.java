package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.rest.verifiers.TeacherVerifier;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TeacherRest {
    @Inject
    TeacherService teacherService;
    TeacherVerifier verifier;

    @Path("new")
    @POST
    public Response createTeacher(Teacher teacher) {
        verifier.verifyTeacher(teacher);
        return Response.ok(teacherService.createTeacher(teacher)).build();
    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        verifier.verifyTeacher(teacher);
        return Response.ok(teacherService.updateTodo(teacher)).build();
    }

    @Path("searchById/{id}")
    @GET
    public Teacher getTeacher(@PathParam("id") Long id) {
        return verifier.TeacherExist(teacherService.findTeacherById(id), id);
    }

//    @Path("searchByLastName/{lastname}")
//    @GET
//    public List<Teacher> getStudentByLastName(@PathParam("lastname") String lastName) {
//        return verifier.list_teachersCheck(teacherService.findTeacherByLastName(lastName), "No student registered with last name " + lastName);
//    }
    @Path("getTeacherAndSubject/{firstname}")
    @GET
    public List<Teacher> getTeacherAndSubject(@PathParam("firstname") String firstname){
    // return   verifier.list_teachersCheck(teacherService.findTeacherAndSubject(firstname),"Teacher not found");
        if (teacherService.findTeacherAndSubject(firstname).size() > 0 )
        return teacherService.findTeacherAndSubject(firstname);
        else {
            throw new StudentNotFoundException("Teacher not found");
        }
    }
    @Path("getStudentBySubjectAndTeacher/{subject}/{teacher}")
    @GET
    public Set<Student> getStudentBySubjectAndTeacher(@PathParam("subject") String subject, @PathParam("teacher") String teacher){
     //   if(teacherService.getSpecifiedStudentsPerSubjectandTeacher(subject,teacher).size() > 0)
        return teacherService.getSpecifiedStudentsPerSubjectandTeacher(subject,teacher);
//        else{                                                                                     //split on two verifier methods that check if teacher and subject exists by their name
//            throw new StudentNotFoundException("Subject and teacher not related");
//        }
    }

    @Path("getall")
    @GET
    public List<Teacher> getAllItems() {
     //   return verifier.list_teachersCheck(teacherService.getAllTeachers(), "No teachers registered");
        return teacherService.getAllTeachers();
    }

    @Path("deleteById/{id}")
    @DELETE
    public Response deleteTecher(@PathParam("id") Long id) {
        return verifier.TeacherExist(teacherService.findTeacherById(id), teacherService);
    }

}
