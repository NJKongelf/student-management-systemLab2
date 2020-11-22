package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {


        @PersistenceContext
        EntityManager entityManager;

        public Teacher createTeacher(Teacher teacher) {
            entityManager.persist(teacher);
            return teacher;
        }

        public Teacher updateTodo(Teacher teacher) {
            entityManager.merge(teacher);
            return teacher;
        }

        public Teacher findTeacherById(Long id) {
            return entityManager.find(Teacher.class, id);
        }


        public List<Teacher> getAllTeachers() {
            return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();

        }
        public List<Teacher> findTeacherAndSubject(String teacherName){
            return entityManager.createQuery("SELECT DISTINCT s.name FROM Subject s WHERE s.teacher.firstname = :teacher", Teacher.class).setParameter("teacher", teacherName).getResultList();
        }
        public Set<Student> getSpecifiedStudentsPerSubjectandTeacher(String subject, String teacher){
            Subject givenSubject = (Subject) entityManager
                .createQuery("SELECT DISTINCT s FROM Subject s INNER JOIN  s.teacher t INNER JOIN  s.students e WHERE t.firstname = :teacher AND s.name = :subject")
                .setParameter("teacher", teacher)
                .setParameter("subject",subject)
                .getSingleResult();

        Set<Student> foundStudents = givenSubject.getStudents();
        return foundStudents;
        }

        public boolean foundTeachertByName(String tName) {
         List<Teacher> foundOnes = entityManager.createQuery("SELECT t from Teacher t where t.firstname like :tName", Teacher.class).setParameter("tName", tName).getResultList();
             if(foundOnes.size() > 0)
                return true;
                else return false;
        }

        public boolean foundSubjectByName(String sName) {
        List<Subject> foundOnes = entityManager.createQuery("SELECT s from Subject s where s.name like :sName", Subject.class).setParameter("sName", sName).getResultList();
            if(foundOnes.size() > 0)
                return true;
                else return false;
        }


        public void removeTeacher(long id) {
            Teacher object = entityManager.find(Teacher.class, id);
            entityManager.remove(object);
        }


}
