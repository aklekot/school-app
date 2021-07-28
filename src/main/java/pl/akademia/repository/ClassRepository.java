package pl.akademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.akademia.entity.ClassT;

public interface ClassRepository extends JpaRepository<ClassT,Long> {



}
