package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findFacultiesByColor(String color);


}
