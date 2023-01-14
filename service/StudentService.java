package ru.hogwarts.schoolhog.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhog.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    public static Long lastId = 0L;

    public Student createStudent(Student student) {
        lastId++;
        students.put(lastId, student);
        student.setId(lastId);
        return student;
    }

    public Student getStudentById(Long studentID) {
        return students.get(studentID);
    }

    public Student updateStudent(Long id, Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudentById(Long studentId) {
        return students.remove(studentId);

    }

    public Collection<Student> getStudentsByAge(int studentAge) {
        return students.values().stream().filter(e -> e.getAge() == studentAge).collect(Collectors.toList());
    }
}
