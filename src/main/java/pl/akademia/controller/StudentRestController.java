package pl.akademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.akademia.entity.Student;
import pl.akademia.entity.Teacher;
import pl.akademia.exceptions.StudentNotFoundException;
import pl.akademia.exceptions.ClassNotFoundException;
import pl.akademia.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    private final StudentService studentService;


    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestParam(required = false, value = "lastName") String lastName){

        if (lastName!=null) {
            List <Student> students = studentService.getStudentByLastname(lastName);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student not found");
            }
         return new ResponseEntity<>(students,HttpStatus.OK);
        }
        List<Student> students1 = studentService.getStudents();
        return  new ResponseEntity<>(students1,HttpStatus.OK);

    }


    @GetMapping("/students/{className}")
    public ResponseEntity<?> getStudentByClassName(@RequestParam(required = false, value = "className") String className){
        List<Student> student = studentService.getStudentByClassName(className);
        if (className!=null) {
            if (student.isEmpty()) {
               throw new ClassNotFoundException("Class not found");
           }
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addOrUpdateStudent(@RequestBody Student student){
        if (student.getId() == null){
            return new ResponseEntity<>(studentService.addOrUpdateStudent(student),HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(studentService.addOrUpdateStudent(student),HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}/delete")
    public  ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        if (studentService.deleteStudentById(id)>0){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

}
