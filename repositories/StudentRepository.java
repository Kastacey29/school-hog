package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByAge(Integer age);
    List <Student> findStudentsByAgeBetween(Integer minAge, Integer maxAge);

    List<Student> findStudentsByFacultyId(Long id);
}
