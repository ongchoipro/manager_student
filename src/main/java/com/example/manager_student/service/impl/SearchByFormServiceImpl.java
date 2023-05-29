package com.example.manager_student.service.impl;

import com.example.manager_student.model.Student;
import com.example.manager_student.repository.StudentRepository;
import com.example.manager_student.service.SearchByFormService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class SearchByFormServiceImpl implements SearchByFormService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> searchByForm(Long id, String name_student, Long experience) {
        Student student = new Student();
        student.setId(id);
        student.setName_student(name_student);
        student.setExperience(experience);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Student> exampleQuery = Example.of(student, matcher);
        List<Student> results = studentRepository.findAll(exampleQuery);
        return results;
    }

//    @Override
//    public List<Student> searchByForm(Long id, String name_student, Long experience) {
//        StringBuilder strQuery = new StringBuilder();
//        strQuery.append("SELECT"+
//                " FROM student "+
//                " WHERE  s.name_student = name_student");
//
//        if(id != null) {
//            strQuery.append(" AND s.id = :id");
//        }
//        if(name_student != null){
//            strQuery.append(" AND s.name_student = :name_student");
//        }
//        if(experience != null){
//            strQuery.append(" AND s.experience = :experience");
//        }
//        Query query = entityManager.createNativeQuery(strQuery.toString());
//        if(id != null){
//            query.setParameter("id",id);
//        }
//        if(name_student != null){
//            query.setParameter("name_student",name_student);
//        }
//        if(experience != null){
//            query.setParameter("experience",experience);
//        }
//        query.unwrap(org.hibernate.query.NativeQuery.class).setResultTransformer(Transformers.aliasToBean(Student.class));
//
//        return query.getResultList();
//
//    }
}
