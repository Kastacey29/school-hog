package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findFacultiesByColorIgnoreCase(String color);
List<Faculty> findByNameIgnoreCase(String name);

}
