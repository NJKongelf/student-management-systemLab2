package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateTodo(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
//        List<Student> s = entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
//        List<Subject> sub = entityManager.createQuery("SELECT s from Subject s", Subject.class).getResultList();
//        List joinList = join
//
//        return
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public List<Student> findStudentByLastName(String LName) {
        return entityManager.createQuery("SELECT s from Student s where s.lastname like :lastname", Student.class).setParameter("lastname", LName).getResultList();

    }



    public void removeStudent(long id) {
        Student object = entityManager.find(Student.class, id);
        entityManager.remove(object);
    }

}
