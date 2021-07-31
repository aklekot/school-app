package pl.akademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.akademia.entity.Teacher;

import java.util.List;


public interface TeacherRepository extends JpaRepository<Teacher,Long> {

  @Modifying
  @Query(value = "delete from Teacher t where t.id = :id")
    int deleteTeacherById(Long id);


  @Query(value = "select t from Teacher t where t.lastName= :lastName")
  List<Teacher> getTeacherByLastname(String lastName);

  @Query(value = "select t from Teacher t where t.subject= :subject")
  List<Teacher> getTeacherBySubject(String subject);
}
