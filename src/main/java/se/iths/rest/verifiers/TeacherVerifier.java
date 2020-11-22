package se.iths.rest.verifiers;

import se.iths.entity.Teacher;
import se.iths.rest.exceptions.BadFormatInputException;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.service.TeacherService;

import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

public class TeacherVerifier {

    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with teacher's information must include fields:\n {\n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n}\n");
    }

    public void verifyTeacher(Teacher teacher) {
        if (teacher.getEmail() == null || teacher.getFirstname() == null || teacher.getLastname() == null)
            badformatInput();
    }

    public List<Teacher> list_teachersCheck(List<Teacher> teacherList, String message) {
        if (teacherList.size() > 0)
            return teacherList;
        else
            throw new StudentNotFoundException(message);
    }

    public Boolean verifyThatTeacherAndSubjectExists(Boolean teacher, Boolean subject){
        Boolean bothExists = null;
            if(teacher && subject)
                bothExists = true;
             if (!teacher && subject){
                 bothExists = false;
             }
             if (!subject && teacher){
                 bothExists = false;
             }
             else if (!subject && !teacher) {
                 bothExists = false;
             }
             return bothExists;

    }


    public Response TeacherExist(Teacher foundTeacher, TeacherService teacherService) {
        if (!(foundTeacher == null)) {
            long removed = foundTeacher.getId();
            teacherService.removeTeacher(foundTeacher.getId());
            return Response.ok().entity("Teacher with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new StudentNotFoundException("Teacher attempting to delete is not registered");
        }

    }

    public Teacher TeacherExist(Teacher foundTeacher, Long id) {
        if (foundTeacher != null) {
            return foundTeacher;
        } else {
            throw new StudentNotFoundException("Not teacher found with id " + id);
        }
    }

}
