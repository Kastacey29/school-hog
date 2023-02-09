package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByAge(Integer age);

    List<Student> findStudentsByAgeBetween(Integer minAge, Integer maxAge);

    Student getStudentById(Long id);

    List<Student> findStudentsByFacultyId(Long id);

    @Query(value = "select count(*) from student", nativeQuery = true)
    Integer findCountOfStudent();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    Double findAverageAge();

    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    List<Student> findFiveLastStudents();

}
