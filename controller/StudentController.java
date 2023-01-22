package ru.hogwarts.schoolhog.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolhog.model.Student;
import ru.hogwarts.schoolhog.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getStudentsByAge(@RequestParam(required = false) Integer age,
                                                                @RequestParam (required = false) Integer minAge,
                                                                @RequestParam (required = false) Integer maxAge) {
        if (age !=null) {
            return ResponseEntity.ok(studentService.getStudentsByAge(age));
        }
        if (minAge != null && maxAge != null && minAge <= maxAge) {
            return  ResponseEntity.ok(studentService.findStudentsByAgeBetween(minAge,maxAge));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/byFaculty/{id}")
    public ResponseEntity<Collection<Student>> findStudentsByFacultyId(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentsByFacultyId(id));
    }
}

