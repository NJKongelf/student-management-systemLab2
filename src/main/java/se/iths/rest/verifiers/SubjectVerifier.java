package se.iths.rest.verifiers;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.rest.exceptions.BadFormatInputException;
import se.iths.rest.exceptions.StudentNotFoundException;

import se.iths.service.SubjectService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SubjectVerifier {
    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with student's information must include fields:\n {\n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n}\n");
    }

    public void verifySubject(Subject subject) {
        if (subject.getName()== null)
            badformatInput();
    }

    public List<Subject> list_subjectsCheck(List<Subject> subjects, String message) {
        List<Subject> subjectslists = subjects;
        if (subjectslists.size() > 0)
            return subjectslists;
        else
            throw new StudentNotFoundException(message);
    }

    public Response SubjectExist(Subject foundsubject, SubjectService subjectService) {
        if (!(foundsubject == null)) {
            long removed = foundsubject.getId();
            subjectService.removeSubject(foundsubject.getId());
            return Response.ok().entity("Subject with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new StudentNotFoundException("Subject attempting to delete is not registered");
        }

    }

    public Subject SubjectExist(Subject foundsubject, Long id) {
        if (foundsubject != null) {
            return foundsubject;
        } else {
            throw new StudentNotFoundException("Not subject found with id " + id);
        }
    }
}
