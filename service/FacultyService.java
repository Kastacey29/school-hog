package ru.hogwarts.schoolhog.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.repositories.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFacultyById(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getFacultiesByColor(String facultyColor) {
        return facultyRepository.findFacultiesByColor(facultyColor);
    }
}

