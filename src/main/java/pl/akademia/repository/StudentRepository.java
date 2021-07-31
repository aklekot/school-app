package pl.akademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.akademia.entity.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {


    @Modifying
    @Query(value = "delete from Student s where s.id = :id")
    int deleteStudentById(Long id);

    @Query(value = "select s from Student s where s.lastName= :lastName")
   List <Student> getStudentByLastname(String lastName);

    @Query(value = "select s from Student s where s.className= :className")
    List <Student> getStudentByClassName(String className);


}
