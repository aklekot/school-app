package pl.akademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.akademia.entity.Classification;

import java.math.BigDecimal;
import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    @Modifying

    @Query(value = "select c from Classification c  where c.studentId = :id")
    List<Classification> getStudentMarks(Long id);

    @Query(value = "select avg(c.score) from Classification c  where c.studentId = :id")
      BigDecimal avgStudentById(Long id);


}
