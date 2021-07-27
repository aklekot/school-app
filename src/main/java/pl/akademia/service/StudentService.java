package pl.akademia.service;

import org.springframework.stereotype.Service;
import pl.akademia.entity.Student;
import pl.akademia.repository.StudentRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){

        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }



    public Student addOrUpdateStudent(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    public int deleteStudentById(Long id){
        return studentRepository.deleteStudentById(id);
    }


    public List<Student> getStudentByLastname(String lastName){
        return studentRepository.getStudentByLastname(lastName);
    }

    public List<Student> getStudentByClassName(String className){
        return studentRepository.getStudentByClassName(className);
    }
}
