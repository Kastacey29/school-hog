package ru.hogwarts.schoolhog.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public ResponseEntity addFaculty(@RequestBody Faculty faculty) {
        Faculty addFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(addFaculty);
    }

    @GetMapping("/{facultyColor}")
    public ResponseEntity<Collection<Faculty>> getFacultiesByColor(@PathVariable int facultyColor) {
        return ResponseEntity.ok(facultyService.getFacultiesByColor(facultyColor));
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity deleteFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.deleteFacultyById(facultyId);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
}
