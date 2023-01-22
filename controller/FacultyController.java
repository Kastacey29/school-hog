package ru.hogwarts.schoolhog.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;
import ru.hogwarts.schoolhog.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getFacultiesByColor(@RequestParam(required = false) String color,
    @RequestParam (required = false) String name) {
        if (color != null && !color.isBlank()) {
return ResponseEntity.ok(facultyService.findFacultiesByColorIgnoreCase(color));

        }
        if (name != null && !name.isBlank()) {
           return ResponseEntity.ok(facultyService.findByNameIgnoreCase(name));
        }
        return ResponseEntity.ok(Collections.emptyList());

    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        if (updatedFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long facultyId) {
        facultyService.deleteFacultyById(facultyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byStudent/{id}")
    public ResponseEntity<Faculty> findFacultyByStudent(@PathVariable Long id) {
return ResponseEntity.ok(facultyService.findFacultyByStudentID(id));
    }
}
