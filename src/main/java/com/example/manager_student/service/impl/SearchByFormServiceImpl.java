package com.example.manager_student.service.impl;

import com.example.manager_student.model.Student;
import com.example.manager_student.service.SearchByFormService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.transform.Transformers;

import java.time.LocalDate;
import java.util.List;

public class SearchByFormServiceImpl implements SearchByFormService {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> searchByForm(Long id, String name_student, Long experience) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT"+
                " FROM student "+
                " WHERE status = Dang_Lam");

        if(id != 100) {
            strQuery.append(" AND id = :id");
        }
        if(name_student != "name"){
            strQuery.append(" AND name_student = :name_student");
        }
        if(experience != 100){
            strQuery.append(" AND name_student = :name_student");
        }
        Query query = entityManager.createNativeQuery(strQuery.toString());
        query.setParameter("id", id);

        if(id != 100){
            query.setParameter("id", id);
        }
        if(name_student != "name"){
            query.setParameter("name_student", name_student);
        }
        if(experience != 100){
            strQuery.append(" AND name_student = :name_student");
        }
        query.unwrap(org.hibernate.query.NativeQuery.class).setResultTransformer(Transformers.aliasToBean(Student.class));

        return query.getResultList();

    }
}
