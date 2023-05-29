package com.example.manager_student.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_student")
    @Size(min = 2,max = 150,message = "Name student must be between 2 and 150 characters")
    @NotBlank(message = "Name Student is mandatory")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+",message = "khong chua cac ky tu dac biet")
    private String name_student;
    @Column(name="birthday" ,columnDefinition = "DATE")
    //@Pattern(regexp = "\\d{4}[-|/]\\d{2}[-|/]\\d{2}",message = "phai dung dinh dang yyyy/mm/dd or yyyy-mm-dd")
    private LocalDate birthday;
    @Column(name ="experience")
    @Min(value = 0)
    @Max(value = 100)
    private Long experience;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="student_project",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name ="project_id"))
    @JsonManagedReference
    private Set<Project> project_join;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "default 'Dang_Lam'")
    private Status status;
}
