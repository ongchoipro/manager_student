package com.example.manager_student.repository;

import com.example.manager_student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query(value = "select s from Student s where (S.id = :id or :id = null ) and (s.name_student =:name_student or :name_student= null )and (s.experience = :experience or :experience = null)")
//     List<Student> searchALL(@Param("id") Long id,
//                                   @Param("name_student") String name_student,
//                                   @Param("3") Long experience);

}
