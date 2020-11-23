package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class SubjectService {
    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject updateTodo(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT DISTINCT s from Subject s INNER JOIN FETCH s.students", Subject.class).getResultList();
     //  return entityManager.createQuery("SELECT s.id, s.name AS \'name\', s.teacher AS \'teacher\' FROM Subject s",Subject.class).getResultList();
      //  return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    public List<Subject> findSubjectByName(String LName) {
        return entityManager.createQuery("SELECT s from Subject s where s.name like :name", Subject.class).setParameter("name", LName).getResultList();

    }
    public Set<Student> findStudentsBySubject(String subject){
        Subject s =  entityManager.createQuery("SELECT s FROM Subject s  WHERE s.name = :sub", Subject.class).setParameter("sub",subject).getSingleResult();
        Long id = s.getId();
        return entityManager.find(Subject.class, id).getStudents();
    }

    public void removeSubject(long id) {
        Subject object = entityManager.find(Subject.class, id);
        entityManager.remove(object);
    }
}
