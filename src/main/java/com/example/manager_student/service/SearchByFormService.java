package com.example.manager_student.service;

import com.example.manager_student.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Component
public interface SearchByFormService {
    List<Student> searchByForm(Long id, String name_student,Long experience);
}
