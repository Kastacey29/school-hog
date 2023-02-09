package ru.hogwarts.schoolhog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schoolhog.model.Avatar;
import ru.hogwarts.schoolhog.model.Faculty;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Repository
public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long id);
@Query(value = "select * from avatar", nativeQuery = true)
    List<Avatar> findAll(Pageable pageable);
}
