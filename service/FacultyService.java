package ru.hogwarts.schoolhog.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhog.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    public static Long lastId = 0L;


    public Faculty createFaculty(Faculty faculty) {
        lastId++;
        faculties.put(lastId, faculty);
        faculty.setId(lastId);
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFacultyById(Long facultyId) {
        return faculties.remove(facultyId);
    }

    public Collection<Faculty> getFacultiesByColor(int facultyColor) {
        return faculties.values().stream().filter(e -> e.getColor().equals(facultyColor)).collect(Collectors.toList());
    }
}

