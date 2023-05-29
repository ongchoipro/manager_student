package com.example.manager_student.controller;

import com.example.manager_student.model.Project;
import com.example.manager_student.model.Student;
import com.example.manager_student.repository.StudentRepository;
import com.example.manager_student.service.SearchByFormService;
import com.example.manager_student.service.impl.SearchByFormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SearchByFormService searchByFormService;
    @GetMapping(value = "/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
            return ResponseEntity.ok(studentRepository.findById(id));
    }
    @GetMapping(value = "/add_project_join")
    public ResponseEntity<?> add_project_join (@RequestParam(value = "id",required = true ) Long id ,
                                               @RequestParam("name") String name){
            Project project = new Project();
            project.setName(name);
            Set<Project> projects = new HashSet<>();
            projects.add(project);
            Student student = studentRepository.findById(id).orElseThrow();
            student.setProject_join(projects);
            return ResponseEntity.ok(studentRepository.save(student));
    }
    @GetMapping(value = "/search")
    public ResponseEntity<?> searchByForm(@RequestParam(value = "id",required = false) Long id,
                                          @RequestParam(value = "name_student",required = false) String name_student,
                                          @RequestParam(value = "experience",required = false) Long experience
                                          ){
        List<Student> students = searchByFormService.searchByForm(id,name_student,experience);
            return ResponseEntity.ok(students);
    }

}
