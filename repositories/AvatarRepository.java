package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhog.model.Avatar;
import ru.hogwarts.schoolhog.model.Faculty;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long id);
}
